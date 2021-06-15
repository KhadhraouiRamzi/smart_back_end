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

import com.example.demo.dao.deviseRepository;
import com.example.demo.entite.devise;



@CrossOrigin(origins = "*")
@RestController
public class deviseRestService {

	
	@Autowired
	deviseRepository DeviseRepository;



	@RequestMapping(path = "/devises", method = RequestMethod.GET)
	public List<devise> listeDevise() {
		return DeviseRepository.listDevise();
	}
	 


	@RequestMapping(path = "/devise/by-id/{id}", method = RequestMethod.GET)
	public Optional<devise> rechercheParId(@PathVariable("id") Integer id) {
		return DeviseRepository.findById(id);
	}
 

    @RequestMapping(method = RequestMethod.POST, path = "/new-devise")
    public void newdevise(@RequestBody devise p)  {
    	DeviseRepository.save(p);
 
     }
    
	@RequestMapping(path = "/newDevise", method = RequestMethod.POST)
	public Integer adddevise(@RequestBody devise p) {
		DeviseRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/updateDevise", method = RequestMethod.PUT)
	public void update(@RequestBody devise u) {
		DeviseRepository.save(u);
 	} 

	@RequestMapping(path = "/deleteDevise/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		DeviseRepository.deleteById(id);
	}


}
 