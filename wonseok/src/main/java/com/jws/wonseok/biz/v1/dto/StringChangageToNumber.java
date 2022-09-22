package com.jws.wonseok.biz.v1.dto;

public class StringChangageToNumber {

    String s;

    StringChangageToNumber(String s) {
        this.s = s;
    }

    private StringChangageToNumber Zero() {
        s = s.replaceAll("zero", "0");
        return this;
    }

    private StringChangageToNumber One() {
        s = s.replaceAll("one", "1");
        return this;
    }

    private StringChangageToNumber Two() {
        s = s.replaceAll("two", "2");
        return this;
    }

    private StringChangageToNumber three() {
        s = s.replaceAll("three", "3");
        return this;
    }

    private StringChangageToNumber four() {
        s = s.replaceAll("four", "4");
        return this;
    }

    private StringChangageToNumber five() {
        s = s.replaceAll("five", "5");
        return this;
    }

    private StringChangageToNumber six() {
        s = s.replaceAll("six", "6");
        return this;
    }

    private StringChangageToNumber seven() {
        s = s.replaceAll("seven", "7");
        return this;
    }

    private StringChangageToNumber eight() {
        s = s.replaceAll("eight", "8");
        return this;
    }

    private StringChangageToNumber nine() {
        s = s.replaceAll("nine", "9");
        return this;
    }

    private StringChangageToNumber allNumber() {
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        return this;
    }
}
