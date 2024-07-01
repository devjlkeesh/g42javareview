package module4.lesson6;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatExample {
    public static void main(String[] args) {
        ThreadLocal<SimpleDateFormat> sdfthreadlocal = ThreadLocal
                .withInitial(() -> new SimpleDateFormat("ddMMyyyy"));

        String formattedDate = "23011995";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for ( int i = 0; i < 60; i++ ) {
            executorService.execute(() -> {
                try {
                    Date parse = sdfthreadlocal.get().parse(formattedDate);
                    System.out.println(parse);
                } catch (Exception ignoring) {

                }
            });
        }
        executorService.shutdown();
    }
}
