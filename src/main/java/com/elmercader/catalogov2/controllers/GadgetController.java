package com.elmercader.catalogov2.controllers;

import com.elmercader.catalogov2.models.Gadget;
import com.elmercader.catalogov2.services.GadgetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gadget")
public class GadgetController {
    @Autowired
    private GadgetServices gadgetServices;

    @GetMapping("/all")
    public List<Gadget> getAllGadgets(){
        return gadgetServices.getAllGadgets();
    }

    @GetMapping("/category/{category}")
    public List<Gadget> getGadgetsByCategory(@PathVariable("category") String category){
        return gadgetServices.getGadgetsByCategory(category);
    }

    @GetMapping("/name/{name}")
    public List<Gadget> getGadgetsByName(@PathVariable("name") String name){
        return gadgetServices.getGadgetsByName(name);
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    public List<Gadget> getGadgetsByPriceRange(@PathVariable("minPrice") Double minPrice, @PathVariable("maxPrice") Double maxPrice){
        return gadgetServices.getGadgetsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/availability/{availability}")
    public List<Gadget> getGadgetsByAvailability(@PathVariable("availability") Boolean availability){
        return gadgetServices.getGadgetsByAvailability(availability);
    }

    @GetMapping("/{gadgetId}")
    public Optional<Gadget> getGadgetById(@PathVariable("gadgetId") Integer gadgetId){
        return gadgetServices.getGadgetById(gadgetId);
    }

    @PostMapping("/new")
    public Gadget insertGadget(@RequestBody Gadget gadget){
        return gadgetServices.insertGadget(gadget);
    }

    @PutMapping("/update")
    public Gadget updateGadget(@RequestBody Gadget gadget){
        return gadgetServices.updateGadget(gadget);
    }

    @DeleteMapping("/{gadgetId}")
    public void deleteGadget(@PathVariable("gadgetId") Integer gadgetId){
        gadgetServices.deleteGadget(gadgetId);
    }
}
