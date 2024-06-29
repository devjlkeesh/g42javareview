package module4.lesson6;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Hello  from main thread 1");
        ExecutorService executor = Executors.newFixedThreadPool(10);
       /* CompletableFuture<Void> compFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello Guys from Comp Future");
        }, executor);*/
        /*for (int i = 0; i < 100_000_000; i++) {
            new Thread(() -> {
                System.out.println("Message sent");
            }).start();
        }*/
        CompletableFuture
                .supplyAsync(antifraudCheck(), executor)
                .thenApply(emailVerify())
                .thenAccept(insertUser())
                .thenRun(() -> System.out.println("registration processes succeeded"));
        System.out.println("Hello  from main thread 2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Hello  from main thread 3");

        CompletableFuture<Object> humoHistory = CompletableFuture.supplyAsync(() -> {
            return null;
        });
        CompletableFuture<Object> uzcardHistory = CompletableFuture.supplyAsync(() -> {
            return null;
        });

//        Object o1 = uzcardHistory.get();
//        Object o = humoHistory.get();
        CompletableFuture<Void> all = CompletableFuture.allOf(humoHistory, uzcardHistory);
        all.get();
        /*Object o = uzcardHistory.get();
        Object o1 = humoHistory.get();*/

    }

    private static Consumer<Boolean> insertUser() {
        return ok -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ok)
                System.out.println("inserting new user");
            else
                System.out.println("email was not valid");
        };
    }

    private static Function<Boolean, Boolean> emailVerify() {
        return ok -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ok)
                System.out.println("Antifraud check was ok");
            else {
                System.out.println("Antifraud check failed");
                return false;
            }
            System.out.println("Email is verified");
            return true;
        };
    }


    private static Supplier<Boolean> antifraudCheck() {
        return () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Antifraud check is successful");
            return true;
        };
    }
}
