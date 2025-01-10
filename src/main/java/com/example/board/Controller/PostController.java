package com.example.board.Controller;

import com.example.board.DTO.PostCreateRequestDTO;
import com.example.board.DTO.PostListResponseDTO;
import com.example.board.Entity.Post;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.board.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
@Controller
@AllArgsConstructor
public class PostController {
    @Autowired
    private final PostService postService;

    @GetMapping({"/post/list"})
    public String postList(Model model) {
        List<PostListResponseDTO> posts = postService.getPosts();
        log.info("posts : {}", posts);
        model.addAttribute("posts", posts);
        return "/post/list";
    }

    // 게시글 작성 페이지
    @GetMapping("/post/write")
    public String openPostWrite() {
         return "/post/write";
    }

    //게시글 작성
    @PostMapping("/post/write")
    public String postWrite(PostCreateRequestDTO postCreateRequestDTO, Model model) {
        postService.createPost(postCreateRequestDTO);
        return "redirect:/post/list";
    }

    @GetMapping("/post/modify/{id}")
    public String openmodifyPost() {
        return "/post/modify";
    }

    @PutMapping("/post/modify/{id}")
    public String modifyPost(@PathVariable Long id, Post post) {
        return "redirect:/post/list";
    }

    @DeleteMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/post/list";
    }

}
