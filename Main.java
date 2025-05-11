import java.util.Scanner;

// Book class
class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String kode;
    private boolean tersedia;

    public Buku(String judul, String penulis, int tahunTerbit, String kode) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.kode = kode;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Kode: " + kode);
        System.out.println("Status: " + (tersedia ? "Tersedia" : "Dipinjam"));
    }
}

// Fiction Book class
class BukuFlick extends Buku {
    private String genre;
    private int jumlahHalaman;

    public BukuFlick(String judul, String penulis, int tahunTerbit, String kode, String genre, int jumlahHalaman) {
        super(judul, penulis, tahunTerbit, kode);
        this.genre = genre;
        this.jumlahHalaman = jumlahHalaman;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Genre: " + genre);
        System.out.println("Jumlah Halaman: " + jumlahHalaman);
    }
}

// Non-Fiction Book class
class BukuWenFlick extends Buku {
    private String subjek;
    private String isbn;

    public BukuWenFlick(String judul, String penulis, int tahunTerbit, String kode, String subjek, String isbn) {
        super(judul, penulis, tahunTerbit, kode);
        this.subjek = subjek;
        this.isbn = isbn;
    }

    public String getSubjek() {
        return subjek;
    }

    public void setSubjek(String subjek) {
        this.subjek = subjek;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Subjek: " + subjek);
        System.out.println("ISBN: " + isbn);
    }
}

// Member class
class Anggets {
    private String id;
    private String nama;
    private String alamat;
    private String membership;
    private Buku[] bukuDipinjam;
    private int jumlahBukuDipinjam;
    private static final int MAX_PINJAM = 5;

    public Anggets(String id, String nama, String alamat, String membership) {
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

// Library class
class Perpastakaan {
    private Buku[] daftarBuku;
    private Anggets[] daftarAnggota;
    private int jumlahBuku;
    private int jumlahAnggota;
    private static final int MAX_BUKU = 100;
    private static final int MAX_ANGGOTA = 50;

    public Perpastakaan() {
        this.daftarBuku = new Buku[MAX_BUKU];
        this.daftarAnggota = new Anggets[MAX_ANGGOTA];
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

    public boolean tambahAnggota(Anggets anggota) {
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

    public Anggets cariAnggotaById(String id) {
        for (int i = 0; i < jumlahAnggota; i++) {
            if (daftarAnggota[i].getId().equalsIgnoreCase(id)) {
                return daftarAnggota[i];
            }
        }
        return null;
    }

    public boolean pinjamBuku(String idAnggota, String kodeBuku) {
        Anggets anggota = cariAnggotaById(idAnggota);
        Buku buku = cariBukuByKode(kodeBuku);
        
        if (anggota != null && buku != null) {
            return anggota.pinjamBuku(buku);
        }
        return false;
    }

    public boolean kembalikanBuku(String idAnggota, String kodeBuku) {
        Anggets anggota = cariAnggotaById(idAnggota);
        Buku buku = cariBukuByKode(kodeBuku);
        
        if (anggota != null && buku != null) {
            return anggota.kembalikanBuku(buku);
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
}

// Main class
public class Main {
    private static Perpastakaan perpustakaan = new Perpastakaan();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiData();
        menuUtama();
    }

    private static void inisialisasiData() {
        // Add some initial data
        perpustakaan.tambahBuku(new BukuFlick("Harry Potter", "J.K. Rowling", 1997, "F001", "Fantasi", 400));
        perpustakaan.tambahBuku(new BukuWenFlick("Sapiens", "Yuval Noah Harari", 2011, "NF001", "Sejarah", "978-0062316097"));
        perpustakaan.tambahAnggota(new Anggets("A001", "John Doe", "Jl. Contoh No. 123", "Premium"));
    }

    private static void menuUtama() {
        while (true) {
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Cari Buku");
            System.out.println("4. Daftar Buku");
            System.out.println("5. Pinjam Buku");
            System.out.println("6. Kembalikan Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (pilihan) {
                case 1:
                    menuTambahBuku();
                    break;
                case 2:
                    menuTambahAnggota();
                    break;
                case 3:
                    menuCariBuku();
                    break;
                case 4:
                    perpustakaan.tampilkanSemuaBuku();
                    break;
                case 5:
                    menuPinjamBuku();
                    break;
                case 6:
                    menuKembalikanBuku();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void menuTambahBuku() {
        System.out.println("\n=== Tambah Buku ===");
        System.out.print("Jenis buku (1. Fiksi / 2. Non-Fiksi): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Tahun Terbit: ");
        int tahun = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kode: ");
        String kode = scanner.nextLine();
        
        if (jenis == 1) {
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Jumlah Halaman: ");
            int halaman = scanner.nextInt();
            scanner.nextLine();
            
            BukuFlick buku = new BukuFlick(judul, penulis, tahun, kode, genre, halaman);
            if (perpustakaan.tambahBuku(buku)) {
                System.out.println("Buku fiksi berhasil ditambahkan!");
            } else {
                System.out.println("Gagal menambahkan buku. Kapasitas penuh.");
            }
        } else if (jenis == 2) {
            System.out.print("Subjek: ");
            String subjek = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            
            BukuWenFlick buku = new BukuWenFlick(judul, penulis, tahun, kode, subjek, isbn);
            if (perpustakaan.tambahBuku(buku)) {
                System.out.println("Buku non-fiksi berhasil ditambahkan!");
            } else {
                System.out.println("Gagal menambahkan buku. Kapasitas penuh.");
            }
        } else {
            System.out.println("Jenis buku tidak valid!");
        }
    }

    private static void menuTambahAnggota() {
        System.out.println("\n=== Tambah Anggota ===");
        System.out.print("ID Anggota: ");
        String id = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Membership: ");
        String membership = scanner.nextLine();
        
        Anggets anggota = new Anggets(id, nama, alamat, membership);
        if (perpustakaan.tambahAnggota(anggota)) {
            System.out.println("Anggota berhasil ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan anggota. Kapasitas penuh.");
        }
    }

    private static void menuCariBuku() {
        System.out.println("\n=== Cari Buku ===");
        System.out.print("Cari berdasarkan (1. Judul / 2. Kode): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        if (pilihan == 1) {
            System.out.print("Masukkan judul buku: ");
            String judul = scanner.nextLine();
            Buku buku = perpustakaan.cariBukuByJudul(judul);
            if (buku != null) {
                buku.tampilkanInfo();
            } else {
                System.out.println("Buku tidak ditemukan!");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan kode buku: ");
            String kode = scanner.nextLine();
            Buku buku = perpustakaan.cariBukuByKode(kode);
            if (buku != null) {
                buku.tampilkanInfo();
            } else {
                System.out.println("Buku tidak ditemukan!");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    private static void menuPinjamBuku() {
        System.out.println("\n=== Pinjam Buku ===");
        System.out.print("ID Anggota: ");
        String idAnggota = scanner.nextLine();
        System.out.print("Kode Buku: ");
        String kodeBuku = scanner.nextLine();
        
        if (perpustakaan.pinjamBuku(idAnggota, kodeBuku)) {
            System.out.println("Buku berhasil dipinjam!");
        } else {
            System.out.println("Gagal meminjam buku. Anggota atau buku tidak ditemukan, atau buku tidak tersedia.");
        }
    }

    private static void menuKembalikanBuku() {
        System.out.println("\n=== Kembalikan Buku ===");
        System.out.print("ID Anggota: ");
        String idAnggota = scanner.nextLine();
        System.out.print("Kode Buku: ");
        String kodeBuku = scanner.nextLine();
        
        if (perpustakaan.kembalikanBuku(idAnggota, kodeBuku)) {
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            System.out.println("Gagal mengembalikan buku. Anggota atau buku tidak ditemukan, atau buku tidak dipinjam oleh anggota tersebut.");
        }
    }
}