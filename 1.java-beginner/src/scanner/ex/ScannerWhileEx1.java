package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx1 {
        /* 이름과 나이를 반복
            사용자로부터 이름과 나이를 반복해서 입력 받고, 입력받은 이름과 나이를 출력하는 프로그램
            - 사용자가 "종료"를 입력하면 프로그램이 종료 되어야한다.
         */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("이름을 입력하세요 (종료를 입력하면 종료): ");

            String name = input.nextLine();

            // 이름대신 종료를 입력하면 프로그램을 종료
            if (name.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("나이를 입력하세요: ");
            int age = input.nextInt();
            // nextLine 은 \n 사용자의 엔터까지 입력받아온다
            // 그래서 나이를 입력하고 enter를 누르면 /n값을 이 남아서 다름 반복문에 \n을 가져오기 때문에  name에는 "" 값이 출력된다
            // nextLine()를 한번더 써서 \n을 버려준다 .
            input.nextLine();

            System.out.println("입력한 이름: " + name + ", 나이: " + age);
        }
    }
}
