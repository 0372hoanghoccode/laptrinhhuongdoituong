import java.util.Arrays;
import java.util.Scanner;

public class DsKhachhang {
   private Khachhang[] ds;
   public DsKhachhang()
   {
       ds=new Khachhang[0];
   }

    public DsKhachhang(Khachhang[] ds) {
        this.ds = ds;
    }

    public Khachhang[] getDs() {
        return ds;
    }

    public void setDs(Khachhang[] ds) {
        this.ds= Arrays.copyOf(this.ds,ds.length);
       this.ds = ds;
    }
    public void Them()
    {
        Khachhang khachhang=new Khachhang();
        khachhang.Nhap();
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=khachhang;
        System.out.println("Them Thanh Cong");
    }
    public void Them(Khachhang khachhang)
    {
        try {
            ds= Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]=khachhang;
            System.out.println("Them thanh cong");
        }catch (Exception e)
        {
            System.out.println("Them that bai");
        }


    }
    public void Them(Khachhang[] khachhang)
    {
        int length=ds.length;
        ds= Arrays.copyOf(ds,(length+khachhang.length));
        for(int j=0,i=length;j<khachhang.length;j++,i++)
        {
            ds[i]=khachhang[j];

        }

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
        for (Khachhang khachhang : ds)
        {
            if(khachhang.getMa()==ma)
            {
                khachhang.Sua();
                System.out.println("Sua Thanh Cong");
                return;
            }
        }
        System.out.println("Khong Tim Thay .");
    }
    void   Sua(int ma)
    {
        for (Khachhang khachhang : ds)
        {
            if(khachhang.getMa()==ma)
            {
                khachhang.Sua();
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
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getMa()==ma)
            {
                khachhang.Xuat();
                return;
            }
        }
        System.out.println("Khong Tim Thay");
    }
    public Khachhang Timkiem(int ma)
    {
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getMa()==ma)
            {
                return khachhang;
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
    public void ThongketheoHo()
    {
        System.out.println("Nhap Ho");
        String ho=new Scanner(System.in).nextLine();
        int x=0;
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getHo().equals(ho))
            {
             x++;
            }
        }
        System.out.println("Co "+x+" nguoi ho "+ho);
    }
    public void ThongketheoHo(String ho)
    {
        int x=0;
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getHo().equals(ho))
            {
                x++;
            }
        }
        System.out.println("Co "+x+" nguoi ho "+ho);
    }
    public void ThongketheoTen()
    {
        System.out.println("Nhap Ten");
        String ten=new Scanner(System.in).nextLine();
        int x=0;
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getHo().equals(ten))
            {
                x++;
            }
        }
        System.out.println("Co "+x+" nguoi ten "+ten);
    }
    public void ThongketheoTen(String ten)
    {
        int x=0;
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getHo().equals(ten))
            {
                x++;
            }
        }
        System.out.println("Co "+x+" nguoi ten "+ten);
    }
}
