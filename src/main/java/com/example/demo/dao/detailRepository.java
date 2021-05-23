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
			+ " select   namea ,  round(sum(uniteprice),3) as uniteprice, count(quantite) as quantite\r\n"
			+ " from (\r\n"
			+ "     select   namea,content ,  category ,uniteprice , quantite   ,  plateforme, date1, netrevenu\r\n"
			+ "     from details   )aa  group by   namea order by round(sum(netrevenu),3)   desc\r\n"
			+ "limit 10 ")
	List<Object[]> listDetail();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  content,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  content order by  round(sum(netrevenu),3)    desc limit 10 ")
	List<Object[]> topChanson();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  namea,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by    namea order by  round(sum(netrevenu),3)    desc limit 10 ")
	List<Object[]> topArtiste();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  category,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by    category order by  round(sum(netrevenu),3)    desc limit 10 ")
	List<Object[]> topcategory();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  content,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  content order by sum(quantite)   desc limit 10 ")
	List<Object[]> topCountC();
	

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  namea,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  namea order by sum(quantite)   desc limit 10 ")
	List<Object[]> topCountA();

	@Query(nativeQuery = true, value = "select  date1,date2,round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite "
			+ "from details group by date1,date2")
	List<Object[]> topDate();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  category,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  category order by  round(sum(netrevenu),3)    desc limit 10 ")
	List<Object[]> topCategory();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  category order by plateforme   desc limit 10 ")
	List<Object[]> topPlateforme();

	@Query(nativeQuery = true, value = "select *  from details    ") //
	List<details> listDArtiste();

}
