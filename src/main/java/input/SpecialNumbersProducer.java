package input;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialNumbersProducer {

    public static List<Integer> produceSpecialNumbers() {
        int[] sn = new int[3];
        for (int i = 0; i < 3; i++) {
            int tmp = (int) (8 * Math.random()) + 1;
            for (int j = 0; j < i; j++) {
                if (sn[j] == tmp) {
                    tmp = (int) (8 * Math.random()) + 1;
                    j = -1;
                }
            }
            sn[i] = tmp;
        }
        List<Integer> specialNumbers = Arrays.asList(sn[0], sn[1], sn[2]);
        return specialNumbers;
    }
}

