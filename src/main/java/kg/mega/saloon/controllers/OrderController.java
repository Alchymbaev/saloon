package kg.mega.saloon.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.saloon.enums.WorkDayEnum;
import kg.mega.saloon.models.dto.MasterDto;
import kg.mega.saloon.models.dto.OrderDto;
import kg.mega.saloon.models.requests.OrderRequest;
import kg.mega.saloon.service.MasterService;
import kg.mega.saloon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Api(tags = "Заявка")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService service;


    @PostMapping("/create")
    @ApiOperation("Создание заявки")
    ResponseEntity<?> save(@RequestBody OrderRequest order) {
        return new ResponseEntity<>(service.create(order), HttpStatus.CREATED);
    }

    @PutMapping("/confirm")
    @ApiOperation("Подтверждение заявки")
    ResponseEntity<?> confirm(@RequestParam String code,@RequestParam Long orderId) {
        return new ResponseEntity<>(service.confirm(code,orderId), HttpStatus.CREATED);
    }




    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestBody OrderDto order) {
        try {
            return new ResponseEntity<>(service.save(order), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск заявки по id")
    ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех заявок")
    ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
