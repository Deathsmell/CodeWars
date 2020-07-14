package parentheses;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

    public static void main(String[] args) {
        String balance = Parentheses.balance(5);
        System.out.println(balance);
    }

    private List<String> array = new ArrayList<>();

    public static String balance(int count) {
        Parentheses parentheses = new Parentheses();
        parentheses.create(5);
        return parentheses.toString();
    }

    @Override
    public String toString() {
        return "Parentheses{" +
                "array=" + array +
                '}';
    }

    private String create(int count) {
        String repeat = "()".repeat(count);
        String[] split = repeat.split("");



        return null;
    }
}
