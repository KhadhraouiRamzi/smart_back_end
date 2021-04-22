package com.example.demo.dao;

import com.example.demo.entite.marketing;
import com.example.demo.entite.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Integer> {

//	Optional<user> findByName(String nameimg);
    @Query("SELECT u FROM user u WHERE u.email = :email")
    public user getUserByUsername(@Param("email") String email);
    
    
	@Query(nativeQuery = true, value = "SELECT u.* FROM user u ") // ==> JPQL, nom de la classe ou entité
	List GetUsers();

	@Query("select c from user c  ")
	List GetUser();

	@Query(nativeQuery = true, value = "SELECT u.* FROM user u " + "inner join user_roles ur on u.id = ur.user_id "
			+ "inner join role r on r.id =ur.role_id " + "where r.name ='ROLE_ARTISTE'\n" + "") // ==> JPQL, nom de la
	List GetArtistes();


	@Query("SELECT u FROM user u  join u.roles r where r.name in('ROLE_FOURNISSEUR','ROLE_ARTISTE')") // ==> JPQL, nom de la
	List GetArtFour();

	@Query(nativeQuery = true, value = "SELECT u.* FROM user u " + "inner join user_roles ur on u.id = ur.user_id "
			+ "inner join role r on r.id =ur.role_id " + "where r.name ='ROLE_FOURNISSEUR'\n" + "") // ==> JPQL, nom de
	List GetFournisseurs();
 
	@Query("SELECT u FROM user u  join u.roles r where r.name ='ROLE_ARTISTE' ") // ==> JPQL, nom de la
	List GetArtss();
	
	@Query( "SELECT u FROM user u  join u.roles r where r.name ='ROLE_FOURNISSEUR' ") 
	List GetFours();

	@Query(nativeQuery = true, value = "SELECT u.* FROM user u " + "inner join user_roles ur on u.id = ur.user_id "
			+ "inner join role r on r.id =ur.role_id " + "where r.name ='ROLE_ADMIN'\n" + "") // ==> JPQL, nom de la
																								// classe ou entité
	List GetAdmins();

	@Query("select c from user c ")
	List<user> findMyUsers(@Param("id") Integer id);

	@Query(nativeQuery = true, value = "select *  from user    \r\n") //
	List<user> listUser();

	@Query(nativeQuery = true, value = "\r\n" + " select   nom,prenom,phone,email,cin,part   from user ")
	List<Object[]> listDUsers();

	Optional<user> findByName(String name);
  //  Optional<ImageModel> findByName(String name);

	// void save(ImageModel img);
	@Modifying 
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE user u SET u.name = :name  , u.pic_byte = :picByte ,u.type = :type "
			+ "where u.id = (select * from (select max(id) from user)xx)")
	public void savenewIn(@Param("name") String name, @Param("picByte") byte[] picByte, @Param("type") String type);
	
	
	@Modifying 
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE user u SET u.name = :name  , u.pic_byte = :picByte ,u.type = :type "
			+ "where u.id = :id")
	public void savenew(@Param("name") String name, @Param("picByte") byte[] picByte, @Param("type") String type, @Param("id") Integer id);
	
	
	
	@Query(nativeQuery = true, value = "select max(c.id) from user c ")
	Integer maxId();
	
	@Query(nativeQuery = true, value = "SELECT u.* FROM user u " + "inner join user_roles ur on u.id = ur.user_id "
			+ "inner join role r on r.id =ur.role_id " + "where r.name ='ROLE_ARTISTE'\n" + "") // ==> JPQL, nom de la
	List aa();
	
	 
	@Query("SELECT u.id, u.cdate, u.cin, u.contrat, u.date, u.datecin, u.email, u.image, u.nArtistique, u.nationnalite, u.nom, u.password, u.phone, "
			+ "u.prenom, u.proposition, u.udate, \n"
			+ "	 u.marketing.id, u.part, u.retenu, u.name, u.picByte, u.type, u.files"
			+ " FROM user u  join u.roles r where r.name ='ROLE_ARTISTE' ") // ==> JPQL, nom de la
	List<user> GetArts(Integer id, Date cdate, String cin, Byte[] contrat, Date date, Date datecin, String email,
			byte[] image, String getnArtistique, String nationnalite, String nom, String password, String phone,
			String prenom, String proposition, Date udate, marketing marketing, double part, double retenu, String name,
			byte[] decompressBytes, String type, File[] files); 

	// void savenew(String originalFilename, byte[] compressBytes, String
	// contentType);

	/*
	 * void save(Optional<user> maxId);
	 * u.id =(select * from (select max(id) from user)xx)
	 * void save(user p, user img);
	 * 
	 */


	/*---------used to Spring Security*/

	Optional<user> findByEmail(String email);

	Boolean existsByEmail(String email);

	/*-------------------------------------*/
	
}
