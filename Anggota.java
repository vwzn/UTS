public class Anggota {
    private String id;
    private String nama;
    private String alamat;
    private String membership;
    private Buku[] bukuDipinjam;
    private int jumlahBukuDipinjam;
    private static final int MAX_PINJAM = 5;

    public Anggota(String id, String nama, String alamat, String membership) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.membership = membership;
        this.bukuDipinjam = new Buku[MAX_PINJAM];
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
            bukuDipinjam[jumlahBukuDipinjam++] = buku;
            buku.setTersedia(false);
            return true;
        }
        return false;
    }

    public boolean kembalikanBuku(Buku buku) {
        for (int i = 0; i < jumlahBukuDipinjam; i++) {
            if (bukuDipinjam[i].equals(buku)) {
                // Shift array to remove the book
                for (int j = i; j < jumlahBukuDipinjam - 1; j++) {
                    bukuDipinjam[j] = bukuDipinjam[j + 1];
                }
                jumlahBukuDipinjam--;
                buku.setTersedia(true);
                return true;
            }
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
            System.out.println("- " + bukuDipinjam[i].getJudul());
        }
    }
}
