import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class HoaDon  implements doituong{
    private int maHoaDon;
    private Date ngayLap;
    private int maNhanVien;
    private int maKhachHang;
    private int tongSoluong;
    private float tongTien;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public int getTongSoluong() {
        return tongSoluong;
    }

    public void setTongSoluong(int tongSoluong) {
        this.tongSoluong = tongSoluong;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public HoaDon() {

    }

    public HoaDon(int maHoaDon, Date ngayLap, int maNhanVien, int maKhachHang,int tongSoluong, float tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.tongSoluong=tongSoluong;
        this.tongTien = tongTien;

    }
    public HoaDon(HoaDon hoadon)
    {
        this.maHoaDon = hoadon.maHoaDon;
        this.ngayLap = hoadon.ngayLap;
        this.maNhanVien = hoadon.maNhanVien;
        this.maKhachHang = hoadon.maKhachHang;
        this.tongTien = hoadon.tongTien;
        this.tongSoluong=hoadon.tongSoluong;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }


    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        maHoaDon = sc.nextInt();
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = sc.nextInt();
        System.out.print("Nhập mã khách hàng: ");
        maKhachHang = sc.nextInt();
        System.out.print("Nhập số lương: ");
        tongSoluong = sc.nextInt();
        System.out.print("Nhập tổng tiền: ");
        tongTien = sc.nextFloat();
        sc.nextLine();
        System.out.print("Nhập ngày lập: dd/MM/yyyy  mặc định hôm nay(enter) ");
        String s=sc.nextLine();
        if(s.isEmpty())
        {
            ngayLap=new Date();
        }else
        {
            try {
                ngayLap = dateFormat.parse(s);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void Xuat() {
        System.out.println("-------------------------------");
        System.out.println("Mã hóa đơn: " + maHoaDon);
        System.out.println("Ngày lập hóa đơn: " + dateFormat.format(ngayLap));
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Mã khách hàng : " + maKhachHang);
        System.out.println("Số lượng mua : " + tongSoluong);
        System.out.println("Tổng tiền : " + tongTien);
    }
    public void Sua()
    {
        String s="";
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên (enter để lấy dữ liệu cũ): ");
        s=sc.nextLine();
        if (!s.isEmpty()){this.maNhanVien=Integer.parseInt(s);s="";}
        System.out.print("Nhập mã khách hàng (enter để lấy dữ liệu cũ): ");
        s=sc.nextLine();
        if (!s.isEmpty()){this.maKhachHang=Integer.parseInt(s);s="";}
        System.out.print("Nhập số lương (enter để lấy dữ liệu cũ): ");
        s=sc.nextLine();
        if (!s.isEmpty()){this.tongSoluong=Integer.parseInt(s);s="";}
        System.out.print("Nhập tổng tiền (enter để lấy dữ liệu cũ): ");
        s=sc.nextLine();
        if (!s.isEmpty()){this.tongTien=Integer.parseInt(s);s="";}
        System.out.print("Nhập ngày lập: dd/MM/yyyy  (enter để lấy dữ liệu cũ) ");
        s=sc.nextLine();
        if (!s.isEmpty()){
            try {
                ngayLap = dateFormat.parse(s);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

