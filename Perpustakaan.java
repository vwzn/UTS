import java.time.LocalDate;

public class Perpustakaan {

    private Buku[] daftarBuku;
    private Anggota[] daftarAnggota;
    private int jumlahBuku;
    private int jumlahAnggota;
    public static final int MAX_BUKU = 100;
    public static final int MAX_ANGGOTA = 50;

    // Add these getter methods
    public int getJumlahBuku() {
        return jumlahBuku;
    }

    public int getJumlahAnggota() {
        return jumlahAnggota;
    }

    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }

    public Anggota[] getDaftarAnggota() {
        return daftarAnggota;
    }

    public Perpustakaan() {
        this.daftarBuku = new Buku[MAX_BUKU];
        this.daftarAnggota = new Anggota[MAX_ANGGOTA];
        this.jumlahBuku = 0;
        this.jumlahAnggota = 0;
    }

    public boolean tambahBuku(Buku buku) {
        if (jumlahBuku < MAX_BUKU) {
            daftarBuku[jumlahBuku++] = buku;
            return true;
        }
        return false;
    }

    public boolean tambahAnggota(Anggota anggota) {
        if (jumlahAnggota < MAX_ANGGOTA) {
            daftarAnggota[jumlahAnggota++] = anggota;
            return true;
        }
        return false;
    }

    public Buku cariBukuByJudul(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    public Buku cariBukuByKode(String kode) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getKode().equalsIgnoreCase(kode)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    public Anggota cariAnggotaById(String id) {
        for (int i = 0; i < jumlahAnggota; i++) {
            if (daftarAnggota[i].getId().equalsIgnoreCase(id)) {
                return daftarAnggota[i];
            }
        }
        return null;
    }

    public boolean pinjamBuku(String idAnggota, String kodeBuku, LocalDate tanggalPinjam) {
        Anggota anggota = cariAnggotaById(idAnggota);
        Buku buku = cariBukuByKode(kodeBuku);

        if (anggota != null && buku != null) {
            return anggota.pinjamBuku(buku);
        }
        return false;
    }

    public boolean kembalikanBuku(String idAnggota, String kodeBuku, LocalDate tanggalKembali) {
        Anggota anggota = cariAnggotaById(idAnggota);
        Buku buku = cariBukuByKode(kodeBuku);

        if (anggota != null && buku != null) {
            return anggota.kembalikanBuku(buku, tanggalKembali);
        }
        return false;
    }

    public void tampilkanSemuaBuku() {
        for (int i = 0; i < jumlahBuku; i++) {
            daftarBuku[i].tampilkanInfo();
            System.out.println("-------------------");
        }
    }

    public void tampilkanSemuaAnggota() {
        for (int i = 0; i < jumlahAnggota; i++) {
            daftarAnggota[i].tampilkanInfo();
            System.out.println("-------------------");
        }
    }

    public boolean hapusAnggotaById(String id) {
        for (int i = 0; i < jumlahAnggota; i++) {
            if (daftarAnggota[i].getId().equalsIgnoreCase(id)) {
                // Geser semua elemen setelahnya ke kiri
                for (int j = i; j < jumlahAnggota - 1; j++) {
                    daftarAnggota[j] = daftarAnggota[j + 1];
                }
                daftarAnggota[--jumlahAnggota] = null; // Kurangi jumlah dan kosongkan slot terakhir
                return true;
            }
        }
        return false;
    }

}