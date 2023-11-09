import java.util.Scanner;

public class Hang  implements doituong{
    private int ma;
    private String tenhang;
    private String diachi;
    public Hang()
    {
        ma=-1;
        tenhang="";
        diachi="";
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
        System.out.println("Nhap ma");
        ma=sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten hang");
        tenhang=sc.nextLine();
        System.out.println("Nhap dia chi");
        diachi=sc.nextLine();

    }
    public  void Xuat()
    {
        System.out.println("Ma : "+ma+" ten hang : "+tenhang+" diachi : "+diachi);
    }
    public void Sua()
    {
        Hang hang= new Hang();
        hang.Nhap();
        if(hang.getMa() != -1)
        {
            ma = hang.getMa();
        }
        if(!hang.getTenhang().isEmpty())
        {
            tenhang = hang.getTenhang();
        }
        if(!hang.getDiachi().isEmpty())
        {
            diachi = hang.getDiachi();
        }

    }

}
