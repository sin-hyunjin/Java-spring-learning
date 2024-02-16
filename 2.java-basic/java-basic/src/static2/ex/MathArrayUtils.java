package static2.ex;

import oop1.ValueData;

public class MathArrayUtils {

    private void MathArrayUtilMain() {
        //private 인스턴스 생성을 막는다.
    }

    public static int sum(int[] values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

    public static double average(int[] values) {
        return (double) sum(values) / values.length;
        
    }

    public static int min(int[] values) {
        int minValue = values[0];
        for (int value : values) {
            if(value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public static int max(int[] values) {
        int maxValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if(values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }

}
