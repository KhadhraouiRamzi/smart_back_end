package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.communication;

 
 

	 @Repository
	public interface communicationRepository extends JpaRepository<communication, Integer> {
		
	   String DELETE = null;

	// Client findByEmail(String email);
	   

	   @Query("select c from communication c  ") 
	   	List GetCommunication();
	    

	   
		@Query(nativeQuery = true, value ="select *  from communication    \r\n"  )//
		List<Object[]> listCommunication();
		

		@Query(nativeQuery = true, value ="\r\n" + 
				" select   id   from communication " )
		List<Object[]> listdetailCom();
		

		@Modifying
		@Transactional
		@Query(nativeQuery = true,value="UPDATE communication u SET u.cdate = '2021-03-14' where u.id = id")
		public void updateCdateCom(@Param("id") Integer chanson); 
		
}
