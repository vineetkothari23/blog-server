package com.blogserver.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogRequest {

    private String title;
    private String content;

}
