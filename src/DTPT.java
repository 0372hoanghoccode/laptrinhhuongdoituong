import java.util.Scanner;

public class DTPT extends Dienthoai implements doituong{
    private String banPhim;

    public DTPT() {
        super();
    }
    public DTPT(String banPhim)
    {
        super();
        this.banPhim=banPhim;

    }

    public DTPT(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc, String banPhim) {
        super(maSanPham, soLuong, donGia, maHang, ten, kichThuoc);
        this.banPhim = banPhim;
    }

    public DTPT(Dienthoai dienthoai,String banPhim )
    {
        super(dienthoai);
        this.banPhim=banPhim;
    }

    public String getBanPhim() {
        return banPhim;
    }

    public void setBanPhim(String banPhim) {
        this.banPhim = banPhim;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhap loai ban phim: ");
        banPhim = scanner.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Loai ban phim: " + banPhim);
    }
    public void Sua()
    {

    }
    public void Goi(){
        System.out.println( " Dang Goi thuong............ " );
    }
}
