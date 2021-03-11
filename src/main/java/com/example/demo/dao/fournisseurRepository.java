/*
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.fournisseur;

 
 

@Repository
public interface fournisseurRepository extends JpaRepository<fournisseur, Integer> {
	
   String DELETE = null;

// Client findByEmail(String email);


	@Query("select c from fournisseur c")// ==> JPQL, nom de la classe ou entité
	static
	List GetFournisseur() {
		// TODO Auto-generated method stub
		return null;
	}
	

 
 
	    @Query("select c from fournisseur c  ")
	    List<fournisseur> findMyUsers(@Param("id") Integer id);
	    
	     
		    
   
	@Query(nativeQuery = true, value ="select *  from fournisseur    \r\n"  )//
	List<fournisseur> listFournisseur();
	 



}
*/
