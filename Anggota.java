import java.time.LocalDate;
import java.util.HashMap;
import java.time.temporal.ChronoUnit;

public class Anggota {
    private String id;
    private String nama;
    private String alamat;
    private String membership;

    private Buku[] bukuArrayDipinjam;
    private int jumlahBukuDipinjam;
    private static final int MAX_PINJAM = 5;

    private HashMap<Buku, LocalDate> dataPinjam = new HashMap<>();
    private static final int BATAS_HARI_PINJAM = 7;
    private static final int DENDA_PER_HARI = 1000;

    public Anggota(String id, String nama, String alamat, String membership) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.membership = membership;
        this.bukuArrayDipinjam = new Buku[MAX_PINJAM];
        this.jumlahBukuDipinjam = 0;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public boolean pinjamBuku(Buku buku) {
        if (jumlahBukuDipinjam < MAX_PINJAM && buku.isTersedia()) {
            bukuArrayDipinjam[jumlahBukuDipinjam++] = buku;
            dataPinjam.put(buku, LocalDate.now());
            buku.setTersedia(false);
            return true;
        }
        return false;
    }

    public boolean kembalikanBuku(Buku buku, LocalDate tanggalKembali) {
        if (dataPinjam.containsKey(buku)) {
            LocalDate tanggalPinjam = dataPinjam.get(buku);
            long selisihHari = ChronoUnit.DAYS.between(tanggalPinjam, tanggalKembali);

            if (selisihHari > BATAS_HARI_PINJAM) {
                long denda = (selisihHari - BATAS_HARI_PINJAM) * DENDA_PER_HARI;
                System.out.println("Terlambat " + (selisihHari - BATAS_HARI_PINJAM) + " hari. Denda: Rp" + denda);
            } else {
                System.out.println("Buku dikembalikan tepat waktu.");
            }

            // Hapus dari daftar pinjam
            dataPinjam.remove(buku);

            // Update array peminjaman
            for (int i = 0; i < jumlahBukuDipinjam; i++) {
                if (bukuArrayDipinjam[i] == buku) {
                    for (int j = i; j < jumlahBukuDipinjam - 1; j++) {
                        bukuArrayDipinjam[j] = bukuArrayDipinjam[j + 1];
                    }
                    bukuArrayDipinjam[jumlahBukuDipinjam - 1] = null;
                    jumlahBukuDipinjam--;
                    break;
                }
            }

            buku.setTersedia(true);
            return true;
        }
        return false;
    }

    public void tampilkanInfo() {
        System.out.println("ID Anggota: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Membership: " + membership);
        System.out.println("Buku yang dipinjam:");
        for (int i = 0; i < jumlahBukuDipinjam; i++) {
            System.out.println("- " + bukuArrayDipinjam[i].getJudul());
        }
    }
}
