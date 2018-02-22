package mapping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TYPY_OCEN", schema = "BD2A20", catalog = "")
public class TypyOcenEntity {
    private short idTypuOceny;
    private String kodPrzedmiotu;
    private String temat;
    private long waga;
    private Collection<OcenyEntity> oceniesByIdTypuOceny;
    private PrzedmiotyEntity przedmiotyByKodPrzedmiotu;

    @Id
    @Column(name = "ID_TYPU_OCENY", nullable = false, precision = 0)
    public short getIdTypuOceny() {
        return idTypuOceny;
    }

    public void setIdTypuOceny(short idTypuOceny) {
        this.idTypuOceny = idTypuOceny;
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
    @Column(name = "TEMAT", nullable = false, length = 20)
    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    @Basic
    @Column(name = "WAGA", nullable = false, precision = 0)
    public long getWaga() {
        return waga;
    }

    public void setWaga(long waga) {
        this.waga = waga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypyOcenEntity that = (TypyOcenEntity) o;
        return idTypuOceny == that.idTypuOceny &&
                waga == that.waga &&
                Objects.equals(kodPrzedmiotu, that.kodPrzedmiotu) &&
                Objects.equals(temat, that.temat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTypuOceny, kodPrzedmiotu, temat, waga);
    }

    @OneToMany(mappedBy = "typyOcenByIdTypuOceny")
    public Collection<OcenyEntity> getOceniesByIdTypuOceny() {
        return oceniesByIdTypuOceny;
    }

    public void setOceniesByIdTypuOceny(Collection<OcenyEntity> oceniesByIdTypuOceny) {
        this.oceniesByIdTypuOceny = oceniesByIdTypuOceny;
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
