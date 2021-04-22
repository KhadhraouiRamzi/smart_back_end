package com.example.demo.webService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 import com.example.demo.dao.detailRepository;
 import com.example.demo.entite.details;
 

	

@CrossOrigin
@RestController
public class detailRestService {

	
	@Autowired
	detailRepository DetailRepository ;
	
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public List<details> listeCategorie() {
		return DetailRepository.GetDetails();
	}
	 

	@RequestMapping(path = "/listDetail", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return DetailRepository.listDetail();
	} 
	 

	@RequestMapping(path = "/listChanson", method = RequestMethod.GET)
	public List<Object[]> listChanson() {
		return DetailRepository.listChanson();
	} 
	 

	@RequestMapping(path = "/listdate", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return DetailRepository.listdate();
	} 
	 

	@RequestMapping(path = "/listArtiste", method = RequestMethod.GET)
	public List<details> lisArtistet() {
		return DetailRepository.listArtiste();
	}
	 
	


	   
    @RequestMapping(path = "/details/by-nom/{id}", method = RequestMethod.GET)
     public Optional<details> ReParNom(@PathVariable("id") Integer id) {
     	return DetailRepository.findById(id); 
     }
     

	@RequestMapping(path = "/details/by-id/{id}", method = RequestMethod.GET)
	public Optional<details> rechercheParId(@PathVariable("id") Integer id) {
		return DetailRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-details", method = RequestMethod.POST)
	public Integer addCategorie(@RequestBody details p) {
		DetailRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateDetails", method = RequestMethod.PUT)
	public void update(@RequestBody details u) {
		DetailRepository.save(u);
	}
 

	
}

