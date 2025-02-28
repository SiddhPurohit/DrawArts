package lk.ac.vau.fas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lk.ac.vau.fas.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	
	@RequestMapping("/deleteCart/{id}")
	public String deleteCart(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/cart";
	}
}