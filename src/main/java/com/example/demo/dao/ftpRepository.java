package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.FTP;
import com.example.demo.entite.album;

 

	 @Repository
	public interface ftpRepository extends JpaRepository<FTP, Integer> {
		
	   String DELETE = null;

	// Client findByEmail(String email);
	   

	 //  @Query("select c from ftp c  ")
	//   	List GetAlbumFtp();
	    

	   
		@Query(nativeQuery = true, value ="select *  from ftp    \r\n"  )//
		List<album> listFtp();
		

		@Query(nativeQuery = true, value ="\r\n" + 
				" select   id   from ftp " )
		List<Object[]> listdetailftp();



}