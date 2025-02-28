package lk.ac.vau.fas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lk.ac.vau.fas.model.Art;
import lk.ac.vau.fas.model.Cart;
import lk.ac.vau.fas.service.ArtService;
import lk.ac.vau.fas.service.CartService;

@Controller
public class ArtController {
	
	@Autowired
	private ArtService artService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/add_art")
	public String artRegister() {
		return "addArt";
	}
	
	@GetMapping("/new_arrivals")
	public ModelAndView getAllArt() {
		List<Art>list=artService.getAllArt();
		return new ModelAndView("newArrivals","art",list);
	}
	
	@PostMapping("/save")
	public String addArt(@ModelAttribute Art a) {
		artService.save(a);
		return "redirect:/new_arrivals";
	}
	@GetMapping("/cart")
	public String getMyArts(Model model)
	{
		List<Cart>list=cartService.getAllMyArts();
		model.addAttribute("art",list);
		return "cart";
	}
	
	@PostMapping("/savecart")
	public String addCart(@ModelAttribute Cart c)
	{
		cartService.saveMyArts(c);
		return "redirect:/cart";
		
	}
	@RequestMapping("/myCart/{id}")
	public String getMyCart(@PathVariable("id") int id) {
		Art a=artService.getArtById(id);
		Cart c=new Cart(a.getId(),a.getName(),a.getSize(),a.getPrice());
		cartService.saveMyArts(c);
		return "redirect:/cart";
	}
	
	@RequestMapping("/editArt/{id}")
	public String editArt(@PathVariable("id") int id,Model model) {
		Art a=artService.getArtById(id);
		model.addAttribute("art",a);
		return "artEdit";
	}
	@RequestMapping("/deleteArt/{id}")
	public String deleteArt(@PathVariable("id")int id) {
		artService.deleteById(id);
		return "redirect:/new_arrivals";
	}
	
}

