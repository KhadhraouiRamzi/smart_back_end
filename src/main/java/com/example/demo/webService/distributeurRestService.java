package com.example.demo.webService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.distributeurRepository;
import com.example.demo.entite.distributeur;

  


@CrossOrigin(origins = "*")
@RestController
public class distributeurRestService {

	
	@Autowired
	distributeurRepository DistributeurRepository;
	/*
	@RequestMapping(path = "/albums", method = RequestMethod.GET)
	public List<FTP> listeAlbum() {
		return DistributeurRepository.GetAlbumFtp();
	}
	

	@RequestMapping(path = "/listDevise", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return DistributeurRepository.listDevise();
	} 
 	 */


	@RequestMapping(path = "/distributeur/by-id/{id}", method = RequestMethod.GET)
	public Optional<distributeur> rechercheParId(@PathVariable("id") Integer id) {
		return DistributeurRepository.findById(id);
	}
 

    @RequestMapping(method = RequestMethod.POST, path = "/new-distributeur")
    public void newdevise(@RequestBody distributeur p)  {
    	DistributeurRepository.save(p);
 
     }
    
	@RequestMapping(path = "/newDistributeur", method = RequestMethod.POST)
	public Integer adddevise(@RequestBody distributeur p) {
		DistributeurRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/updateDistributeur", method = RequestMethod.PUT)
	public void update(@RequestBody distributeur u) {
		DistributeurRepository.save(u);
 	} 

	@RequestMapping(path = "/deleteDistributeur/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		DistributeurRepository.deleteById(id);
	}


}
