package com.example.board.dto;

import com.example.board.entity.Post;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDTO {
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
