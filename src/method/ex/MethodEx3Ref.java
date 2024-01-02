package method.ex;

public class MethodEx3Ref {
    public static void main(String[] args) {
        int balance = 10000;

        // 대목차느낌
        balance = deposit(balance, 1000); //입금 1000
        balance = withdraw(balance, 2000); //출금 2000

        System.out.println("최종 잔액: " + balance + "원");
    }

    // 입금 메소드 1000
    public static int deposit(int balance, int amount) { // balance = 입금, amount = 잔액
        balance += amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
        return balance;
    }
    // 출금 메소드 2000
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