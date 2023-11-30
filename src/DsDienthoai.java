import java.util.Arrays;
import java.util.Scanner;

public class DsDienthoai {
   static private Dienthoai[] ds;
    private Scanner scanner = new Scanner(System.in);

    public DsDienthoai() {
        ds = new Dienthoai[0];
    }

    public DsDienthoai(Dienthoai[] dienthoai) {
        ds = dienthoai;
    }

    public void Them() {
        System.out.print("Bạn muốn thêm : ? ");
        System.out.print("1. Điện thoại phổ thông ");
        System.out.println("2. Smartphone");
        int loai = scanner.nextInt();
        Dienthoai dt;
        scanner.nextLine();
        switch (loai) {
            case 1:
                dt = new DTPT();
               dt.Nhap();
                break;
            case 2:
               dt = new Smartphone();
                dt.Nhap();

                break;
            default:
                System.out.print("Không hợp lệ ");
                return;
        }
        while (!checkid(dt.getMaSanPham()))
        {
            System.out.print("Trùng mã sản phẩm , vui lòng nhập lại :");
            dt.setMaSanPham(new Scanner(System.in).nextInt());
        }
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dt;
    }

    public void Them(Dienthoai dt) {
        if(!checkid(dt.getMaSanPham()))
        {
            return;
        }
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dt;
    }
    public void Them(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc,String banphim)
    {
        if(!checkid(maSanPham))
        {
            return;
        }
        Dienthoai dt=new DTPT(maSanPham,soLuong,donGia,maHang,ten,kichThuoc,banphim);
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dt;

    }
    public void Them(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc,String hedieuhanh,int ram,String chip)
    {
        if(!checkid(maSanPham))
        {
            return;
        }
        Dienthoai dt=new Smartphone(maSanPham,soLuong,donGia,maHang,ten,kichThuoc,hedieuhanh,ram,chip);
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dt;

    }
    public boolean checkid(int id)
    {
        for (Dienthoai dt :ds)
        {
          if(  dt.getMaSanPham()==id)
              return false;
        }
        return true;
    }



    public void Xoa() {
        if(ds.length==0)
        {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.print("Nhập mã sản phẩm cần xóa :");
        int x = new Scanner(System.in).nextInt();
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Mã sản phẩm không còn lại.");
    }

    public void Xoa(int x) {
        if(ds.length==0)
        {
            return;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                return;
            }
        }
    }


    public void Sua() {
        if(ds.length==0)
        {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.print("Nhập mã sản phẩm cần sửa: ");
        int maSanPham = scanner.nextInt();
       for (Dienthoai dt:ds)
       {
           if(dt.getMaSanPham()==maSanPham)
           {
               dt.Sua();
           }

       }
            System.out.println("Mã sàn phẩm không tồn tại.");

    }

    public void Sua(int maSanPham) {

        for (Dienthoai dt:ds)
        {
            if(dt.getMaSanPham()==maSanPham)
            {
                dt.Sua();
            }

        }
    }

    public static Dienthoai getDienthoai(int maSanPham) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == maSanPham) {
                return ds[i];
            }
        }
        return null;
    }
    public void XemDs()
    {
        for (int i=0;i<ds.length;i++)
        {
            System.out.println(".......Vị trí thứ "+(i+1)+"......");
            if(ds[i] instanceof DTPT)
            {
                DTPT dtpt=(DTPT) ds[i];
                dtpt.Xuat();
            }else
            {
                Smartphone smartphone=(Smartphone) ds[i];
                smartphone.Xuat();
            }
        }
    }


    public void Thongke() {
        int dtpt = 0;
        int dtsmp = 0;
        for (Dienthoai d : ds) {
            if (d instanceof Smartphone) {
                dtsmp++;
            }
            if (d instanceof DTPT) {
                dtpt++;
            }
        }
        System.out.println("Có : " + ds.length + " điện thoại trong đó có " + dtpt + " điện thoại phổ thông và " + dtsmp + " điện thoại smartphone");
    }



    public void Xuat() {
        for (Dienthoai d : ds) {
            if (d instanceof Smartphone) {
                System.out.print("SMARTPHONE : ");
                d.Xuat();
            }
            if (d instanceof DTPT) {
                System.out.print("DTPT : ");
                d.Xuat();
            }
        }
    }

    public Dienthoai Timkiem(int maSanPham) {
        for (Dienthoai d : ds) {
            if (d.getMaSanPham() == maSanPham) {
                return d;
            }
        }
        return null;
    }

    public void Timkiem() {
        System.out.print("Nhập mã sản phẩm");
        int maSanPham=scanner.nextInt();
        for (Dienthoai d : ds) {
            if (d.getMaSanPham() == maSanPham) {
                d.Xuat();
            }
        }

        System.out.println("Mã sản phẩm không tồn tại.");
    }

    public static void Muahang(int ma,int sl)
    {
        for(int i=0;i<ds.length;i++)
        {
           if( ds[i].getMaSanPham()==ma)
           {
               ds[i].setSoLuong(ds[i].getSoLuong()-sl);
               File file=new File();
               String newdata="";
               if(ds[i] instanceof DTPT){
                   newdata+=String.valueOf(ma)+","+ String.valueOf(0)+","+ds[i].getSoLuong()+","+ ds[i].getDonGia()+","+ ds[i].getMaHang()+","+ds[i].getTen()+","+ds[i].getKichThuoc()+","+((DTPT) ds[i]).getBanPhim();

               }else {
                   newdata+= String.valueOf(ma)+","+String.valueOf(1)+","+ds[i].getSoLuong()+","+ ds[i].getDonGia()+","+ ds[i].getMaHang()+","+ds[i].getTen()+","+ds[i].getKichThuoc()+","+((Smartphone)ds[i]).getHeDieuHanh()+","+((Smartphone)ds[i]).getRam()+","+((Smartphone)ds[i]).getChip();
               }

              file.UpdateRow(newdata,"dsdienthoai",ds[i].getMaSanPham());
               return;
           }

        }
    }
    public  void Themtofile()
    {

    }
    public  void Xoatofile()
    {

    }
    public  void Suatofile()
    {

    }

}