package lk.ac.vau.fas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.model.Cart;
import lk.ac.vau.fas.repo.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	public void saveMyArts(Cart c) {
		cartRepo.save(c);
	}
	
	public List<Cart> getAllMyArts(){
		return cartRepo.findAll();
	}
	
	public void deleteById(int id) {
		cartRepo.deleteById(id);
	}
}

