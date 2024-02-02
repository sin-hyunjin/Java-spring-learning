package ref;

public class NullMain4 {
    /** NullMain3 예외처리방법

     */
    public static void main(String[] args) {

        BigData bigData = new BigData();
        // 새로운 참조할 곳을 생성해주면 된다.
        bigData.data = new Data();

        System.out.println("bigData.count = " + bigData.count); // 0
        System.out.println("bigData.data = " + bigData.data); // null


        System.out.println("bigData.data.value = " + bigData.data.value);
        /** 실행과정
        * bigData.data.value
        * x001.data.value //bigData는 x001 참조값을 가진다.
        * x002.value //x001.data는 x002 값을 가진다.
        * 0 // 최종 결과
         */
    }
}
