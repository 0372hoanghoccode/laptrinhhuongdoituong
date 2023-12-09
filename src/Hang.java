import java.util.Scanner;

public class Hang  implements doituong{
    private int ma;
    private String tenhang;
    private String diachi;
    public Hang()
    {
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Hang(int ma, String tenhang, String diachi) {
        this.ma = ma;
        this.tenhang = tenhang;
        this.diachi = diachi;
    }
    public  Hang(Hang hang)
    {
        this.ma=hang.ma;
        this.tenhang=hang.tenhang;
        this.diachi=hang.diachi;
    }
    public void Nhap()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập mã hãng :");
        ma=sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên hãng :");
        tenhang=sc.nextLine();
        System.out.print("Nhập địa chỉ :");
        diachi=sc.nextLine();

    }
    public  void Xuat()
    {
        System.out.println("Mã "+ma+" tên "+tenhang+" địa chỉ "+diachi);
    }


}
