package com.cs.air.services;

import com.cs.air.models.Item;
import com.cs.air.models.Person;
import com.cs.air.repositories.ItemRepository;
import com.cs.air.repositories.PeopleRepository;
import com.cs.air.util.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemsService {
    private final ItemRepository itemRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public ItemsService(ItemRepository itemRepository, PeopleRepository peopleRepository) {
        this.itemRepository = itemRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    public Item findOneItem(int id){
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found!"));
    }

    @Transactional
    public void save(Item item){
        itemRepository.save(item);
    }

    public Person findOwner(Item item){
        return item.getOwner();
    }
}
