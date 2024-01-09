package scanner;

import java.util.Scanner;

public class ScannerWhile1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 사용자가 "exit"라는 문자열을 입력할 때 까지 프로그램이 돌아가게 함
        while (true) {
            System.out.print("문자열을 입력하세요(exit: 종료):");
            String str = scanner.nextLine();
            /*
            입력받은 문자가 "exit" 이면 프로그램을 종료
             */
            if (str.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("입력한 문자열: " + str);
        }
    }
}
