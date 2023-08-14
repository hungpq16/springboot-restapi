package com.example.restapi.service;

import com.example.restapi.dto.request.PostDTO;
import com.example.restapi.dto.response.PostResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<PostResponseDTO> getAll();

    Optional<PostResponseDTO> findById(Long id);

    PostResponseDTO save(PostDTO dto);

    PostResponseDTO update(PostDTO dto, Long id);

    String delete(Long id);
}
