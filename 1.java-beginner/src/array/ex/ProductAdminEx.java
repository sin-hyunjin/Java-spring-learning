import java.util.Scanner;

public class ProductAdminEx {
    /*
    상품 관리 프로그램
    - 상품 등록: 상품 이름과 가격을 입력받아 저장한다.
    - 상품 목록: 지금까지 등록한 모든 상품의 목록을 출력한다.

    * 제약조건
    - 상품은 최대 10개까지 등록할 수 있다.

    - 1. 상품 등록, 2. 상품 목록, 3. 종료
        - 메뉴 선택 :
        - 상품 이름을 입력
        - 상품 가격을 입력
    */

    public static void main(String[] args) {
        int maxProducts = 10; // 최대 등록 가능한 상품 수
        String[] productNames = new String[maxProducts]; // 상품 이름을 저장하는 배열
        int[] productPrices = new int[maxProducts]; // 상품 가격을 저장하는 배열
        int productCount = 0; // 현재까지 등록된 상품 수를 나타내는 변수

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1. 상품 등록 | 2. 상품 목록 | 3. 종료\n메뉴를 선택하세요:");
            int menu = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (menu == 1) {
                // 상품 등록 메뉴

                // 최대 상품 등록 제한 확인
                if (productCount >= maxProducts) {
                    System.out.println("더 이상 상품을 등록할 수 없습니다.");
                    continue;
                }

                // 상품 이름 및 가격 입력 받기
                System.out.print("상품 이름을 입력하세요:");
                productNames[productCount] = scanner.nextLine();

                System.out.print("상품 가격을 입력하세요:");
                productPrices[productCount] = scanner.nextInt();

                productCount++; // 상품 등록 완료, 상품 수 증가
            } else if (menu == 2) {
                // 상품 목록 출력 메뉴

                // 등록된 상품이 없는 경우
                if (productCount == 0) {
                    System.out.println("등록된 상품이 없습니다.");
                    continue;
                }

                // 등록된 상품 목록 출력
                for (int i = 0; i < productCount; i++) {
                    System.out.println(productNames[i] + ": " + productPrices[i] + "원");
                }
            } else if (menu == 3) {
                // 프로그램 종료 메뉴
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                // 잘못된 메뉴 선택 시 안내
                System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }
        }
    }
}
