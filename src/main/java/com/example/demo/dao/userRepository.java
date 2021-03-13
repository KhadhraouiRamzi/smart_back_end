package com.example.demo.dao;

import com.example.demo.entite.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user,Integer> {

    String DELETE = null;

// Client findByEmail(String email);


    @Query("select c from user c")// ==> JPQL, nom de la classe ou entité
    List GetUser();




    @Query("select c from user c  ")
    List<user> findMyUsers(@Param("id") Integer id);




    @Query(nativeQuery = true, value ="select *  from user    \r\n"  )//
    List<user> listUser();


    @Query(nativeQuery = true, value ="\r\n" +
            " select   nom,prenom,phone,email,cin,part   from user " )
    List<Object[]> listDUsers();

    /*---------used to Spring Security*/

    Optional<user> findByEmail(String email);

    Boolean existsByEmail(String email);

    /*-------------------------------------*/


}
