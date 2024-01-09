package array;
/* 향상된 for-each문
    for(변수 : 배열 또는 컬렉션) {
       // 배열 또는 컬렉션의 요소를 순회하면서 수행할 작업
    }
 //개발자 입장에서는 그냥 배열을 순서대로 처음부터 끝까지 탐색하고 싶은데 일반 for문은 너무 번잡한 일을 해주어야 하는 귀찮음이 생김,,,
 //그래서 for-each 문이 탄생
 */
public class EnhancedFor1 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        //일반 for문
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.println(number);
        }

        //향상된 for문, for-each문 (실무에서 가장 많이 씀)
        for (int number : numbers) {
            System.out.println(number);
        }

        //향상된 for문에는 증가하는 인덱스 값이 감추어져 있다.
        //for-each문을 사용할 수 없는 경우, 증가하는 index 값 필요
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("number" + i + "번의 결과는: " + numbers[i]);
        }

    }
}
