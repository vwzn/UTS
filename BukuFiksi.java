public class BukuFiksi extends Buku {
    private String genre;
    private int jumlahHalaman;

    public BukuFiksi(String judul, String penulis, int tahunTerbit, String kode, String genre, int jumlahHalaman) {
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
