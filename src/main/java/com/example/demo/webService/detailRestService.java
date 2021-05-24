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

	/*----------------------------stat avec top 10---------------------------*/

	@RequestMapping(path = "/listDetail", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return DetailRepository.listDetail();
	}

	@RequestMapping(path = "/topChanson", method = RequestMethod.GET)
	public List<Object[]> listChanson() {
		return DetailRepository.topChanson();
	}

	@RequestMapping(path = "/topArtiste", method = RequestMethod.GET)
	public List<Object[]> topArtiste() {
		return DetailRepository.topArtiste();
	}


	@RequestMapping(path = "/topCategory", method = RequestMethod.GET)
	public List<Object[]> topCategory() {
		return DetailRepository.topCategory();
	}

	@RequestMapping(path = "/topCountC", method = RequestMethod.GET)
	public List<Object[]> topCountC() {
		return DetailRepository.topCountC();
	}

	@RequestMapping(path = "/topCountA", method = RequestMethod.GET)
	public List<Object[]> topCountA() {
		return DetailRepository.topCountA();
	}

	@RequestMapping(path = "/topDate", method = RequestMethod.GET)
	public List<Object[]> topDate() {
		return DetailRepository.topDate();
	}

	/*-----------tout les stat sans top 10-------------*/

	@RequestMapping(path = "/statArtiste", method = RequestMethod.GET)
	public List<Object[]> statArtiste() {
		return DetailRepository.statArtiste();
	}

	@RequestMapping(path = "/statChanson", method = RequestMethod.GET)
	public List<Object[]> statChanson() {
		return DetailRepository.statChanson();
	}

	@RequestMapping(path = "/statcategory", method = RequestMethod.GET)
	public List<Object[]> statcategory() {
		return DetailRepository.statcategory();
	}

	@RequestMapping(path = "/statCountC", method = RequestMethod.GET)
	public List<Object[]> statCountC() {
		return DetailRepository.statCountC();
	}

	@RequestMapping(path = "/statCountA", method = RequestMethod.GET)
	public List<Object[]> statCountA() {
		return DetailRepository.statCountA();
	}

	@RequestMapping(path = "/statDate", method = RequestMethod.GET)
	public List<Object[]> statDate() {
		return DetailRepository.statDate();
	}

	@RequestMapping(path = "/statPlateforme", method = RequestMethod.GET)
	public List<Object[]> statPlateforme() {
		return DetailRepository.statPlateforme();
	}

	@RequestMapping(path = "/statPlateformeC", method = RequestMethod.GET)
	public List<Object[]> statPlateformeC() {
		return DetailRepository.statPlateformeC();
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

