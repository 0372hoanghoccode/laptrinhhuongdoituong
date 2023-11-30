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
    }
    public void Them( ChiTietHoaDon chiTietHoaDon){
          if(!checkid(chiTietHoaDon.getMaChiTietHoaDon()))
          {
              return;
          }
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=chiTietHoaDon;

    }
    public void Them(int machitiet, int maHoaDon,int maSanPham,int soLuongMua,float donGia,float thanhTien){
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(machitiet,maHoaDon, maSanPham, soLuongMua, donGia, thanhTien);
        if(!checkid(chiTietHoaDon.getMaChiTietHoaDon()))
        {
            return;
        }
       ds=Arrays.copyOf(ds,ds.length+1);
       ds[ds.length-1]=chiTietHoaDon;
    }
    public void Xoa(){
        if(ds.length == 0){
            System.out.println("Chưa có chi tiết hóa đơn");
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
                    return;
                }
            }
                System.out.println("Mã hóa đơn không tồn tại");
    }
    public void Xoa(int ma){
        if(ds.length == 0){
            System.out.println("Chưa có chi tiết hóa đơn");
            return;
        }
        for(int i = 0; i < ds.length; i++){
            if(ds[i].getMaHoaDon() ==ma){
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                return;
            }
        }
    }
    public void Timkiem(){
        System.out.print("Nhập mã hóa đơn:" );
        int maHoaDon = sc.nextInt();
        for(int i = 0; i < ds.length; i++){
            if(ds[i].getMaHoaDon() == maHoaDon){
               ds[i].Xuat();
               return;
            }
        }

            System.out.println("Mã chi tiết hóa đơn không tồn tại");

    }
    private ChiTietHoaDon Timkiem(int maHoaDon){
        for(int i = 0;i < ds.length; i++){
            if(ds[i].getMaHoaDon() == maHoaDon){

                return ds[i];
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
            System.out.print("Nhập mã chi tiết hóa đơn: ");
            int maHoaDonCanSua = sc.nextInt();
            for (ChiTietHoaDon chiTietHoaDon : ds)
            {
                if(maHoaDonCanSua==chiTietHoaDon.getMaChiTietHoaDon())
                {
                    chiTietHoaDon.Sua();
                    return;
                }
            }
            System.out.println("Không tìm thấy mã.");
    }

    public void XemDs(){
        if(ds.length == 0){
            System.out.println("Chưa có hóa đơn");
            return;
        }
            for(int i = 0; i < ds.length; i++){
                System.out.println(".......Vị trí thứ"+(i+1)+"........");
                ds[i].Xuat();
            }

    }
    public void Thongke()
    {
        System.out.println("Có "+ds.length+" chi tiết hóa đơn");
    }
    public static void Themchitiethoadontofile(float  [][]arr,int mahd)
    {
        File file=new File();
        int maxid=file.getMaxId("dschitiethoadon");
        for(int i=0,j=(maxid+1);i< arr.length;i++,j++)
        {
            String data=j+","+mahd+ arr[i][0]+","+arr[i][3]+","+arr[i][4]+","+arr[i][5];
            file.WriteNewLine("dschitiethoadon.txt",data);
        }


    }

}
