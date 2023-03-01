package kg.mega.saloon.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.mega.saloon.models.dto.ClientDto;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.models.dto.SaloonDto;
import kg.mega.saloon.models.entities.Client;
import kg.mega.saloon.models.entities.Master;
import kg.mega.saloon.models.entities.Order;
import kg.mega.saloon.models.entities.Saloon;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T12:31:27+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto d) {
        if ( d == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( d.getId() );
        order.setAddDate( d.getAddDate() );
        order.setUpdateDate( d.getUpdateDate() );
        order.setAppointment_date( d.getAppointment_date() );
        order.setStatus( d.getStatus() );
        order.setClient( clientDtoToClient( d.getClient() ) );
        order.setMaster( masterDtoToMaster( d.getMaster() ) );
        order.setActive( d.isActive() );

        return order;
    }

    @Override
    public OrderDto toDto(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( e.getId() );
        orderDto.setAddDate( e.getAddDate() );
        orderDto.setUpdateDate( e.getUpdateDate() );
        orderDto.setAppointment_date( e.getAppointment_date() );
        orderDto.setStatus( e.getStatus() );
        orderDto.setClient( clientToClientDto( e.getClient() ) );
        orderDto.setMaster( masterToMasterDto( e.getMaster() ) );
        orderDto.setActive( e.isActive() );

        return orderDto;
    }

    @Override
    public List<Order> toEntities(List<OrderDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Order> list1 = new ArrayList<Order>( list.size() );
        for ( OrderDto orderDto : list ) {
            list1.add( toEntity( orderDto ) );
        }

        return list1;
    }

    @Override
    public List<OrderDto> toDtos(List<Order> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto> list1 = new ArrayList<OrderDto>( list.size() );
        for ( Order order : list ) {
            list1.add( toDto( order ) );
        }

        return list1;
    }

    protected Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setName( clientDto.getName() );
        client.setSurname( clientDto.getSurname() );
        client.setPhoneNumber( clientDto.getPhoneNumber() );
        client.setEmail( clientDto.getEmail() );
        client.setActive( clientDto.isActive() );

        return client;
    }

    protected Saloon saloonDtoToSaloon(SaloonDto saloonDto) {
        if ( saloonDto == null ) {
            return null;
        }

        Saloon saloon = new Saloon();

        saloon.setId( saloonDto.getId() );
        saloon.setName( saloonDto.getName() );
        saloon.setAddress( saloonDto.getAddress() );
        saloon.setPhoneNumber( saloonDto.getPhoneNumber() );
        saloon.setActive( saloonDto.isActive() );

        return saloon;
    }

    protected Master masterDtoToMaster(MasterDto masterDto) {
        if ( masterDto == null ) {
            return null;
        }

        Master master = new Master();

        master.setId( masterDto.getId() );
        master.setName( masterDto.getName() );
        master.setSurname( masterDto.getSurname() );
        master.setActive( masterDto.isActive() );
        master.setSaloon( saloonDtoToSaloon( masterDto.getSaloon() ) );
        master.setWorkType( masterDto.getWorkType() );

        return master;
    }

    protected ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setName( client.getName() );
        clientDto.setSurname( client.getSurname() );
        clientDto.setPhoneNumber( client.getPhoneNumber() );
        clientDto.setEmail( client.getEmail() );
        clientDto.setActive( client.isActive() );

        return clientDto;
    }

    protected SaloonDto saloonToSaloonDto(Saloon saloon) {
        if ( saloon == null ) {
            return null;
        }

        SaloonDto saloonDto = new SaloonDto();

        saloonDto.setId( saloon.getId() );
        saloonDto.setName( saloon.getName() );
        saloonDto.setAddress( saloon.getAddress() );
        saloonDto.setPhoneNumber( saloon.getPhoneNumber() );
        saloonDto.setActive( saloon.isActive() );

        return saloonDto;
    }

    protected MasterDto masterToMasterDto(Master master) {
        if ( master == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

        masterDto.setId( master.getId() );
        masterDto.setName( master.getName() );
        masterDto.setSurname( master.getSurname() );
        masterDto.setSaloon( saloonToSaloonDto( master.getSaloon() ) );
        masterDto.setWorkType( master.getWorkType() );
        masterDto.setActive( master.isActive() );

        return masterDto;
    }
}
