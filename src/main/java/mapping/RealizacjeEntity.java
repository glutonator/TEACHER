package mapping;

import javax.persistence.*;

@Entity
@Table(name = "REALIZACJE", schema = "BD2A20", catalog = "")
@IdClass(RealizacjeEntityPK.class)
public class RealizacjeEntity {
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RealizacjeEntity that = (RealizacjeEntity) o;

        if (rok != that.rok) return false;
        if (kodPrzedmiotu != null ? !kodPrzedmiotu.equals(that.kodPrzedmiotu) : that.kodPrzedmiotu != null)
            return false;
        if (rodzajSemestru != null ? !rodzajSemestru.equals(that.rodzajSemestru) : that.rodzajSemestru != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kodPrzedmiotu != null ? kodPrzedmiotu.hashCode() : 0;
        result = 31 * result + (int) (rok ^ (rok >>> 32));
        result = 31 * result + (rodzajSemestru != null ? rodzajSemestru.hashCode() : 0);
        return result;
    }
}
