package mapping;

import javax.persistence.*;

@Entity
@Table(name = "TYPY_OCEN", schema = "BD2A20", catalog = "")
public class TypyOcenEntity {
    private short idTypuOceny;
    private String kodPrzedmiotu;
    private String temat;
    private long waga;

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

        if (idTypuOceny != that.idTypuOceny) return false;
        if (waga != that.waga) return false;
        if (kodPrzedmiotu != null ? !kodPrzedmiotu.equals(that.kodPrzedmiotu) : that.kodPrzedmiotu != null)
            return false;
        if (temat != null ? !temat.equals(that.temat) : that.temat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idTypuOceny;
        result = 31 * result + (kodPrzedmiotu != null ? kodPrzedmiotu.hashCode() : 0);
        result = 31 * result + (temat != null ? temat.hashCode() : 0);
        result = 31 * result + (int) (waga ^ (waga >>> 32));
        return result;
    }
}
