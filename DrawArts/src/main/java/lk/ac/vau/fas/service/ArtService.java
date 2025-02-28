package lk.ac.vau.fas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ac.vau.fas.model.Art;
import lk.ac.vau.fas.repo.ArtRepo;

@Service
public class ArtService {
	
	@Autowired
	private ArtRepo artRepo;
	
	public void save(Art b) {
		artRepo.save(b);
	}
	
	public List<Art> getAllArt(){
		return artRepo.findAll();
	}
	
	public Art getArtById(int id) {
		return artRepo.findById(id).get();
	}
	public void deleteById(int id) {
		artRepo.deleteById(id);
	}
}

