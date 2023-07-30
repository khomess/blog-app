package com.my.blog.dto.comment;

import lombok.Data;

@Data
public class CommentDto{
    private long id;
    private String name;
    private String email;
    private String messageBody;
}
