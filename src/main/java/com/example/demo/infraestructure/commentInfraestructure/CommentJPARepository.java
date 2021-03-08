package com.example.demo.infraestructure.commentInfraestructure;

import java.util.UUID;

import com.example.demo.domain.commentDomain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<Comment, UUID>
{
    
}
