import java.text.SimpleDateFormat;
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
        Themtofile(hang);
        System.out.println("Thêm thành công.");
    }
    public void Them(Hang hang)
    {
        if (!checkid(hang.getMa()))
        {
           return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
        Themtofile(hang);
    }
    public void Them(int ma, String tenhang, String diachi)
    {
        Hang hang=new Hang(ma,tenhang,diachi);
        if (!checkid(hang.getMa()))
        {
            return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hang;
        Themtofile(hang);
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
        if(ds.length==0)
        {
            System.out.println("Danh sách hãng trống.");return;
        }
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
                Xoatofile(x);
                System.out.println("Xóa thành công.");
                return;
            }
        }
        System.out.println("Mã hãng không tồn tại.");
    }
    public void Xoa(int x)
    {
        for (int i=0; i<ds.length;i++) {
            if (ds[i].getMa() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                Xoatofile(x);
                return ;
            }
        }
    }
    public void Sua()
    {
        if(ds.length==0)
        {
            System.out.println("Danh sách hãng trống.");
            return;
        }
        System.out.print("Nhập mã cần sửa :");
        int ma=new Scanner(System.in).nextInt();
        for (Hang hang : ds)
        {
            if(hang.getMa()==ma)
            {
                String x="";
                System.out.print("Nhập tên hãng (enter để lấy dữ liệu cũ) :");
                x=new Scanner(System.in).nextLine();
                if(!x.isEmpty()) {hang.setTenhang(x);x="";}
                System.out.print("Nhập địa chỉ hãng (enter để lấy dữ liệu cũ) :");
                x=new Scanner(System.in).nextLine();
                if(!x.isEmpty()) {hang.setDiachi(x);x="";}
                Suatofile(hang,ma);
                System.out.println("Sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy.");
    }
    public void Sua(int ma, Hang h)
    {

        for (Hang hang : ds)
        {
            if(hang.getMa()==ma)
            {
               hang=h;
                Suatofile(h,ma);
                return;
            }
        }
    }
    public void Timkiem()
    {
        if(ds.length==0)
        {
            System.out.println("Danh sách hãng trống.");
            return;
        }
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
        if(ds.length==0){System.out.println("Danh sách hãng trống."); return;}
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
        File file=new File();
        String data=hang.getMa()+","+hang.getTenhang()+","+hang.getDiachi();
        file.WriteNewLine(data,"dshang.txt");
    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dshang.txt",id);
    }
    public void Suatofile(Hang hang,int id)
    {
        File file=new File();
        String data=hang.getMa()+","+hang.getTenhang()+","+hang.getDiachi();
        file.UpdateRow(data,"dshang.txt",id);

    }

}
