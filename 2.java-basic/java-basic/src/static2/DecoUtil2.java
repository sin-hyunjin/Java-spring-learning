package static2;

public class DecoUtil2 {
    /** `deco()` 는 문자열을 꾸미는 기능을 제공한다. 문자열이 들어오면 앞 뒤에 `*` 을 붙여서 반환
     * 메서드에 static 추가한다면?
     * -> 인스턴스 생성 없이 클래스명을 통해서 바로 호출 할 수 있다. */
    public static String deco(String str) {
        return "*" + str + "*";
    }
}
