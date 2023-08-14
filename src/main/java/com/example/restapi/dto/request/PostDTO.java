package com.example.restapi.dto.request;

import lombok.Data;

@Data
public class PostDTO {

    private String title;

    private String description;

    private Integer maximumOfComments;

    private String content;

    private String phoneNumber;

}
