package com.example.demo.webService;

import com.example.demo.dao.userRepository;
import com.example.demo.entite.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@CrossOrigin
@RestController
public class userRestService {

	@Autowired
	userRepository UserRepository;

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<user> listeUsers() {
		return UserRepository.GetUser();
	}
 
	@RequestMapping(path = "/artistes", method = RequestMethod.GET)
	public List<user> listeAlbums() {
		return UserRepository.GetArtistes();
	}

	@RequestMapping(path = "/ArtFour", method = RequestMethod.GET)
	public List<user> ArtFour() {
		return UserRepository.GetArtFour();
	}


	@RequestMapping(path = "/fours", method = RequestMethod.GET)
	public List<user> listeFours() {
		return UserRepository.GetFours();
	}

	@RequestMapping(path = "/admins", method = RequestMethod.GET)
	public List<user> listeAdmins() {
		return UserRepository.GetAdmins();
	}

	@RequestMapping(path = "/fournisseurs", method = RequestMethod.GET)
	public List<user> listeFournisseurs() {
		return UserRepository.GetFournisseurs();
	}
	


	@RequestMapping(path = "/listUser", method = RequestMethod.GET)
	public List<Object[]> listDetail() {
		return UserRepository.listDUsers();
	}

	@RequestMapping(path = "/user/by-id/{id}", method = RequestMethod.GET)
	public Optional<user> rechercheParId(@PathVariable("id") Integer id) {
		return UserRepository.findById(id);
	}

	@RequestMapping(path = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		UserRepository.deleteById(id);
	}

	@RequestMapping(path = "/updateUser", method = RequestMethod.PUT)
	public void update(@RequestBody user u) {
		UserRepository.save(u);
	}

	@RequestMapping(path = "/newUser", method = RequestMethod.POST)
	public Integer addUser(@RequestBody user p) {
		UserRepository.save(p);
		return p.getId();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/new-user")
	public void newAlbum(@RequestBody user p) {
		UserRepository.save(p);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/test1")
	public void newTes1(@RequestBody user p) {
		user newU = new user(p.getId(), p.getCdate(),p.getUdate(), p.getNom(), p.getPrenom(), p.getImage(),p.getName(),p.getType(),
				p.getPicByte(),p.getnArtistique(), p.getPhone(),p.getEmail(),p.getPassword(),p.getDate(),
				p.getNationnalite(), p.getCin(), p.getDatecin(), p.getContrat(),p.getPart(), p.getRetenu(),
				p.getProposition(),p.getRoles(),p.getMarketing());
		System.out.println("aa" +p.getIdRole());
		System.out.println("bb" +p.getName());
		System.out.println("cc" +newU.getIdRole());
		System.out.println("dd" +newU.getName());
		UserRepository.save(p);
 	}

	@RequestMapping(method = RequestMethod.POST, path = "/test")
	public BodyBuilder newTes(@RequestParam("imageFile") MultipartFile files,@RequestBody user p) throws IOException {
		 user img = new user(files.getOriginalFilename(), files.getContentType(),compressBytes(files.getBytes()));
 		 UserRepository.save(img);
		// p.setPicByte(img.getPicByte());
		p.setFiles(null);
		p.setPicByte(null);
		p.setType("bb");
 		//UserRepository.save(p);
		return ResponseEntity.status(HttpStatus.OK);
	}


	@RequestMapping(path = "/upload/{id}", method = RequestMethod.PUT)
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile files,@PathVariable("id") Integer id) throws IOException {
		System.out.println("Original Image Byte Size - " + files.getBytes().length);
		user img = new user(files.getOriginalFilename(), files.getContentType(), compressBytes(files.getBytes()));
		UserRepository.savenew(files.getOriginalFilename(), compressBytes(files.getBytes()), files.getContentType(), id);
		return null;
		}
		
	@RequestMapping(path = "/uploadIn", method = RequestMethod.PUT)
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile files) throws IOException {
		System.out.println("Original Image Byte Size - " + files.getBytes().length);
		user img = new user(files.getOriginalFilename(), files.getContentType(), compressBytes(files.getBytes()));
		UserRepository.savenewIn(files.getOriginalFilename(), compressBytes(files.getBytes()), files.getContentType());
		return null;
		}
	/*			System.out.println("Original Image Byte Size - " + files.getBytes().length);
				System.out.println("Contenu : "+ img.getId()  + img.getName()+" "+ img.getPicByte());
				user newU = new user(p.getId(), p.getCdate(),p.getUdate(), p.getNom(), p.getPrenom(), p.getImage(),p.getName(),p.getType(),
				p.getPicByte(),p.getnArtistique(), p.getPhone(),p.getEmail(),p.getPassword(),p.getDate(),
				p.getNationnalite(), p.getCin(), p.getDatecin(), p.getContrat(),p.getPart(), p.getRetenu(),
				p.getProposition(),p.getRoles(),p.getMarketing());*/
	

	private Integer maxId() {
		// TODO Auto-generated method stub
		return UserRepository.maxId();
 	}
	@RequestMapping(path = "/arts", method = RequestMethod.GET)
	public List<user> listeArts() {
		return UserRepository.GetArtss();
	}
	
	@RequestMapping(path = "/artssss", method = RequestMethod.GET)
	public List<user> listeArtiss() {
		user p = new user();
		//p = UserRepository.GetArtss() ;
		return UserRepository.GetArtss() ;
	}
	
	@RequestMapping(path = "/artis", method = RequestMethod.GET)
	public List<user> listeArtis() {
		 user p = new user();
		return UserRepository.GetArts(p.getId(), p.getCdate(), p.getCin(),p.getContrat(), p.getDate(),p.getDatecin(), p.getEmail(), p.getImage(),
				p.getnArtistique(),p.getNationnalite(), p.getNom(), p.getPassword(),p.getPhone(),  p.getPrenom(), p.getProposition(),p.getUdate(), 
				p.getMarketing(),p.getPart(),  p.getRetenu(), p.getName(),decompressBytes(p.getPicByte()), p.getType(), p.getFiles());
		
		/*for (int i = 0; i < 6; i++) {
			user newU1 = new user(p.getId(), p.getCdate(),p.getUdate(), p.getNom(), p.getPrenom(), p.getImage(),p.getName(),p.getType(),
					decompressBytes(p.getPicByte()),p.getnArtistique(), p.getPhone(),p.getEmail(),p.getPassword(),p.getDate(),
					p.getNationnalite(), p.getCin(), p.getDatecin(), p.getContrat(),p.getPart(), p.getRetenu(),
					p.getProposition(),p.getRoles(),p.getMarketing());
			}
		return newU;*/
	}
	

	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
	public user getImage(@PathVariable("id") Integer id) throws IOException {
		Optional<user> retrievedImage = UserRepository.findById(id);
		System.out.println("img "+retrievedImage);
			if(retrievedImage.get().getType()!=null) {
				user img = new user(retrievedImage.get().getName(), retrievedImage.get().getType(),
						decompressBytes(retrievedImage.get().getPicByte()));
				return img;
			}
		else return	retrievedImage.get();

	}

	public static byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();
 
		deflater.setInput(data);

		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);

		}

		try {

			outputStream.close();

		} catch (IOException e) {

		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();

	}

// uncompress the image bytes before returning it to the angular application

	public static byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}

}
