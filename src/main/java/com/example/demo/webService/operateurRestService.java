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

import com.example.demo.dao.operateurReposirory;
import com.example.demo.entite.operateur;
 
@CrossOrigin
@RestController
public class operateurRestService {

	
@Autowired
operateurReposirory OperateurRepository ;
	
	@RequestMapping(path = "/operateurs", method = RequestMethod.GET)
	public List<operateur> listeHist_communication() {
		return OperateurRepository.Getoperateur();
	}
	 

	@RequestMapping(path = "/listoperateur", method = RequestMethod.GET)
	public List<Object[]> listCommunication() {
		return OperateurRepository.listoperateur();
	} 
	  

	@RequestMapping(path = "/listDateOpe", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return OperateurRepository.listDetailOpe();
	} 
	  

	   
    @RequestMapping(path = "/operateurs/by-nom/{id}", method = RequestMethod.GET)
     public Optional<operateur> ReParNom(@PathVariable("id") Integer id) {
     	return OperateurRepository.findById(id); 
     }
     

	@RequestMapping(path = "/operateur/by-id/{id}", method = RequestMethod.GET)
	public Optional<operateur> rechercheParId(@PathVariable("id") Integer id) {
		return OperateurRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-operateur", method = RequestMethod.POST)
	public Integer addoperateur(@RequestBody operateur p) {
		OperateurRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateOperateur", method = RequestMethod.PUT)
	public void update(@RequestBody operateur u) {
		OperateurRepository.save(u);
	}

	@RequestMapping(path = "/deleteOperateur/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		OperateurRepository.deleteById(id);
	}


}
