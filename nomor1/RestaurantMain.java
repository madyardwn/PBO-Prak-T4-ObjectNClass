import java.util.Scanner;

public class RestaurantMain {
  public static void pause() {
    Scanner s = new Scanner(System.in);
    System.out.print("Press any key to continue...");
    s.nextLine();
  }

  public static void main(String[] args) {
    Restaurant menu = new Restaurant();

    menu.tambahkanMenuMakanan("Batagor", 5000, 10);
    menu.tambahkanMenuMakanan("Roti Bakar", 12000, 10);
    menu.tambahkanMenuMakanan("Indomie", 10000, 10);
    menu.tambahkanMenuMakanan("Kwetiaw", 12000, 10);
    menu.tambahkanMenuMakanan("NasiGoreng", 12000, 10);
    menu.tambahkanMenuMakanan("AirMineral", 3000, 10);
    menu.tambahkanMenuMakanan("Teh Manis", 4000, 10);
    menu.tambahkanMenuMakanan("Jus Alpukat", 8000, 10);
    menu.tambahkanMenuMakanan("Teh Botol", 5000, 10);
    menu.tambahkanMenuMakanan("Kopi", 3000, 10);

    while (true) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Menu Makanan");
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
        System.out.print("Masukkan nama makanan : ");
        String nama = new Scanner(System.in).nextLine();

        if (menu.isExist(nama.toLowerCase())) {
          System.out.println("Menu sudah ada");
          pause();
          continue;
        }
        System.out.print("Masukkan harga makanan : ");
        int harga = new Scanner(System.in).nextInt();

        System.out.print("Masukkan stok makanan : ");
        int stok = new Scanner(System.in).nextInt();

        menu.tambahkanMenuMakanan(nama, harga, stok);
      } else

          if (pilih == 2) {
        System.out.print("Masukkan nama makanan : ");
        String nama = new Scanner(System.in).nextLine();

        if (!menu.isExist(nama.toLowerCase())) {
          System.out.println("Menu tidak ada");
          pause();
          continue;
        }
        System.out.print("Masukkan jumlah pesanan : ");
        int jmlPesanan = new Scanner(System.in).nextInt();
        menu.pesanMakanan(nama, jmlPesanan);
        pause();
      } else

          if (pilih == 3) {
        System.out.print("Masukkan nama makanan : ");
        String nama = new Scanner(System.in).nextLine();

        if (!menu.isExist(nama.toLowerCase())) {
          System.out.println("Menu tidak ada");
          pause();
          continue;
        }

        System.out.print("Masukkan jumlah penambahan : ");
        int jmlPenambahan = new Scanner(System.in).nextInt();

        menu.tambahStok(nama, jmlPenambahan);

        pause();
      } else

          if (pilih == 4) {
        System.out.println("Terima Kasih");
        break;
      } else {
        System.out.println("Menu tidak tersedia");
      }
    }
  }
}
