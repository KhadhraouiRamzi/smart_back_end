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

import com.example.demo.dao.albumRepository;
//import com.example.demo.dao.artisteRepository;
import com.example.demo.entite.album;
  
 

@CrossOrigin
@RestController
public class albumRestService {

	
	@Autowired
	albumRepository AlbumRepository ;
	
	@RequestMapping(path = "/albums", method = RequestMethod.GET)
	public List<album> listeAlbum() {
		return AlbumRepository.GetAlbum();
	}
	 
	

	@RequestMapping(path = "/listdetailA", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return AlbumRepository.listdetail();
	} 
 

	@RequestMapping(path = "/album/by-id/{id}", method = RequestMethod.GET)
	public Optional<album> rechercheParId(@PathVariable("id") Integer id) {
		return AlbumRepository.findById(id);
	}
 

    @RequestMapping(method = RequestMethod.POST, path = "/new-album")
    public void newAlbum(@RequestBody album p)  {
    	AlbumRepository.save(p);
 
     }
    
	@RequestMapping(path = "/newalbum", method = RequestMethod.POST)
	public Integer addAlbum(@RequestBody album p) {
		AlbumRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/updateAlbum", method = RequestMethod.PUT)
	public void update(@RequestBody album u) {
		AlbumRepository.save(u);
 	} 

	@RequestMapping(path = "/deleteAlbum/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		AlbumRepository.deleteById(id);
	}


}
