package module4.lesson7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("e.{2}");
        Matcher matcher = pattern.matcher("Hello PDP 535 Some random text 34");
        // System.out.println(matcher.matches());
        while ( matcher.find() ) {
            System.out.println("start=" + matcher.start() + ", end=" + matcher.end() + ", group=" + matcher.group());
        }
    }
}
