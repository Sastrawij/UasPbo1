# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh aplikasi simulasi balapan menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa jarak lintasan balapan, dan memberikan output berupa estimasi waktu tempuh dari setiap kendaraan (Mobil F1 dan Mobil Rally) beserta status hasil balapan dan poin yang diperoleh masing-masing pembalap.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Kendaraan`, `MobilF1`, `MobilRally`, `Pembalap`, dan `Main` adalah contoh dari class.

```bash
public abstract class Kendaraan {
    ...
}

public class MobilF1 extends Kendaraan {
    ...
}

public class MobilRally extends Kendaraan {
    ...
}

public class Pembalap {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `daftarKendaraan[0] = new MobilF1(...)` adalah contoh pembuatan object.

```bash
daftarKendaraan[0] = new MobilF1("Red Sparrow", "RS-24", 350, 2024, "Falcon Racing", 8);
daftarKendaraan[2] = new MobilRally("Dust Devil", "DD-9", 220, 2022, "tanah");
daftarPembalap[0] = new Pembalap("Rian Saputra", 7, "Indonesia");
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `merek`, `topSpeed`, `levelDownforce`, dan `nama` adalah contoh atribut.

```bash
private String merek;
private double topSpeed;
private int levelDownforce;
private String nama;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Kendaraan`, `MobilF1`, `MobilRally`, dan `Pembalap`.

```bash
public Kendaraan(String merek, String model, double topSpeed, int tahunProduksi) {
    this.merek = merek;
    this.model = model;
    this.topSpeed = topSpeed;
    this.tahunProduksi = tahunProduksi;
}

public MobilF1(String merek, String model, double topSpeed, int tahunProduksi,
                String timF1, int levelDownforce) {
    super(merek, model, topSpeed, tahunProduksi);
    this.timF1 = timF1;
    setLevelDownforce(levelDownforce);
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setTopSpeed` dan `setLevelDownforce` adalah contoh method mutator.

```bash
public void setTopSpeed(double topSpeed) {
    if (topSpeed <= 0) {
        throw new IllegalArgumentException("Top speed harus lebih besar dari 0");
    }
    this.topSpeed = topSpeed;
}

public void setLevelDownforce(int levelDownforce) {
    if (levelDownforce < 1 || levelDownforce > 10) {
        throw new IllegalArgumentException("Level downforce harus di antara 1 - 10");
    }
    this.levelDownforce = levelDownforce;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getMerek`, `getTopSpeed`, `getTimF1`, dan `getNama` adalah contoh method accessor.

```bash
public String getMerek() {
    return merek;
}

public double getTopSpeed() {
    return topSpeed;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di setiap class dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String merek;
private double topSpeed;
private int levelDownforce;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `MobilF1` dan `MobilRally` mewarisi `Kendaraan` dengan sintaks `extends`.

```bash
public class MobilF1 extends Kendaraan {
    ...
}

public class MobilRally extends Kendaraan {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `hitungWaktuTempuh` dan `info` di `MobilF1` dan `MobilRally` merupakan override dari method abstrak/method yang ada di `Kendaraan`, di mana keduanya memiliki nama method yang sama persis namun hasil perhitungan yang berbeda tergantung objeknya.

```bash
// Method abstrak di Kendaraan (kontrak yang wajib dipenuhi subclass)
public abstract double hitungWaktuTempuh(double jarakKm);

// Overriding dengan rumus berbasis downforce - di MobilF1
@Override
public double hitungWaktuTempuh(double jarakKm) {
    double faktorDownforce = 1 - (levelDownforce * 0.01);
    double kecepatanEfektif = getTopSpeed() * faktorDownforce;
    return jarakKm / kecepatanEfektif;
}

// Overriding dengan rumus berbasis jenis medan - di MobilRally
@Override
public double hitungWaktuTempuh(double jarakKm) {
    double faktorMedan;
    switch (jenisMedan.toLowerCase()) {
        case "aspal": faktorMedan = 1.0; break;
        case "tanah": faktorMedan = 0.8; break;
        case "salju": faktorMedan = 0.6; break;
        default: faktorMedan = 0.7;
    }
    double kecepatanEfektif = getTopSpeed() * faktorMedan;
    return jarakKm / kecepatanEfektif;
}

// Pemakaian nyata: baris yang sama, hasil beda tergantung objek k
double waktuTempuh = k.hitungWaktuTempuh(jarakLintasan);
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `main` untuk menentukan status balapan, dan seleksi `switch` dalam method `hitungWaktuTempuh` di `MobilRally`.

```bash
if (waktuTempuh < 1.0) {
    poinDidapat = 25;
} else if (waktuTempuh < 1.5) {
    poinDidapat = 18;
} else {
    poinDidapat = 10;
}

switch (jenisMedan.toLowerCase()) {
    case "aspal":
        faktorMedan = 1.0;
        break;
    case "tanah":
        faktorMedan = 0.8;
        break;
    default:
        faktorMedan = 0.7;
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `while` untuk validasi input, loop `for` untuk memproses setiap kendaraan dan pembalap, serta loop `for-each` untuk menampilkan klasemen akhir.

```bash
while (!inputValid) {
    ...
}

for (int i = 0; i < daftarKendaraan.length; i++) {
    ...
}

for (Pembalap p : daftarPembalap) {
    ...
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan jarak lintasan balapan (km): ");
jarakLintasan = scanner.nextDouble();

System.out.println(k.info());
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `Kendaraan[] daftarKendaraan = new Kendaraan[4];` adalah contoh penggunaan array.

```bash
Kendaraan[] daftarKendaraan = new Kendaraan[4];
Pembalap[] daftarPembalap = new Pembalap[4];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani input yang tidak valid dan poin yang tidak valid.

```bash
try {
    jarakLintasan = scanner.nextDouble();
} catch (InputMismatchException e) {
    System.out.println("Input tidak valid! Harap masukkan angka.");
    scanner.next();
}

try {
    p.tambahPoin(poinDidapat);
} catch (IllegalArgumentException e) {
    System.out.println("Terjadi kesalahan poin: " + e.getMessage());
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Sukma Sastra Wijaya
NPM: 2410010462
