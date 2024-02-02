package oop1;

/** 객체지향 프로그래밍
 * 속성과 기능이 하나로 뭉쳐있는것
 * 새로운 메서드를 생성하는것이 아닌 데이터와
 *
 */
public class ValueObjectMain {
    public static void main(String[] args) {
        ValueData valueData = new ValueData();
        valueData.add();
        valueData.add();
        valueData.add();
        System.out.println("최종 숫자 value = " + valueData.value);

    }

}
