package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 import com.example.demo.entite.hist_communication;

 
	 @Repository
	public interface hist_communicationRepositoy extends JpaRepository<hist_communication, Integer> {
		
	   String DELETE = null;

	// Client findByEmail(String email);
	   

	   @Query("select c from hist_communication c  ") 
	   	List GetHistCommunication();
	    

	   
		@Query(nativeQuery = true, value ="select *  from hist_communication    \r\n"  )//
		List<Object[]> listHistCommunication();
		

		@Query(nativeQuery = true, value ="\r\n" + 
				" select   id   from hist_communication " )
		List<Object[]> listdetailHistCom();
		

		@Modifying
		@Transactional
		@Query(nativeQuery = true,value="UPDATE hist_communication u SET u.cdate = '2021-03-14' where u.id = id")
		public void updateCdateCom(@Param("id") Integer hist_communication); 
		
}
