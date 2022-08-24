package com.jws.wonseok.biz.v1.java8testModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;
}
