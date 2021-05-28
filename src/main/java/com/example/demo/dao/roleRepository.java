package com.example.demo.dao;

 import com.example.demo.entite.ERole;
import com.example.demo.entite.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface roleRepository extends JpaRepository<role,Integer> {
	

	   String DELETE = null;
	 
		 @Query("select c from role c  ")
		    List<role> findMyRoles(@Param("id") Integer id);
		    
		     

			   @Query("select c from role c  ") 
			   	List GetRole();
			    

			   
				@Query(nativeQuery = true, value ="select *  from role    \r\n"  )//
				List<Object[]> listRole();
				

				@Query(nativeQuery = true, value ="\r\n" + 
						" select   id   from role " )
				List<Object[]> listDetailRole();
				

				@Modifying
				@Transactional
				@Query(nativeQuery = true,value="UPDATE role u SET u.cdate = '2021-03-14' where u.id = id")
				public void updateCdateRole(@Param("id") Integer role);

				Optional<role> findByName(ERole name);

				@Query(nativeQuery = true, value ="select name from role where (name!='ROLE_ARTISTE' && name!='ROLE_FOURNISSEUR')")
				List<String> getRolesNames();

}
