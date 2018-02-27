package mapping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PRZEDMIOTY", schema = "BD2A20", catalog = "")
public class PrzedmiotyEntity {
    private String kodPrzedmiotu;
    private String nazwa;
    private String opis;
    private Collection<RealizacjeEntity> realizacjesByKodPrzedmiotu;
    private Collection<TypyOcenEntity> typyOcensByKodPrzedmiotu;

    @Id
    @Column(name = "KOD_PRZEDMIOTU", nullable = false, length = 3)
    public String getKodPrzedmiotu() {
        return kodPrzedmiotu;
    }

    public void setKodPrzedmiotu(String kodPrzedmiotu) {
        this.kodPrzedmiotu = kodPrzedmiotu;
    }

    @Basic
    @Column(name = "NAZWA", nullable = false, length = 30)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "OPIS", nullable = true, length = 200)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrzedmiotyEntity that = (PrzedmiotyEntity) o;
        return Objects.equals(kodPrzedmiotu, that.kodPrzedmiotu) &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(opis, that.opis);
    }

    @Override
    public int hashCode() {

        return Objects.hash(kodPrzedmiotu, nazwa, opis);
    }

    @OneToMany(mappedBy = "przedmiotyByKodPrzedmiotu")
    public Collection<RealizacjeEntity> getRealizacjesByKodPrzedmiotu() {
        return realizacjesByKodPrzedmiotu;
    }

    public void setRealizacjesByKodPrzedmiotu(Collection<RealizacjeEntity> realizacjesByKodPrzedmiotu) {
        this.realizacjesByKodPrzedmiotu = realizacjesByKodPrzedmiotu;
    }

    @OneToMany(mappedBy = "przedmiotyByKodPrzedmiotu")
    public Collection<TypyOcenEntity> getTypyOcensByKodPrzedmiotu() {
        return typyOcensByKodPrzedmiotu;
    }

    public void setTypyOcensByKodPrzedmiotu(Collection<TypyOcenEntity> typyOcensByKodPrzedmiotu) {
        this.typyOcensByKodPrzedmiotu = typyOcensByKodPrzedmiotu;
    }

    @Override
    public String toString() {
        return getKodPrzedmiotu();
    }
}
