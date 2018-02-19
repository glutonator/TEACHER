package mapping;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "OCENY", schema = "BD2A20", catalog = "")
public class OcenyEntity {
    private long idOceny;
    private int idStudenta;
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;
    private short idTypuOceny;
    private long wartosc;
    private Time dataICzasWystawienia;
    private String komentarz;

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
    public long getWartosc() {
        return wartosc;
    }

    public void setWartosc(long wartosc) {
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

        if (idOceny != that.idOceny) return false;
        if (idStudenta != that.idStudenta) return false;
        if (rok != that.rok) return false;
        if (idTypuOceny != that.idTypuOceny) return false;
        if (wartosc != that.wartosc) return false;
        if (kodPrzedmiotu != null ? !kodPrzedmiotu.equals(that.kodPrzedmiotu) : that.kodPrzedmiotu != null)
            return false;
        if (rodzajSemestru != null ? !rodzajSemestru.equals(that.rodzajSemestru) : that.rodzajSemestru != null)
            return false;
        if (dataICzasWystawienia != null ? !dataICzasWystawienia.equals(that.dataICzasWystawienia) : that.dataICzasWystawienia != null)
            return false;
        if (komentarz != null ? !komentarz.equals(that.komentarz) : that.komentarz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idOceny ^ (idOceny >>> 32));
        result = 31 * result + idStudenta;
        result = 31 * result + (kodPrzedmiotu != null ? kodPrzedmiotu.hashCode() : 0);
        result = 31 * result + (int) (rok ^ (rok >>> 32));
        result = 31 * result + (rodzajSemestru != null ? rodzajSemestru.hashCode() : 0);
        result = 31 * result + (int) idTypuOceny;
        result = 31 * result + (int) (wartosc ^ (wartosc >>> 32));
        result = 31 * result + (dataICzasWystawienia != null ? dataICzasWystawienia.hashCode() : 0);
        result = 31 * result + (komentarz != null ? komentarz.hashCode() : 0);
        return result;
    }
}
