package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 import com.example.demo.entite.hist_communication;
import com.example.demo.entite.historique;

@Repository
public interface historiqueRepository extends JpaRepository<historique, Integer> {
	
   String DELETE = null;
 
 
 
	 @Query("select c from historique c  ")
	    List<historique> findMyUsers(@Param("id") Integer id);
	    
	     

		   @Query("select c from historique c  ") 
		   	List GetHistorique();
		    

		   
			@Query(nativeQuery = true, value ="select *  from historique    \r\n"  )//
			List<Object[]> listHistorique();
			

			@Query(nativeQuery = true, value ="\r\n" + 
					" select   id   from historique " )
			List<Object[]> listdetailHistorique();
			

			@Modifying
			@Transactional
			@Query(nativeQuery = true,value="UPDATE historique u SET u.cdate = '2021-03-14' where u.id = id")
			public void updateCdateHist(@Param("id") Integer historique); 
			
}