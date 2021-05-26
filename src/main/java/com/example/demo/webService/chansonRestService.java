package com.example.demo.webService;

import com.example.demo.dao.chansonRepository;
import com.example.demo.entite.chanson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

	@RequestMapping(path = "/chansons/by-userId/{idUser}", method = RequestMethod.GET)
	public List<chanson> listChansonsByUser(@PathVariable("idUser") Integer idUser) {
		List<chanson> chansons=ChansonRepository.getChansonsByIdUser(idUser);
		System.out.println("===>> "+chansons);
		return chansons;
	}

	@RequestMapping(path = "/chanson/by-id/{id}", method = RequestMethod.GET)
	public Optional<chanson> rechercheParId(@PathVariable("id") Integer id) {
		return ChansonRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/new-chanson")
	public void newChanson(@Valid @RequestBody chanson p) {
		chanson ch=new chanson(p.getId(),
				p.getCdate(),
				p.getNom(),
				p.getGenre(),
				p.getDatec(),
				p.getType(),
				p.getRbt_src(),
				p.getFeaturing(),
				p.getUdate(),
				p.getAlbum(),
				p.getUser(),
				p.getPlatformes(),
				p.getOperateurs());
		System.out.println(ch.getPlatformes().size());
		p=ch;
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
