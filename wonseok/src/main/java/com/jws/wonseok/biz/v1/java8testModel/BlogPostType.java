package com.jws.wonseok.biz.v1.java8testModel;

public enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE;

    public String getName(){
        return this.name();
    }
}
