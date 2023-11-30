import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
public class DsHoaDon {
    Scanner sc = new Scanner(System.in);
    private HoaDon[]  ds;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public DsHoaDon() {
        ds = new HoaDon[0];
    }

    public DsHoaDon(HoaDon[] ds) {
        this.ds = ds;
    }

    public HoaDon[] getDs() {
        return ds;
    }

    public void setDs(HoaDon[] ds) {
        this.ds = ds;
    }

    public void Them(){
        HoaDon hoaDon = new HoaDon();
        hoaDon.Nhap();
        while (!checkma(hoaDon.getMaHoaDon()))
        {
            System.out.print("Mã trùng, vui lòng nhập lại :");
            hoaDon.setMaHoaDon(sc.nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hoaDon;
    }
    boolean checkma(int ma)
    {
        for (HoaDon d : ds) {
            if (d.getMaHoaDon() == ma) {
              return false;

            }
        }
        return true;
    }

    public void Them(HoaDon hoaDon)
    {
        if(!checkma(hoaDon.getMaHoaDon()))
        {
            return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hoaDon;
    }
    public void Them(int maHoaDon, Date ngayLap, int maNhanVien, int maKhachHang,int tongSoluong, float tongTien)
    {
        HoaDon hoaDon=new HoaDon(maHoaDon,ngayLap,maNhanVien,maKhachHang,tongSoluong,tongTien);

        if(!checkma(hoaDon.getMaHoaDon()))
        {
            return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hoaDon;

    }

    public void Xoa() {
        if(ds.length == 0) {
            System.out.println("Chưa có hóa đơn nào.");
            return;
        }
            System.out.print("Nhập mã hóa đơn cần xóa: ");
            int maHoaDon = sc.nextInt();
            for (int i = 0; i < ds.length; i++) {
                if (ds[i].getMaHoaDon() == maHoaDon) {
                    for(int j=i;j<ds.length-1;j++)
                    {
                        ds[j]=ds[j+1];
                    }
                    ds=Arrays.copyOf(ds,ds.length-1);
                    System.out.println("Xóa thành công");
                    return;
                }
            }
           System.out.println("Không tìm thấy mã hóa đơn.");
    }
    public void Xoa(int ma){
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHoaDon() == ma) {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                System.out.println("Xóa thành công.");
                return;
            }
        }
    }
    public void Sua()
    {
        if(ds.length == 0) {
            System.out.println("Chưa có hóa đơn nào.");
            return;
        }
        System.out.print("Nhập mã hóa đơn cần sửa: ");
        int maHoaDon = sc.nextInt();
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHoaDon() == maHoaDon) {
               ds[i].Sua();
                System.out.println("Sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy mã hóa đơn.");

    }

    public HoaDon Timkiem(int ma) {

        for (HoaDon d : ds) {
            if (d.getMaHoaDon() == ma) {
                return d;
            }
        }

        return null;
    }
    public void Timkiem() {
       System.out.print("Nhập mã hóa đơn :");
       int ma= sc.nextInt();
        for (HoaDon d : ds) {
            if (d.getMaHoaDon() == ma) {
               d.Xuat();return;
            }
        }
        System.out.println("Không tìm thấy.");
    }
   public void XemDs()
   {
       if(ds.length==0)
       {
           System.out.println("........Danh sách trống.........");return;
       }

       for (int i=0;i<ds.length;i++) {
           System.out.println("-----Vị trí "+(i+1)+"   -----");
           ds[i].Xuat();
       }
   }
   public void Thongke()
   {
       System.out.println("Có "+ds.length+" hóa đơn");
   }


    public void thongKeVaHienthiHoaDonTheoNgay() {
        LocalDate fromDate = null;
        LocalDate toDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Nhập ngày bắt đầu (dd-MM-yyyy): ");
        String fromDateStr = sc.nextLine();
        try {
            fromDate = LocalDate.parse(fromDateStr, formatter);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Định dạng: dd-MM-yyyy");
        }

        System.out.println("Nhập ngày kết thúc (dd-MM-yyyy): ");
        String toDateStr = sc.nextLine();
        try {
            toDate = LocalDate.parse(toDateStr, formatter);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Định dạng: dd-MM-yyyy");
        }
        int count = 0;
        for (int i = 0; i < ds.length; i++) {
            LocalDate ngayLap = ds[i].getNgayLap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (!ngayLap.isBefore(fromDate) && !ngayLap.isAfter(toDate)) {
                count++;
            }
        }
        if(count != 0) {
            System.out.println("Có " + count + " hóa đơn từ " + fromDate.format(dateFormatter) + " đến " + toDate.format(dateFormatter) + " bao gồm: ");
            for (int i = 0; i < ds.length; i++) {
                LocalDate ngayLap = ds[i].getNgayLap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (!ngayLap.isBefore(fromDate) && !ngayLap.isAfter(toDate)) {
                    ds[i].Xuat();
                }
            }
        }else{
            System.out.println("Không có hóa đơn từ " + fromDate.format(dateFormatter) + " đến " + toDate.format(dateFormatter));
        }
    }



    public static int Themhoadontofile(int manv,int makh,int soluong,float tongtien,String ngay)
    {
        File file=new File();
        int max=file.getMaxId("dshoadon");
        String data=(max+1)+","+manv+","+makh+","+ngay+","+soluong+","+tongtien;
        file.WriteNewLine(data,"dshoadon.txt");
     return max+1;
    }
}
