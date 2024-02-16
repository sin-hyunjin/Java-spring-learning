package final1;

/**
 `Constant.MAX_USERS` 상수를 사용했다. 만약 프로그램 최대 참여자 수를 변경해야 하면
 `Constant.MAX_USERS` 의 상수 값만 변경하면 된다.
 매직 넘버 문제를 해결했다. 숫자 `1000` 이 아니라 사람이 인지할 수 있게 `MAX_USERS` 라는 변수명으로 코드로 이해할 수 있다.
 */
public class ConstantMain2 {
    public static void main(String[] args) {
        System.out.println("프로그램 최대 참여자 수 " + Constant.MAX_USERS);
        int currentUserCount = 999;
        process(currentUserCount++);
        process(currentUserCount++);
        process(currentUserCount++);

    }
    private static void process(int currentUserCount){
        System.out.println("참여자 수:" + currentUserCount);
        if (currentUserCount > Constant.MAX_USERS) {
            System.out.println("대기자로 등록합니다.");
        }else {
            System.out.println("게임에 참가합니다.");
        }
    }
}
