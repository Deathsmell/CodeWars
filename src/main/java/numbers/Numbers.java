package numbers;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    @Deprecated
    public static int nextBigger(long number) {

        long income = number;
        List<Long> sequence = new ArrayList<>();
        int count = 0;
        int result = 0;

        while (number != 0) {
            count++;
            sequence.add(number % 10);
            number /= 10;
        }

        for (int i = 0; i < sequence.size() - 1; i++) {
            if (sequence.get(i) > sequence.get(i + 1)) {
                long temp = sequence.get(i);
                sequence.set(i, sequence.get(i + 1));
                sequence.set(i + 1, temp);
                break;
            }
        }
        for (int i = sequence.size() - 1; i >= 0; --i) {
            result += sequence.get(i) * (Math.pow(10,--count));
        }

        return result == income ? -1 : result;
    }

}
