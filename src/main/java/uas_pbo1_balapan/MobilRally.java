package uas_pbo1_balapan;


public class MobilRally extends Kendaraan {

    // ===== Atribut tambahan =====
    private String jenisMedan; // "aspal", "tanah", "salju"

    // ===== Constructor =====
    public MobilRally(String merek, String model, double topSpeed, int tahunProduksi,
                       String jenisMedan) {
        super(merek, model, topSpeed, tahunProduksi);
        this.jenisMedan = jenisMedan;
    }

    // ===== Accessor =====
    public String getJenisMedan() {
        return jenisMedan;
    }

    // ===== Mutator =====
    public void setJenisMedan(String jenisMedan) {
        this.jenisMedan = jenisMedan;
    }

    /**
     * Override -> Polymorphism.
     * Setiap jenis medan punya faktor hambatan (friksi) yang berbeda.
     */
    @Override
    public double hitungWaktuTempuh(double jarakKm) {
        double faktorMedan;

        // ===== Seleksi (switch) =====
        switch (jenisMedan.toLowerCase()) {
            case "aspal":
                faktorMedan = 1.0;
                break;
            case "tanah":
                faktorMedan = 0.8;
                break;
            case "salju":
                faktorMedan = 0.6;
                break;
            default:
                faktorMedan = 0.7; // medan tidak dikenal, asumsi sedang
        }

        double kecepatanEfektif = getTopSpeed() * faktorMedan;
        return jarakKm / kecepatanEfektif;
    }

    @Override
    public String info() {
        return super.info() + "\n" +
               "Jenis Medan : " + jenisMedan;
    }
}
