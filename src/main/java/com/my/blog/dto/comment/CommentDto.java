package com.my.blog.dto.comment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto{
    private long id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Name should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String messageBody;
}
