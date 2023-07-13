package com.elmercader.catalogov2.repositories;

import com.elmercader.catalogov2.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    @Query("{status: ?0}")
    public List<Order> getOrderByStatus(String status);

    // TODO test
    public List<Order> findByStatusAndBySalesManId(String status, Integer salesmanId);

    public List<Order> findBySalesManZone(String zone);

    public List<Order> findBySalesManId(Integer salesmanId);

    @Query("{id: ?0}")
    public Optional<Order> getOrderById(Integer id);
}
