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

import com.example.demo.dao.historiqueRepository;
import com.example.demo.entite.historique;


@CrossOrigin
@RestController
public class historiqueRestService {

	
@Autowired
historiqueRepository HistoriqueRepository ;
	
	@RequestMapping(path = "/historiques", method = RequestMethod.GET)
	public List<historique> listeHist_communication() {
		return HistoriqueRepository.GetHistorique();
	}
	 

	@RequestMapping(path = "/listHistorique", method = RequestMethod.GET)
	public List<Object[]> listCommunication() {
		return HistoriqueRepository.listHistorique();
	} 
	  

	@RequestMapping(path = "/listDateHist", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return HistoriqueRepository.listdetailHistorique();
	} 
	  


	   
    @RequestMapping(path = "/historiques/by-nom/{id}", method = RequestMethod.GET)
     public Optional<historique> ReParNom(@PathVariable("id") Integer id) {
     	return HistoriqueRepository.findById(id); 
     }
     

	@RequestMapping(path = "/historique/by-id/{id}", method = RequestMethod.GET)
	public Optional<historique> rechercheParId(@PathVariable("id") Integer id) {
		return HistoriqueRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-historique", method = RequestMethod.POST)
	public Integer addCommunication(@RequestBody historique p) {
		HistoriqueRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateHistorique", method = RequestMethod.PUT)
	public void update(@RequestBody historique u) {
		HistoriqueRepository.save(u);
	}
 

}
