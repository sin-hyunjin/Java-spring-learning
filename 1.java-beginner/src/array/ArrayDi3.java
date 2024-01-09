package array;
/*이 코드는 2x3 크기의 2차원 배열을 생성하고, 배열의 각 요소를 반복문을 통해 출력하는 Java 프로그램

 */
public class ArrayDi3 {

    public static void main(String[] args) {
        // 2x3 2차원 배열을 만든다.
        int[][] arr = {
            {1,2,3},
            {4,5,6}
        }; //행2, 열3

        // 배열의 각 요소를 순회하면서 출력한다.
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();//한 행이 끝나면 라인을 변경한다.
        }
    }
}
