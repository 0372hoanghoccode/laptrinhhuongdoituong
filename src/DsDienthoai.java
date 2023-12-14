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
        Dienthoai dienthoai;
        switch (loai) {
            case 1:
                dienthoai = new DTPT();
                dienthoai.Nhap();
                break;
            case 2:
                dienthoai = new Smartphone();
                dienthoai.Nhap();
                break;
            default:
                System.out.println("Không hợp lệ.");
                return;
        }
        while (!checkid(dienthoai.getMaSanPham()))
        {
            System.out.print("Trùng mã sản phẩm , vui lòng nhập lại :");
            dienthoai.setMaSanPham(scanner.nextInt());
        }
        ds = Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=dienthoai;
        Themtofile(dienthoai);
        System.out.println("Thêm thành công.");
    }

    public void Them(Dienthoai dienthoai) {
        if(!checkid(dienthoai.getMaSanPham()))
        {
            return;
        }
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dienthoai;
        Themtofile(dienthoai);
    }
    public void Them(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc,String banphim)
    {
        if(!checkid(maSanPham))
        {
            return;
        }
        Dienthoai dienthoai=new DTPT(maSanPham,soLuong,donGia,maHang,ten,kichThuoc,banphim);
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dienthoai;
        Themtofile(dienthoai);
    }
    public void Them(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc,String hedieuhanh,int ram,String chip)
    {
        if(!checkid(maSanPham))
        {
            return;
        }
        Dienthoai dienthoai=new Smartphone(maSanPham,soLuong,donGia,maHang,ten,kichThuoc,hedieuhanh,ram,chip);
        ds = new Dienthoai[ds.length + 1];
        ds[ds.length-1]=dienthoai;

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
                Xoatofile(x);
                System.out.println("Xóa thành công.");
                return;
            }
        }
        System.out.println("Mã sản phẩm không còn lại.");
    }
    public void Xoa(int ma) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == ma) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                Xoatofile(ma);
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
        System.out.print("Nhập mã sản phẩm cần sửa :");
        int maSanPham = scanner.nextInt();
       for (Dienthoai dt:ds)
       {
           if(dt.getMaSanPham()==maSanPham)
           {
               String x = "";
               System.out.println("Nhập tên (enter để lấy dữ liệu cũ): ");
               x = scanner.nextLine();
               if (!x.isEmpty()) {dt.setTen( x);x = "";}
               System.out.println("Nhập kích thước (enter để lấy dữ liệu cũ): ");
               x = scanner.nextLine();
               if (!x.isEmpty()) {dt.setKichThuoc(x);x = "";}
               System.out.print("Nhập số lượng (enter để lấy dữ liệu cũ) :");
               x = scanner.nextLine();
               if (!x.isEmpty()) {dt.setSoLuong( Integer.parseInt(x));x="";}
               System.out.print("Nhập đơn giá (enter để lấy dữ liệu cũ) :");
               x = scanner.nextLine();
               if (!x.isEmpty()) {dt.setDonGia( Float.parseFloat(x));x="";}
               System.out.print("Nhập  mã hãng (enter để lấy dữ liệu cũ) :");
               x = scanner.nextLine();
               if (!x.isEmpty()) {dt.setMaHang( Integer.parseInt(x));x="";}
               if(dt instanceof DTPT){
                   System.out.print("Nhập bàn phím (enter để lấy dữ liệu cũ) :");
                   x = scanner.nextLine();
                  if(!x.isEmpty()){((DTPT) dt).setBanPhim(x);x="";}
                  Suatofile(dt,maSanPham);
                  System.out.println("Sửa thành công.");return;
               }else if(dt instanceof Smartphone)
               {
                   System.out.print("Nhập hệ điều hành (enter để lấy dữ liệu cũ) :");
                   x = scanner.nextLine();
                   if(!x.isEmpty()){
                       ((Smartphone) dt).setHeDieuHanh(x);x="";
                   }
                   System.out.print("Nhập dung lương RAM (Gb) (enter để lấy dữ liệu cũ) :");
                   x = scanner.nextLine();
                   if(!x.isEmpty()){
                       ((Smartphone) dt).setRam(Integer.parseInt(x));x="";
                   }
                   System.out.print("Nhập chip (enter để lấy dữ liệu cũ) :");
                   x = scanner.nextLine();
                   if(!x.isEmpty()){
                       ((Smartphone) dt).setChip(x);x="";
                   }
                   Suatofile(dt,maSanPham);
                   System.out.println("Sửa thành công."); return;
               }


           }

       }


    }

    public void Sua(int maSanPham,Dienthoai dt) {

        for (Dienthoai dienthoai:ds)
        {
            if(dienthoai.getMaSanPham()==maSanPham)
            {
                dienthoai=dt;
                Suatofile(dt,maSanPham);
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



    public void XemDs() {
        for (int i=0;i< ds.length;i++) {
            System.out.println(".......Vị trí thứ "+(i+1)+"......");
            if (ds[i] instanceof Smartphone) {
                System.out.println("SMARTPHONE : ");
                ds[i].Xuat();
            }
            if (ds[i] instanceof DTPT) {
                System.out.println("DTPT : ");
                ds[i].Xuat();
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
        System.out.print("Nhập mã sản phẩm :");
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
                   newdata+=ma+","+ String.valueOf(0)+","+ds[i].getSoLuong()+","+ ds[i].getDonGia()+","+ ds[i].getMaHang()+","+ds[i].getTen()+","+ds[i].getKichThuoc()+","+((DTPT) ds[i]).getBanPhim();

               }else {
                   newdata+= String.valueOf(ma)+","+String.valueOf(1)+","+ds[i].getSoLuong()+","+ ds[i].getDonGia()+","+ ds[i].getMaHang()+","+ds[i].getTen()+","+ds[i].getKichThuoc()+","+((Smartphone)ds[i]).getHeDieuHanh()+","+((Smartphone)ds[i]).getRam()+","+((Smartphone)ds[i]).getChip();
               }

              file.UpdateRow(newdata,"dsdienthoai.txt",ds[i].getMaSanPham());
               return;
           }

        }
    }
    public void Goi()
    {
        System.out.print("Vui lòng nhập mã sản phẩm :");
        int ma=scanner.nextInt();
        for (Dienthoai dienthoai :ds)
        {
            if(dienthoai.getMaSanPham()==ma)
            {
                dienthoai.Goi();
                return;
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
    public void Themtofile(Dienthoai dienthoai)
    {
        String data="";
        File file=new File();
        if(dienthoai instanceof DTPT)
        {
            DTPT dtpt=(DTPT) dienthoai;
           data=dienthoai.getMaSanPham()+","+0+","+dienthoai.getSoLuong()+","+dienthoai.getDonGia()+","+dienthoai.getMaHang()+","+dienthoai.getTen()+","+
                   dienthoai.getKichThuoc()+","+dtpt.getBanPhim();
        }
        else
        {
            Smartphone smartphone=(Smartphone) dienthoai;
            data=dienthoai.getMaSanPham()+","+0+","+dienthoai.getSoLuong()+","+dienthoai.getDonGia()+","+dienthoai.getMaHang()+","+dienthoai.getTen()+","+
                    dienthoai.getKichThuoc()+","+smartphone.getHeDieuHanh()+","+smartphone.getRam()+","+smartphone.getChip();
        }
       file.WriteNewLine(data,"dsdienthoai.txt");
    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dsdienthoai.txt",id);
    }
    public void Suatofile(Dienthoai dienthoai,int id)
    {
        String data="";
        File file=new File();
        if(dienthoai instanceof DTPT)
        {
            DTPT dtpt=(DTPT) dienthoai;
            data=dienthoai.getMaSanPham()+","+0+","+dienthoai.getSoLuong()+","+dienthoai.getDonGia()+","+dienthoai.getMaHang()+","+dienthoai.getTen()+","+
                    dienthoai.getKichThuoc()+","+dtpt.getBanPhim();
        }
        else
        {
            Smartphone smartphone=(Smartphone) dienthoai;
            data=dienthoai.getMaSanPham()+","+0+","+dienthoai.getSoLuong()+","+dienthoai.getDonGia()+","+dienthoai.getMaHang()+","+dienthoai.getTen()+","+
                    dienthoai.getKichThuoc()+","+smartphone.getHeDieuHanh()+","+smartphone.getRam()+","+smartphone.getChip();
        }
        file.UpdateRow(data,"dsdienthoai.txt",id);
    }

}