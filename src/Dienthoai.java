
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
        System.out.println("Nhập mã sản phẩm: ");
        maSanPham = scanner.nextInt();
        System.out.println("Nhập số lượng: ");
        soLuong = scanner.nextInt();
        System.out.println("Nhập đơn giá: ");
        donGia = scanner.nextFloat();
        System.out.println("Nhập mã hãng: ");
        maHang = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        ten = scanner.nextLine();
        System.out.println("Nhập kích thước: ");
        kichThuoc = scanner.nextLine();
    }

    public void Xuat() {
        System.out.println("Mã sản phẩm :" +maSanPham);
        System.out.println("Tên sản phẩm :" +ten);
        System.out.println("Số lượng:" +soLuong);
        System.out.println("Đơn giá :" +donGia);
        System.out.println("Mã hãng :" +maHang);
        System.out.println("Kích thước :" +kichThuoc);
    }
    public void Sua(){
        String x = "";
        System.out.println("Nhập mã sản phẩm (enter để lấy dữ liệu cũ): ");
        x = scanner.nextLine();
        if (!x.isEmpty()) {maSanPham = Integer.parseInt(x);x = "";}

        System.out.println("Nhập tên (enter để lấy dữ liệu cũ): ");
        x = scanner.nextLine();
        if (!x.isEmpty()) {ten = x;x = "";}

        System.out.println("Nhập kích thước (enter để lấy dữ liệu cũ): ");
        x = scanner.nextLine();
        if (!x.isEmpty()) {
            kichThuoc = x;
            x = "";
        }

        System.out.println("Nhập số lượng (enter để lấy dữ liệu cũ): ");
        x = scanner.nextLine();
        if (!x.isEmpty()) {
            soLuong = Integer.parseInt(x);
        }

        System.out.println("Nhập đơn giá (enter để lấy dữ liệu cũ): ");
        x = scanner.nextLine();
        if (!x.isEmpty()) {
            donGia = Float.parseFloat(x);
        }

        System.out.println("Nhập  mã hãng (enter để lấy dữ liệu cũ): ");
        x = scanner.nextLine();
        if (!x.isEmpty()) {
            maHang = Integer.parseInt(x);
        }

    }
    abstract void Goi();
}
