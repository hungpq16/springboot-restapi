package com.example.restapi.service;

import com.example.restapi.dto.request.CommentDTO;
import com.example.restapi.dto.response.CommentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<CommentResponseDTO> getAll();

    Optional<CommentResponseDTO> findById(Long id);

    CommentResponseDTO save(CommentDTO dto);

    CommentResponseDTO update(CommentDTO dto, Long id);

    String delete(Long id);

}
