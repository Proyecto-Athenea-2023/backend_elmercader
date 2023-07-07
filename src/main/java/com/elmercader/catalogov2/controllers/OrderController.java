package com.elmercader.catalogov2.controllers;

import com.elmercader.catalogov2.models.Order;
import com.elmercader.catalogov2.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderServices.getAllOrders();
    }

    @GetMapping("/state/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status){
        return orderServices.getOrdersByStatus(status);
    }

    @GetMapping("/zone/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone) {
        return orderServices.getOrdersByZone(zone);
    }

    @GetMapping("/salesman/{salesmanId}")
    public List<Order> getOrdersBySalesman(@PathVariable("salesmanId") Integer salesmanId){
        return orderServices.getOrdersBySalesman(salesmanId);
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrderById(@PathVariable("orderId") Integer orderId){
        return orderServices.getOrderById(orderId);
    }

    @PostMapping("/new")
    public Order insertOrder(@RequestBody Order order){
        return orderServices.insertOrder(order);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderServices.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Integer orderId){
        orderServices.deleteOrder(orderId);
    }
}
