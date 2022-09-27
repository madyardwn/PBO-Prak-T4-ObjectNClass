import java.util.Scanner;

// extends dari class Product
public class Penjualan extends Product {
  // Deklarasi variabel
  private int hargaTotal;

  private int jumlah;

  private int[] jumlahPesanan = new int[20];
  private String[] pesananMakanan = new String[20];


  // Method untuk memesan makanan
  void pesanMakanan(Product menu, Penjualan penjualan) {
    while (true) {
      clearScreen();
      menu.tampilkanMenuMakanan();
      resume(penjualan, menu);

      System.out.print("\nMasukkan nama makanan : ");
      String namaMakanan = new Scanner(System.in).nextLine().toLowerCase();

      if (menu.isExist(namaMakanan)) {
        System.out.print("Masukkan jumlah makanan : ");
        jumlah = new Scanner(System.in).nextInt();

        jumlahPesanan[menu.getId(namaMakanan)] += jumlah;

        if (menu.getStok(namaMakanan) >= jumlah) {
          this.hargaTotal += menu.getHarga(namaMakanan) * jumlah;

          menu.kurangiStok(namaMakanan, jumlah);

          pesananMakanan[menu.getId(namaMakanan)] =
              menu.uppercaseFirst(namaMakanan) + " [" +
              jumlahPesanan[menu.getId(namaMakanan)] + "]";
        } else {
          System.out.println("Stok tidak cukup");
          pause();
        }
      } else {
        System.out.println("Menu tidak ada");
        pause();
        continue;
      }

      clearScreen();
      menu.tampilkanMenuMakanan();
      resume(penjualan, menu);

      System.out.println("\n1. Pesan lagi");
      System.out.println("2. Selesai");

      System.out.print("Pilih Menu : ");
      int pilih2 = new Scanner(System.in).nextInt();

      if (pilih2 == 2) {
        clearScreen();
        resume(penjualan, menu);

        pause();
        break;
      }
    }
  }

  // Method untuk menampilkan resume pesanan
  void resume(Penjualan penjualan, Product menu) {
    System.out.println("\n[Resume]");
    for (int i = 0; i < pesananMakanan.length; i++) {
      if (pesananMakanan[i] != null) {
        System.out.println(
            pesananMakanan[i] + " x " + menu.getHarga(menu.getNamaMakanan(i)) +
            "      \t= " + menu.getHarga(menu.getNamaMakanan(i)) * jumlahPesanan[i]);
      }
    }
    System.out.println("Total harga   \t\t\t= " + penjualan.hargaTotal);
  }

  // Method untuk menambahkan menu makanan
  void tambahMenuMakanan(Product menu, Penjualan penjualan) {

    clearScreen();

    menu.tampilkanMenuMakanan();

    System.out.print("Masukkan nama makanan : ");
    String namaMakanan = new Scanner(System.in).nextLine().toLowerCase();

    if (menu.isExist(namaMakanan)) {
      System.out.println("Menu sudah ada");
      pause();
      return;
    }
    System.out.print("Masukkan harga makanan : ");
    int harga = new Scanner(System.in).nextInt();

    System.out.print("Masukkan stok makanan : ");
    int stok = new Scanner(System.in).nextInt();

    menu.tambahMenuMakanan(namaMakanan, harga, stok);
  }

  // Method untuk menambahkan stok makanan
  void tambahStokMakanan(Product menu, Penjualan penjualan) {

    clearScreen();

    menu.tampilkanMenuMakanan();

    System.out.print("Masukkan nama makanan : ");
    String namaMakanan = new Scanner(System.in).nextLine().toLowerCase();

    if (!menu.isExist(namaMakanan)) {
      System.out.println("Menu tidak ada");
      pause();
      return;
    }
    System.out.print("Masukkan stok makanan : ");
    int stok = new Scanner(System.in).nextInt();

    menu.tambahStok(namaMakanan, stok);
  }

  // Method untuk tampilan awal
  void restaurantMenu(Product menu, Penjualan penjualan) {
    while (true) {
      clearScreen();

      menu.tampilkanMenuMakanan();

      System.out.println();
      System.out.println("1. Tambahkan Menu Makanan");
      System.out.println("2. Pesan Makanan");
      System.out.println("3. Tambah Stok Makanan");
      System.out.println("4. Keluar");
      System.out.print("Pilih Menu : ");

      int pilih = new Scanner(System.in).nextInt();
      System.out.println();

      if (pilih == 1) {
        tambahMenuMakanan(menu, penjualan);
      } else if (pilih == 2) {
        pesanMakanan(menu, penjualan);
        return;
      } else if (pilih == 3) {
        tambahStokMakanan(menu, penjualan);
      } else if (pilih == 4) {
        System.out.println("Terima Kasih");
        break;
      } else {
        System.out.println("Menu tidak tersedia");
      }
    }
  }

  // Pause
  public static void pause() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter untuk melanjutkan ... ");
    s.nextLine();
  }

  // Clear screen
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
