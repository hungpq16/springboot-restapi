package com.example.restapi.service.impl;

import com.example.restapi.dto.request.CommentDTO;
import com.example.restapi.dto.response.CommentResponseDTO;
import com.example.restapi.entity.Comment;
import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.repository.ICommentRepository;
import com.example.restapi.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

    private final ICommentRepository commentRepository;

    //private final IPostRepository postRepository;

    @Override
    public List<CommentResponseDTO> getAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(c -> mapperToCommentDTO(c)).collect(Collectors.toList());
    }

    @Override
    public Optional<CommentResponseDTO> findById(Long id) {
        commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        Comment comment = commentRepository.findById(id).get();
        return Optional.of(mapperToCommentDTO(comment));
    }

    @Override
    public CommentResponseDTO save(CommentDTO dto) {
        //Post p = postRepository.findById(dto.getPostId())
        //.orElseThrow(() -> new ResourceNotFoundException("Post not found with id : " + dto.getPostId()));

        Comment cmt = new Comment();
        cmt.setName(dto.getName());
        cmt.setEmail(dto.getEmail());
        cmt.setBody(dto.getBody());
        //cmt.setPost(p);
        Comment savedComment = commentRepository.save(cmt);
        return mapperToCommentDTO(savedComment);
    }

    @Override
    public CommentResponseDTO update(CommentDTO dto, Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found to update"));

        //Post p = postRepository.findById(dto.getPostId())
        //.orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        comment.setEmail(dto.getEmail());
        comment.setBody(dto.getBody());
        comment.setName(dto.getName());
        //comment.setPost(p);
        return mapperToCommentDTO(commentRepository.save(comment));
    }

    @Override
    public String delete(Long id) {
        commentRepository.deleteById(id);
        return "Delete successfully.";
    }

    /**
     * Mapper entity to dto
     *
     * @param comment entity
     * @return data dto
     */
    public static CommentResponseDTO mapperToCommentDTO(Comment comment) {
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        dto.setName(comment.getName());
        dto.setPost(comment.getPost());
        return dto;
    }
}
