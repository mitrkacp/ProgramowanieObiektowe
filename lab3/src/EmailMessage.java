import java.util.ArrayList;
import java.util.LinkedList;
import javax.mail.internet.AddressException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Scanner;


public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType; // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    protected EmailMessage(){}
    protected EmailMessage(Builder builder){
        if(builder == null)return;
        from = builder.from;
        to = builder.to;
        subject = builder.subject;
        content = builder.content;
        mimeType = builder.mimeType;
        cc = builder.cc;
        bcc = builder.bcc;

    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    //metoda sprawdzajaca poprawnosc adresu email
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public void send(){
        String username;
        String password;
        System.out.print("Podaj haslo:");
        username = this.from;
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new Authenticator()
                {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username,password);
                    }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
            for (String it: this.to) {
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(it));
            }
            message.setSubject(this.subject);
            message.setText(this.content);
            Transport.send(message);
            System.out.println("message has been sent");

        } catch (MessagingException obj) {
            obj.printStackTrace();
        }
    }

    static class Builder{
        private String from; //required (must be e-mail)
        private LinkedList<String> to = new LinkedList<String>(); //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType; // optional
        private LinkedList<String> cc = new LinkedList<String>(); //optional
        private LinkedList<String> bcc = new LinkedList<String>(); // optional

        public Builder(){
            from = null;
            to = new LinkedList<String>();
            subject = null;
            content = null;
            mimeType = null;
            cc = null;
            bcc = null;
        }

        public Builder(String from, String to){
            from = from;
            to = to;
            subject = null;
            content = null;
            mimeType = null;
            cc = null;
            bcc = null;
        }

        public Builder addFrom(String f){
            if(isValidEmailAddress(f)){
                from = f;
            }
            else{
                System.out.println("bledny adres nadawcy");
            }
            return this;
        }

        public Builder addTo(String t){
            if(isValidEmailAddress(t)){
                to.addLast(t);
            }
            else{
                System.out.println("bledny adres odbiorcy");
            }
            return this;
        }

        public Builder addSubject(String s){
            subject = s;
            return this;
        }

        public Builder addContent(String c){
            content = c;
            return this;
        }

        public EmailMessage build(){
            return new EmailMessage(this);
        }
    }
}

