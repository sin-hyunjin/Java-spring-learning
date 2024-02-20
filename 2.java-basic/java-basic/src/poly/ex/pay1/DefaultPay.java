package poly.ex.pay1;


/** 결제 수단을 찾지 못했을 때 사용한다. `DefaultPay` 사용하면 `null` 체크를 피할 수 있다.*/
public class DefaultPay implements Pay{
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
