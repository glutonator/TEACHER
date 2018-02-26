package mapping;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "OCENY", schema = "BD2A20", catalog = "")
public class OcenyEntity {
    private long idOceny;
    private int idStudenta;
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;
    private short idTypuOceny;
    private double wartosc;
    private Time dataICzasWystawienia;
    private String komentarz;
    private OcenyKoncoweEntity ocenyKoncowe;
    private TypyOcenEntity typyOcenByIdTypuOceny;

    @Id
    @Column(name = "ID_OCENY", nullable = false, precision = 0)
    public long getIdOceny() {
        return idOceny;
    }

    public void setIdOceny(long idOceny) {
        this.idOceny = idOceny;
    }

    @Basic
    @Column(name = "ID_STUDENTA", nullable = false, precision = 0)
    public int getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    @Basic
    @Column(name = "KOD_PRZEDMIOTU", nullable = false, length = 3)
    public String getKodPrzedmiotu() {
        return kodPrzedmiotu;
    }

    public void setKodPrzedmiotu(String kodPrzedmiotu) {
        this.kodPrzedmiotu = kodPrzedmiotu;
    }

    @Basic
    @Column(name = "ROK", nullable = false, precision = 0)
    public long getRok() {
        return rok;
    }

    public void setRok(long rok) {
        this.rok = rok;
    }

    @Basic
    @Column(name = "RODZAJ_SEMESTRU", nullable = false, length = 1)
    public String getRodzajSemestru() {
        return rodzajSemestru;
    }

    public void setRodzajSemestru(String rodzajSemestru) {
        this.rodzajSemestru = rodzajSemestru;
    }

    @Basic
    @Column(name = "ID_TYPU_OCENY", nullable = false, precision = 0)
    public short getIdTypuOceny() {
        return idTypuOceny;
    }

    public void setIdTypuOceny(short idTypuOceny) {
        this.idTypuOceny = idTypuOceny;
    }

    @Basic
    @Column(name = "WARTOSC", nullable = false, precision = 1)
    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    @Basic
    @Column(name = "DATA_I_CZAS_WYSTAWIENIA", nullable = false)
    public Time getDataICzasWystawienia() {
        return dataICzasWystawienia;
    }

    public void setDataICzasWystawienia(Time dataICzasWystawienia) {
        this.dataICzasWystawienia = dataICzasWystawienia;
    }

    @Basic
    @Column(name = "KOMENTARZ", nullable = true, length = 50)
    public String getKomentarz() {
        return komentarz;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OcenyEntity that = (OcenyEntity) o;
        return idOceny == that.idOceny &&
                idStudenta == that.idStudenta &&
                rok == that.rok &&
                idTypuOceny == that.idTypuOceny &&
                wartosc == that.wartosc &&
                Objects.equals(kodPrzedmiotu, that.kodPrzedmiotu) &&
                Objects.equals(rodzajSemestru, that.rodzajSemestru) &&
                Objects.equals(dataICzasWystawienia, that.dataICzasWystawienia) &&
                Objects.equals(komentarz, that.komentarz);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idOceny, idStudenta, kodPrzedmiotu, rok, rodzajSemestru, idTypuOceny, wartosc, dataICzasWystawienia, komentarz);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "ID_STUDENTA", referencedColumnName = "ID_STUDENTA", nullable = false), @JoinColumn(name = "KOD_PRZEDMIOTU", referencedColumnName = "KOD_PRZEDMIOTU", nullable = false), @JoinColumn(name = "ROK", referencedColumnName = "ROK", nullable = false), @JoinColumn(name = "RODZAJ_SEMESTRU", referencedColumnName = "RODZAJ_SEMESTRU", nullable = false)})
    public OcenyKoncoweEntity getOcenyKoncowe() {
        return ocenyKoncowe;
    }

    public void setOcenyKoncowe(OcenyKoncoweEntity ocenyKoncowe) {
        this.ocenyKoncowe = ocenyKoncowe;
    }

    @ManyToOne
    @JoinColumn(name = "ID_TYPU_OCENY", referencedColumnName = "ID_TYPU_OCENY", nullable = false)
    public TypyOcenEntity getTypyOcenByIdTypuOceny() {
        return typyOcenByIdTypuOceny;
    }

    public void setTypyOcenByIdTypuOceny(TypyOcenEntity typyOcenByIdTypuOceny) {
        this.typyOcenByIdTypuOceny = typyOcenByIdTypuOceny;
    }
}
