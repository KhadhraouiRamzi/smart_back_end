/*
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.artiste;
 
@Repository
public interface artisteRepository extends JpaRepository<artiste, Integer> {
	
   String DELETE = null;

// Client findByEmail(String email);


	@Query("select c from artiste c")// ==> JPQL, nom de la classe ou entité
	List GetArtistess();
	

 
 
	 @Query("select c from artiste c  ")
	    List<artiste> findMyUsers(@Param("id") Integer id);
	    
	     
		    
   
	@Query(nativeQuery = true, value ="select *  from artiste    \r\n"  )//
	List<artiste> listArtiste();
	

	@Query(nativeQuery = true, value ="\r\n" + 
			" select   nom,prenom,phone,email,cin,part   from artiste " )
	List<Object[]> listDArtiste();
	

}
*/
