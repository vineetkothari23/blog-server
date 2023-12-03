package com.blogserver.model;

import com.blogserver.model.request.BlogRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
@Data
public class BlogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "related_blog_id")
    private Long relatedBlogId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "author_id", nullable = false)
    private Long authorId;

    public BlogRecord() {

    }

    private BlogRecord(String title, String content, String authorName, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.authorId = authorId;
        this.createdAt = LocalDateTime.now();
    }

    public static BlogRecord create(BlogRequest blogRequest, String authorName, Long authorId) {
        return new BlogRecord(blogRequest.getTitle(), blogRequest.getContent(), authorName, authorId);
    }
}
