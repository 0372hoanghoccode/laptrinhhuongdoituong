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
        while (!checkid(khachhang.getMa()))
        {
            System.out.print("Trùng mã, vui lòng nhập lại mã :");
            khachhang.setMa(new Scanner(System.in).nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=khachhang;
    }
    public void Xoa()
    {
        if(ds.length==0){
            System.out.println("Danh sách trống.");
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
                khachhang.Sua();
                System.out.println("Sửa thành công.");
                return;
            }
        }
        System.out.println("Mã khách hàng khng tồn tại");
    }
    void   Sua(int ma)
    {
        for (Khachhang khachhang : ds)
        {
            if(khachhang.getMa()==ma)
            {
                khachhang.Sua();
                return;
            }
        }
    }
   public void Timkiem()
    {
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
            if(khachhang.getHo().equals(ten))
            {
                x++;
            }
        }
        System.out.println("Có "+x+ " người tên "+ten);
    }
    public void Themtofile(Khachhang khachhang)
    {

    }
    public void Xoatofile(int id)
    {

    }
    public void Suatofile(Khachhang khachhang,int id)
    {

    }

}
