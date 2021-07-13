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

import com.example.demo.dao.artisteRepository;
 import com.example.demo.entite.artiste;
  


@CrossOrigin
@RestController
public class artisteRestService {

	
	@Autowired
	artisteRepository ArtisteRepository ;
	
	@RequestMapping(path = "/artistes", method = RequestMethod.GET)
	public List<artiste> listeCategorie() {
		return ArtisteRepository.GetArtiste();
	}
	 
	

	@RequestMapping(path = "/listDArtiste", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return ArtisteRepository.listDArtiste();
	} 
	 

	@RequestMapping(path = "/artiste", method = RequestMethod.GET)
	public List<artiste> listerClient() {
		return ArtisteRepository.GetArtiste();
	}

	@RequestMapping(path = "/artiste/by-id/{id}", method = RequestMethod.GET)
	public Optional<artiste> rechercheParId(@PathVariable("id") Integer id) {
		return ArtisteRepository.findById(id);
	}
 

    @RequestMapping(method = RequestMethod.POST, path = "/new-artiste")
    public void newProduit(@RequestBody artiste p)  {
		ArtisteRepository.save(p);
 
     }
    
	@RequestMapping(path = "/newartiste", method = RequestMethod.POST)
	public Integer addProduit(@RequestBody artiste p) {
		ArtisteRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/updateArtiste", method = RequestMethod.PUT)
	public void update(@RequestBody artiste u) {
		ArtisteRepository.save(u);
 	} 

	@RequestMapping(path = "/deleteArtiste/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		ArtisteRepository.deleteById(id);
	}


}
*/
