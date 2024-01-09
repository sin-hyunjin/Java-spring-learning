package array;

public class Array1Ref3 {

    public static void main(String[] args) {
        int[] students; //배열 변수 선언
        students = new int[]{90, 80, 70, 60, 50}; // 배열 생성과 초기화

        /* Array2Ref2 코드 리팩토링
              students = new int[]{90, 80, 70, 60, 50}; 배열을 생성할때 바로 초기화를 해준다
         */
        //변수 값 사용
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생" + (i + 1) + " 점수: " + students[i]);
        }
    }
}
