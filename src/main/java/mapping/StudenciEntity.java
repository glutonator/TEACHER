package mapping;

import javax.persistence.*;

@Entity
@Table(name = "STUDENCI", schema = "BD2A20", catalog = "")
public class StudenciEntity {
    private int idStudenta;
    private String nrAlbumu;
    private String nazwisko;
    private String imie;

    @Id
    @Column(name = "ID_STUDENTA", nullable = false, precision = 0)
    public int getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    @Basic
    @Column(name = "NR_ALBUMU", nullable = false, length = 10)
    public String getNrAlbumu() {
        return nrAlbumu;
    }

    public void setNrAlbumu(String nrAlbumu) {
        this.nrAlbumu = nrAlbumu;
    }

    @Basic
    @Column(name = "NAZWISKO", nullable = false, length = 30)
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "IMIE", nullable = false, length = 20)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudenciEntity that = (StudenciEntity) o;

        if (idStudenta != that.idStudenta) return false;
        if (nrAlbumu != null ? !nrAlbumu.equals(that.nrAlbumu) : that.nrAlbumu != null) return false;
        if (nazwisko != null ? !nazwisko.equals(that.nazwisko) : that.nazwisko != null) return false;
        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudenta;
        result = 31 * result + (nrAlbumu != null ? nrAlbumu.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        return result;
    }
}
