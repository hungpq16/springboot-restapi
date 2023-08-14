package com.example.restapi.dto.request;

import lombok.Data;

@Data
public class CommentDTO {

    private String name;

    private String email;

    private String body;

    private Long postId;
}