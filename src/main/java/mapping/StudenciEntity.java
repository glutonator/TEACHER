package mapping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "STUDENCI", schema = "BD2A20", catalog = "")
public class StudenciEntity {
    private int idStudenta;
    private String nrAlbumu;
    private String nazwisko;
    private String imie;
    private Collection<OcenyKoncoweEntity> ocenyKoncowesByIdStudenta;

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
        return idStudenta == that.idStudenta &&
                Objects.equals(nrAlbumu, that.nrAlbumu) &&
                Objects.equals(nazwisko, that.nazwisko) &&
                Objects.equals(imie, that.imie);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idStudenta, nrAlbumu, nazwisko, imie);
    }

    @OneToMany(mappedBy = "studenciByIdStudenta")
    public Collection<OcenyKoncoweEntity> getOcenyKoncowesByIdStudenta() {
        return ocenyKoncowesByIdStudenta;
    }

    public void setOcenyKoncowesByIdStudenta(Collection<OcenyKoncoweEntity> ocenyKoncowesByIdStudenta) {
        this.ocenyKoncowesByIdStudenta = ocenyKoncowesByIdStudenta;
    }
}
