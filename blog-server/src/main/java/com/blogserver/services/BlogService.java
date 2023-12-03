package com.blogserver.services;

import com.blogserver.authentication.User;
import com.blogserver.model.BlogMetadata;
import com.blogserver.model.BlogRecord;
import com.blogserver.model.request.BlogRequest;
import com.blogserver.repositories.BlogRepository;

import java.util.List;
import java.util.stream.StreamSupport;

public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogRecord addBlog(BlogRequest blogRequest, User user) {
        BlogRecord blogRecord = BlogRecord.create(blogRequest, user.getName(), user.getId());
        return blogRepository.save(blogRecord);
    }

    public BlogRecord getBlog(Long id) throws Exception {
        return blogRepository.findById(id).orElseThrow(
                () -> new Exception("Blog not found"));
    }

    public BlogRecord updateBlog(Long id, BlogRequest blogRequest) throws Exception {
        BlogRecord blogRecord = blogRepository.findById(id).orElseThrow(
                () -> new Exception("Blog not found"));
        blogRecord.setTitle(blogRequest.getTitle());
        blogRecord.setContent(blogRequest.getContent());
        return blogRepository.save(blogRecord);
    }

    public void deleteBlog(Long id) throws Exception {
        BlogRecord blogRecord = blogRepository.findById(id).orElseThrow(
                () -> new Exception("Blog not found"));
        blogRepository.delete(blogRecord);
    }

    public Iterable<BlogRecord> getAllBlogs() {
        return blogRepository.findAll();
    }

    public List<BlogMetadata> getAllBlogMetadata() {
        return StreamSupport.stream(blogRepository.findAll().spliterator(), false)
                .map(blogRecord -> BlogMetadata.builder()
                        .id(blogRecord.getId())
                        .title(blogRecord.getTitle())
                        .authorId(blogRecord.getAuthorId())
                        .createdAt(blogRecord.getCreatedAt())
                        .updatedAt(blogRecord.getUpdatedAt())
                        .build())
                .toList();
    }
}
