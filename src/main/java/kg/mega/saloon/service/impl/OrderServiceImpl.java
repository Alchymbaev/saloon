package kg.mega.saloon.service.impl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import kg.mega.saloon.dao.OrderRep;
import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.mappers.OrderMapper;
import kg.mega.saloon.models.dto.ClientDto;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.models.dto.ScheduleDto;
import kg.mega.saloon.models.requests.OrderRequest;
import kg.mega.saloon.models.responses.Response;
import kg.mega.saloon.network.EmailSender;
import kg.mega.saloon.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/*
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class OrderServiceImpl implements OrderService {

    OrderMapper mapper = OrderMapper.INSTANCE;
    private final OrderRep rep;
    private final ClientService clientService;
    private final MasterService masterService;
    private final ScheduleService scheduleService;

    public OrderServiceImpl(OrderRep rep, ClientService clientService, MasterService masterService, ScheduleService scheduleService) {
        this.rep = rep;
        this.clientService = clientService;
        this.masterService = masterService;
        this.scheduleService = scheduleService;
    }

    @Override
    public OrderDto save(OrderDto order) {
        ClientDto client = new ClientDto();
        client.setName(order.getClient().getName());
        client.setSurname(order.getClient().getSurname());
        client.setPhoneNumber(order.getClient().getPhoneNumber());
        client.setEmail(order.getClient().getEmail());
        client = clientService.save(client);
        order.setClient(client);

        if (client.getName().isEmpty() | client.getPhoneNumber().isEmpty()) {
            throw new RuntimeException("Имя или номер телефона не может быть пустым!");
        }

        try {
            emailSender(order.getClient().getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mapper.toDto(rep.save(mapper.toEntity(order)));

    }

    @Override
    public OrderDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Заявка не найдена!")));
    }

    @Override
    public OrderDto delete(Long id) {
        OrderDto order = findById(id);
        order.setActive(false);
        return save(order);
    }

    @Override
    public List<OrderDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }


    @Override
    public void emailSender(String email) throws IOException, MessagingException {
        /*final Properties properties = new Properties();
        properties.load(EmailSender.class.getClassLoader().getResourceAsStream("application.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("41mazkin"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Hello");
        message.setText("you have successfully registered");

        Transport transport = mailSession.getTransport();
        transport.connect(null, "rpbubkqxutjgcjtx");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();*/
    }

    @Override
    public Response create(OrderRequest order) {
        //Найти клиента, если его нет, ошибка код 404  /done
        //Найти мастера,если нет 404  /done
        //Найти график мастера на этот appointmentDate  /done
        //Найти день недели appointmentDate /done
        //По дню недели найти график /done
        // add exc with 404 code  /done

        ClientDto clientDto = clientService.findById(order.getClientId());

        MasterDto masterDto = masterService.findById(order.getMasterId());

        List<ScheduleDto> scheduleDtos = scheduleService.getScheduleByMasterId(masterDto.getId());

        ScheduleDto scheduleDto = null;  //не должны создавать новый график или можно??????

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getAppointmentDate());
        WorkDayEnum workDayEnum = WorkDayEnum.getValue(calendar.get(Calendar.DAY_OF_WEEK));

        for (ScheduleDto item : scheduleDtos) {
            if (item.getWorkDay().equals(workDayEnum)) {
                scheduleDto = item;
                break;
            }
        }
        if (scheduleDto==null){
            throw new RuntimeException("В этот день мастер не работает!");
        }


        //проверка по графику мастера /done
        //проверка на ордерс  /done

        LocalTime startTime = scheduleDto.getStartTime();
        LocalTime endTime = scheduleDto.getEndTime();

        LocalTime appointmentTime = LocalDateTime.ofInstant(order.getAppointmentDate().toInstant(),
                ZoneId.systemDefault()).toLocalTime();

        if (!(appointmentTime.isAfter(startTime) & appointmentTime.isBefore(endTime))) {
            throw new RuntimeException("Извините, но мастер не работает в это время!");
        }
        SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OrderDto orderDto = new OrderDto();
        //вытащить по мастеру
        List<OrderDto> orderDtoList = findAll();

        for (OrderDto item : orderDtoList) {
            //Проверка на статус если deleted пропускаем, confirm  Извините, на данное время клиент уже записан! повторите позже,
            // либо выберите другое время
            String adppDate = sdm.format(item.getAppointment_date());
            String newAppDate = sdm.format(order.getAppointmentDate());

            if (adppDate.equals(newAppDate)) {
                throw new RuntimeException("Извините, на данное время клиент уже записан!");
            } else continue;
        }
        orderDto.setMaster(masterDto);
        orderDto.setClient(clientDto);
        orderDto.setAppointment_date(order.getAppointmentDate());
        //  orderDto.setStatus(OrderStatusEnum.CONFIRM);
        save(orderDto);
        //TODO add code
//        try {
//            emailSenderService.emailSender(orderDto.getClient().getEmail(),
//                    orderDto.getMaster().getSaloon().getName(),
//                    orderDto.getAppointment_date());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        return new Response("Registration completed successfully!");}

    @Override
    public Response confirm(String code, Long orderId) {

        // Найти заявку по айди
        //проверка на код неверный ошибка, верный идем дальше
        // добавить проверку на время , если прошел час ошибку , если нет идем дальше
        // переводим заявку в статус confirm
        return null;
    }

    @Override
    public void checkSuspendOrders() {
        //вытащить все заявки со статусом suspend
        // если прошел час переводите их в статус deleted

        System.out.println("job for suspend");

    }
}
