package ref;

public class VarChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10; // x001
        Data dataB = dataA;

        System.out.println("dataA 참조값= " + dataA);
        System.out.println("dataB 참조값= " + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);

        //dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value); // 20
        System.out.println("dataB.value = " + dataB.value); // 20
        //dataB 변경
        dataB.value = 30; // 참조값은 하나이다
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value); // 30
        System.out.println("dataB.value = " + dataB.value); // 30

        // 변수에 들어있는 참조값을 복사해서 전달할 뿐이다 .
    }
}
