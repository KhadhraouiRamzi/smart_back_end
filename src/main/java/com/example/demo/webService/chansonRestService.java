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

import com.example.demo.dao.chansonRepository;
import com.example.demo.entite.chanson;

@CrossOrigin
@RestController
public class chansonRestService {

	@Autowired
	chansonRepository ChansonRepository;

	@RequestMapping(path = "/chansons", method = RequestMethod.GET)
	public List<chanson> listeAlbum() {
		return ChansonRepository.GetChnason();
	}

	@RequestMapping(path = "/listdetailC", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return ChansonRepository.listdetail();
	}

	@RequestMapping(path = "/chanson", method = RequestMethod.GET)
	public List<chanson> listerClient() {
		return ChansonRepository.GetChnason();
	}

	@RequestMapping(path = "/chanson/by-id/{id}", method = RequestMethod.GET)
	public Optional<chanson> rechercheParId(@PathVariable("id") Integer id) {
		return ChansonRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/new-chanson")
	public void newChanson(@RequestBody chanson p) {
		ChansonRepository.save(p);
		// ChansonRepository.updatecdate(p.getId());
	}
  
	@RequestMapping(path = "/newchanson", method = RequestMethod.POST)
	public Integer addProduit(@RequestBody chanson p) {
		ChansonRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateChanson", method = RequestMethod.PUT)
	public void update(@RequestBody chanson u) {
		ChansonRepository.save(u);
	}

	@RequestMapping(path = "/deleteChanson/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		ChansonRepository.deleteById(id);
	}

}
