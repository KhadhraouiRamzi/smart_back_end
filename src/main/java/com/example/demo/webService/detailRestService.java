package com.example.demo.webService;

import com.example.demo.dao.detailRepository;
import com.example.demo.entite.details;
import com.example.demo.excel.ExcelService;
import com.example.demo.excel.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
 
@CrossOrigin
@RestController
public class detailRestService {
	
	@Autowired
	detailRepository DetailRepository ;

	@Autowired
	ExcelService excelService;
	
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public List<details> listeCategorie() {
		return DetailRepository.GetDetails();
	}	 
 
	@RequestMapping(path = "/listDetail", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return DetailRepository.listDetail();
	} 	 

	@RequestMapping(path = "/listChanson", method = RequestMethod.GET)
	public List<Object[]> listChanson() {
		return DetailRepository.listChanson();
	} 	   

	@RequestMapping(path = "/listdate", method = RequestMethod.GET)
	public List<Object[]> listdate() {
		return DetailRepository.listdate();
	}  

	@RequestMapping(path = "/listArtiste", method = RequestMethod.GET)
	public List<details> lisArtistet() {
		return DetailRepository.listArtiste();
	}
	   
    @RequestMapping(path = "/details/by-nom/{id}", method = RequestMethod.GET)
     public Optional<details> ReParNom(@PathVariable("id") Integer id) {
     	return DetailRepository.findById(id); 
     }     

	@RequestMapping(path = "/details/by-id/{id}", method = RequestMethod.GET)
	public Optional<details> rechercheParId(@PathVariable("id") Integer id) {
		return DetailRepository.findById(id);
	}
	
	@RequestMapping(path = "/new-details", method = RequestMethod.POST)
	public Integer addCategorie(@RequestBody details p) {
		DetailRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateDetails", method = RequestMethod.PUT)
	public void update(@RequestBody details u) {
		DetailRepository.save(u);
	}

	/*--------------*web Service pour l'upload des details*--------------*/

	@PostMapping("/uploadExcel")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (excelService.hasExcelFormat(file)) {
			try {
				excelService.uploadExcel(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + ": "+e;
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}  
		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

}

