package com.elmercader.catalogov2.repositories;

import com.elmercader.catalogov2.models.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GadgetRepository extends MongoRepository<Gadget, Integer> {
    @Query("{id: ?0}")
    Optional<Gadget> getGadgetById(Integer id);

    @Query("{category: ?0}")
    List<Gadget> getGadgetByCategory(String category);

    @Query("{name: {$regex: /?0/}}")
    List<Gadget> getGadgetByName(String name);

    @Query("{description: {$regex: /?0/}}")
    List<Gadget> getGadgetByDescription(String keyword);

    @Query("{price: {$lte: ?0}}")
    List<Gadget> getGadgetByMaxPrice(Double maxPrice);

    @Query("{price: {$gte:?0, $lte: ?1}}")
    List<Gadget> getGadgetByPrice(Double minPrice, Double maxPrice);

    @Query("{availability: ?0}")
    List<Gadget> getGadgetByAvailability(Boolean availability);
}
