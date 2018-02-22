package mapping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "REALIZACJE", schema = "BD2A20", catalog = "")
@IdClass(RealizacjeEntityPK.class)
public class RealizacjeEntity {
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;
    private Collection<OcenyKoncoweEntity> ocenyKoncowes;
    private PrzedmiotyEntity przedmiotyByKodPrzedmiotu;

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
        return rok == that.rok &&
                Objects.equals(kodPrzedmiotu, that.kodPrzedmiotu) &&
                Objects.equals(rodzajSemestru, that.rodzajSemestru);
    }

    @Override
    public int hashCode() {

        return Objects.hash(kodPrzedmiotu, rok, rodzajSemestru);
    }

    @OneToMany(mappedBy = "realizacje")
    public Collection<OcenyKoncoweEntity> getOcenyKoncowes() {
        return ocenyKoncowes;
    }

    public void setOcenyKoncowes(Collection<OcenyKoncoweEntity> ocenyKoncowes) {
        this.ocenyKoncowes = ocenyKoncowes;
    }

    @ManyToOne
    @JoinColumn(name = "KOD_PRZEDMIOTU", referencedColumnName = "KOD_PRZEDMIOTU", nullable = false)
    public PrzedmiotyEntity getPrzedmiotyByKodPrzedmiotu() {
        return przedmiotyByKodPrzedmiotu;
    }

    public void setPrzedmiotyByKodPrzedmiotu(PrzedmiotyEntity przedmiotyByKodPrzedmiotu) {
        this.przedmiotyByKodPrzedmiotu = przedmiotyByKodPrzedmiotu;
    }
}
