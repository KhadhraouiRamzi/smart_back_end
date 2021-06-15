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

import com.example.demo.dao.marketingRepository;
import com.example.demo.entite.marketing;
 

@CrossOrigin(origins = "*")
@RestController
public class marketingRestService {

	
@Autowired
marketingRepository MarketingRepository ;
	
	@RequestMapping(path = "/marketings", method = RequestMethod.GET)
	public List<marketing> listeHist_communication() {
		return MarketingRepository.GetMarketing();
	}
	 

	@RequestMapping(path = "/listMarketing", method = RequestMethod.GET)
	public List<Object[]> listCommunication() {
		return MarketingRepository.listMarketing();
	} 
	  

	@RequestMapping(path = "/listDateMar", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return MarketingRepository.listDetailMarketing();
	} 
	  

	   
    @RequestMapping(path = "/marketings/by-nom/{id}", method = RequestMethod.GET)
     public Optional<marketing> ReParNom(@PathVariable("id") Integer id) {
     	return MarketingRepository.findById(id); 
     }
     

	@RequestMapping(path = "/marketing/by-id/{id}", method = RequestMethod.GET)
	public Optional<marketing> rechercheParId(@PathVariable("id") Integer id) {
		return MarketingRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-marketing", method = RequestMethod.POST)
	public Integer addMarketing(@RequestBody marketing p) {
		MarketingRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateMarketing", method = RequestMethod.PUT)
	public void update(@RequestBody marketing u) {
		MarketingRepository.save(u);
	}
 
	
 	@RequestMapping(path = "/deleteMarketing/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
 		MarketingRepository.deleteById(id);
	}

}

