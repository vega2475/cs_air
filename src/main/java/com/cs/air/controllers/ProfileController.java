package com.cs.air.controllers;

import com.cs.air.models.Item;
import com.cs.air.repositories.ItemRepository;
import com.cs.air.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final PersonService personService;
    private final ItemRepository itemRepository;

    @Autowired
    public ProfileController(PersonService personService, ItemRepository itemRepository) {
        this.personService = personService;

        this.itemRepository = itemRepository;
    }

    @GetMapping()
    public String showItems(Model model) {
        // Получите текущего аутентифицированного пользователя (или его ID)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Получите имя пользователя

        // Напишите логику для получения списка предметов пользователя
        List<Item> items = personService.findByUsername(username).get().getItems();

        // Передайте список предметов в модель
        model.addAttribute("itemList", items);

        return "profile"; // Возвращает имя шаблона Thymeleaf для отображения страницы
    }



}
