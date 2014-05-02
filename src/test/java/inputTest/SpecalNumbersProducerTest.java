package inputTest;

import input.SpecialNumbersProducer;
import org.junit.Test;
import java.util.List;
import static junit.framework.Assert.assertTrue;

public class SpecalNumbersProducerTest {
    List<Integer> specialNumbers;

    @Test
    public void numbersProducedIsNotOutOfRange() throws Exception {
        for (int count = 0; count < 10; count++) {
            specialNumbers = SpecialNumbersProducer.produceSpecialNumbers();
            for (int i = 0; i < 3; i++) {
                assertTrue(specialNumbers.get(i) <= 9);
                assertTrue(specialNumbers.get(i) > 0);
            }
        }
    }

    @Test
    public void produceThreeDifferentNumbers() throws Exception {
        for (int count = 0; count < 10; count++) {
            specialNumbers = SpecialNumbersProducer.produceSpecialNumbers();
            assertTrue(specialNumbers.get(0) != specialNumbers.get(1));
            assertTrue(specialNumbers.get(1) != specialNumbers.get(2));
            assertTrue(specialNumbers.get(2) != specialNumbers.get(0));
        }
    }
}
