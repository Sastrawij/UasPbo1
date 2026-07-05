package uas_pbo1_balapan;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("   SISTEM SIMULASI BALAPAN - F1 & RALLY EDITION");
        System.out.println("=================================================\n");

        // ===== ARRAY of Kendaraan (Object) - menampung objek beda subclass -> Polymorphism =====
        Kendaraan[] daftarKendaraan = new Kendaraan[4];
        daftarKendaraan[0] = new MobilF1("Red Sparrow", "RS-24", 350, 2024, "Falcon Racing", 8);
        daftarKendaraan[1] = new MobilF1("Blue Comet", "BC-23", 340, 2023, "Nova Motorsport", 5);
        daftarKendaraan[2] = new MobilRally("Dust Devil", "DD-9", 220, 2022, "tanah");
        daftarKendaraan[3] = new MobilRally("Ice Breaker", "IB-3", 200, 2021, "salju");

        // ===== ARRAY of Pembalap (Object) =====
        Pembalap[] daftarPembalap = new Pembalap[4];
        daftarPembalap[0] = new Pembalap("Rian Saputra", 7, "Indonesia");
        daftarPembalap[1] = new Pembalap("Marco Bellini", 21, "Italia");
        daftarPembalap[2] = new Pembalap("Aksel Berg", 55, "Norwegia");
        daftarPembalap[3] = new Pembalap("Yuki Nakamura", 3, "Jepang");

        // ===== IO Sederhana + Error Handling (input jarak lintasan) =====
        double jarakLintasan = 0;
        boolean inputValid = false;

        while (!inputValid) { // ===== Perulangan (while) =====
            try {
                System.out.print("Masukkan jarak lintasan balapan (km): ");
                jarakLintasan = scanner.nextDouble();

                if (jarakLintasan <= 0) {
                    // ===== Seleksi (if) =====
                    System.out.println("Jarak harus lebih besar dari 0! Coba lagi.\n");
                    continue;
                }
                inputValid = true;

            } catch (InputMismatchException e) {
                // ===== Error Handling (exception bawaan Java) =====
                System.out.println("Input tidak valid! Harap masukkan angka.\n");
                scanner.next(); // buang input yang salah dari buffer
            }
        }

        System.out.println("\n--- HASIL SIMULASI UNTUK JARAK " + jarakLintasan + " KM ---\n");

        // ===== Perulangan (for) menggabungkan Kendaraan & Pembalap + Polymorphism =====
        for (int i = 0; i < daftarKendaraan.length; i++) {
            Kendaraan k = daftarKendaraan[i];
            Pembalap p = daftarPembalap[i];

            double waktuTempuh = k.hitungWaktuTempuh(jarakLintasan); // method sama, hasil beda -> polymorphism

            System.out.println("Pembalap  : " + p.getNama() + " (" + p.getNegara() + ")");
            System.out.println(k.info());
            System.out.printf("Estimasi Waktu Tempuh : %.2f jam%n", waktuTempuh);

            // ===== Seleksi (if-else) menentukan poin berdasarkan kecepatan waktu tempuh =====
            int poinDidapat;
            if (waktuTempuh < 1.0) {
                poinDidapat = 25;
                System.out.println("Status    : SANGAT CEPAT! Podium utama.");
            } else if (waktuTempuh < 1.5) {
                poinDidapat = 18;
                System.out.println("Status    : Cepat, masuk zona poin.");
            } else {
                poinDidapat = 10;
                System.out.println("Status    : Selesai balapan dengan baik.");
            }

            // ===== Error Handling (exception bawaan Java, dilempar dari method tambahPoin) =====
            try {
                p.tambahPoin(poinDidapat);
            } catch (IllegalArgumentException e) {
                System.out.println("Terjadi kesalahan poin: " + e.getMessage());
            }

            System.out.println("-------------------------------------------------");
        }

        // ===== Perulangan (for-each) menampilkan klasemen akhir =====
        System.out.println("\n=== KLASEMEN AKHIR PEMBALAP ===");
        for (Pembalap p : daftarPembalap) {
            System.out.println(p.info());
            System.out.println("-------------------------------------------------");
        }

        scanner.close();
        System.out.println("\nSimulasi selesai. Terima kasih!");
    }
}
