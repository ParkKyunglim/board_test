package com.example.board.Controller;

import com.example.board.DTO.PostCreateRequestDTO;
import com.example.board.DTO.PostListResponseDTO;
import com.example.board.DTO.PostResponseDTO;
import com.example.board.DTO.PostUpdateRequestDTO;
import com.example.board.Service.PostService;
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
