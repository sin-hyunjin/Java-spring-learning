package method.ex;

import java.util.Scanner;

public class MethodEx4 {
    /*
    deposit 메소드: 입금 기능을 처리하며, 입금액을 현재 잔액에 더한 후 결과를 반환함

    withdraw 메소드: 출금 기능을 처리하며, 출금액이 현재 잔액보다 작거나 같을 경우 출금하고 결과를 반환함. 그렇지 않으면 잔액이 부족하다는 메시지를 출력함

    main 메소드: 사용자로부터 메뉴를 선택받아 해당하는 기능을 수행하고, 잔액을 출력함. 종료 메뉴를 선택하면 프로그램이 종료됨
     */
    public static void main(String[] args) {
        int balance = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택: ");

            int choice = scanner.nextInt(); //사용자가 선택한 숫자
            int amount; //사용자가 입력한 금액

            switch (choice) {
                case 1:
                    System.out.print("입금액을 입력하세요: ");
                    amount = scanner.nextInt();
                    balance = deposit(balance, amount);
                    break;
                case 2:
                    System.out.print("출금액을 입력하세요: ");
                    amount = scanner.nextInt();
                    balance = withdraw(balance, amount);
                case 3:
                    System.out.println("현재 잔액: " + balance + "원");
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다. 다시 선택해주세요.");
            }

        }

    }

    public static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }

        return balance;
    }

}
