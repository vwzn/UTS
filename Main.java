import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Perpustakaan perpustakaan = new Perpustakaan();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiData();
        menuUtama();
    }

    private static void inisialisasiData() {
        // Add some initial data
        perpustakaan.tambahBuku(new BukuFiksi("Harry Potter", "J.K. Rowling", 1997, "F001", "Fantasi", 400));
        perpustakaan.tambahBuku(
                new BukuNonFiksi("Sapiens", "Noah Harari", 2011, "NF001", "Sejarah", "978-0062316097"));
        perpustakaan.tambahAnggota(new Anggota("A001", "Heryanto", "Jl. Contoh No. 123", "Premium"));
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
            System.out.println("7. Daftar Anggota");
            System.out.println("8. Hapus Anggota");
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
                case 7:
                    perpustakaan.tampilkanSemuaAnggota();
                    break;
                case 8:
                    System.out.println("Masukkan ID Anggota yang ingin dihapus:");
                    String id = scanner.nextLine();
                    if (perpustakaan.hapusAnggotaById(id)) {
                        System.out.println("Anggota berhasil dihapus!");
                    } else {
                        System.out.println("Anggota tidak ditemukan.");
                    }
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

        int jenis = 0;
        while (true) {
            System.out.print("Jenis buku (1. Fiksi / 2. Non-Fiksi): ");
            if (scanner.hasNextInt()) {
                jenis = scanner.nextInt();
                scanner.nextLine(); // Buang newline
                break;
            } else {
                System.out.println("Input harus berupa angka 1 atau 2!");
                scanner.nextLine(); // Buang input salah
            }
        }

        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis: ");
        String penulis = scanner.nextLine();

        int tahun = 0;
        while (true) {
            System.out.print("Tahun Terbit: ");
            if (scanner.hasNextInt()) {
                tahun = scanner.nextInt();
                scanner.nextLine(); // Buang newline
                break;
            } else {
                System.out.println("Input harus berupa angka (tahun)!");
                scanner.nextLine();
            }
        }

        System.out.print("Kode: ");
        String kode = scanner.nextLine();

        if (jenis == 1) {
            System.out.print("Genre: ");
            String genre = scanner.nextLine();

            int halaman = 0;
            while (true) {
                System.out.print("Jumlah Halaman: ");
                if (scanner.hasNextInt()) {
                    halaman = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Input harus berupa angka!");
                    scanner.nextLine();
                }
            }

            BukuFiksi buku = new BukuFiksi(judul, penulis, tahun, kode, genre, halaman);
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

            BukuNonFiksi buku = new BukuNonFiksi(judul, penulis, tahun, kode, subjek, isbn);
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

        if (perpustakaan.cariAnggotaById(id) != null) {
            System.out.println("Id sudah terdaftar, gunakan ID lain!");
            return;
        }
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Membership: ");
        String membership = scanner.nextLine();

        Anggota anggota = new Anggota(id, nama, alamat, membership);
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
        System.out.print("Tanggal Kembali (yyyy-mm-dd): ");
        String tanggalStr = scanner.nextLine();
        LocalDate tanggalKembali = LocalDate.parse(tanggalStr);

        if (perpustakaan.kembalikanBuku(idAnggota, kodeBuku, tanggalKembali)) {
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            System.out.println("Gagal mengembalikan buku.");
        }
    }

}