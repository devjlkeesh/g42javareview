package module4.lesson7;

import java.util.Arrays;

public class StringRegexExample {
    public static void main(String[] args) {
        String[] es = "hello".split("e");
        System.out.println(Arrays.toString(es));
        String input = "Some 12 random 3 Text 90 For Fun 2 oor 1243";
        //String input = "12344567qw";
        String[] split = input.split("\\d+");
        System.out.println(Arrays.toString(split));
        System.out.println(input.matches("\\d{4}"));
        System.out.println(input.replace("12", "PDP"));
        String welcomePdp = input.replaceAll("\\d+", "Welcome PDP");
        System.out.println(welcomePdp);
    }
}
