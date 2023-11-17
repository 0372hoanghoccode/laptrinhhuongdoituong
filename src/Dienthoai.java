
import java.util.Scanner;
abstract class Dienthoai {
    private int maSanPham;
    private int soLuong;
    private float donGia;
    private int maHang;
    private String ten;
    private String kichThuoc;

    // Sử dụng Scanner làm biến static để tránh tạo nhiều đối tượng Scanner
    protected static Scanner scanner = new Scanner(System.in);

    public Dienthoai() {

    }

    public Dienthoai(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc) {
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maHang = maHang;
        this.ten = ten;
        this.kichThuoc = kichThuoc;
    }
    public Dienthoai(Dienthoai dienthoai)
    {
        this.maSanPham = dienthoai.maSanPham;
        this.soLuong = dienthoai.soLuong;
        this.donGia = dienthoai.donGia;
        this.maHang = dienthoai.maHang;
        this.ten = dienthoai.ten;
        this.kichThuoc = dienthoai.kichThuoc;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public int getMaHang() {
        return maHang;
    }

    public String getTen() {
        return ten;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public void Nhap() {
        System.out.println("Nhap ma san pham: ");
        maSanPham = scanner.nextInt();
        System.out.println("Nhap so luong: ");
        soLuong = scanner.nextInt();
        System.out.println("Nhap don gia: ");
        donGia = scanner.nextFloat();
        System.out.println("Nhap ma hang: ");
        maHang = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap ten: ");
        ten = scanner.nextLine();
        System.out.println("Nhap kich thuoc: ");
        kichThuoc = scanner.nextLine();
    }

    public void Xuat() {
        System.out.printf("Ma san pham: %d\nSo luong: %d\nDon gia: %.2f\nMa hang: %d\nTen: %s\nKich thuoc: %s\n",
                maSanPham, soLuong, donGia, maHang, ten, kichThuoc);


    }
    public void Sua(){

    }
    abstract void Goi();
}
