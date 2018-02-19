package mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OcenyKoncoweEntityPK implements Serializable {
    private int idStudenta;
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;

    @Column(name = "ID_STUDENTA", nullable = false, precision = 0)
    @Id
    public int getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    @Column(name = "KOD_PRZEDMIOTU", nullable = false, length = 3)
    @Id
    public String getKodPrzedmiotu() {
        return kodPrzedmiotu;
    }

    public void setKodPrzedmiotu(String kodPrzedmiotu) {
        this.kodPrzedmiotu = kodPrzedmiotu;
    }

    @Column(name = "ROK", nullable = false, precision = 0)
    @Id
    public long getRok() {
        return rok;
    }

    public void setRok(long rok) {
        this.rok = rok;
    }

    @Column(name = "RODZAJ_SEMESTRU", nullable = false, length = 1)
    @Id
    public String getRodzajSemestru() {
        return rodzajSemestru;
    }

    public void setRodzajSemestru(String rodzajSemestru) {
        this.rodzajSemestru = rodzajSemestru;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OcenyKoncoweEntityPK that = (OcenyKoncoweEntityPK) o;

        if (idStudenta != that.idStudenta) return false;
        if (rok != that.rok) return false;
        if (kodPrzedmiotu != null ? !kodPrzedmiotu.equals(that.kodPrzedmiotu) : that.kodPrzedmiotu != null)
            return false;
        if (rodzajSemestru != null ? !rodzajSemestru.equals(that.rodzajSemestru) : that.rodzajSemestru != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudenta;
        result = 31 * result + (kodPrzedmiotu != null ? kodPrzedmiotu.hashCode() : 0);
        result = 31 * result + (int) (rok ^ (rok >>> 32));
        result = 31 * result + (rodzajSemestru != null ? rodzajSemestru.hashCode() : 0);
        return result;
    }
}
