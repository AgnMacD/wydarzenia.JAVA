import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class ZarzadzanieWydarzeniami {
    private List<Wydarzenie> wydarzenia = new ArrayList<>();

    // Metoda do dodawania dowolnego obiektu dziedziczącego po Wydarzenie
    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        wydarzenia.add(wydarzenie);
    }

    // Metody do zarządzania wydarzeniami
    public void edytujWydarzenie(Wydarzenie wydarzenie, String nowyTytul, LocalDateTime nowaDataCzas, String noweMiejsce) {
        if (wydarzenia.contains(wydarzenie)) {
            wydarzenie.setTytul(nowyTytul);
            wydarzenie.setDataCzas(nowaDataCzas);
            wydarzenie.setMiejsce(noweMiejsce);
        }
    }

    public void usunWydarzenie(Wydarzenie wydarzenie) {
        wydarzenia.remove(wydarzenie);
    }

    public List<Wydarzenie> getNadchodzaceWydarzenia() {
        return wydarzenia.stream()
                .filter(w -> w.getDataCzas().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public void zapiszWydarzeniaDoPliku(String sciezkaPliku) {
        List<String> linie = wydarzenia.stream()
            .map(w -> w.getTytul() + ";" + w.getDataCzas() + ";" + w.getMiejsce())
            .collect(Collectors.toList());

        try {
            Files.write(Paths.get(sciezkaPliku), linie);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }

    public void wczytajWydarzeniaZPliku(String sciezkaPliku) {
        try {
            List<String> linie = Files.readAllLines(Paths.get(sciezkaPliku));
            for (String linia : linie) {
                String[] atrybuty = linia.split(";");
                // Sprawdzenie typu wydarzenia i odpowiednie przekształcenie
                if ("Spotkanie".equals(atrybuty[0])) {
                    this.dodajWydarzenie(new Spotkanie(atrybuty[1], LocalDateTime.parse(atrybuty[2]), atrybuty[3]));
                } else if ("Warsztat".equals(atrybuty[0])) {
                    this.dodajWydarzenie(new Warsztat(atrybuty[1], LocalDateTime.parse(atrybuty[2]), atrybuty[3], atrybuty[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu z pliku: " + e.getMessage());
        }
    }
}
