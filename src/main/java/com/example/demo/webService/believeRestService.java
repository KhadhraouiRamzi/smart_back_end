package com.example.demo.webService;

import com.example.demo.dao.believeRepository;
import com.example.demo.dao.userRepository;
import com.example.demo.entite.details;
import com.example.demo.entite.devise;
import com.example.demo.entite.user;
import com.example.demo.excel.DateException;
import com.example.demo.excel.ExcelService;
import com.example.demo.excel.ResponseMessage;
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
public class believeRestService {

	@Autowired
	believeRepository BelieveRepository;

	@Autowired
	userRepository UserRepository;

	@Autowired
	ExcelService excelService;

	@Autowired
	pdfService PdfService;

	@RequestMapping(path = "/detailsBelieve", method = RequestMethod.GET)
	public List<devise> listeDevise() {
		return BelieveRepository.listDetails();
	}

	@RequestMapping(path = "/newdetailsBelieve", method = RequestMethod.POST)
	public Integer adddetails(@RequestBody details p) {
		BelieveRepository.save(p);
		return p.getId();

	}

	@RequestMapping(path = "/deleteDetailBelieve/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		BelieveRepository.deleteById(id);
	}

	@RequestMapping(path = "/listArtisteBelieve", method = RequestMethod.GET)
	public List<details> lisArtistet() {
		return BelieveRepository.listArtiste();
	}

	@RequestMapping(path = "/detailsBelieve/by-nom/{id}", method = RequestMethod.GET)
	public Optional<details> ReParNom(@PathVariable("id") Integer id) {
		return BelieveRepository.findById(id);
	}

	@RequestMapping(path = "/detailBelieve/by-id/{id}", method = RequestMethod.GET)
	public Optional<details> rechercheParId(@PathVariable("id") Integer id) {
		return BelieveRepository.findById(id);
	}

	@RequestMapping(path = "/new-detailBelieve", method = RequestMethod.POST)
	public Integer addCategorie(@RequestBody details p) {
		BelieveRepository.save(p);
		return p.getId();
	}

	@RequestMapping(path = "/updateDetailBelieve", method = RequestMethod.PUT)
	public void update(@RequestBody details u) {
		BelieveRepository.save(u);
	}

	/*----------------------------stat avec top 10---------------------------*/

	@RequestMapping(path = "/listDetailBelieve", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return BelieveRepository.listDetail();
	}

	@RequestMapping(path = "/topChansonBelieve", method = RequestMethod.GET)
	public List<Object[]> listChanson() {
		return BelieveRepository.topChanson();
	}

	@RequestMapping(path = "/topArtisteBelieve", method = RequestMethod.GET)
	public List<Object[]> topArtiste() {
		return BelieveRepository.topArtiste();
	}

	@RequestMapping(path = "/topCategoryBelieve", method = RequestMethod.GET)
	public List<Object[]> topCategory() {
		return BelieveRepository.topCategory();
	}

	@RequestMapping(path = "/topCountCBelieve", method = RequestMethod.GET)
	public List<Object[]> topCountC() {
		return BelieveRepository.topCountC();
	}

	@RequestMapping(path = "/topCountABelieve", method = RequestMethod.GET)
	public List<Object[]> topCountA() {
		return BelieveRepository.topCountA();
	}

	@RequestMapping(path = "/topDateBelieve", method = RequestMethod.GET)
	public List<Object[]> topDate() {
		return BelieveRepository.topDate();
	}

	@RequestMapping(path = "/topPaysBelieve", method = RequestMethod.GET)
	public List<Object[]> topPaysBelieve() {
		return BelieveRepository.topPaysBelieve();
	}
	
	@RequestMapping(path = "/topAbonnementBelieve", method = RequestMethod.GET)
	public List<Object[]> topAbonnementBelieve() {
		return BelieveRepository.topAbonnementBelieve();
	}
	/*-----------tout les stat sans top 10-------------*/

	@RequestMapping(path = "/statArtisteBelieve", method = RequestMethod.GET)
	public List<Object[]> statArtiste() {
		return BelieveRepository.statArtiste();
	}

	@RequestMapping(path = "/statChansonBelieve", method = RequestMethod.GET)
	public List<Object[]> statChanson() {
		return BelieveRepository.statChanson();
	}

	@RequestMapping(path = "/statcategoryBelieve", method = RequestMethod.GET)
	public List<Object[]> statcategory() {
		return BelieveRepository.statcategory();
	}

	@RequestMapping(path = "/statCountCBelieve", method = RequestMethod.GET)
	public List<Object[]> statCountC() {
		return BelieveRepository.statCountC();
	}

	@RequestMapping(path = "/statCountABelieve", method = RequestMethod.GET)
	public List<Object[]> statCountA() {
		return BelieveRepository.statCountA();
	}

	@RequestMapping(path = "/statDateBelieve", method = RequestMethod.GET)
	public List<Object[]> statDate() {
		return BelieveRepository.statDate();
	}

	@RequestMapping(path = "/statPlateformeBelieve", method = RequestMethod.GET)
	public List<Object[]> statPlateforme() {
		return BelieveRepository.statPlateforme();
	}

	@RequestMapping(path = "/statPlateformeCBelieve", method = RequestMethod.GET)
	public List<Object[]> statPlateformeC() {
		return BelieveRepository.statPlateformeC();
	}

	@RequestMapping(path = "/statPaysBelieve", method = RequestMethod.GET)
	public List<Object[]> statPaysBelieve() {
		return BelieveRepository.statPaysBelieve();
	}
	
	@RequestMapping(path = "/statAbonnementBelieve", method = RequestMethod.GET)
	public List<Object[]> statAbonnementBelieve() {
		return BelieveRepository.statAbonnementBelieve();
	}
	
	/*-----------tout les stat sans top 10 By Users Connected-------------*/

	@RequestMapping(path = "/statArtisteBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statArtisteById(@PathVariable("id") Integer id) {
		return BelieveRepository.statArtisteById(id);
	}

	@RequestMapping(path = "/statChansonBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statChansonById(@PathVariable("id") Integer id) {
		return BelieveRepository.statChansonById(id);
	}

	@RequestMapping(path = "/statCategorieBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statCategorieById(@PathVariable("id") Integer id) {
		return BelieveRepository.statCategoryById(id);
	}

	@RequestMapping(path = "/statPlateformeBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statPlateformeById(@PathVariable("id") Integer id) {
		return BelieveRepository.statPlateformeById(id);
	}

	@RequestMapping(path = "/statDateBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statDateById(@PathVariable("id") Integer id) {
		return BelieveRepository.statDateById(id);
	}
	

	@RequestMapping(path = "/statPaysBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statPaysBelieve(@PathVariable("id") Integer id) {
		return BelieveRepository.statPaysBelieve(id);
	}

	@RequestMapping(path = "/statAbonnementBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statAbonnementBelieve(@PathVariable("id") Integer id) {
		return BelieveRepository.statAbonnementBelieve(id);
	}

	/*-----------tout les stat sans top 10 By Users Connected-------------*/

	@RequestMapping(path = "/topArtisteBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statArtisteUsersById(@PathVariable("id") Integer id) {
		return BelieveRepository.statArtisteUsersById(id);
	}

	@RequestMapping(path = "/topChansonBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statChansonUsersById(@PathVariable("id") Integer id) {
		return BelieveRepository.statChansonUsersById(id);
	}

	@RequestMapping(path = "/topCategoryBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statcategoryUsersById(@PathVariable("id") Integer id) {
		return BelieveRepository.statcategoryUsersById(id);
	}

	@RequestMapping(path = "/topPlateformeBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statPlateformeUsersById(@PathVariable("id") Integer id) {
		return BelieveRepository.statPlateformeUsersById(id);
	}

	@RequestMapping(path = "/topDateBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statDateUsersById(@PathVariable("id") Integer id) {
		return BelieveRepository.statDateUsersById(id);
	}


	@RequestMapping(path = "/topPaysBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> topPaysBelieveById(@PathVariable("id") Integer id) {
		return BelieveRepository.topPaysBelieveById(id);
	}


	@RequestMapping(path = "/topAbonnementBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> topAbonnementBelieveById(@PathVariable("id") Integer id) {
		return BelieveRepository.topAbonnementBelieveById(id);
	}

	/*-----------web service pour les totaux des stats----------------*/

	@RequestMapping(path = "/statTotalBelieve", method = RequestMethod.GET)
	public List<Object[]> statTotal() {
		return BelieveRepository.statTotal();
	}

	@RequestMapping(path = "/statTotalBelieve/by-userId/{id}", method = RequestMethod.GET)
	public List<Object[]> statTotalUsersById(@PathVariable("id") Integer id) {
		return BelieveRepository.statTotalUsersById(id);
	}

	/*--------------*web Service pour l'upload des details*--------------*/

	@PostMapping("/uploadExcelBelieve")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (ExcelService.hasExcelFormat(file)) {
			try {
				excelService.uploadExcel(file);

				message = "l'importation et terminé avec succes: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (DateException | ParseException | InvalidFormatException e) {
				message = "echec d'importation: " + e.getMessage();
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}
		message = "echec d'importation: le fichier n'est pas de type excel !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	/*--------------*web Service pour la generation des rapport finale*--------------*/

	@GetMapping(value = "/rapportOrangeBelieve/by-userId-datedebut-datefin/{id}/{datedebut}/{datefin}/{retenue}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> rapportArtisteOrange(@PathVariable Integer id,
			@PathVariable java.sql.Date datedebut, @PathVariable java.sql.Date datefin, @PathVariable Double retenue)
			throws pdfExceptionNoDataFound, pdfExceptionDateFormat, IOException, DocumentException {

		Optional<user> u = UserRepository.findById(id);
		System.out.println("user----->>>>>>>>>>>>>>" + u);
		Date d = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd_HHmmss");

		ByteArrayInputStream in = PdfService.toPDF(id, datedebut, datefin, retenue);
		if (in == null) {
			System.out.println("PDF	----->>>>>>>>>>>>>>" + in);
			return (ResponseEntity<InputStreamResource>) ResponseEntity.status(HttpStatus.OK);
		} else {
			System.out.println("aaaa" + in);
			HttpHeaders headers = new HttpHeaders();
			/* headers.setAccessControlAllowOrigin("*"); */
			headers.add("Content-Disposition", "inline; filename=Rapport_" + u.get().getNom() + "_"
					+ u.get().getPrenom() + "-" + formater.format(d) + ".pdf");

			// return ResponseEntity.status(HttpStatus.OK);

			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
		}
	}

	/*--------------------- web service Revenu------------------*/

	@RequestMapping(path = "/HistRevenuBelieve", method = RequestMethod.GET)
	public List<Object[]> statRevenu() {
		return BelieveRepository.statRevenu();
	}

	/*--------------------- web service Revenu ById------------------*/
	@RequestMapping(path = "/HistRevenuBelieve/by-id/{id}", method = RequestMethod.GET)
	public List<Object[]> HistRevenu(@PathVariable("id") Integer id) {
		return BelieveRepository.HistRevenu(id);
	}

	/*--------------*Set and get service paiementParMois*--------------
	 *
	@RequestMapping(path = "/paiementParMois", method = RequestMethod.POST, consumes = "application/json")
	public void paiementParMois(@Valid @RequestBody details detailsPaiement) {
		BelieveRepository.paiementParMois(detailsPaiement.getNamea(), detailsPaiement.getDate1(),
				detailsPaiement.getDate2());
	}
	*/
	@RequestMapping(path = "/paiementParMoisHistBelieve/{namea}/{date1}/{date2}", method = RequestMethod.PUT)
	public void paiementParMoisHist(@PathVariable String namea, @PathVariable java.sql.Date date1,
			@PathVariable java.sql.Date date2) {
		System.out.println(namea + ' ' + date1 + ' ' + date2);
		BelieveRepository.paiementParMoisHist(namea, date1, date2);
	}

	@RequestMapping(path = "/paiementParMoisBelieve/{namea}/{date1}/{date2}", method = RequestMethod.PUT)
	public void paiementParMois(@PathVariable String namea, @PathVariable java.sql.Date date1,
			@PathVariable java.sql.Date date2) {
		System.out.println(namea + ' ' + date1 + ' ' + date2);
		BelieveRepository.paiementParMois(namea, date1, date2);
	}

	@RequestMapping(path = "/compenseParMoisBelieve/{namea}/{date1}/{date2}", method = RequestMethod.PUT)
	public void compenseParMois(@PathVariable String namea, @PathVariable java.sql.Date date1,
			@PathVariable java.sql.Date date2) {
		System.out.println(namea + ' ' + date1 + ' ' + date2);
		BelieveRepository.compenseParMois(namea, date1, date2);
	}
}
