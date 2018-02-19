package mapping;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "OCENY_KONCOWE", schema = "BD2A20", catalog = "")
@IdClass(OcenyKoncoweEntityPK.class)
public class OcenyKoncoweEntity {
    private int idStudenta;
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;
    private long ocenaKoncowa;
    private Time dataICzasAktualizacji;

    @Id
    @Column(name = "ID_STUDENTA", nullable = false, precision = 0)
    public int getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    @Id
    @Column(name = "KOD_PRZEDMIOTU", nullable = false, length = 3)
    public String getKodPrzedmiotu() {
        return kodPrzedmiotu;
    }

    public void setKodPrzedmiotu(String kodPrzedmiotu) {
        this.kodPrzedmiotu = kodPrzedmiotu;
    }

    @Id
    @Column(name = "ROK", nullable = false, precision = 0)
    public long getRok() {
        return rok;
    }

    public void setRok(long rok) {
        this.rok = rok;
    }

    @Id
    @Column(name = "RODZAJ_SEMESTRU", nullable = false, length = 1)
    public String getRodzajSemestru() {
        return rodzajSemestru;
    }

    public void setRodzajSemestru(String rodzajSemestru) {
        this.rodzajSemestru = rodzajSemestru;
    }

    @Basic
    @Column(name = "OCENA_KONCOWA", nullable = false, precision = 2)
    public long getOcenaKoncowa() {
        return ocenaKoncowa;
    }

    public void setOcenaKoncowa(long ocenaKoncowa) {
        this.ocenaKoncowa = ocenaKoncowa;
    }

    @Basic
    @Column(name = "DATA_I_CZAS_AKTUALIZACJI", nullable = false)
    public Time getDataICzasAktualizacji() {
        return dataICzasAktualizacji;
    }

    public void setDataICzasAktualizacji(Time dataICzasAktualizacji) {
        this.dataICzasAktualizacji = dataICzasAktualizacji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OcenyKoncoweEntity that = (OcenyKoncoweEntity) o;

        if (idStudenta != that.idStudenta) return false;
        if (rok != that.rok) return false;
        if (ocenaKoncowa != that.ocenaKoncowa) return false;
        if (kodPrzedmiotu != null ? !kodPrzedmiotu.equals(that.kodPrzedmiotu) : that.kodPrzedmiotu != null)
            return false;
        if (rodzajSemestru != null ? !rodzajSemestru.equals(that.rodzajSemestru) : that.rodzajSemestru != null)
            return false;
        if (dataICzasAktualizacji != null ? !dataICzasAktualizacji.equals(that.dataICzasAktualizacji) : that.dataICzasAktualizacji != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudenta;
        result = 31 * result + (kodPrzedmiotu != null ? kodPrzedmiotu.hashCode() : 0);
        result = 31 * result + (int) (rok ^ (rok >>> 32));
        result = 31 * result + (rodzajSemestru != null ? rodzajSemestru.hashCode() : 0);
        result = 31 * result + (int) (ocenaKoncowa ^ (ocenaKoncowa >>> 32));
        result = 31 * result + (dataICzasAktualizacji != null ? dataICzasAktualizacji.hashCode() : 0);
        return result;
    }
}
