package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Strings {

    public static String stripComments(String text, String[] commentSymbols) {
        String[] split = text.split("\n");
        String pattern = "[\\s]*([" + String.join("", commentSymbols) + "].*)?$";
        return Arrays.stream(split)
                .map(s -> s.replaceAll(pattern, ""))
                .collect(Collectors.joining("\n"));
    }

    public static String rangeExtraction(int[] array) {

        StringBuilder sb = new StringBuilder();

        int right = 0, left = 0;
        while (right < array.length) {
            while (++left < array.length && array[left] - array[left - 1] == 1) {
                // empty
            }
            if (left - right > 2) {
                sb.append(array[right]).append("-").append(array[left - 1]);
                if (left != array.length) {
                    sb.append(",");
                }
                right = left;
            } else {
                for (; right < left; right++) {
                    sb.append(array[right]);
                    if (right != array.length - 1) {
                        sb.append(",");
                    }
                }
            }
        }
        return sb.toString();
    }


//    private static void find(int[] array, StringBuilder sb) {
//        for (int i = 0; i <= array.length - 1; i++) {
//            sb.append(array[i]);
//            if (i != array.length - 1) {
//                if ( array[i] + 1 == array[i + 1] && array[i] + 2 == array[i + 2]) {
//                    sb.append("-");
//                    while (i != array.length - 1 && array[i] + 1 == array[i + 1]) {
//                        i++;
//                    }
//                    sb.append(array[i]);
//                }
//            }
//            if (i != array.length - 1){
//                sb.append(",");
//            }
//        }
//    }


    @Deprecated
    public static boolean isMerge(String string, String part1, String part2) {
        if (string.length() != part1.length() + part2.length()) {
            return false;
        }
        return find(string, part1, part2) || find(string, part2, part1);
    }

    private static boolean find(String source, String part1, String part2) {
        int markPart1 = 0, markPart2 = 0;
        int lengthPart1 = part1.length();
        int lengthPart2 = part2.length();
        for (int i = 0; i < source.length() - 1; i++) {
            if (markPart1 != lengthPart1 && source.charAt(i) == part1.charAt(markPart1)) {
                markPart1++;
                continue;
            }
            if (markPart2 != lengthPart2 && source.charAt(i) == part2.charAt(markPart2)) {
                markPart2++;
                continue;
            }
            return false;
        }
        return true;
    }


//    private static boolean find( String[] sourceLetters, String[] lettersPart1, String[] lettersPart2) {
//        int markPart1 =0, markPart2 = 0;
//        for (int i = 0; i < sourceLetters.length - 1; i++) {
//            if (markPart1 != lettersPart1.length && sourceLetters[i].equals(lettersPart1[markPart1])) {
//                markPart1++;
//                continue;
//            }
//            if (markPart2 != lettersPart2.length && sourceLetters[i].equals(lettersPart2[markPart2])){
//                markPart2++;
//                continue;
//            }
//            return false;
//        }
//        return true;
//    }
}
