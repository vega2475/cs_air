package com.cs.air.controllers;

import com.cs.air.models.Item;
import com.cs.air.services.ItemsService;
import com.cs.air.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pricing")
public class PurchaseController {
    private final ItemsService itemsService;
    private final PersonService personService;

    @Autowired
    public PurchaseController(ItemsService itemsService, PersonService personService) {
        this.itemsService = itemsService;
        this.personService = personService;
    }


    @PostMapping()
    @PreAuthorize("isAuthenticated()")
    public String buyItem(@ModelAttribute("item") Item item){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        item.setOwner(personService.findByUsername(authentication.getName()).get());
        itemsService.save(item);
        return "/pricing";
    }
}
