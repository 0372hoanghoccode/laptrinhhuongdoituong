import java.util.Scanner;

public class ChiTietHoaDon implements doituong {
    private int maChiTietHoaDon;
    private int maHoaDon;
    private int maSanPham;
    private int soLuongMua;
    private float donGia;
    private float thanhTien;
    Scanner sc = new Scanner(System.in);
    public ChiTietHoaDon(){

    }
    public ChiTietHoaDon(int maChiTietHoaDon,int maHoaDon, int maSanPham, int soLuongMua, float donGia, float thanhTien){
        this.maChiTietHoaDon=maChiTietHoaDon;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public int getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(int maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void Nhap(){
        System.out.print("Nhập mã chi tiết hóa đơn: ");
        maSanPham = sc.nextInt();
        System.out.print("Nhập mã hóa đơn: ");
        soLuongMua = sc.nextInt();
        System.out.print("Nhập mã sản phẩm: ");
        maSanPham = sc.nextInt();
        System.out.print("Nhập số lượng mua: ");
        soLuongMua = sc.nextInt();
        System.out.print("Nhập đơn giá: ");
        donGia = sc.nextFloat();
        System.out.print("Nhập thành tiền: ");
        thanhTien = sc.nextFloat();
    }
    public void Xuat(){
        System.out.println("Mã hóa đơn: " + getMaHoaDon());
        System.out.println("Mã sản phẩm: " + maSanPham);
        System.out.println("Số lượng mua " + soLuongMua);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Thành tiền: " + thanhTien);
    }
    public void Sua()
    {
        String x="";
        System.out.print("Nhập mã hóa đơn (enter để lấy dữ liệu cũ): ");
        x = sc.nextLine();
        if(x.isEmpty()){maHoaDon=Integer.parseInt(x);x="";}
        System.out.print("Nhập mã sản phẩm (enter để lấy dữ liệu cũ): ");
        x = sc.nextLine();
        if(x.isEmpty()){maSanPham=Integer.parseInt(x);x="";}
        System.out.print("Nhập số lượng mua (enter để lấy dữ liệu cũ): ");
        x = sc.nextLine();
        if(x.isEmpty()){soLuongMua=Integer.parseInt(x);x="";}
        System.out.print("Nhập đơn giá (enter để lấy dữ liệu cũ): ");
        x = sc.nextLine();
        if(x.isEmpty()){donGia=Float.parseFloat(x);x="";}
        System.out.print("Nhập thành tiền (enter để lấy dữ liệu cũ): ");
        x = sc.nextLine();
        if(x.isEmpty()){thanhTien=Float.parseFloat(x);x="";}

    }
}
