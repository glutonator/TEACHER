package mapping;

import javax.persistence.*;

@Entity
@Table(name = "PRZEDMIOTY", schema = "BD2A20", catalog = "")
public class PrzedmiotyEntity {
    private String kodPrzedmiotu;
    private String nazwa;
    private String opis;

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

        if (kodPrzedmiotu != null ? !kodPrzedmiotu.equals(that.kodPrzedmiotu) : that.kodPrzedmiotu != null)
            return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (opis != null ? !opis.equals(that.opis) : that.opis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kodPrzedmiotu != null ? kodPrzedmiotu.hashCode() : 0;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (opis != null ? opis.hashCode() : 0);
        return result;
    }
}
