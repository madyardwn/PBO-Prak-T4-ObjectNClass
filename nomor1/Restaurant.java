public class Restaurant {
  private String[] nama_makanan;
  private int[] harga_makanan;
  private int[] stok;
  private static byte id = 1;

  public Restaurant(){
    nama_makanan = new String[20];
    harga_makanan = new int[20];
    stok = new int[20];
  }

  String uppercaseFirst(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  boolean isExist(String nama) {
    for (int i = 0; i < nama_makanan.length; i++) {
      if (nama_makanan[i] != null && nama_makanan[i].equals(nama)) {
        return true;
      }
    }
    return false;
  }

  public void tambahkanMenuMakanan(String nama, int harga, int stok){
    this.nama_makanan[id] = nama.toLowerCase();
    this.harga_makanan[id] = harga;
    this.stok[id] = stok;
    nextId();
  }

  public void tampilkanMenuMakanan(){
    for (int i = 0; i <= id; i++) {
      if (!isOutOfStock(i)) {
        System.out.println(i +". "+ uppercaseFirst(nama_makanan[i]) + "\t [" + stok[i]+"]"+" \tRp. "+ harga_makanan[i]); 
      }
    }
  }
 
  public void pesanMakanan(String nama_makanan, int jmlPesanan){
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.toLowerCase().equals(this.nama_makanan[i])) {
        if (jmlPesanan > stok[i]) {
          System.out.println("stok tidak mencukupi");
        }else{
          stok[i] -= jmlPesanan;
          System.out.println("Pemesanan "+ jmlPesanan + " " + uppercaseFirst(nama_makanan) + " Berhasil,\n" + "sisa stok " + stok[i] + " "+ uppercaseFirst(nama_makanan));
          System.out.println();
        }
      }
    }
  }

  public void tambahStok(String nama_makanan, int jmlPenambahan){
    for (int i = 0; i <= id; i++) {
      if (nama_makanan.toLowerCase().equals(this.nama_makanan[i])) {
        stok[i] += jmlPenambahan;
        System.out.println("Penambahan stok " + jmlPenambahan + " " + uppercaseFirst(nama_makanan) + " Berhasil,\n" + "sisa stok " + stok[i] + " "+ uppercaseFirst(nama_makanan));
        System.out.println();
      }
    }
  }

  public boolean isOutOfStock(int id){
    if (stok[id] == 0) {
      return true;
    }else{
      return false;
    }
  }

  public static void nextId(){
    id++;
  }
}
