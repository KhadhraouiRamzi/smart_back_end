package com.example.demo.dao;

import com.example.demo.entite.details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface deezerRepository extends JpaRepository<details, Integer> {


    @Query(nativeQuery = true, value = "select DISTINCT count(date1) from details where date1=:date1 and file=:file \r\n")
    int getDetailsByDate1andFile(@Param("date1") Date date1, @Param("file") String file);

}
