package ref;

public class NullMain3 {
    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("bigData.count = " + bigData.count); // 0
        System.out.println("bigData.data = " + bigData.data); // null

        //NullPointerException
        System.out.println("bigData.data.value=" + bigData.data.value);
//        System.out.println("bigData.data.value=" + x001.data.value); //bigData는 x001 참조값을 가진다
//        System.out.println("bigData.data.value=" + null.value);  //x001.data는 null 값을 가진다.
//        NullPointerException //null 값에 .(dot)을 찍으면 예외가 발생한다

    }
}
