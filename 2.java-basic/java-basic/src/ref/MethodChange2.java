package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value); // 10
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value);
    }
    // 1. dataA의 참조값을 복사해서 dataX로  넘어간다
    // Data dataX = dataA
    // 따라서 변수 dataA , dataX 둘다 같은 참조값인 x001 을 가지게 된다.
    static void changeReference(Data dataX) {
        dataX.value = 20;
    }

    /** 종이 두장이있다
     *  기본형 - 내가 10을 가지고 있고 옆사람 종이에 10을 적어줬다
     *  내 종이를 20으로 바꾼다고해서 옆사람 종이가 20으로 바뀌지 않는다
     *
     *  참조형 - 내 종이에 있는 주소값을 옆사람 종이에게 적어줬다
     *   옆사람이 주소값에 있는 건물에 뭔가를 변경했고, 내가 그 주소지에가면 똑같은 건물에 변경되어있는걸 확인할수 있다.
     *
     */
}

