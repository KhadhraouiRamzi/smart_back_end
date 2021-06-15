package com.example.demo.webService;

import com.example.demo.dao.operateurReposirory;
import com.example.demo.entite.operateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
 
@CrossOrigin(origins = "*")
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
