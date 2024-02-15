package static1;

import memory.Data;

public class DataCountMain3 {

  /** 데 `Data3.count` 와 같이 클래스명에 `.` (dot)을 사용 한다. 마치 클래스에 직접 접근하는 것 처럼 느껴진다.
   * static` 이 붙은 멤버 변수는 메서드 영역에서 관리한다.
   * `static` 이 붙은 멤버 변수 `count` 는 인스턴스 영역에 생성되지 않는다. 대신에 메서드 영역에서 이 변수 를 관리한다.*/
    public static void main(String[] args) {

        Data3 data1 = new Data3("A"); // A 인스턴스
        System.out.println("A count = " + Data3.count);
        Data3 data2 = new Data3("B"); // B 인스턴스
        System.out.println("B count = " + Data3.count);
        Data3 data3 = new Data3("C"); // C 인스턴스
        System.out.println("C count = " + Data3.count);

        // 추가
        // 인스턴스를 통한 접근은 권장하지 않음 왜냐하면 인스턴스로 착각할 수 있음
        Data3 data4 = new Data3("D");
        System.out.println(data4.count);

        // 클래스를 통한 접근
        // 정적 변수는 클래스에서 공용으로 관리하기 때문에 클래스를 통해서 접근하는 것이 더 명확하다
        System.out.println(Data3.count);

    }

}
