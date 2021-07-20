package com.github.wadrob.myset.domain.service;

import com.github.wadrob.myset.domain.model.Collection;
import com.github.wadrob.myset.domain.model.Item;
import com.github.wadrob.myset.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // TODO Zawsze jak się tylko da (zawsze się da ;)) używać Stream API (próbować)
    public Map<String, List<Item>> mapByStatus(Collection collection){
        List<Item> collectionItems = itemRepository.findAllByCollection(collection);
        Map<String, List<Item>> mappedCollection = new HashMap<>();
        Comparator<Item> compareByStatus = Comparator.comparing(Item::getStatus);
        collectionItems.sort(compareByStatus);
        List<Item> toAdd = new ArrayList<>();

        for (int i = 0; i < collectionItems.size(); i++){
            // TODO i1 -> itemStatus1
            String i1 = collectionItems.get(i).getStatus();
            String i2;


            if (i+1 >= collectionItems.size()){
                toAdd.add(collectionItems.get(i));
                mappedCollection.put(i1, toAdd);
            }
            else {
                i2 = collectionItems.get(i+1).getStatus();
                if (i1.equals(i2)){
                    toAdd.add(collectionItems.get(i));
                }
                else {
                    toAdd.add(collectionItems.get(i));
                    mappedCollection.put(i1, toAdd);
                    toAdd = new ArrayList<>();
                }
            }
        }
        return mappedCollection;
    }

}
