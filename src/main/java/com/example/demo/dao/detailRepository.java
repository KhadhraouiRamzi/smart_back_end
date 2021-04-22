package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entite.details;

@Repository
public interface detailRepository extends JpaRepository<details, Integer> {

	String DELETE = null;

// Client findByEmail(String email);

	@Query("select c from details c  ")
	List GetDetails();

	@Query(nativeQuery = true, value = "select *  from details    \r\n") //
	List<details> listArtiste();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select   namea ,  round(sum(netrevenu),3) as netrevenu, count(quantite) as quantite\r\n" + " from (\r\n"
			+ "     select   namea, chanson  ,  category ,uniteprice , quantite  ,content ,  plateforme, date1, netrevenu\r\n"
			+ "     from details   )aa\r\n" + " group by   namea\r\n" + "order by round(sum(netrevenu),3)   desc\r\n"
			+ "limit 10 ")
	List<Object[]> listDetail();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select   chanson ,  round(sum(netrevenu),3) as netrevenu, count(quantite) as quantite\r\n"
			+ " from (\r\n"
			+ "     select   namea, chanson  ,  category ,uniteprice , quantite  ,content ,  plateforme, date1, netrevenu\r\n"
			+ "     from details   )aa\r\n" + " group by   chanson\r\n" + "order by round(sum(netrevenu),3)   desc\r\n"
			+ "limit 10 ")
	List<Object[]> listChanson();

	@Query(nativeQuery = true, value = "SELECT DISTINCT CONCAT( MONTH( date1 ) , '-', YEAR( date1 ) )\r\n"
			+ "FROM details \r\n" + "ORDER BY YEAR( date1 ) , MONTH( date1 ) ASC")
	List<Object[]> listdate();

	@Query(nativeQuery = true, value = "select *  from details    \r\n") //
	List<details> listDArtiste();

}
