import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
public class DsHoaDon {
    Scanner sc = new Scanner(System.in);
    private HoaDon[]  ds;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
        Themtofile(hoaDon);
        System.out.println("Thêm thành công.");
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
        Themtofile(hoaDon);
    }
    public void Them(int maHoaDon, Date ngayLap, int maNhanVien, int maKhachHang,int tongSoluong, float tongTien)
    {
        if(!checkma(maHoaDon))
        {
            return;
        }
        HoaDon hoaDon=new HoaDon(maHoaDon,ngayLap,maNhanVien,maKhachHang,tongSoluong,tongTien);
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=hoaDon;
        Themtofile(hoaDon);
    }

    public void Xoa() {
        if(ds.length == 0) {
            System.out.println("Chưa có hóa đơn nào.");
            return;
        }
            System.out.print("Nhập mã hóa đơn cần xóa :");
            int maHoaDon = sc.nextInt();
            for (int i = 0; i < ds.length; i++) {
                if (ds[i].getMaHoaDon() == maHoaDon) {
                    for(int j=i;j<ds.length-1;j++)
                    {
                        ds[j]=ds[j+1];
                    }
                    ds=Arrays.copyOf(ds,ds.length-1);
                    Xoatofile(maHoaDon);
                    System.out.println("Xóa thành công.");
                    return;
                }
            }
           System.out.println("Mã hóa đơn không tồn tại.");
    }
    public void Xoa(int ma){
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHoaDon() == ma) {
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
    public void Sua()
    {
        if(ds.length == 0) {
            System.out.println("Chưa có hóa đơn nào.");
            return;
        }
        System.out.print("Nhập mã hóa đơn cần sửa: ");
        int maHoaDon = sc.nextInt();
        for (HoaDon hoaDon : ds) {
            if (hoaDon.getMaHoaDon() == maHoaDon) {

                String s="";
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập mã nhân viên (enter để lấy dữ liệu cũ): ");
                s=sc.nextLine();
                if (!s.isEmpty()){hoaDon.setMaNhanVien(Integer.parseInt(s));s="";}
                System.out.print("Nhập mã khách hàng (enter để lấy dữ liệu cũ): ");
                s=sc.nextLine();
                if (!s.isEmpty()){hoaDon.setMaKhachHang(Integer.parseInt(s));s="";}
                System.out.print("Nhập số lương (enter để lấy dữ liệu cũ): ");
                s=sc.nextLine();
                if (!s.isEmpty()){hoaDon.setTongSoluong(Integer.parseInt(s));s="";}
                System.out.print("Nhập tổng tiền (enter để lấy dữ liệu cũ): ");
                s=sc.nextLine();
                if (!s.isEmpty()){hoaDon.setTongTien(Float.parseFloat(s));s="";}
                System.out.print("Nhập ngày lập: dd/MM/yyyy  (enter để lấy dữ liệu cũ) ");
                s=sc.nextLine();
                if (!s.isEmpty()){
                    try {
                        hoaDon.setNgayLap(dateFormat.parse(s));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }



                Suatofile(hoaDon,maHoaDon);
                System.out.println("Sửa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy mã hóa đơn.");

    }
    public void Sua(int ma, HoaDon hd)
    {
        for (HoaDon hoaDon : ds) {
            if (hoaDon.getMaHoaDon() == ma) {
                hoaDon=hd;
                Suatofile(hoaDon,ma);
                System.out.println("Sửa thành công.");
                return;
            }
        }
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
        if(ds.length==0)
        {
            System.out.println("Danh sách hóa đơn trống.");return;
        }
       System.out.print("Nhập mã hóa đơn :");
       int ma= sc.nextInt();
        for (HoaDon d : ds) {
            if (d.getMaHoaDon() == ma) {
               d.Xuat();return;
            }
        }
        System.out.println("Không tìm thấy.");
    }
    public void Timkiemtheomakh() {
        if(ds.length==0)
        {
            System.out.println("Danh sách hóa đơn trống.");return;
        }
        System.out.print("Nhập mã khách hàng :");
        int ma= sc.nextInt();
        boolean co=false;
        for (HoaDon d : ds) {
            if (d.getMaKhachHang() == ma) {
                co=true;
                d.Xuat();

            }
        }
        if(co)
            return;
        System.out.println("Không tìm thấy.");
    }
   public void XemDs()
   {
       if(ds.length==0)
       {
           System.out.println("........Danh sách trống.........");return;
       }

       for (int i=0;i<ds.length;i++) {
           System.out.println("-----Vị trí thứ "+(i+1)+"-------");
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
        System.out.println("Nhập ngày bắt đầu (dd-MM-yyyy) :");
        String fromDateStr = sc.nextLine();
        try {
            fromDate = LocalDate.parse(fromDateStr, formatter);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Định dạng: dd-MM-yyyy");
        }

        System.out.println("Nhập ngày kết thúc (dd-MM-yyyy) :");
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
            System.out.println("Có " + count + " hóa đơn từ " + fromDateStr + " đến " + toDateStr + " bao gồm: ");
            for (int i = 0; i < ds.length; i++) {
                LocalDate ngayLap = ds[i].getNgayLap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (!ngayLap.isBefore(fromDate) && !ngayLap.isAfter(toDate)) {
                    ds[i].Xuat();
                }
            }
        }else{
            System.out.println("Không có hóa đơn từ " + fromDateStr + " đến " + toDateStr);
        }
    }
    public void Timkiembakhachhangmuadonlonnhat()
    {
        if(ds.length==0){System.out.println("Danh sách trống.");return;}
        System.out.print("Nhập năm  :");
        int year=sc.nextInt();

       int kh1=-1,kh2=-1,kh3=-1;
       float maxt1=-1,maxt2=-1,maxt3=-1;
        for (HoaDon hoaDon:ds)
        {
          if( (hoaDon.getNgayLap().getYear()+1900)==year && hoaDon.getTongTien()>maxt3)
          {
           if(hoaDon.getTongTien()>=maxt1){
               kh3=kh2;kh2=kh1;kh1=hoaDon.getMaKhachHang();
               maxt3=maxt2;maxt2=maxt1;maxt1=hoaDon.getTongTien();
           }else if(hoaDon.getTongTien()>=maxt2){
              kh3=kh2;kh2=hoaDon.getMaKhachHang();
              maxt3=maxt2;maxt2=hoaDon.getTongTien();
          } else if (hoaDon.getTongTien()>maxt3) {
               kh3=hoaDon.getMaKhachHang();
               maxt3=hoaDon.getTongTien();
           }
          }
        }


        System.out.print("Các khách hàng mua nhều nhất trong năm là :");
        if(kh1!=-1)
            System.out.println("khách hàng thứ nhất có mã "+kh1+" mua lớn nhất "+maxt1);
        if(kh2!=-1)
            System.out.println("khách hàng thứ hai có mã "+kh2+" mua lớn nhất "+maxt2);
        if(kh3!=-1)
            System.out.println("khách hàng thứ ba có mã "+kh3+" mua lớn nhất "+maxt3);


    }

    public void ThongKedoanhthutheoquy()
    {
        System.out.print("Nhập năm cần thống kê :");
        int year=sc.nextInt();
        float q1=0,q2=0,q3=0,q4=0;
        for (HoaDon hd:ds) {
            if(hd.getNgayLap().getYear()+1900==year) {
                if (hd.getNgayLap().getMonth()+1 == 1 || hd.getNgayLap().getMonth()+1 == 2 || hd.getNgayLap().getMonth()+1 == 3) {
                    q1 += hd.getTongTien();
                }
                if (hd.getNgayLap().getMonth()+1 == 4 || hd.getNgayLap().getMonth()+1 == 5 || hd.getNgayLap().getMonth()+1 == 6) {
                    q2 += hd.getTongTien();
                }
                if (hd.getNgayLap().getMonth()+1 == 7 || hd.getNgayLap().getMonth()+1 == 8 || hd.getNgayLap().getMonth()+1 == 9) {
                    q3 += hd.getTongTien();
                }
                if (hd.getNgayLap().getMonth()+1 == 10 || hd.getNgayLap().getMonth()+1 == 11 || hd.getNgayLap().getMonth()+1 == 12) {
                    q4 += hd.getTongTien();

                }
            }
        }
        System.out.println("Doanh thu trong quý 1 "+q1+" quý 2 "+q2+" quý 3 "+q3+" quý 4 "+q4);
        System.out.println("Tổng doang thu trong cả năm :"+(q1+q2+q3+q4));

    }



    public static int Themhoadontofile(HoaDon hoaDon)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(hoaDon.getNgayLap());
        File file=new File();
        int max=file.getMaxId("dshoadon.txt");
        String data=(max+1)+","+strDate+","+ hoaDon.getMaNhanVien()+","+ hoaDon.getMaKhachHang()+","+ hoaDon.getTongSoluong()+","+ hoaDon.getTongTien();
        file.WriteNewLine(data,"dshoadon.txt");
     return max+1;
    }
    public void Themtofile(HoaDon hoaDon)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(hoaDon.getNgayLap());
        File file=new File();
        String data=hoaDon.getMaHoaDon()+","+strDate+","+hoaDon.getMaNhanVien()+","+ hoaDon.getMaKhachHang()+","+hoaDon.getTongSoluong()+","+hoaDon.getTongTien();
        System.out.println(data);
        file.WriteNewLine(data,"dshoadon.txt");

    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dshoadon.txt",id);
    }
    public void Suatofile(HoaDon hoaDon,int id)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(hoaDon.getNgayLap());
        File file=new File();
        String data=hoaDon.getMaHoaDon()+","+strDate+","+hoaDon.getMaNhanVien()+","+ hoaDon.getMaKhachHang()+","+hoaDon.getTongSoluong()+","+hoaDon.getTongTien();
        file.UpdateRow(data,"dshoadon.txt",id);

    }
}
