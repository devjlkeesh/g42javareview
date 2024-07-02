package module4.lesson9;

import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        basic("/usr/lib/jvm/java-1.21.0-openjdk-amd64/bin/java -javaagent:/home/jlkeesh/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=34373:/home/jlkeesh/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/jlkeesh/IdeaProjects/g42/java_review/target/classes:/home/jlkeesh/.m2/repository/com/sun/mail/javax.mail/1.6.2/javax.mail-1.6.2.jar:/home/jlkeesh/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar module4.lesson9.Base64Example\n");
        mime("/usr/lib/jvm/java-1.21.0-openjdk-amd64/bin/java -javaagent:/home/jlkeesh/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=34373:/home/jlkeesh/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/jlkeesh/IdeaProjects/g42/java_review/target/classes:/home/jlkeesh/.m2/repository/com/sun/mail/javax.mail/1.6.2/javax.mail-1.6.2.jar:/home/jlkeesh/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar module4.lesson9.Base64Example\n");
        url("\"a?");
    }

    private static void url(String input) {
        String s = Base64.getUrlEncoder().encodeToString(input.getBytes());
        String d = new String(Base64.getUrlDecoder().decode(s));
        System.out.println(s);
        System.out.println(d);
    }

    private static void basic(String input) {
        Base64.Encoder encoder = Base64.getEncoder();
        String s = encoder.encodeToString(input.getBytes());
        System.out.println("s = " + s);
        Base64.Decoder decoder = Base64.getDecoder();
        String d = new String(decoder.decode(s));
        System.out.println("d = " + d);
    }
    private static void mime(String input) {
        Base64.Encoder encoder = Base64.getMimeEncoder();
        String s = encoder.encodeToString(input.getBytes());
        System.out.println( s);
        Base64.Decoder decoder = Base64.getMimeDecoder();
        String d = new String(decoder.decode(s));
        System.out.println("d = " + d);
    }
}
