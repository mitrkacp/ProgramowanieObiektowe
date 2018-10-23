
public class Main {

    public static void main(String[] args) {

        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("testowyemailagh@gmail.com")
                .addTo("testowyemailagh@gmail.com")
                .addSubject("Test")
                .addContent("Brak tresci")
                .build();

        wiadomosc.send();

    }
}
