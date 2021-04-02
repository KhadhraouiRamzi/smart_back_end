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

import com.example.demo.dao.roleRepository;
import com.example.demo.entite.role;
 

@CrossOrigin
@RestController
public class roleRestService {

	
@Autowired
roleRepository RoleRepository ;
	
	@RequestMapping(path = "/roles", method = RequestMethod.GET)
	public List<role> listeRoleqq() {
		return RoleRepository.GetRole();
	}
	 

	@RequestMapping(path = "/listRole", method = RequestMethod.GET)
	public List<Object[]> listRole() {
		return RoleRepository.listRole();
	} 
	  

	@RequestMapping(path = "/listDateRol", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return RoleRepository.listDetailRole();
	} 
	  

	   
    @RequestMapping(path = "/roles/by-nom/{id}", method = RequestMethod.GET)
     public Optional<role> ReParNomRole(@PathVariable("id") Integer id) {
     	return RoleRepository.findById(id); 
     }
     

	@RequestMapping(path = "/role/by-id/{id}", method = RequestMethod.GET)
	public Optional<role> rechercheParId(@PathVariable("id") Integer id) {
		return RoleRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-role", method = RequestMethod.POST)
	public Integer addRole(@RequestBody role p) {
		RoleRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateRole", method = RequestMethod.PUT)
	public void update(@RequestBody role u) {
		RoleRepository.save(u);
	}
 

}

