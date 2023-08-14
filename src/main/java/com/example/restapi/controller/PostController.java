package com.example.restapi.controller;

import com.example.restapi.dto.request.PostDTO;
import com.example.restapi.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final IPostService postService;

    @GetMapping("findAll")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody PostDTO dto) {
        //Map<String, String> errorValidator = ValidateObject.validatePostDTO(dto);
        //if (!ObjectUtils.isEmpty(errorValidator)) {
        //return new ResponseEntity<>(errorValidator, HttpStatus.BAD_REQUEST);
        //}
        return new ResponseEntity<>(postService.save(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestParam("id") Long id, @RequestBody PostDTO dto) {
        return new ResponseEntity<>(postService.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idToDelete}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.delete(id), HttpStatus.OK);
    }

}
