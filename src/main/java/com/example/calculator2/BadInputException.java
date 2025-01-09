package com.example.calculator2;

public class BadInputException extends Exception{
    public BadInputException () {
        super("잘못된 입력입니다.");
    }
}
