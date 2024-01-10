package class1;

public class ClassStart2 {
    /** ClassStart1 문제를 배열로 해결하보기
     * 배열을 사용한 덕분에 학생이 추가되어도 배열에 학생의 데이터만 추가하면 된다.
     * 이제 변수를 더 추가하지 않아도 되고, 출력 부분의 코드도 그대로 유지할 수 있다
     *
     * 배열을 사용해서 코드 변경을 최소화하는데는 성공했지만,
     * 한 학생의 데이터가 `studentNames[]` , `studentAges[]` , `studentGrades[]` 라는 3개의 배열에 나누어져 있다.
     * 따라서 데이터를 변경할 때 매우 조심해서 작업해야 한다.
     * 예를 들어서 학생 2의 데이터를 제거하려면 각각의 배열마다 학생2의 요소를 정확하게 찾아서 제거 해주어야 한다.
     *
     * 지금처럼 이름, 나이, 성적을 각각 따로 나누어서 관리하는 것은 사람이 관리하기 좋은 방식이 아니다.
     * 사람이 관리하기 좋은 방식은 학생이라는 개념을 하나로 묶는 것이다. 그리고 각각의 학생 별로 본인의 이름, 나이, 성적 을 관리하는 것이다.
     */
    public static void main(String[] args) {
        String[] studentNames = {"학생1", "학생2","학생3","학생4"};
        int[] studentAges = {15, 16, 17, 18};
        int[] studentGrades = {90, 80, 70, 60};

        for (int i = 0; i < studentNames.length; i++) {
            System.out.println("이름:" + studentNames[i] + " 나이:" + studentAges[i] + " 성적:" + studentGrades[i]);
        }
    }
}
