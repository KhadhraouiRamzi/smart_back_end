package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.marketing;
 

@Repository
public interface marketingRepository extends JpaRepository<marketing, Integer> {
	
   String DELETE = null;
 
 
 
	 @Query("select c from marketing c  ")
	    List<marketing> findMyUsers(@Param("id") Integer id);
	    
	     

		   @Query("select c from marketing c  ") 
		   	List GetMarketing();
		    

		   
			@Query(nativeQuery = true, value ="select *  from marketing    \r\n"  )//
			List<Object[]> listMarketing();
			

			@Query(nativeQuery = true, value ="\r\n" + 
					" select   id   from marketing " )
			List<Object[]> listDetailMarketing();
			

			@Modifying
			@Transactional
			@Query(nativeQuery = true,value="UPDATE marketing u SET u.cdate = '2021-03-14' where u.id = id")
			public void updateCdateMar(@Param("id") Integer marketing); 
			
}
