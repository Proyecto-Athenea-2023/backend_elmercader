package com.elmercader.catalogov2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="gadgets")
public class Gadget {
    @Id
    private Integer id;
    private String brand;
    private String category;
    private String name;
    private String description;
    private Double price;
    private Boolean availability = true;
    private Integer quantity;
    private String photography;
}
