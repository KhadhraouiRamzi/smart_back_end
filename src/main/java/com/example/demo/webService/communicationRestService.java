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

import com.example.demo.dao.communicationRepository;
import com.example.demo.entite.communication;
 

@CrossOrigin(origins = "*")
@RestController
public class communicationRestService {

	
	@Autowired
	communicationRepository CommunicationRepository ;
	
	@RequestMapping(path = "/communications", method = RequestMethod.GET)
	public List<communication> listeCategorie() {
		return CommunicationRepository.GetCommunication();
	}
	 

	@RequestMapping(path = "/listCommunication", method = RequestMethod.GET)
	public List<Object[]> listCommunication() {
		return CommunicationRepository.listCommunication();
	} 
	  

	@RequestMapping(path = "/listDateCom", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return CommunicationRepository.listdetailCom();
	} 
	  


	   
    @RequestMapping(path = "/communications/by-nom/{id}", method = RequestMethod.GET)
     public Optional<communication> ReParNom(@PathVariable("id") Integer id) {
     	return CommunicationRepository.findById(id); 
     }
     

	@RequestMapping(path = "/communication/by-id/{id}", method = RequestMethod.GET)
	public Optional<communication> rechercheParId(@PathVariable("id") Integer id) {
		return CommunicationRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-communication", method = RequestMethod.POST)
	public Integer addCommunication(@RequestBody communication p) {
		CommunicationRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateCommunication", method = RequestMethod.PUT)
	public void update(@RequestBody communication u) {
		CommunicationRepository.save(u);
	}
 

	
}