import java.util.Scanner;

public class Khachhang implements doituong{
    private int ma;
   private String ho;
   private String ten;
    private String diachi;
   private String sdt;
public Khachhang()
{

}
    public Khachhang(int ma, String ho, String ten, String diachi, String sdt) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    public Khachhang (Khachhang kh)
    {
        this.ma=kh.ma;
        this.ho=kh.ho;
        this.ten=kh.ten;
        this.diachi= kh.diachi;
        this.sdt=kh.sdt;

    }


    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void Nhap()
    {
        System.out.print("Nhập mã khách hàng :");
        ma=new Scanner(System.in).nextInt();
        System.out.print("Nhập họ :");
        ho=new Scanner(System.in).nextLine();
        System.out.print("Nhập tên :");
        ten=new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ :");
        diachi=new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại :");
        sdt=new Scanner(System.in).nextLine();
    }
    public void Xuat()
    {
        System.out.println("------------------------------");
        System.out.println("Khách hàng có mã :"+ma+" \nhọ :"+ho+"\ntên :"+ten+"\nđịa chỉ :"+diachi+ "\nsdt :"+sdt);
    }

}
