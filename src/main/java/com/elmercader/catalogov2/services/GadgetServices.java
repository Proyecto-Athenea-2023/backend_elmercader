package com.elmercader.catalogov2.services;

import com.elmercader.catalogov2.models.Gadget;
import com.elmercader.catalogov2.repositories.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetServices {
    @Autowired
    private GadgetRepository gadgetRepository;

    /**
     *
     * @return
     */
    public List<Gadget> getAllGadgets() {
        return (List<Gadget>) gadgetRepository.findAll();
    }

    /**
     *
     * @param category
     * @return
     */
    public List<Gadget> getGadgetsByCategory(String category){
        return gadgetRepository.getGadgetByCategory(category);
    }

    /**
     *
     * @param name
     * @return
     */
    public List<Gadget> getGadgetsByName(String name){
        return gadgetRepository.getGadgetByName(name);
    }

    /**
     *
     * @param keyword
     * @return
     */
    public List<Gadget> getGadgetsByDescription(String keyword){
       return gadgetRepository.getGadgetByDescription(keyword.toLowerCase());
    }


    /**
     *
     * @param maxPrice
     * @return
     */
    public List<Gadget> getGadgetsByMaxPrice(Double maxPrice){
        return gadgetRepository.getGadgetByMaxPrice(maxPrice);
    }

    /**
     *
     * @param minPrice
     * @param maxPrice
     * @return
     */
    public List<Gadget> getGadgetsByPriceRange(Double minPrice, Double maxPrice){
        if(maxPrice >= minPrice){
            return gadgetRepository.getGadgetByPrice(minPrice, maxPrice);
        }
        else
            return null;
    }

    /**
     *
     * @param availability
     * @return
     */
    public List<Gadget> getGadgetsByAvailability(Boolean availability){
        return gadgetRepository.getGadgetByAvailability(availability);
    }

    /**
     *
     * @param gadgetId
     * @return
     */
    public Optional<Gadget> getGadgetById(Integer gadgetId){
        return gadgetRepository.getGadgetById(gadgetId);
    }

    /**
     *
     * @param gadget
     * @return
     */
    public Gadget insertGadget(Gadget gadget){
        Optional<Gadget> tempGadget = gadgetRepository.getGadgetById(gadget.getId());
        if(tempGadget.isPresent())
            return gadget;
        gadget.setDescription( gadget.getDescription().toLowerCase() );
        if(gadget.getPrice() >= 0 && gadget.getQuantity() >= 0)
            return gadgetRepository.save(gadget);
        else
            return gadget;
    }

    /**
     *
     * @param gadget
     * @return
     */
    public Gadget updateGadget(Gadget gadget){
        Optional<Gadget> tempGadget = gadgetRepository.getGadgetById(gadget.getId());
        if(tempGadget.isPresent()){
            if(gadget.getPrice() >= 0 && gadget.getQuantity() >= 0){
                if(gadget.getCategory() != null)
                    tempGadget.get().setCategory(gadget.getCategory());
                if(gadget.getDescription() != null)
                    tempGadget.get().setDescription(gadget.getDescription());
                if(gadget.getPrice() != null)
                    tempGadget.get().setPrice(gadget.getPrice());
                if(gadget.getAvailability() != null)
                    tempGadget.get().setAvailability(gadget.getAvailability());
                if(gadget.getQuantity() != null)
                    tempGadget.get().setQuantity(gadget.getQuantity());
                if(gadget.getPhotography() != null)
                    tempGadget.get().setPhotography(gadget.getPhotography());
                return gadgetRepository.save(tempGadget.get());
            }
            else
                return gadget;
        }
        else
            return gadget;
    }

    /**
     *
     * @param gadgetId
     */
    public void deleteGadget(Integer gadgetId){
        Optional<Gadget> tempGadget = gadgetRepository.findById(gadgetId);

        if(tempGadget.isPresent())
            gadgetRepository.delete(tempGadget.get());
        // TODO add exception
    }
}
