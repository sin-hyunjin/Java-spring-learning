package static2;

public class DecoMain2 {
    /** 정적 메서드 덕분에 불필요한 객체 생성 없이 편리하게 메서드를 사용했다.*/
    public static void main(String[] args) {
        String s = "hello java";
        String deco = DecoUtil2.deco(s);

        System.out.println("before:" + s);
        System.out.println("after:" + deco);
    }
}
