package pack;


import pack.a.User;

public class PakageMain3 {
    public static void main(String[] args) {
        User userA = new User();
        pack.b.User userB = new pack.b.User(); // 똑같은 User는  pack.b.User pull name을 적어줘야한다.
    }
}
