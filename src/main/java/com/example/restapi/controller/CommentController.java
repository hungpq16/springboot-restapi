package com.example.restapi.controller;

import com.example.restapi.dto.request.CommentDTO;
import com.example.restapi.dto.response.CommentResponseDTO;
import com.example.restapi.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final ICommentService commentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CommentResponseDTO>> getAll() {
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CommentResponseDTO> save(@RequestBody CommentDTO dto) {
        return new ResponseEntity<>(commentService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CommentResponseDTO>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CommentResponseDTO> update(@RequestParam("id") Long id, @RequestBody CommentDTO dto) {
        return new ResponseEntity<>(commentService.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        return new ResponseEntity<>(commentService.delete(id), HttpStatus.OK);
    }

}
