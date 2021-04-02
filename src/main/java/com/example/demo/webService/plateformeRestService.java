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

import com.example.demo.dao.plateformeRepository;
import com.example.demo.entite.plateforme;
 

@CrossOrigin
@RestController
public class plateformeRestService {

	
@Autowired
plateformeRepository PlateformeRepository ;
	
	@RequestMapping(path = "/plateformes", method = RequestMethod.GET)
	public List<plateforme> listeHist_communication() {
		return PlateformeRepository.GetPlateforme();
	}
	 

	@RequestMapping(path = "/listPlateforme", method = RequestMethod.GET)
	public List<Object[]> listCommunication() {
		return PlateformeRepository.listPlateforme();
	} 
	  

	@RequestMapping(path = "/listDatePlat", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return PlateformeRepository.listDetailPlat();
	} 
	  

	   
    @RequestMapping(path = "/plateformes/by-nom/{id}", method = RequestMethod.GET)
     public Optional<plateforme> ReParNom(@PathVariable("id") Integer id) {
     	return PlateformeRepository.findById(id); 
     }
     

	@RequestMapping(path = "/plateforme/by-id/{id}", method = RequestMethod.GET)
	public Optional<plateforme> rechercheParId(@PathVariable("id") Integer id) {
		return PlateformeRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-plateforme", method = RequestMethod.POST)
	public Integer addPlateforme(@RequestBody plateforme p) {
		PlateformeRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updatePlateforme", method = RequestMethod.PUT)
	public void update(@RequestBody plateforme u) {
		PlateformeRepository.save(u);
	}
 

}

