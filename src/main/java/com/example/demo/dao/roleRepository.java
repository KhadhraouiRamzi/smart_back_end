package com.example.demo.dao;

import com.example.demo.entite.ERole;
import com.example.demo.entite.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface roleRepository extends JpaRepository<role,Integer> {

    Optional<role> findByName(ERole name);

}
