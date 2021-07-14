package com.example.demo.webService;

import com.example.demo.dao.detailRepository;
import com.example.demo.dao.userRepository;
import com.example.demo.entite.details;
import com.example.demo.entite.devise;
import com.example.demo.entite.user;
import com.example.demo.excel.DateException;
import com.example.demo.excel.ExcelService;
import com.example.demo.excel.ResponseMessage;
import com.example.demo.excel.nullException;
import com.example.demo.pdf.pdfExceptionDateFormat;
import com.example.demo.pdf.pdfExceptionNoDataFound;
import com.example.demo.pdf.pdfService;
import com.itextpdf.text.DocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class detailRestService {

	@Autowired
	detailRepository DetailRepository;

	@Autowired
	userRepository UserRepository;

	@Autowired
	ExcelService excelService;

	@Autowired
	pdfService PdfService;

	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public List<devise> listeDevise() {
		return DetailRepository.listDetails();
	}

	@RequestMapping(path = "/newdetails", method = RequestMethod.POST)
	public Integer adddetails(@RequestBody details p) {
		DetailRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/deleteDetail/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		DetailRepository.deleteById(id);
	}

	@RequestMapping(path = "/listArtiste", method = RequestMethod.GET)
	public List<details> lisArtistet() {
		return DetailRepository.listArtiste();
	}

	@RequestMapping(path = "/details/by-nom/{id}", method = RequestMethod.GET)
	public Optional<details> ReParNom(@PathVariable("id") Integer id) {
		return DetailRepository.findById(id);
	}

	@RequestMapping(path = "/detail/by-id/{id}", method = RequestMethod.GET)
	public Optional<details> rechercheParId(@PathVariable("id") Integer id) {
		return DetailRepository.findById(id);
	}

	@RequestMapping(path = "/new-detail", method = RequestMethod.POST)
	public Integer addCategorie(@RequestBody details p) {
		DetailRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateDetail", method = RequestMethod.PUT)
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

	/*-----------tout les stat sans top 10 By Users Connected-------------*/

	@RequestMapping(path = "/statArtiste/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statArtisteById(@PathVariable("id") Integer id) {
		return DetailRepository.statArtisteById(id);
	}

	@RequestMapping(path = "/statChanson/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statChansonById(@PathVariable("id") Integer id) {
		return DetailRepository.statChansonById(id);
	}

	@RequestMapping(path = "/statCategorie/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statCategorieById(@PathVariable("id") Integer id) {
		return DetailRepository.statCategoryById(id);
	}

	@RequestMapping(path = "/statPlateforme/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statPlateformeById(@PathVariable("id") Integer id) {
		return DetailRepository.statPlateformeById(id);
	}

	@RequestMapping(path = "/statDate/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statDateById(@PathVariable("id") Integer id) {
		return DetailRepository.statDateById(id);
	}

	/*-----------tout les stat sans top 10 By Users Connected-------------*/

	@RequestMapping(path = "/topArtiste/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statArtisteUsersById(@PathVariable("id") Integer id) {
		return DetailRepository.statArtisteUsersById(id);
	}

	@RequestMapping(path = "/topChanson/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statChansonUsersById(@PathVariable("id") Integer id) {
		return DetailRepository.statChansonUsersById(id);
	}

	@RequestMapping(path = "/topCategory/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statcategoryUsersById(@PathVariable("id") Integer id) {
		return DetailRepository.statcategoryUsersById(id);
	}

	@RequestMapping(path = "/topPlateforme/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statPlateformeUsersById(@PathVariable("id") Integer id) {
		return DetailRepository.statPlateformeUsersById(id);
	}

	@RequestMapping(path = "/topDate/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statDateUsersById(@PathVariable("id") Integer id) {
		return DetailRepository.statDateUsersById(id);
	}

	/*-----------web service pour les totaux des stats----------------*/

	@RequestMapping(path = "/statTotal", method = RequestMethod.GET)
	public List<Object[]> statTotal() {
		return DetailRepository.statTotal();
	}

	@RequestMapping(path = "/statTotal/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statTotalUsersById(@PathVariable("id") Integer id) {
		return DetailRepository.statTotalUsersById(id);
	}

	/*--------------*web Service pour l'upload des details*--------------*/

	@PostMapping("/uploadExcel")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (ExcelService.hasExcelFormat(file)) {
			try {
				excelService.uploadExcel(file);

				message = "l'importation et terminé avec succes: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (DateException | ParseException | InvalidFormatException | nullException e) {
				message = "echec d'importation: " + e.getMessage();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "echec d'importation: le fichier n'est pas de type excel !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	/*--------------*web Service pour la generation des rapport finale*--------------*/

	@GetMapping(value = "/rapportOrange/by-userId-datedebut-datefin/{id}/{datedebut}/{datefin}/{retenue}",produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource>  rapportArtisteOrange(@PathVariable Integer id, @PathVariable java.sql.Date datedebut, @PathVariable java.sql.Date datefin, @PathVariable Double retenue) throws pdfExceptionNoDataFound, pdfExceptionDateFormat, IOException, DocumentException {


			Optional<user> u = UserRepository.findById(id);
			System.out.println("user----->>>>>>>>>>>>>>"+u);
			Date d = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd_HHmmss");

			ByteArrayInputStream in = PdfService.toPDF(id,datedebut, datefin,retenue);
			//System.out.println("aaaa"+ in);
			HttpHeaders headers = new HttpHeaders();
			/*headers.setAccessControlAllowOrigin("*");*/
			headers.add("Content-Disposition", "inline; filename=Rapport_" + u.get().getNom() + "_" + u.get().getPrenom() + "-" + formater.format(d) + ".pdf");

            return ResponseEntity
					.ok()
					.headers(headers)
					.body(new InputStreamResource(in));
	}

	/*--------------------- web service Revenu------------------*/

	@RequestMapping(path = "/HistRevenu", method = RequestMethod.GET)
	public List<Object[]> statRevenu() {
		return DetailRepository.statRevenu();
	}
	/*--------------------- web service Revenu ById------------------*/
	@RequestMapping(path = "/HistRevenu/by-id/{id}", method = RequestMethod.GET)
	public List<Object[]> HistRevenu(@PathVariable("id") Integer id) {
		return DetailRepository.HistRevenu(id);
	}
	/*--------------*Set and get service paiementParMois*--------------
	 *
	@RequestMapping(path = "/paiementParMois", method = RequestMethod.POST, consumes = "application/json")
	public void paiementParMois(@Valid @RequestBody details detailsPaiement) {
		DetailRepository.paiementParMois(detailsPaiement.getNamea(), detailsPaiement.getDate1(),
				detailsPaiement.getDate2());
	}
*/
	@RequestMapping(path = "/paiementParMoisHist/{namea}/{date1}/{date2}", method = RequestMethod.PUT)
	public void paiementParMoisHist(@PathVariable String namea, @PathVariable java.sql.Date date1,@PathVariable java.sql.Date date2) {
		System.out.println(namea+' '+date1+' '+date2);
		DetailRepository.paiementParMoisHist(namea,date1,date2);
	}


	@RequestMapping(path = "/paiementParMois/{namea}/{date1}/{date2}", method = RequestMethod.PUT)
	public void paiementParMois(@PathVariable String namea, @PathVariable java.sql.Date date1,@PathVariable java.sql.Date date2) {
		System.out.println(namea+' '+date1+' '+date2);
		DetailRepository.paiementParMois(namea,date1,date2);
	}
	
	@RequestMapping(path = "/compenseParMois/{namea}/{date1}/{date2}", method = RequestMethod.PUT)
	public void compenseParMois(@PathVariable String namea, @PathVariable java.sql.Date date1,@PathVariable java.sql.Date date2) {
		System.out.println(namea+' '+date1+' '+date2);
		DetailRepository.compenseParMois(namea,date1,date2);
	}
}

