package com.example.demo.domain.commentDomain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity 
public class Comment {
    @Id
    @Type(type= "uuid-char")
    public UUID id;

    private Date date;

    @Column(nullable = false)
    public int rating;

    @Column(nullable = false)
    public String text;

    @Column(nullable = false)
    public Date getDate(){
        return this.date;
    }

    public void SetDate(Date value){
        this.date = value;
    }


}
