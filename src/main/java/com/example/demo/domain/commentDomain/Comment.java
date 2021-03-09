package com.example.demo.domain.commentDomain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity 
public class Comment {
    @Id
    @Type(type= "uuid-char")
    public UUID id;
    @Column(nullable = false)
    public Date date;
    @Column(nullable = false)
    public int rating;
    @Column(nullable = false)
    public String text;
}
