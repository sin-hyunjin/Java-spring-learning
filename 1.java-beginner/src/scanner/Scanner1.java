package scanner;

// 자바에 있는 라이브러리
import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        // System.in 사용자에게 입력받을 곳
        Scanner scanner = new Scanner(System.in);

        System.out.println("hello\n"); // print("\n"), println() 이랑 같다. \n = 개행

        System.out.println("문자열을 입력하세요:");
        // 엔터를 입력할 때 문자를 가져온다 .
        String str = scanner.nextLine(); //입력을 String으로 가져온다
        System.out.println("입력한 문자열: " + str);

        System.out.println("정수를 입력하세요 : ");
        int intValue = scanner.nextInt();
        System.out.println("입력한 정수 :  " + intValue);

        System.out.println("실수를 입력하세요 : ");
        double doubleValue = scanner.nextDouble();
        System.out.println("입력한 실수 :  " + doubleValue);
    }
}
