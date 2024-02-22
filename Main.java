import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ZarzadzanieWydarzeniami zarzadzanie = new ZarzadzanieWydarzeniami();
    
        // Dodanie wydarzenia
        zarzadzanie.dodajWydarzenie(new Spotkanie("Spotkanie Java", LocalDateTime.of(2024, 2, 10, 15, 0), "Warszawa"));

        
        // Pobranie i wyświetlenie nadchodzących wydarzeń
        List<Wydarzenie> nadchodzace = zarzadzanie.getNadchodzaceWydarzenia();
        nadchodzace.forEach(w -> System.out.println(w.getTytul() + " - " + w.getDataCzas().toString()));
    }
}
