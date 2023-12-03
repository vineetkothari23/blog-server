package com.blogserver.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class BlogMetadata {
    private Long id;
    private String title;
    private Long authorId;

    private String authorName;

    private Long relatedBlogId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
