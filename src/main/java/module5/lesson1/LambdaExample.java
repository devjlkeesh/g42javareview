package module5.lesson1;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class LambdaExample {
    private static String name;

    static {
        name = "Lambda Example";
        Runnable runnable = () -> {

        };
    }

    public static void main(String[] args) {
        Runnable runnable = () -> "Hello PDP !".length();

        Callable<Integer> callable = () -> "Hello PDP !".length();
        int b = 12;

        Function<Integer, String> myFunc = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                int c = b;
                System.out.println(++c);
                System.out.println(name);
                return "Hello";
            }
        };

        CallCenter callCenter = () -> {
            return "salom bu pdp support";
        };

//        b=90;

    }
}
