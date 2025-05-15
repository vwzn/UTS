public class Buku {
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