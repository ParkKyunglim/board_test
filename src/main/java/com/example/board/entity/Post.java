package com.example.board.entity;

import com.example.board.dto.PostCreateRequestDTO;
import com.example.board.dto.PostUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT", length = 20)
    private String content;

    @Column(nullable = false, length = 5, columnDefinition = "VARCHAR(5) DEFAULT '익명'")
    private String author = "익명";

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Post(PostCreateRequestDTO requestsDto) {
        this.title = requestsDto.getTitle();
        this.content = requestsDto.getContent();
    }

    public void update(PostUpdateRequestDTO requestsDto) {
        this.title = requestsDto.getTitle();
        this.content = requestsDto.getContent();
    }
}
