package construct;

import java.lang.reflect.Member;

public class MemberDefault {
    String name;

    // 기본생성자가 없으면 자동으로 만들어줌
    public MemberDefault(){
        System.out.println("생성자호출");
    }


}
