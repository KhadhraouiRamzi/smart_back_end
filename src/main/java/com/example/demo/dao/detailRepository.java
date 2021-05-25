package com.example.demo.dao;

import com.example.demo.entite.chanson;
import com.example.demo.entite.details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface detailRepository extends JpaRepository<details, Integer> {

	String DELETE = null;

	@Query("select c from details c  ")
	List GetDetails();

	@Query(nativeQuery = true, value = "select *  from details    \r\n") //
	List<details> listArtiste();

	/*----------------------------stat avec top 10---------------------------*/

	@Query(nativeQuery = true, value = "\r\n"
			+ " select   namea ,  round(sum(uniteprice),3) as uniteprice, count(quantite) as quantite\r\n"
			+ " from (\r\n"
			+ "     select   namea,content ,  category ,uniteprice , quantite   ,  plateforme, date1, netrevenu\r\n"
			+ "     from details   )aa  group by   namea order by round(sum(netrevenu),3)   desc\r\n"
			+ "limit 10 ")
	List<Object[]> listDetail();

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n" +
			"round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n" +
			"round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n" +
			"from details group by  content order by  round(sum(ttc),3) desc limit 10")
	List<Object[]> topChanson();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n" +
			"round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n" +
			"round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n" +
			"from details group by    namea ORDER BY  round(sum(ttc),3) desc limit 10")
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

	@Query(nativeQuery = true, value = "select  date1,date2,round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n" +
			"round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n" +
			"round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n" +
			"from details group by date1,date2 desc limit 10")
	List<Object[]> topDate();

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n" +
			"round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n" +
			"round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n" +
			"from details group by  category order by round((sum(ttc)),3) desc limit 10 ")
	List<Object[]> topCategory();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  category order by plateforme   desc limit 10 ")
	List<Object[]> topPlateforme();

	@Query(nativeQuery = true, value = "select *  from details    ") //
	List<details> listDArtiste();


	/*------------------tout les stat sans top 10-------------*/


	@Query(nativeQuery = true, value = "\r\n"
			+ " select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  content order by  round(sum(ttc),3) desc ")
	List<Object[]> statChanson();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by    namea \n" + "ORDER BY  round(sum(ttc),3) desc ")
	List<Object[]> statArtiste();

	@Query(nativeQuery = true, value ="select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ " from details group by  category order by round((sum(ttc)),3) desc")
	List<Object[]> statcategory();

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ " from details group by  content order by   sum(quantite)    desc")
	List<Object[]> statCountC();

	@Query(nativeQuery = true, value =  "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by    namea \n" + "ORDER BY sum(quantite) DESC")
	List<Object[]> statCountA();

	@Query(nativeQuery = true, value = "select  date1,date2,round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by date1,date2")
	List<Object[]> statDate();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  plateforme order by TTC   desc")
	List<Object[]> statPlateforme();


	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  plateforme")
	List<Object[]> statPlateformeC();

	/*-----------tout les stat sans top 10 By Users Connected-------------*/


	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details "
			+ "where namea =(SELECT concat(  `prenom` ,' ',`nom`) FROM `user` where id=:id)"
			+ " group by    namea \n" + "ORDER BY  round(sum(ttc),3) desc ")
	Optional<details> statArtisteById(Integer id);

	@Query(nativeQuery = true, value = "select  content, round((sum(`ttc`)),3) as ttc, sum(quantite) as quantite, round(sum(`part_smart`),3) as part_smart,\n"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details\n"
			+ "where namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n"
			+ "group by content ORDER BY round(sum(ttc),3) desc")
	List<Object[]> statChansonById(@Param("id") Integer id);
} 
