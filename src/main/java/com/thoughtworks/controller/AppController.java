package com.thoughtworks.controller;

import com.thoughtworks.entity.CartItem;
import com.thoughtworks.entity.Scanner;
import com.thoughtworks.util.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/pay")
public class AppController {
    @Autowired
    private Scanner scanner;

	@RequestMapping(method = RequestMethod.GET)
	public String printInventory(ModelMap model) {
        List<CartItem> cartItems = scanner.getCartItems(FileProcessor.readFile("cart.txt"));
        Set<String> cartCategories = scanner.getCartCategories(cartItems);
		model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartCategories",cartCategories);
		return "inventory";
	}
}

