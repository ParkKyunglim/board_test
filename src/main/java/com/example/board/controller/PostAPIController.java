package com.example.board.controller;

import com.example.board.dto.PostCreateRequestDTO;
import com.example.board.dto.PostListResponseDTO;
import com.example.board.dto.PostResponseDTO;
import com.example.board.dto.PostUpdateRequestDTO;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostAPIController {
    private final PostService postService;

    @PostMapping("/api/post")
    public PostResponseDTO createPost(@RequestBody PostCreateRequestDTO requestDTO) {
        return postService.createPost(requestDTO);
    }

    @GetMapping("/api/posts")
    public List<PostListResponseDTO> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDTO getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/api/post/{id}")
    public PostResponseDTO updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDTO requestsDto) throws Exception {
        return postService.updatePost(id, requestsDto);
    }

    @DeleteMapping("/api/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
