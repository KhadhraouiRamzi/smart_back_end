package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.operateur;

 

@Repository
public interface operateurReposirory extends JpaRepository<operateur, Integer> {
	
   String DELETE = null;
 
 
 
	 @Query("select c from operateur c  ")
	    List<operateur> findMyOperateurs(@Param("id") Integer id);
	    
	     

		   @Query("select c from operateur c  ") 
		   	List Getoperateur();
		    

		   
			@Query(nativeQuery = true, value ="select *  from operateur    \r\n"  )//
			List<Object[]> listoperateur();
			

			@Query(nativeQuery = true, value ="\r\n" + 
					" select   id   from operateur " )
			List<Object[]> listDetailOpe();
			

			@Modifying
			@Transactional
			@Query(nativeQuery = true,value="UPDATE operateur u SET u.cdate = '2021-03-14' where u.id = id")
			public void updateCdatePlat(@Param("id") Integer operateur); 
			
}
