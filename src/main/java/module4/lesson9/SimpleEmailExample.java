package module4.lesson9;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Properties;

public class SimpleEmailExample {
    private static final String username = "5c70206544a443";
    private static final String password = "055546fa0ed59c";

    public static void main(String[] args) throws Exception {
        Properties properties = getProperties();
        Session session = getSession(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("nig'matjon"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("recipient@gmail.com"));
        message.setSubject("This is Subject For Test Message");
        MimeMultipart multipart = new MimeMultipart();

        FileDataSource fileDataSource = new FileDataSource("cv.md");
        DataHandler dataHandler = new DataHandler(fileDataSource);

        MimeBodyPart attachment1 = new MimeBodyPart();
        attachment1.setFileName("ElmurodovJavohir.md");
        attachment1.setDataHandler(dataHandler);

        MimeBodyPart attachment2 = new MimeBodyPart();
        FileDataSource fileDataSource2 = new FileDataSource("samples.txt");
        DataHandler dataHandler2 = new DataHandler(fileDataSource2);
        attachment2.setFileName("samples.txt");
        attachment2.setDataHandler(dataHandler2);

        MimeBodyPart contentMessage = new MimeBodyPart();
        String body = """
                <div>
                <h1 style="color:red;">Body of mail here</h1>
                <img src="data:image/png;base64,%s" width=1000 >
                </div>
                """.formatted(getImageAsBase64());
        contentMessage.setContent(body, "text/html");

        multipart.addBodyPart(attachment1);
        multipart.addBodyPart(attachment2);
        multipart.addBodyPart(contentMessage);
        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    private static String getImageAsBase64() throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        Path path = Path.of("animal.png");
        byte[] allBytes = Files.readAllBytes(path);
        String encodeToString = encoder.encodeToString(allBytes);
        Files.writeString(Path.of("imageAstring.txt"),
                encodeToString,
                StandardOpenOption.TRUNCATE_EXISTING);
        return encodeToString;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }


    private static Session getSession(Properties properties) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
