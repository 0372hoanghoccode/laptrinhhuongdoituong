import java.util.Arrays;
import java.util.Scanner;

public class DsHang {
    private Hang[] ds;
    public DsHang()
    {
        ds=new Hang[0];
    }
    public DsHang(Hang[] ds) {
        this.ds = ds;
    }

    public Hang[] getDs() {
        return ds;
    }

    public void setDs(Hang[] ds) {
        this.ds = ds;
    }

    public void Them()
    {
        Hang hang=new Hang();
        hang.Nhap();
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
        System.out.println("Them Thanh Cong");
    }
    public void Them(Hang hang)
    {
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
        System.out.println("Them Thanh Cong");

    }
    public void Xoa()
    {
        System.out.println("Nhap Ma");
        int x=new Scanner(System.in).nextInt();
        for (int i=0; i<ds.length;i++) {
            if(ds[i].getMa()==x)
            {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xoa Thanh Cong");
                return;
            }
        }
        System.out.println("Khong Tim Thay");
    }
    public void Xoa(int x)
    {
        for (int i=0; i<ds.length;i++) {
            if (ds[i].getMa() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Xoa thanh cong");
                return ;
            }
        }
        System.out.println("Xoa that bai");
    }
    public void Sua()
    {
        System.out.println("Nhap Ma Can Sua :");
        int ma=new Scanner(System.in).nextInt();
        for (Hang hang : ds)
        {
            if(hang.getMa()==ma)
            {
                hang.Sua();
                System.out.println("Sua Thanh Cong");
                return;
            }
        }
        System.out.println("Khong Tim Thay .");
    }
    void   Sua(int ma)
    {
        for (Hang hang : ds)
        {
            if(hang.getMa()==ma)
            {
                hang.Sua();
                System.out.println("Sua Thanh Cong");
                return;
            }
        }
        System.out.println("Khong Tim Thay .");
    }
    public void Timkiem()
    {
        System.out.println("Nhap Ma");
        int ma=new Scanner(System.in).nextInt();
        for (Hang hang :ds)
        {
            if(hang.getMa()==ma)
            {
                hang.Xuat();
                return;
            }
        }
        System.out.println("Khong Tim Thay");
    }
    public Hang Timkiem(int ma)
    {
        for (Hang hang :ds)
        {
            if(hang.getMa()==ma)
            {
                return hang;
            }
        }
        return null;
    }
    public void Xem()
    {
        for (int i=0;i<ds.length;i++)
        {
            System.out.println("-----"+(i+1)+"-----");
            ds[i].Xuat();
        }
    }
    public void Thongke()
    {
        System.out.println("Co "+ds.length+" khach hang");
    }

    public String Thongkeds()
    {
        String dscachang="";
        for (Hang hang :ds)
        {
          dscachang+=  hang.getTenhang()+"/";
        }
        return  dscachang;
    }



}
