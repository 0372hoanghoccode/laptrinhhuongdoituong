import java.util.Scanner;

public class Khachhang implements doituong{
    private int ma;
   private String ho;
   private String ten;
    private String diachi;
   private String sdt;
public Khachhang()
{
    ma=-1;
    ho="";
    ten="";
    diachi="";
    sdt="";

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
        System.out.println("Nhap Ma");
        ma=new Scanner(System.in).nextInt();
        System.out.println("Nhap Ho");
        ho=new Scanner(System.in).nextLine();
        System.out.println("Nhap Ten");
        ten=new Scanner(System.in).nextLine();
        System.out.println("Nhap Dia Chi");
        diachi=new Scanner(System.in).nextLine();
        System.out.println("Nhap Sdt");
        sdt=new Scanner(System.in).nextLine();
    }
    public void Xuat()
    {
        System.out.println("Khach hang co ma :"+ma+" ho : "+ho+" ten : "+ten+" dia chi : "+diachi+ " sdt : "+sdt);
    }
    public void Sua()
    {
      String x="";
        System.out.println("Nhap ho (enter de bo qua) :");
        x=new Scanner(System.in).nextLine();
        if(!x.isEmpty()){ho=x; x="";}
        System.out.println("Nhap Ten");
        x=new Scanner(System.in).nextLine();
        if(!x.isEmpty()){ten=x;x="";}
        System.out.println("Nhap Dia Chi");
        x=new Scanner(System.in).nextLine();
        if(!x.isEmpty()){diachi=x;x="";}
        System.out.println("Nhap Sdt");
        x=new Scanner(System.in).nextLine();
        if(!x.isEmpty()){sdt=x;}
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
