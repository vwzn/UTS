import java.time.LocalDate;

public class Peminjaman {
    private String idAnggota;
    private String kodeBuku;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private boolean sudahDikembalikan;

    public Peminjaman(String idAnggota, String kodeBuku, LocalDate tanggalPinjam, LocalDate tanggalKembali) {
        this.idAnggota = idAnggota;
        this.kodeBuku = kodeBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.sudahDikembalikan = false;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public boolean isSudahDikembalikan() {
        return sudahDikembalikan;
    }

    public void setSudahDikembalikan(boolean sudahDikembalikan) {
        this.sudahDikembalikan = sudahDikembalikan;
    }
}
