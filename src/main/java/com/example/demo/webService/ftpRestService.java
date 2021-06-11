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
import com.example.demo.dao.ftpRepository;
import com.example.demo.entite.FTP;


@CrossOrigin(origins = "*")
@RestController
public class ftpRestService {

	
	@Autowired
	ftpRepository FtpRepository ;
	
 	@RequestMapping(path = "/ftps", method = RequestMethod.GET)
	public List<FTP> listeFtps() {
		return FtpRepository.listFtp();
	}
 	

	@RequestMapping(path = "/listdetailF", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return FtpRepository.listdetailftp();
	} 
 

	@RequestMapping(path = "/ftp/by-id/{id}", method = RequestMethod.GET)
	public Optional<FTP> rechercheParId(@PathVariable("id") Integer id) {
		return FtpRepository.findById(id);
	}
 

    @RequestMapping(method = RequestMethod.POST, path = "/new-ftp")
    public void newFtp(@RequestBody FTP p)  {
    	FtpRepository.save(p);
 
     }
    
	@RequestMapping(path = "/newftp", method = RequestMethod.POST)
	public Integer addFtp(@RequestBody FTP p) {
		FtpRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/updateFtp", method = RequestMethod.PUT)
	public void update(@RequestBody FTP u) {
		FtpRepository.save(u);
 	} 

	@RequestMapping(path = "/deleteFtp/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		FtpRepository.deleteById(id);
	}


}
