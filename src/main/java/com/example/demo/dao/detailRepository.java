package com.example.demo.dao;

import com.example.demo.entite.details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface detailRepository extends JpaRepository<details, Integer> {

	String DELETE = null;

	@Query("select c from details c  ")
	List listDetails();

	@Query(nativeQuery = true, value = "select *  from details    \r\n")
	//
	List<details> listArtiste();

	/*----------------------------stat avec top 10---------------------------*/

	@Query(nativeQuery = true, value = "\r\n"
			+ " select   namea ,  round(sum(uniteprice),3) as uniteprice, count(quantite) as quantite\r\n"
			+ " from (\r\n"
			+ "     select   namea,content ,  category ,uniteprice , quantite   ,  plateforme, date1, netrevenu\r\n"
			+ "     from details   )aa  group by   namea order by round(sum(netrevenu),3)   desc\r\n" + "limit 10 ")
	List<Object[]> listDetail();

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  content order by  round(sum(ttc),3) desc limit 10")
	List<Object[]> topChanson();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by    namea ORDER BY  round(sum(ttc),3) desc limit 10")
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

	@Query(nativeQuery = true, value = "select  date1,date2,round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by date1,date2 desc limit 10")
	List<Object[]> topDate();

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  category order by round((sum(ttc)),3) desc limit 10 ")
	List<Object[]> topCategory();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme,  round((sum(netrevenu)),3) as netrevenu,   sum(quantite) as quantite\n"
			+ "from details group by  category order by plateforme   desc limit 10 ")
	List<Object[]> topPlateforme();

	@Query(nativeQuery = true, value = "select *  from details    ")
	//
	List<details> listDArtiste();

	/*------------------tout les stat sans top 10-------------*/

	@Query(nativeQuery = true, value = " select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  content order by  round(sum(ttc),3) desc ")
	List<Object[]> statChanson();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  namea ORDER BY  round(sum(ttc),3) desc ")
	List<Object[]> statArtiste();

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ " from details group by  category order by round((sum(ttc)),3) desc")
	List<Object[]> statcategory();

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ " from details group by  content order by   sum(quantite)    desc")
	List<Object[]> statCountC();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
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

	/*-----------tout les stat Users Connected-------------*/

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  content\n" + "union ALL\n"
			+ "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  content)xx\n" + "order by ttc desc")
	List<Object[]> statChansonById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  namea,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  namea\n" + "union ALL\n"
			+ "select  namea,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  namea)xx\n" + "order by ttc desc")
	List<Object[]> statArtisteById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  category\n" + "union ALL\n"
			+ "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  category)xx\n" + "order by ttc desc")
	List<Object[]> statCategoryById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  plateforme,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  plateforme\n" + "union ALL\n"
			+ "select  plateforme,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  plateforme)xx\n" + "order by ttc desc")
	List<Object[]> statPlateformeById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select   date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details\n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by   date1,date2\n" + "union ALL\n"
			+ "select   date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by   date1,date2)xx\n" + "order by ttc desc")
	List<Object[]> statDateById(@Param("id") Integer id);

	/*------------------tout les stat sans top 10 UsersById-------------*/

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details\n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  content\n" + "union ALL\n"
			+ "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  content)xx\n" + "order by ttc desc limit 10")
	List<Object[]> statChansonUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  namea,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  namea\n" + "union ALL\n"
			+ "select  namea,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details\n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  namea)xx\n" + "order by ttc desc limit 10")
	List<Object[]> statArtisteUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  category\n" + "union ALL\n"
			+ "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ " from details\n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  category)xx\n" + "order by ttc desc limit 10")
	List<Object[]> statcategoryUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ " from details\n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  content\n" + "union ALL\n"
			+ "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ " group by  content order by   sum(quantite)    desc limit 10")
	List<Object[]> statCountCUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "	where namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n" + "group by namea \n"
			+ "ORDER BY sum(quantite) DESC limit 10")
	List<Object[]> statCountAUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select   date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details\n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by   date1,date2\n" + "union ALL\n"
			+ "select   date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by   date1,date2)xx\n" + "order by ttc desc limit 10")
	List<Object[]> statDateUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select * from (\n"
			+ " select  plateforme,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details\n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "group by  plateforme\n" + "union ALL\n"
			+ "select  plateforme,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste \n"
			+ "from details \n" + "where namea  LIKE CONCAT((select n_artistique "
			+ "FROM user u where u.id=:id),'%')\n" + "group by  plateforme)xx\n" + "order by ttc desc limit 10")
	List<Object[]> statPlateformeUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ " round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ " round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "	where namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n"
			+ " group by  plateforme order by round((sum(`ttc`)),3) desc limit 10")
	List<Object[]> statPlateformeCUsersById(@Param("id") Integer id);

	/*-----------totaux des stats----------------*/

	@Query(nativeQuery = true, value = "select  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n" + "from details")
	List<Object[]> statTotal();

	@Query(nativeQuery = true, value = "select  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			+ "round(sum(tax_telecom),3) as tax_telecom, round(sum(part_TTC),3) as part_TTC,\n"
			+ "round(sum(`htva`),3) as htva, round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "where namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)")
	List<Object[]> statTotalUsersById(@Param("id") Integer id);

	/*--------------*pour la generation des rapport finale*--------------*/

	@Query(nativeQuery = true, value = "select round(sum(part_artiste),3) as part_artiste "
			+ "from ( select   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom,\n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details d\n"
			+ "where namea  LIKE CONCAT((select concat(prenom ,' ',nom) FROM user u where u.id=:id),'%')\n"
			+ "and d.date1 between :datedebut and :datefin\n" + "and d.date2 between :datedebut and :datefin\n" + "\n"
			+ "union ALL\n" + "\n"
			+ "select round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, round(sum(tax_telecom),3) as tax_telecom,\n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste\n"
			+ "from details dd\n" + "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "and dd.date1 between :datedebut and :datefin\n" + "and dd.date2 between :datedebut and :datefin) XX")
	List<Double> rapportStatTotalUsersById(@Param("id") Integer id, @Param("datedebut") Date datedebut,
			@Param("datefin") Date datefin);

	@Query(nativeQuery = true, value = "select  namea, date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, \n"
			+ "round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste ,paye\n"
			+ "	from details \n" + " group by   date1,date2,namea,paye  order by namea")
	List<Object[]> statRevenu();

	@Query(nativeQuery = true, value = "select  namea, date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, \n"
			+ "round(sum(tax_telecom),3) as tax_telecom, \n"
			+ "round(sum(part_TTC),3) as part_TTC, round(sum(htva),3) as htva, round(sum(part_artiste),3) as part_artiste ,paye\n"
			+ "	from details where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ " group by   date1,date2,namea,paye")
	List<Object[]> HistRevenu(@Param("id") Integer id);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update details d set d.paye = 1\n"
			+ "where d.namea=:namea and d.date1=:date1 and d.date2=:date2")
	public void paiementParMois(@Param("namea") String namea, @Param("date1") Date date1, @Param("date2") Date date2);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update details d set d.paye = 0\n"
			+ "where d.namea=:namea and d.date1=:date1 and d.date2=:date2")
	public void compenseParMois(@Param("namea") String namea, @Param("date1") Date date1, @Param("date2") Date date2);
	
	
}
