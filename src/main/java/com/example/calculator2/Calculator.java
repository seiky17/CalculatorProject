package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 ArrayList 타입 필드 생성
    private final List<Integer> resultArray = new ArrayList<>();
    String str = "";

    // ArrayList 타입의 resultArray를 리턴해주는 메서드
    public ArrayList<Integer> getResult() {
        return (ArrayList<Integer>) resultArray;
    }

    // resultArray의 값을 변경해주는 메서드
    public void setResult(int index, int number) {
        resultArray.set(index, number);
    }

    // 가장 오래된 resultArray의 값을 지우는 메서드
    public void removeResult() {
        resultArray.remove(0);
    }

    // 사칙연산을 수행하는 메서드
    public void calculate (int firstNum, int secondNum, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = firstNum + secondNum;
                resultArray.add(result);
                break;
            case '-':
                result = firstNum - secondNum;
                resultArray.add(result);
                break;
            case '*':
                result = firstNum * secondNum;
                resultArray.add(result);
                break;
            case '/':
                result = firstNum / secondNum;
                resultArray.add(result);
                break;
            default: str = "none";
        }
    }
}
