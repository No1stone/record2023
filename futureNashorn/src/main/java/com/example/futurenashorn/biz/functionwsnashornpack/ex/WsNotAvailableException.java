package com.example.futurenashorn.biz.functionwsnashornpack.ex;

public class WsNotAvailableException extends RuntimeException{


    public WsNotAvailableException() {
        super("잘못된 코드를 입력했습니다.");
    }
    public WsNotAvailableException(String msg) {
        super(msg);
    }

}
