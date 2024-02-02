package construct;

public class MethodInitMain3 {
    public static void main(String[] args) {

        MemberInit member1 = new MemberInit(); // 기본 생성자 생성자가 하나라도 있으면 자바는 기본 생성자를 만들지 않는다.
        member1.initMember( "user1", 15, 90);

        MemberInit member2 = new MemberInit();
        member2.initMember("user2", 16, 80);


        MemberInit[] members = {member1, member2};

        for (MemberInit s : members) {
            System.out.println("이름:" + s.name + " 나이:" + s.age + " 성적:" + s.grade);
        }
    }

}
