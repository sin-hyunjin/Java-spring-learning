package access.a;

public class PublicClass {

    //파일명과 이 클래스의 이름이 반드시 같아야 한다. 이 클래스는 `public` 이기 때문에 외부에서 접근할 수 있다.
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 class1 = new DefaultClass1();
        DefaultClass2 class2 = new DefaultClass2();
    }
}

class DefaultClass1{

}
class DefaultClass2{

}
