import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

class Warsztat extends Wydarzenie {
    private String temat;

    public Warsztat(String tytul, LocalDateTime dataCzas, String miejsce, String temat) {
        super(tytul, dataCzas, miejsce);
        this.temat = temat;
    }
    
    public String getTemat() {
        return temat;
    }
}
