public class Product {
  // Deklarasi variable
  private String[] nama_makanan;
  private int[] harga_makanan;
  private int[] stok;
  private static byte id = 1;

  // Constructor
  public Product(){
    nama_makanan = new String[20];
    harga_makanan = new int[20];
    stok = new int[20];
  }

  // Method Product (add menu)
  public void tambahMenuMakanan(String nama, int harga, int stok){
    this.nama_makanan[id] = nama.toLowerCase();
    this.harga_makanan[id] = harga;
    this.stok[id] = stok;
    nextId();
  }

  // Method Product (tampilkan menu)
  public void tampilkanMenuMakanan(){
    System.out.println("[Menu Makanan]");
    for (int i = 0; i <= id; i++) {
      if (!isOutOfStock(i)) {
        System.out.println(i +". "+ uppercaseFirst(nama_makanan[i]) + "\t [" + stok[i]+"]"+" \tRp. "+ harga_makanan[i]); 
      }
    }
  }
 
  // Method Product (kurangi stok)
  public void kurangiStok(String nama_makanan, int jmlPesanan){
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.equals(this.nama_makanan[i])) {
          stok[i] -= jmlPesanan;
      }
    }
  }

  // Method Product (tambah stok)
  public void tambahStok(String nama_makanan, int jmlPenambahan){
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.equals(this.nama_makanan[i])) {
        stok[i] += jmlPenambahan;
        System.out.println("Penambahan stok " + jmlPenambahan + " " + uppercaseFirst(nama_makanan) + " Berhasil,\n" + "sisa stok " + stok[i] + " "+ uppercaseFirst(nama_makanan));
        System.out.println();
      }
    }
  }


  // Method Product (validasi nama makanan)
  boolean isExist(String nama) {
    for (int i = 0; i < nama_makanan.length; i++) {
      if (nama_makanan[i] != null && nama_makanan[i].equals(nama)) {
        return true;
      }
    }
    return false;
  }

  // Method Product (validasi jumlah stok)
  public boolean isOutOfStock(int id){
    if (stok[id] == 0) {
      return true;
    }else{
      return false;
    }
  }

  // Method Product (getter nama makanan by id)
  String getNamaMakanan(int id){
    return nama_makanan[id];
  }

  // Method Product (getter jumlah stok by nama_makanan)
  public int getStok(String nama_makanan) {
    int temp = 0;
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.equals(this.nama_makanan[i])) {
         temp = stok[i];
      }
    }
    return temp;
  }

  // Method Product (getter harga makanan by nama_makanan)
  public int getHarga(String nama_makanan) {
    int temp = 0;
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.equals(this.nama_makanan[i])) {
         temp = harga_makanan[i];
      }
    }
    return temp;
  }

  // Method Product (getter id by nama_makanan)
  byte getId(String nama_makanan) {
    byte temp = 0;
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.equals(this.nama_makanan[i])) {
         temp = (byte) i;
      }
    }
    return temp;
  }

  // Method Product (increment id)
  public static void nextId(){
    id++;
  }

  // Method Product (uppercase setiap penampilan nama makanan)
  String uppercaseFirst(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

}
