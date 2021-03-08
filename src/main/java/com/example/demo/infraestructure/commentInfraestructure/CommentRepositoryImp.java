package com.example.demo.infraestructure.commentInfraestructure;

import com.example.demo.domain.commentDomain.Comment;
import com.example.demo.domain.commentDomain.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImp implements CommentRepository{

    private final CommentJPARepository commentJPARepository;

    @Autowired
    public CommentRepositoryImp(final CommentJPARepository commentJPARepository){
        this.commentJPARepository=commentJPARepository;
    }


    @Override
    public void add(Comment comment) {
        this.commentJPARepository.save(comment);        
    }

    
    
}
