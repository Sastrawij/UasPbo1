package uas_pbo1_balapan;


public class MobilF1 extends Kendaraan {

    // ===== Atribut tambahan (private -> encapsulation) =====
    private String timF1;
    private int levelDownforce; // skala 1 - 10, makin tinggi makin stabil di tikungan tapi mengurangi top speed efektif

    // ===== Constructor =====
    public MobilF1(String merek, String model, double topSpeed, int tahunProduksi,
                    String timF1, int levelDownforce) {
        super(merek, model, topSpeed, tahunProduksi); // memanggil constructor superclass
        this.timF1 = timF1;
        setLevelDownforce(levelDownforce);
    }

    // ===== Accessor =====
    public String getTimF1() {
        return timF1;
    }

    public int getLevelDownforce() {
        return levelDownforce;
    }

    // ===== Mutator dengan validasi (Error Handling) =====
    public void setTimF1(String timF1) {
        this.timF1 = timF1;
    }

    public void setLevelDownforce(int levelDownforce) {
        if (levelDownforce < 1 || levelDownforce > 10) {
            throw new IllegalArgumentException("Level downforce harus di antara 1 - 10");
        }
        this.levelDownforce = levelDownforce;
    }

    /**
     * Override method superclass -> Polymorphism.
     * Downforce tinggi mengurangi kecepatan efektif sedikit,
     * tapi di sini disederhanakan hanya sebagai faktor pengali.
     */
    @Override
    public double hitungWaktuTempuh(double jarakKm) {
        double faktorDownforce = 1 - (levelDownforce * 0.01); // makin tinggi downforce, sedikit lebih lambat
        double kecepatanEfektif = getTopSpeed() * faktorDownforce;
        return jarakKm / kecepatanEfektif;
    }

    @Override
    public String info() {
        return super.info() + "\n" +
               "Tim F1      : " + timF1 + "\n" +
               "Downforce   : " + levelDownforce;
    }
}
