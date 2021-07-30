package com.example.demo.dao;

import com.example.demo.entite.album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
 
 

	 @Repository
	public interface albumRepository extends JpaRepository<album, Integer> {
		
	   String DELETE = null;

	// Client findByEmail(String email);
	   

	   @Query("select c from album c  ")
	   	List GetAlbum();
	    

	   
		@Query(nativeQuery = true, value ="select *  from album    \r\n"  )//
		List<album> listAlbum();
		

		@Query(nativeQuery = true, value ="\r\n" + 
				" select   id   from album " )
		List<Object[]> listdetail();

		 @Query(nativeQuery = true, value ="select * from album a JOIN chanson c ON a.id=c.id where c.user_id=:id"  )
		 List<album> getAlbumsByIdUser(@Param("id") Integer id);



}
