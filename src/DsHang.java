import java.util.Arrays;
import java.util.Scanner;

public class DsHang {
   static private Hang[] ds;
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
        while (!checkid(hang.getMa()))
        {
            System.out.print("Trùng mã hãng, vui lòng nhập lại :");
            hang.setMa(new Scanner(System.in).nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
        System.out.println("Thêm thành công.");
    }
    public void Them(Hang hang)
    {
        while (!checkid(hang.getMa()))
        {
            System.out.print("Trùng mã hãng, vui lòng nhập lại :");
            hang.setMa(new Scanner(System.in).nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
    }
    public void Them(int ma, String tenhang, String diachi)
    {
        Hang hang=new Hang(ma,tenhang,diachi);
        while (!checkid(hang.getMa()))
        {
            System.out.print("Trùng mã hãng, vui lòng nhập lại :");
            hang.setMa(new Scanner(System.in).nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
    }
    public boolean checkid(int id)
    {
        for (Hang hang :ds)
        {
            if(hang.getMa()==id)
            {
                return false;
            }
        }
        return true;
    }

    public void Xoa()
    {
        System.out.print("Nhập mã :");
        int x=new Scanner(System.in).nextInt();
        for (int i=0; i<ds.length;i++) {
            if(ds[i].getMa()==x)
            {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Mã hãng khng tồn tại.");
    }
    public void Xoa(int x)
    {
        for (int i=0; i<ds.length;i++) {
            if (ds[i].getMa() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                return ;
            }
        }
    }
    public void Sua()
    {
        System.out.println("Nhập mã cần sửa :");
        int ma=new Scanner(System.in).nextInt();
        for (Hang hang : ds)
        {
            if(hang.getMa()==ma)
            {
                hang.Sua();
                System.out.println("Sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy.");
    }
    void   Sua(int ma)
    {
        for (Hang hang : ds)
        {
            if(hang.getMa()==ma)
            {
                hang.Sua();
                return;
            }
        }
    }
    public void Timkiem()
    {
        System.out.print("Nhập mã :");
        int ma=new Scanner(System.in).nextInt();
        for (Hang hang :ds)
        {
            if(hang.getMa()==ma)
            {
                hang.Xuat();
                return;
            }
        }
        System.out.println("Mã hãng không tồn tại.");
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
    public void XemDs()
    {
        if(ds.length==0){System.out.println("Danh sách trống."); return;}
        for (int i=0;i<ds.length;i++)
        {
            System.out.println("-----Vị trí thứ "+(i+1)+"-----");
            ds[i].Xuat();
        }
    }
    public void Thongke()
    {
        System.out.println("Có "+ds.length+" hãng.");
        Thongkeds();
    }

    public void Thongkeds()
    {
        for (Hang hang :ds)
        {
          System.out.println(hang.getTenhang());
        }
    }

    public void Themtofile(Hang hang)
    {

    }
    public void Xoatofile(int id)
    {

    }
    public void Suatofile(Hang hang,int id)
    {

    }

}
