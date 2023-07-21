package com.elmercader.catalogov2.repositories;

import com.elmercader.catalogov2.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    @Query("{status: ?0}")
    List<Order> getOrderByStatus(String status);

    List<Order> findByStatusAndSalesManId(String status, Integer salesmanId);

    // TODO fix
    List<Order> findByRegisterDayAndSalesManId(String date, Integer salesmanId);

    List<Order> findBySalesManZone(String zone);

    List<Order> findBySalesManId(Integer salesmanId);

    @Query("{id: ?0}")
    Optional<Order> getOrderById(Integer id);
}
