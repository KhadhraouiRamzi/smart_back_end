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

 import com.example.demo.dao.hist_communicationRepositoy;
import com.example.demo.entite.hist_communication;


@CrossOrigin
@RestController
public class hist_communicationRestService {

	
	@Autowired
	hist_communicationRepositoy Hist_communicationRepository ;
	
	@RequestMapping(path = "/hist_communications", method = RequestMethod.GET)
	public List<hist_communication> listeHist_communication() {
		return Hist_communicationRepository.GetHistCommunication();
	}
	 

	@RequestMapping(path = "/listHistCommunication", method = RequestMethod.GET)
	public List<Object[]> listCommunication() {
		return Hist_communicationRepository.listHistCommunication();
	} 
	  

	@RequestMapping(path = "/listDateHistCom", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return Hist_communicationRepository.listdetailHistCom();
	} 
	  


	   
    @RequestMapping(path = "/HistCommunications/by-nom/{id}", method = RequestMethod.GET)
     public Optional<hist_communication> ReParNom(@PathVariable("id") Integer id) {
     	return Hist_communicationRepository.findById(id); 
     }
     

	@RequestMapping(path = "/HistCommunication/by-id/{id}", method = RequestMethod.GET)
	public Optional<hist_communication> rechercheParId(@PathVariable("id") Integer id) {
		return Hist_communicationRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-histCommunication", method = RequestMethod.POST)
	public Integer addCommunication(@RequestBody hist_communication p) {
		Hist_communicationRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateHistCommunication", method = RequestMethod.PUT)
	public void update(@RequestBody hist_communication u) {
		Hist_communicationRepository.save(u);
	}
 

	
}