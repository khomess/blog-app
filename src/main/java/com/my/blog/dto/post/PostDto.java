package com.my.blog.dto.post;

import com.my.blog.dto.comment.CommentDto;
import com.my.blog.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class PostDto {

    private Long id;

    private String title;

    private String description;

    private String content;
    private List<CommentDto> comments;
}
