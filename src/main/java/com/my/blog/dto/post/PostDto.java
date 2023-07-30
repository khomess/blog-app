package com.my.blog.dto.post;

import com.my.blog.dto.comment.CommentDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @NotEmpty(message = "Name should not be empty")
    private String content;

    private List<CommentDto> comments;
}
