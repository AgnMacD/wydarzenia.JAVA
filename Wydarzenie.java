import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

abstract class Wydarzenie {
    protected String tytul;
    protected LocalDateTime dataCzas;
    protected String miejsce;
    protected List<String> uczestnicy;

    public Wydarzenie(String tytul, LocalDateTime dataCzas, String miejsce) {
        this.tytul = tytul;
        this.dataCzas = dataCzas;
        this.miejsce = miejsce;
        this.uczestnicy = new ArrayList<>();
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public LocalDateTime getDataCzas() {
        return dataCzas;
    }

    public void setDataCzas(LocalDateTime dataCzas) {
        this.dataCzas = dataCzas;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public List<String> getUczestnicy() {
        return uczestnicy;
    }

    public void dodajUczestnika(String uczestnik) {
        uczestnicy.add(uczestnik);
    }

    public void usunUczestnika(String uczestnik) {
        uczestnicy.remove(uczestnik);
    }
}
