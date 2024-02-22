import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

class Spotkanie extends Wydarzenie {
    public Spotkanie(String tytul, LocalDateTime dataCzas, String miejsce) {
        super(tytul, dataCzas, miejsce);
    }
}