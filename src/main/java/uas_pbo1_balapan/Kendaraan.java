package uas_pbo1_balapan;


public abstract class Kendaraan {

    // ===== Atribut (private -> encapsulation) =====
    private String merek;
    private String model;
    private double topSpeed; // km/jam
    private int tahunProduksi;

    // ===== Constructor =====
    public Kendaraan(String merek, String model, double topSpeed, int tahunProduksi) {
        this.merek = merek;
        this.model = model;
        this.topSpeed = topSpeed;
        this.tahunProduksi = tahunProduksi;
    }

    // ===== Accessor (getter) =====
    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    // ===== Mutator (setter) dengan validasi sederhana (Error Handling) =====
    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTopSpeed(double topSpeed) {
        if (topSpeed <= 0) {
            throw new IllegalArgumentException("Top speed harus lebih besar dari 0");
        }
        this.topSpeed = topSpeed;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    /**
     * Method abstrak yang wajib di-override oleh setiap subclass
     * dengan rumus masing-masing -> Polymorphism.
     * @param jarakKm jarak lintasan dalam kilometer
     * @return estimasi waktu tempuh dalam jam
     */
    public abstract double hitungWaktuTempuh(double jarakKm);

    /**
     * Method info dasar, boleh dipanggil / di-override subclass.
     */
    public String info() {
        return "Merek       : " + merek + "\n" +
               "Model       : " + model + "\n" +
               "Top Speed   : " + topSpeed + " km/jam\n" +
               "Tahun       : " + tahunProduksi;
    }
}
