import java.time.LocalDateTime;

public class AplikacjaWydarzenia {
    public static void main(String[] args) {
        Spotkanie spotkanie = new Spotkanie("Spotkanie Java", LocalDateTime.now(), "Warszawa");
        Warsztat warsztat = new Warsztat("Warsztat programowania", LocalDateTime.now(), "Kraków", "Programowanie w Java");

        System.out.println("Spotkanie: " + spotkanie.getTytul() + " w " + spotkanie.getMiejsce());
        System.out.println("Warsztat: " + warsztat.getTytul() + " o temacie " + warsztat.getTemat() + " w " + warsztat.getMiejsce());
    }
}
