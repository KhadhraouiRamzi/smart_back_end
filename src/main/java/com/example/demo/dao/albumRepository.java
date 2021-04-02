package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.album;
 
 

	 @Repository
	public interface albumRepository extends JpaRepository<album, Integer> {
		
	   String DELETE = null;

	// Client findByEmail(String email);
	   

	   @Query("select c from album c  ")
	   	List GetAlbum();
	    

	   
		@Query(nativeQuery = true, value ="select *  from album    \r\n"  )//
		List<album> listAlbum();
		

		@Query(nativeQuery = true, value ="\r\n" + 
				" select   id   from album " )
		List<Object[]> listdetail();



}
