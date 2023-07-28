package com.my.blog.service;

import com.my.blog.dto.comment.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getAllCommentsByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    CommentDto updateCommentById(long postId, long commentId, CommentDto commentDto);

    void deleteCommentById(long postId, long commentId);
}
