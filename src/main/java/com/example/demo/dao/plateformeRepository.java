package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.plateforme;

 

@Repository
public interface plateformeRepository extends JpaRepository<plateforme, Integer> {
	
   String DELETE = null;
 
 
 
	 @Query("select c from plateforme c  ")
	    List<plateforme> findMyUsers(@Param("id") Integer id);
	    
	     

		   @Query("select c from plateforme c  ") 
		   	List GetPlateforme();
		    

		   
			@Query(nativeQuery = true, value ="select *  from plateforme    \r\n"  )//
			List<Object[]> listPlateforme();
			

			@Query(nativeQuery = true, value ="\r\n" + 
					" select   id   from plateforme " )
			List<Object[]> listDetailPlat();
			

			@Modifying
			@Transactional
			@Query(nativeQuery = true,value="UPDATE plateforme u SET u.cdate = '2021-03-14' where u.id = id")
			public void updateCdatePlat(@Param("id") Integer plateforme); 
			
}
