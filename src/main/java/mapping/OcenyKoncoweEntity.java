package mapping;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "OCENY_KONCOWE", schema = "BD2A20", catalog = "")
@IdClass(OcenyKoncoweEntityPK.class)
public class OcenyKoncoweEntity {
    private int idStudenta;
    private String kodPrzedmiotu;
    private long rok;
    private String rodzajSemestru;
    private double ocenaKoncowa;
    private Time dataICzasAktualizacji;
    private Collection<OcenyEntity> ocenies;
    private StudenciEntity studenciByIdStudenta;
    private RealizacjeEntity realizacje;

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
    public double getOcenaKoncowa() {
        return ocenaKoncowa;
    }

    public void setOcenaKoncowa(double ocenaKoncowa) {
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
        return idStudenta == that.idStudenta &&
                rok == that.rok &&
                ocenaKoncowa == that.ocenaKoncowa &&
                Objects.equals(kodPrzedmiotu, that.kodPrzedmiotu) &&
                Objects.equals(rodzajSemestru, that.rodzajSemestru) &&
                Objects.equals(dataICzasAktualizacji, that.dataICzasAktualizacji);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idStudenta, kodPrzedmiotu, rok, rodzajSemestru, ocenaKoncowa, dataICzasAktualizacji);
    }

    @OneToMany(mappedBy = "ocenyKoncowe")
    public Collection<OcenyEntity> getOcenies() {
        return ocenies;
    }

    public void setOcenies(Collection<OcenyEntity> ocenies) {
        this.ocenies = ocenies;
    }

    @ManyToOne
    @JoinColumn(name = "ID_STUDENTA", referencedColumnName = "ID_STUDENTA", nullable = false)
    public StudenciEntity getStudenciByIdStudenta() {
        return studenciByIdStudenta;
    }

    public void setStudenciByIdStudenta(StudenciEntity studenciByIdStudenta) {
        this.studenciByIdStudenta = studenciByIdStudenta;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "KOD_PRZEDMIOTU", referencedColumnName = "KOD_PRZEDMIOTU", nullable = false), @JoinColumn(name = "ROK", referencedColumnName = "ROK", nullable = false), @JoinColumn(name = "RODZAJ_SEMESTRU", referencedColumnName = "RODZAJ_SEMESTRU", nullable = false)})
    public RealizacjeEntity getRealizacje() {
        return realizacje;
    }

    public void setRealizacje(RealizacjeEntity realizacje) {
        this.realizacje = realizacje;
    }
}
