package ref;
/** Null
 */
public class NullMain1 {

    public static void main(String[] args) {
        //1 . Data타입을 받을수 있는 참조형 변수 data를 만든후 null값을 할당했다
        Data data = null;
        System.out.println("1. data = " + data);
        //2. 이후 새로운 data객체를 생성해서 그 참조값을 data 변수에 할당함
        data = new Data();
        System.out.println("2. data = " + data);
        // 3.마지막에 data에 다시 null값을 할당했다. 이렇게하면 Data인스턴스를 더는 참조하지 않는다.
        data = null;
        System.out.println("3. data = " + data);
    }
}
