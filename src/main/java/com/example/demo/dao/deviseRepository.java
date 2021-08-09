 package com.example.demo.dao;

import com.example.demo.entite.devise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface deviseRepository extends JpaRepository<devise, Integer> {
	
   String DELETE = null;

// Client findByEmail(String email);

 
	@Query("select c from devise c  ")
	List<devise> findMyUsers(@Param("id") Integer id);


	@Query(nativeQuery = true, value ="select *  from devise    \r\n"  )
	List<devise> listDevise();


	@Query(nativeQuery = true, value ="select cours  from devise where code='EUR' and datecours between :date1 and :date2"  )//
	Double getCourParDate(Date date1, Date date2);






} 
