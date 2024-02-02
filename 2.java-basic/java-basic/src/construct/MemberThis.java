package construct;

public class MemberThis {
    String nameField;

    // this를 생략할 수 있다.
    // IDE가 발전하면서 색깔로 구분하기 떄문에, 꼭 필요한 경우에만 사용해도 충분하다.
    void initMember(String nameParameter) {
        nameField = nameParameter;
    }
}
