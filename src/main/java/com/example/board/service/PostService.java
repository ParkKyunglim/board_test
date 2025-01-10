package com.example.board.service;


import com.example.board.dto.PostCreateRequestDTO;
import com.example.board.dto.PostListResponseDTO;
import com.example.board.dto.PostResponseDTO;
import com.example.board.dto.PostUpdateRequestDTO;
import com.example.board.entity.Post;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDTO createPost(PostCreateRequestDTO requestsDto) {
        Post post = new Post(requestsDto);
        postRepository.save(post);
        return new PostResponseDTO(post);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDTO> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostListResponseDTO(post)).collect(Collectors.toList());
    }

    @Transactional
    public PostResponseDTO getPost(Long id) {
        return postRepository.findById(id).map(post -> new PostResponseDTO(post)).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @Transactional
    public PostResponseDTO updatePost(Long id, PostUpdateRequestDTO requestsDto) throws Exception {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestsDto);
        postRepository.save(post);
        return new PostResponseDTO(post);
    }

    public PostResponseDTO deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        postRepository.deleteById(id);
        return null;
    }

}
