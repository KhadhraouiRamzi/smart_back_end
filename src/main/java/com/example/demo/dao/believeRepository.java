package com.example.demo.dao;

import com.example.demo.entite.details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface believeRepository extends JpaRepository<details, Integer> {

	String DELETE = null;

	@Query("select c from details c  ")
	List listDetails();

	@Query(nativeQuery = true, value = "select *  from details    \r\n")
	//
	List<details> listArtiste();

	@Query(nativeQuery = true, value = "select distinct date1  from details where date1=:date1 and file=:file and id =26440")
	List<details> getDetailsByDate1andFile(@Param("date1") Date date1,@Param("file") String file);

	/*----------------------------stat avec top 10---------------------------*/
 
	@Query(nativeQuery = true, value = "\r\n"
			+ " select   namea ,  round(sum(uniteprice),3) as uniteprice, count(quantite) as quantite\r\n"
			+ " from (\r\n"
			+ "     select   namea,content ,  category ,uniteprice , quantite   ,  plateforme, date1, netrevenu\r\n"
			+ "     from details   )aa  group by   namea order by round(sum(netrevenu),3)   desc\r\n" + "limit 10 ")
	List<Object[]> listDetail();

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			 + "  round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by  content order by  round(sum(ttc),3) desc limit 10")
	List<Object[]> topChanson();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			
			+ " round(sum(part_artiste),3) as part_artiste\n"
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
			
			+ " round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by date1,date2 desc limit 10")
	List<Object[]> topDate();

	@Query(nativeQuery = true, value = "select  pays,round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			
			+ " round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by pays desc limit 10")
	List<Object[]> topPaysBelieve();

	@Query(nativeQuery = true, value = "select  abonnement,round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			
			+ " round(sum(part_artiste),3) as part_artiste\n"
			+ "from details group by abonnement desc limit 10")
	List<Object[]> topAbonnementBelieve();

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			 + "  round(sum(part_artiste),3) as part_artiste\n"
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
			+ "   \n" + "   round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by  content order by  round(sum(ttc),3) desc ")
	List<Object[]> statChanson();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			
			+ " round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by  namea ORDER BY  round(sum(ttc),3) desc ")
	List<Object[]> statArtiste();

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ "   \n" + "   round(sum(part_artiste),3) as part_artiste\n"
			+ " from details  where file ='Believe' group by  category order by round((sum(ttc)),3) desc")
	List<Object[]> statcategory();

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ "   \n" + "   round(sum(part_artiste),3) as part_artiste\n"
			+ " from details  where file ='Believe' group by  content order by   sum(quantite)    desc")
	List<Object[]> statCountC();

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			
			+ " round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by    namea \n" + "ORDER BY sum(quantite) DESC")
	List<Object[]> statCountA();

	@Query(nativeQuery = true, value = "select  date1,date2,round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by date1,date2")
	List<Object[]> statDate();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by  plateforme order by TTC   desc")
	List<Object[]> statPlateforme();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by  plateforme")
	List<Object[]> statPlateformeC();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  pays, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by  pays")
	List<Object[]> statPaysBelieve();

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  abonnement, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n"
			+ "from details  where file ='Believe' group by  abonnement")
	List<Object[]> statAbonnementBelieve();
	/*-----------tout les stat Users Connected-------------*/

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where   file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  content")
	List<Object[]> statChansonById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  namea,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  namea ")
	List<Object[]> statArtisteById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  category")
	List<Object[]> statCategoryById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  plateforme,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by plateforme")
	List<Object[]> statPlateformeById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select   date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by   date1,date2")
	List<Object[]> statDateById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select   pays,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by pays")
	List<Object[]> statPaysBelieve(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select   abonnement,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ " round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by abonnement")
	List<Object[]> statAbonnementBelieve(@Param("id") Integer id);
	/*------------------tout les stat sans top 10 UsersById-------------*/

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,\n"
			+ "  round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  content order by round((sum(ttc)),3) desc limit 10")
	List<Object[]> statChansonUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  namea,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  namea order by round((sum(ttc)),3) desc limit 10")
	List<Object[]> statArtisteUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  category,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ " from details where file ='Believe' and  namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by  category order by round((sum(ttc)),3) desc limit 10")
	List<Object[]> statcategoryUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  content,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ " group by  content order by   sum(quantite)    desc limit 10")
	List<Object[]> statCountCUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  namea,  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			
			+ " round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "	where file ='Believe' and namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n"
			+ "group by namea \n" + "ORDER BY sum(quantite) DESC limit 10")
	List<Object[]> statCountAUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select   date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "group by   date1,date2 order by round((sum(ttc)),3) desc limit 10")
	List<Object[]> statDateUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select  plateforme,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart,   \n"
			+ "   round(sum(part_artiste),3) as part_artiste \n"
			+ "from details  where file ='Believe' and  namea  LIKE CONCAT((select n_artistique "
			+ "FROM user u where u.id=:id),'%')\n" + "group by  plateforme order by round((sum(ttc)),3) desc limit 10")
	List<Object[]> statPlateformeUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  plateforme, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "  round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "	where file ='Believe' and namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n"
			+ " group by  plateforme order by round((sum(`ttc`)),3) desc limit 10")
	List<Object[]> statPlateformeCUsersById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  pays, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "	where file ='Believe' and namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n"
			+ " group by  pays order by round((sum(`ttc`)),3) desc limit 10")
	List<Object[]> topPaysBelieveById(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "\r\n"
			+ " select  abonnement, round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,\n"
			+ "   \n"
			+ "  round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "	where file ='Believe' and namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)\n"
			+ " group by  abonnement order by round((sum(`ttc`)),3) desc limit 10")
	List<Object[]> topAbonnementBelieveById(@Param("id") Integer id);
	/*-----------totaux des stats----------------*/

	@Query(nativeQuery = true, value = "select  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			
			+ " round(sum(part_artiste),3) as part_artiste\n" + "from details")
	List<Object[]> statTotal();

	@Query(nativeQuery = true, value = "select  round((sum(`ttc`)),3) as ttc,   sum(quantite) as quantite,round(sum(`part_smart`),3) as part_smart,"
			
			+ " round(sum(part_artiste),3) as part_artiste\n" + "from details\n"
			+ "where namea=(select concat(prenom ,' ',nom) FROM user u where u.id=:id)")
	List<Object[]> statTotalUsersById(@Param("id") Integer id);

	/*--------------*pour la generation des rapport finale*--------------*/

	@Query(nativeQuery = true, value = "select round(((case when (sum(part_artiste)) is null then 0 else  round((sum(part_artiste)),3) end) *\n"
			+ " (select cours from devise where datecours between  :datedebut and :datefin and code ='EUR')),3) as part_artiste\n"
			+ "from details dd\n"
			+ "where namea  LIKE CONCAT((select n_artistique FROM user u where u.id=:id),'%')\n"
			+ "and file ='Believe' and dd.date1 between :datedebut and :datefin and dd.date2 between :datedebut and :datefin and paye =0")
	List<Double> rapportStatTotalBelieveUsersById(@Param("id") Integer id, @Param("datedebut") Date datedebut,
			@Param("datefin") Date datefin);

	@Query(nativeQuery = true, value = "select  namea, date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, \n"
			+ "   round(sum(part_artiste),3) as part_artiste ,paye\n" + "	from details \n"
			+ " group by   date1,date2,namea,paye  order by namea")
	List<Object[]> statRevenu();

	@Query(nativeQuery = true, value = "select  namea, date1,date2,   round((sum(ttc)),3) as ttc,   sum(quantite) as quantite,round(sum(part_smart),3) as part_smart, \n"
			+ "   round(sum(part_artiste),3) as part_artiste ,paye\n"
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
	@Query(nativeQuery = true, value = "update details d set d.paye = 1\n"
			+ "where d.namea like concat(:namea,'%') and d.date1 between :date1 and :date2 and d.date2 between :date1 and :date2")
	public void paiementParMoisHist(@Param("namea") String namea, @Param("date1") Date date1,
			@Param("date2") Date date2);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update details d set d.paye = 0\n"
			+ "where d.namea=:namea and d.date1=:date1 and d.date2=:date2")
	public void compenseParMois(@Param("namea") String namea, @Param("date1") Date date1, @Param("date2") Date date2);

}
