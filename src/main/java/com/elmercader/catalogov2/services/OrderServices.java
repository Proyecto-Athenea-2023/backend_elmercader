package com.elmercader.catalogov2.services;

import com.elmercader.catalogov2.models.Order;
import com.elmercader.catalogov2.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;

    /**
     *
     * @return
     */
    public List<Order> getAllOrders(){
       return (List<Order>) orderRepository.findAll();
    }

    /**
     *
     * @param status
     * @return
     */
    public List<Order> getOrdersByStatus(String status){
        return orderRepository.getOrderByStatus(Utilities.toCapitalize(status));
    }

    public List<Order> getOrdersByStatusBySalesman(String status, Integer salesmanId){
        return orderRepository.findByStatusAndBySalesManId(status, salesmanId);
    }

    /**
     *
     * @param zone
     * @return
     */
    public List<Order> getOrdersByZone(String zone){
        return orderRepository.findBySalesManZone(zone.toUpperCase());
    }

    /**
     *
     * @param salesmanId
     * @return
     */
    public List<Order> getOrdersBySalesman(Integer salesmanId){
        return orderRepository.findBySalesManId(salesmanId);
    }

    /**
     *
     * @param orderId
     * @return
     */
    public Optional<Order> getOrderById(Integer orderId){
        return orderRepository.getOrderById(orderId);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order insertOrder(Order order){
        if(!order.getProducts().isEmpty()){
            if(order.getProducts().size() == order.getQuantities().size()){
                order.setStatus("Pendiente");
                // if date is not provided by the user, the system timestamp will be used
                if(order.getRegisterDay().toString().length() == 0)
                    order.setRegisterDay(Date.from(Instant.now()));

                return orderRepository.save(order);
            }
            else
                // TODO handle exception, no quantities for all products
                return order;
        }
        else
            // TODO handle exception, empty products list
            return order;
    }

    /**
     *
     * @param order
     * @return
     */
    public Order updateOrder(Order order){
        Optional<Order> tempOrder = orderRepository.getOrderById(order.getId());
        if(order.getStatus()=="Aprobada" || order.getStatus()=="Rechazada"){
            tempOrder.get().setStatus(order.getStatus());
            if(order.getRegisterDay().toString().length() == 0)
                 order.setRegisterDay(Date.from(Instant.now()));
            tempOrder.get().setRegisterDay(order.getRegisterDay());
            return orderRepository.save(tempOrder.get());
         }
         else
             // TODO invalid update status
             return order;
    }

    /**
     *
     * @param orderId
     */
    public void deleteOrder(Integer orderId){
        Optional<Order> tempOrder = orderRepository.getOrderById(orderId);
        if(tempOrder.isPresent())
            orderRepository.delete(tempOrder.get());
        // TODO if it does not exist, an exception is necessary
    }
}
