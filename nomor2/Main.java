import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    Product menu = new Product();
    Penjualan penjualan1 = new Penjualan();
    Penjualan penjualan2 = new Penjualan();
    Penjualan penjualan3 = new Penjualan();

    menu.tambahMenuMakanan("Batagor", 5000, 10);
    menu.tambahMenuMakanan("Roti Bakar", 12000, 10);
    menu.tambahMenuMakanan("Indomie", 10000, 10);
    menu.tambahMenuMakanan("Kwetiaw", 12000, 10);
    menu.tambahMenuMakanan("Nasi Goreng", 12000, 10);
    menu.tambahMenuMakanan("Air Mineral", 3000, 10);
    menu.tambahMenuMakanan("Teh Manis", 4000, 10);
    menu.tambahMenuMakanan("Jus Alpukat", 8000, 10);
    menu.tambahMenuMakanan("Teh Botol", 5000, 10);
    menu.tambahMenuMakanan("Kopi", 3000, 10);

    penjualan1.restaurantMenu(menu, penjualan1);
    penjualan2.restaurantMenu(menu, penjualan2);
    penjualan3.restaurantMenu(menu, penjualan3);
    
  }
}
