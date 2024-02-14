package access.ex;

public class MaxCounter {
    private int count = 0;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increment() {
        // if else 문으로 쓸수 있지만 return문으로 쓰는 이유는?
        // 코드가 명확하게 구별할수 있음

        //검증로직
        if(count >= max) {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        //실행로직
        count++;
    }
    public int getCount() {
        return count;
    }


}
