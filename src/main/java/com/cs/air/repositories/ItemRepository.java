package com.cs.air.repositories;

import com.cs.air.models.Item;
import com.cs.air.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findItemsByOwner(Person owner);
}
