package com.example.demo.entite;

import javax.persistence.*;
import java.util.Date;


@Entity
public class role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    private Date cdate;

    private Date udate;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }
}
