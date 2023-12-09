import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DsChiTietHoaDon {
    private ChiTietHoaDon[] ds;

    Scanner sc = new Scanner(System.in);
    public DsChiTietHoaDon(){
        ds = new ChiTietHoaDon[0];
    }
    public DsChiTietHoaDon(ChiTietHoaDon[] ds)
    {
        this.ds=ds;
    }
    public ChiTietHoaDon[] getDanhSachChiTietHoaDon() {
        return ds;
    }

    public void setDanhSachChiTietHoaDon(ChiTietHoaDon[] ds) {
        this.ds = ds;
    }

    public void Them(){
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
        chiTietHoaDon.Nhap();
        while (!checkid(chiTietHoaDon.getMaChiTietHoaDon()))
        {
            System.out.print("Trùng mã chi tiết hóa đơn, vui lòng nhập lại :");
            chiTietHoaDon.setMaChiTietHoaDon(sc.nextInt());
        }

           ds= Arrays.copyOf(ds,ds.length+1);
           ds[ds.length-1]=chiTietHoaDon;
           Themtofile(chiTietHoaDon);
           System.out.println("Thêm thành công.");
    }
    public void Them( ChiTietHoaDon chiTietHoaDon){
          if(!checkid(chiTietHoaDon.getMaChiTietHoaDon()))
          {
              return;
          }
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=chiTietHoaDon;
        Themtofile(chiTietHoaDon);
    }
    public void Them(int machitiet, int maHoaDon,int maSanPham,int soLuongMua,float donGia,float thanhTien){
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(machitiet,maHoaDon, maSanPham, soLuongMua, donGia, thanhTien);
        if(!checkid(chiTietHoaDon.getMaChiTietHoaDon()))
        {
            return;
        }
       ds=Arrays.copyOf(ds,ds.length+1);
       ds[ds.length-1]=chiTietHoaDon;
        Themtofile(chiTietHoaDon);
    }
    public void Xoa(){
        if(ds.length == 0){
            System.out.println("Chưa có chi tiết hóa đơn.");
            return;
        }
          System.out.print("Nhập mã chi tiết hóa đơn cần xóa :");
        int ma =sc.nextInt();
            for(int i = 0; i < ds.length; i++){
                if(ds[i].getMaHoaDon() ==ma){
                    for(int j=i;j<ds.length-1;j++)
                    {
                        ds[j]=ds[j+1];
                    }
                    ds=Arrays.copyOf(ds,ds.length-1);
                    Xoatofile(ma);
                    System.out.println("Xóa thành công.");
                    return;
                }
            }
                System.out.println("Mã hóa đơn không tồn tại");
    }
    public void Xoa(int ma){
        for(int i = 0; i < ds.length; i++){
            if(ds[i].getMaHoaDon() ==ma){
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                Xoatofile(ma);
                return;
            }
        }
    }
    public void Timkiem(){
        System.out.print("Nhập mã hóa đơn :" );
        int maHoaDon = sc.nextInt();
        for (ChiTietHoaDon d : ds) {
            if (d.getMaHoaDon() == maHoaDon) {
                d.Xuat();
                return;
            }
        }

            System.out.println("Mã chi tiết hóa đơn không tồn tại");

    }
    public ChiTietHoaDon Timkiem(int maHoaDon){
        for (ChiTietHoaDon d : ds) {
            if (d.getMaHoaDon() == maHoaDon) {

                return d;
            }
        }
        return null;
    }

    public boolean checkid(int ma)
    {
        for (ChiTietHoaDon chiTietHoaDon:ds)
        {
            if( chiTietHoaDon.getMaChiTietHoaDon()==ma)
            {
                return false;
            }
        }
        return true;
    }
    public void Sua() {
        if (ds.length == 0) {
            System.out.println("Chưa có chi tiết hóa đơn");
            return;
        }
            System.out.print("Nhập mã chi tiết hóa đơn :");
            int maHoaDonCanSua = sc.nextInt();
            for (ChiTietHoaDon chiTietHoaDon : ds)
            {
                if(maHoaDonCanSua==chiTietHoaDon.getMaChiTietHoaDon())
                {
                    String x="";
                    System.out.print("Nhập mã hóa đơn (enter để lấy dữ liệu cũ): ");
                    x = sc.nextLine();
                    if(!x.isEmpty()){chiTietHoaDon.setMaHoaDon(Integer.parseInt(x));x="";}
                    System.out.print("Nhập mã sản phẩm (enter để lấy dữ liệu cũ): ");
                    x = sc.nextLine();
                    if(!x.isEmpty()){chiTietHoaDon.setMaSanPham(Integer.parseInt(x));x="";}
                    System.out.print("Nhập số lượng mua (enter để lấy dữ liệu cũ): ");
                    x = sc.nextLine();
                    if(!x.isEmpty()){chiTietHoaDon.setSoLuongMua(Integer.parseInt(x));x="";}
                    System.out.print("Nhập đơn giá (enter để lấy dữ liệu cũ): ");
                    x = sc.nextLine();
                    if(!x.isEmpty()){chiTietHoaDon.setDonGia(Float.parseFloat(x));x="";}
                    System.out.print("Nhập thành tiền (enter để lấy dữ liệu cũ): ");
                    x = sc.nextLine();
                    if(!x.isEmpty()){chiTietHoaDon.setThanhTien(Float.parseFloat(x));x="";}
                    Suatofile(chiTietHoaDon,maHoaDonCanSua);
                    System.out.println("Sửa thành công.");
                    return;
                }
            }
            System.out.println("Mã chi tiết hóa đơn không tồn tại.");
    }
    public void Sua(ChiTietHoaDon chiTietHoaDon,int maHoaDonCanSua) {
        for (ChiTietHoaDon ct : ds)
        {
            if(maHoaDonCanSua==ct.getMaChiTietHoaDon())
            {
                ct=chiTietHoaDon;
                Suatofile(chiTietHoaDon,maHoaDonCanSua);
                return;
            }
        }
    }

    public void XemDs(){
        if(ds.length == 0){
            System.out.println("Chưa có hóa đơn.");
            return;
        }
            for(int i = 0; i < ds.length; i++){
                System.out.println(".......Vị trí thứ "+(i+1)+"........");
                ds[i].Xuat();
            }

    }
    public void Thongke()
    {
        System.out.println("Có "+ds.length+" chi tiết hóa đơn");
    }
    public void ThongkeTheoSanpham()
    {
        int count=0;
        System.out.print("Nhập mã sản phẩm :");
        int ma=sc.nextInt();
        for (ChiTietHoaDon chiTietHoaDon :ds)
        {
            if(chiTietHoaDon.getMaSanPham()==ma)
            {
                count+=chiTietHoaDon.getSoLuongMua();
            }
        }
        System.out.println("Sản phẩm có mã "+ma+ " đã bán được "+count+" sản phẩm.");
    }
    public static void ThemDschitiethoadontofile(List<ChiTietHoaDon> ds)
    {
        File file=new File();
        int maxid=file.getMaxId("dschitiethoadon.txt");
        for(int i=0,j=(maxid+1);i< ds.size();i++,j++)
        {
            String data=j+","+ds.get(i).getMaHoaDon()+","+ ds.get(i).getMaSanPham()+","+ds.get(i).getSoLuongMua()+","+ds.get(i).getDonGia()+","+ds.get(i).getThanhTien();
            file.WriteNewLine(data,"dschitiethoadon.txt");
        }


    }

    public void Themtofile(ChiTietHoaDon chiTietHoaDon)
    {
        File file=new File();
        String data=chiTietHoaDon.getMaChiTietHoaDon()+","+chiTietHoaDon.getMaHoaDon()+","+chiTietHoaDon.getMaSanPham()+","+chiTietHoaDon.getSoLuongMua()+","+chiTietHoaDon.getDonGia()+","+
                chiTietHoaDon.getThanhTien();
        file.WriteNewLine(data,"dschitiethoadon.txt");
    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dschitiethoadon.txt",id);

    }
    public void Suatofile(ChiTietHoaDon chiTietHoaDon,int id)
    {
        File file=new File();
        String data=chiTietHoaDon.getMaChiTietHoaDon()+","+chiTietHoaDon.getMaHoaDon()+","+chiTietHoaDon.getMaSanPham()+","+chiTietHoaDon.getSoLuongMua()+","+chiTietHoaDon.getDonGia()+","+
                chiTietHoaDon.getThanhTien();
        file.UpdateRow(data,"dschitiethoadon.txt",id);
    }

}
