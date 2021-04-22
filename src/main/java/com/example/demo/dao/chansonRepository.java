package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.chanson;

  
	 @Repository
	public interface chansonRepository extends JpaRepository<chanson, Integer> {
		
	   String DELETE = null;

	// Client findByEmail(String email);
	   

	   @Query("select c from chanson c  ") 
	   	List GetChnason();
	    

	   
		@Query(nativeQuery = true, value ="select *  from chanson    \r\n"  )//
		List<chanson> listChanson();
		

		@Query(nativeQuery = true, value ="\r\n" + 
				" select   id   from chanson " )
		List<Object[]> listdetail();
		
		
		@Modifying
		@Transactional
		@Query(nativeQuery = true,value="UPDATE chanson u SET u.cdate = '2021-03-14' where u.id = id")
		public void updatecdate(@Param("id") Integer chanson); 
		
		
		@Query("select c from chanson c  where c.user.id = :id")
 		List chansonArtiste(@Param("id") Integer chanson); 
		
}
