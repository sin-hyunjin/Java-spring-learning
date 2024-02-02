package oop1.ex;

/**
 * 은행 계좌를 객체로 설계해야 한다.
 * `Account` 클래스를 만들어라.
 * `int balance` 잔액
 * `deposit(int amount)` : 입금 메서드
 * 입금시 잔액이 증가한다.
 * `withdraw(int amount)` : 출금 메서드
 * 출금시 잔액이 감소한다.
 * 만약 잔액이 부족하면 **잔액 부족**을 출력해야 한다.
 */
public class Account {
    // 잔액
    int balance;

    // 입금 메서드
    void deposit(int amount) {
        balance += amount;
        System.out.println("balance = " + balance);
    }

    // 출금 메서드
    void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("balance = " + balance);
        } else {
            System.out.println("잔액이 부족합니다");
        }

    }
}
