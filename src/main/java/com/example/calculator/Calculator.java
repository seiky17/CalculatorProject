package com.example.calculator;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            if (num1 < 0 || num2 < 0 ) {
                System.out.println("양의 정수를 입력하세요.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char ch = sc.next().charAt(0);

            switch (ch) {
                case '+':
                    System.out.println("결과: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("결과: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("결과: " + (num1 * num2));
                    break;
                case '/':
                    if(num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                        continue;
                    } else {
                        System.out.println("결과:  " + (num1 / num2));
                    }
                    break;
                default:
                    System.out.println("기호를 잘못 입력했습니다.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str = sc.next();
            if(str.equals("exit")) {
                break;
            }
        }
    }
}
