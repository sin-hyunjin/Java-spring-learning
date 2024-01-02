package array;

public class ArrayDi4 {

    public static void main(String[] args) {

        // 10x10 크기의 2차원 배열을 생성한다.
        int[][] arr = new int[10][10];

        int i = 1;

        // 배열의 각 요소에 1부터 100까지의 값을 순차적으로 할당한다.
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = i++;
            }
        }

        // 배열의 각 요소를 순회하면서 출력한다.
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println(); // 한 행이 끝나면 라인을 변경한다.
        }
    }
}
