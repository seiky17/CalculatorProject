package com.example.calculator2;

import java.util.List;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        // Calculator 클래스의 인스턴스 생성
        Calculator cal = new Calculator();
        // 스캐너 인스턴스 생성
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 첫 번째 숫자 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            // 두 번째 숫자 입력
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 첫 번째, 두 번째 숫자가 양의 정수인지 확인하는 조건문
            if (num1 < 0 || num2 < 0) {
                System.out.println("양의 정수값만 입력할 수 있습니다.");
                continue;
            }

            // 사칙연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요: ");
            char ch = sc.next().charAt(0);

            // 사칙연산 기호가 '/' 이고, 두 번째 숫자(분모)가 0이면 경고메시지를 출력하는 조건문
            if(ch == '/' && num2 == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이하의 값이 입력될 수 없습니다.");
                continue;
            }

            // 연산 메소드 'calculate' 를 호출
            cal.calculate(num1, num2, ch);

            // 기호를 잘못 입력했을 때 경고 메시지 출력
            if(cal.str.equals("none")){
                System.out.println("사칙연산 기호를 잘못 입력하였습니다.");
                cal.str = "";
                continue;
            }

            // List 타입의 array 변수에 메서드 calculate를 수행한 결과값을 넣음
            List<Integer> array = cal.getResult();

            // 연산한 결과를 출력
            System.out.println("결과: " + array.get(array.size() - 1)); // 결과 출력

            while (true) {
                // 연산 결과에 대한 사용자의 입력을 받음
                System.out.println("연산 결과를 어떻게 하시겠습니까? (get, set, remove)");
                String text = sc.next();

                // 예외 처리 부분
                try {
                    // 사용자의 입력에 따라서 결과를 출력
                    switch (text) {
                        case "get":
                            System.out.println("가장 최근 연산 결과: " + array.get(array.size() - 1));
                            break;
                        case "set":
                            System.out.println("몇 번째 계산결과를 수정하시겠습니까?");
                            int i = sc.nextInt();
                            System.out.println("어떤 정수로 수정하시겠습니까?");
                            int j = sc.nextInt();

                            cal.setResult(i - 1, j);
                            System.out.println(i + " 번째 계산결과가 수정된 결과: " + array.get(i - 1));
                            break;
                        case "remove":
                            cal.removeResult();
                            System.out.println("가장 오래된 계산결과를 삭제했습니다.");
                            System.out.println("현재 가장 오래된 계산결과: " + array.get(0));
                            break;
                        // get, set, remove 외의 다른 문자열을 입력하면 예외를 던짐
                        default: throw new BadInputException();
                    }
                } catch (BadInputException e) {  // 예외 처리 부분
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String string = sc.next(); // 더 계산할건지 입력

            // 만약 exit 라고 입력 받았다면 반복문을 종료
            if(string.equals("exit")){
                break;
            }
        }
    }
}
