package module5.lesson1;

@FunctionalInterface
public interface CallCenter {
    String call();

    default String call2() {
        return "bot";
    }

    ;
}
