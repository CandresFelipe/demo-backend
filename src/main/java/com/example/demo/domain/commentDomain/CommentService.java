package com.example.demo.domain.commentDomain;

import java.util.Date;
import java.util.UUID;

import com.example.demo.dto.commentDto.CommentDTO;
import com.example.demo.dto.commentDto.CreateCommentDTO;

public class CommentService {
    public static Comment create (CreateCommentDTO dto){
        Comment comment = new Comment();
        comment.date = new Date();
        comment.id = UUID.randomUUID();
        comment.rating = dto.rating;
        comment.text = dto.text;
        return comment;
    }
    public static CommentDTO createDTO (Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.date = comment.date;
        commentDTO.id = comment.id;
        commentDTO.rating = comment.rating;
        commentDTO.text = comment.text;
        return commentDTO;
        
    }
}
