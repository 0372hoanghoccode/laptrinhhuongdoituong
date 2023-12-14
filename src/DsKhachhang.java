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
       this.ds = ds;
    }
    public void Them()
    {
        Khachhang khachhang=new Khachhang();
        khachhang.Nhap();
        while (!checkid(khachhang.getMa()))
        {
            System.out.print("Trùng mã, vui lòng nhập lại mã :");
            khachhang.setMa(new Scanner(System.in).nextInt());

        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=khachhang;
        Themtofile(khachhang);
        System.out.println("Thêm thành công.");
    }
    public boolean checkid(int id)
    {
        for (Khachhang kh : ds)
        {
            if(kh.getMa()==id)
                return false;
        }
        return true;
    }
    public void Them(Khachhang khachhang)
    {
        if (!checkid(khachhang.getMa()))
        {
           return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=khachhang;
        Themtofile(khachhang);
    }
    public void Them(int ma, String ho, String ten, String diachi, String sdt)
    {
        if (!checkid(ma))
        {
            return;
        }
        Khachhang khachhang=new Khachhang(ma,ho,ten,diachi,sdt);
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=khachhang;
        Themtofile(khachhang);
    }
    public void Xoa()
    {
        if(ds.length==0){
            System.out.println("Danh sách khách hàng trống."); return;
        }
        System.out.print("Nhập mã khách hàng cần xóa :");
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
        System.out.println("Mã khách hàng không tồn tại.");
    }
    public void Xoa(int x)
    {
        for (int i=0; i<ds.length;i++) {
            if (ds[i].getMa() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                Xoatofile(x);
                ds = Arrays.copyOf(ds, ds.length - 1);
                return ;
            }
        }
    }
    public void Sua()
    {
        System.out.println("Nhập mã khaách hàng cần sửa :");
        int ma=new Scanner(System.in).nextInt();
        for (Khachhang khachhang : ds)
        {
            if(khachhang.getMa()==ma)
            {

                String x="";
                System.out.print("Nhập họ (enter để lấy giá trị cũ) :");
                x=new Scanner(System.in).nextLine();
                if(!x.isEmpty()){khachhang.setHo(x); x="";}
                System.out.print("Nhập tên (enter để lấy giá trị cũ) :");
                x=new Scanner(System.in).nextLine();
                if(!x.isEmpty()){khachhang.setTen(x);x="";}
                System.out.print("Nhập địa chỉ (enter để lấy giá trị cũ) :");
                x=new Scanner(System.in).nextLine();
                if(!x.isEmpty()){khachhang.setDiachi(x);x="";}
                System.out.print("Nhập số điện thoại (enter để lấy giá trị cũ) :");
                x=new Scanner(System.in).nextLine();
                if(!x.isEmpty()){khachhang.setSdt(x);x="";}

                Suatofile(khachhang,ma);
                System.out.println("Sửa thành công.");
                return;
            }
        }
        System.out.println("Mã khách hàng không tồn tại");
    }
    void   Sua(int ma,Khachhang kh)
    {
        for (Khachhang khachhang : ds)
        {
            if(khachhang.getMa()==ma)
            {
                khachhang=kh;
                Suatofile(kh,ma);
                return;
            }
        }
    }
   public void Timkiem()
    {
        if(ds.length==0)
        {
            System.out.println("Danh sách khách hàng trống.");return;
        }
        System.out.print("Nhập mã khách hàng cần tìm kiếm :");
        int ma=new Scanner(System.in).nextInt();
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getMa()==ma)
            {
                khachhang.Xuat();
                return;
            }
        }
        System.out.println("Mã khách hàng không tồn tại.");
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
    public void XemDs()
    {
        for (int i=0;i<ds.length;i++)
        {
            System.out.println("-----Vị trí thứ "+(i+1)+"-----");
            ds[i].Xuat();
        }
    }
    public void Thongke()
    {
        System.out.println("Có "+ds.length+" khách hàng");
    }
    public void ThongketheoHo()
    {
        System.out.print("Nhập  họ :");
        String ho=new Scanner(System.in).nextLine();
        int x=0;
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getHo().equals(ho))
            {
             x++;
            }
        }
        System.out.println("Có "+x+" người họ "+ho);
    }

    public void ThongketheoTen()
    {
        System.out.print("Nhập tên :");
        String ten=new Scanner(System.in).nextLine();
        int x=0;
        for (Khachhang khachhang :ds)
        {
            if(khachhang.getTen().equals(ten))
            {
                x++;
            }
        }
        System.out.println("Có "+x+ " người tên "+ten);
    }
    public void Themtofile(Khachhang khachhang)
    {
        File file=new File();
        String data=khachhang.getMa()+","+khachhang.getHo()+","+khachhang.getTen()+","+ khachhang.getDiachi()+","+khachhang.getSdt();
        file.WriteNewLine(data,"dskhachhang.txt");

    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dskhachhang.txt",id);
    }
    public void Suatofile(Khachhang khachhang,int id)
    {
        File file=new File();
        String data=khachhang.getMa()+","+khachhang.getHo()+","+khachhang.getTen()+","+ khachhang.getDiachi()+","+khachhang.getSdt();
        file.UpdateRow(data,"dskhachhang.txt",id);


    }

}
