public class BukuNonFiksi extends Buku {
    private String subjek;
    private String isbn;

    public BukuNonFiksi(String judul, String penulis, int tahunTerbit, String kode, String subjek, String isbn) {
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
