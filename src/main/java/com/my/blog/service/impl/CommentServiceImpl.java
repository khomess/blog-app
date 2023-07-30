package com.my.blog.service.impl;

import com.my.blog.dto.comment.CommentDto;
import com.my.blog.entity.Comment;
import com.my.blog.entity.Post;
import com.my.blog.configuration.exception.BlogAPIException;
import com.my.blog.configuration.exception.ResourceNotFoundException;
import com.my.blog.repository.CommentRepository;
import com.my.blog.repository.PostRepository;
import com.my.blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);

        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);
        return modelMapper.map(newComment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw  new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong po post");
        }

        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateCommentById(long postId, long commentId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw  new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong po post");
        }

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setMessageBody(commentDto.getMessageBody());

        Comment updatedComment = commentRepository.save(comment);

        return modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public void deleteCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())) {
            throw  new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong po post");
        }
        commentRepository.delete(comment);
    }
}
