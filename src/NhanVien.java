import java.util.Scanner;

public class NhanVien  implements doituong{
    private int maNhanVien;
    private String hoNhanVien;
    private String tenNhanVien;
    private float luong;

    public NhanVien(){
        maNhanVien = 0;
        hoNhanVien = "";
        tenNhanVien = "";
        luong = 0.0F;
    }
    public NhanVien(int maNhanVien, String hoNhanVien, String tenNhanVien, float luong){
        this.maNhanVien = maNhanVien;
        this.hoNhanVien = hoNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.luong = luong;
    }
    public int getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getHoNhanVien() {
        return hoNhanVien;
    }

    public void setHoNhanVien(String hoNhanVien) {
        this.hoNhanVien = hoNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhập mã nhân viên: ");
            maNhanVien = sc.nextInt();
            if (maNhanVien <= 0) {
                System.out.println("Mã nhân viên không hợp lệ.");
            }
        } while (maNhanVien <= 0);
        sc.nextLine();
        System.out.print("Nhập họ nhân viên: ");
        hoNhanVien = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        tenNhanVien = sc.nextLine();
        System.out.print("Nhập lương nhân viên: ");
        luong = sc.nextFloat();
    }
    public void Xuat(){
        System.out.println("------------------------------");
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ nhân viên: " + hoNhanVien);
        System.out.println("Tên nhân viên: " + tenNhanVien);
        System.out.println("Lương nhân viên: " + luong);
    }
    public void Sua()
    {

    }
}