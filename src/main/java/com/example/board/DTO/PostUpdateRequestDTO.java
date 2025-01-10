package com.example.board.DTO;

import com.example.board.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateRequestDTO {
    private String title;
    private String content;
    private LocalDateTime updatedDate;

}
