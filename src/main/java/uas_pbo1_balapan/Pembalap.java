package uas_pbo1_balapan;


public class Pembalap {

    // ===== Atribut (private -> encapsulation) =====
    private String nama;
    private int nomorMobil;
    private String negara;
    private int poin;

    // ===== Constructor =====
    public Pembalap(String nama, int nomorMobil, String negara) {
        this.nama = nama;
        this.nomorMobil = nomorMobil;
        this.negara = negara;
        this.poin = 0; // poin awal selalu 0
    }

    // ===== Accessor =====
    public String getNama() {
        return nama;
    }

    public int getNomorMobil() {
        return nomorMobil;
    }

    public String getNegara() {
        return negara;
    }

    public int getPoin() {
        return poin;
    }

    // ===== Mutator =====
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNomorMobil(int nomorMobil) {
        this.nomorMobil = nomorMobil;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    /**
     * Menambah poin hasil balapan.
     * Melempar exception bawaan Java jika poin yang ditambahkan negatif -> Error Handling.
     */
    public void tambahPoin(int poinBaru) {
        if (poinBaru < 0) {
            throw new IllegalArgumentException("Poin yang ditambahkan tidak boleh negatif: " + poinBaru);
        }
        this.poin += poinBaru;
    }

    public String info() {
        return "Nama Pembalap : " + nama + "\n" +
               "No. Mobil     : " + nomorMobil + "\n" +
               "Negara        : " + negara + "\n" +
               "Total Poin    : " + poin;
    }
}
