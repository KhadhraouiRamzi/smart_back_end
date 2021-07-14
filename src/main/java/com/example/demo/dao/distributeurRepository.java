package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.distributeur;
 

@Repository
public interface distributeurRepository extends JpaRepository<distributeur, Integer> {
	
   String DELETE = null;

// Client findByEmail(String email);


	@Query("select c from distributeur c")// ==> JPQL, nom de la classe ou entité
	static
	List GetDistributeur() {
		// TODO Auto-generated method stub
		return null;
	}
	
 
 
    @Query("select c from distributeur c  ")
    List<distributeur> findMyUsers(@Param("id") Integer id);
	    
	     
		    
   
	@Query(nativeQuery = true, value ="select *  from distributeur    \r\n"  )//
	List<distributeur> listDistributeur();
	 



}