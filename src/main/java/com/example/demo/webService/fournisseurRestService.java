/*
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

import com.example.demo.dao.fournisseurRepository;
import com.example.demo.entite.fournisseur;
 


@CrossOrigin
@RestController
public class fournisseurRestService {

	
	@Autowired
	fournisseurRepository FournisseurRepository ;
	
	@RequestMapping(path = "/fournisseurs", method = RequestMethod.GET)
	public List<fournisseur> listeFournisseur() {
		return fournisseurRepository.GetFournisseur();
	}
	 
	  
	 

	@RequestMapping(path = "/fournisseur", method = RequestMethod.GET)
	public List<fournisseur> listeFournisseur2() {
		return FournisseurRepository.listFournisseur();
	}

	@RequestMapping(path = "/fournisseur/by-id/{id}", method = RequestMethod.GET)
	public Optional<fournisseur> rechercheParId(@PathVariable("id") Integer id) {
		return FournisseurRepository.findById(id);
	}
 

    @RequestMapping(method = RequestMethod.POST, path = "/new-fournisseur")
    public void newFournisseur(@RequestBody fournisseur p)  {
		FournisseurRepository.save(p);
 
     }
    
	@RequestMapping(path = "/newfournisseur", method = RequestMethod.POST)
	public Integer addProduit(@RequestBody fournisseur p) {
		FournisseurRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/updateFournisseur", method = RequestMethod.PUT)
	public void update(@RequestBody fournisseur u) {
		FournisseurRepository.save(u);
 	} 

	@RequestMapping(path = "/deleteFournisseur/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		FournisseurRepository.deleteById(id);
	}


}*/
