package com.example.demo.dao;

import com.example.demo.entite.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role,Integer> {
}
