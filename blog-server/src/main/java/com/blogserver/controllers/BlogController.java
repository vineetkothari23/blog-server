package com.blogserver.controllers;

import com.blogserver.authentication.User;
import com.blogserver.model.BlogMetadata;
import com.blogserver.model.BlogRecord;
import com.blogserver.model.request.BlogRequest;
import com.blogserver.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/metadata")
    public ResponseEntity<List<BlogMetadata>> getBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogMetadata());
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<BlogRecord> getBlog(@PathVariable Long blogId) throws Exception {
        return ResponseEntity.ok(blogService.getBlog(blogId));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BlogRecord> addBlog(@AuthenticationPrincipal User user,
                                              @RequestBody BlogRequest blogRequest) {
        return ResponseEntity.ok(blogService.addBlog(blogRequest, user));
    }

    @PostMapping("/{blogId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BlogRecord> updateBlog(@PathVariable Long blogId,
                                                 @RequestBody BlogRequest blogRequest) throws Exception {
        return ResponseEntity.ok(blogService.updateBlog(blogId, blogRequest));
    }

}
