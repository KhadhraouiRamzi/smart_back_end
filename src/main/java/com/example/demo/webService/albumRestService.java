package com.example.demo.webService;

import com.example.demo.dao.albumRepository;
import com.example.demo.entite.album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//import com.example.demo.dao.artisteRepository;
  
 

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

	@RequestMapping(path = "/album/by-userId/{idUser}", method = RequestMethod.GET)
	public List<album> listAlbumsByUser(@PathVariable("idUser") Integer idUser) {
		List<album> albums = AlbumRepository.getAlbumsByIdUser(idUser);
		System.out.println("===>> " + albums);
		return albums;
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
