import java.util.Arrays;
import java.util.Scanner;

public class DsNhanVien {
    private NhanVien[] ds;
    Scanner sc = new Scanner(System.in);
    public DsNhanVien() {
        ds = new NhanVien[0];
    }
    public DsNhanVien(NhanVien[] ds)
    {
        this.ds=ds;
    }
    public void Them() {
            NhanVien nhanVien = new NhanVien();
            nhanVien.Nhap();
            while (!checkid(nhanVien.getMaNhanVien()))
            {
                System.out.print("Mã trùng, vui lòng nhập lại :");
                nhanVien.setMaNhanVien(sc.nextInt());
            }
            ds= Arrays.copyOf(ds,ds.length+1);
            ds[ds.length-1]=nhanVien;
    }
    public void Them(int maNhanVien, String hoNhanVien, String tenNhanVien, float luong) {
        NhanVien nhanVien = new NhanVien(maNhanVien,hoNhanVien,tenNhanVien,luong);
        if(!checkid(nhanVien.getMaNhanVien()))
        {
            return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=nhanVien;
        Themtofile(nhanVien);
    }
    public void Them(NhanVien nhanVien) {

        if(!checkid(nhanVien.getMaNhanVien()))
        {
            return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=nhanVien;
        Themtofile(nhanVien);
    }

    boolean checkid(int id)
    {
        for (NhanVien nhanVien :ds)
        {
            if(nhanVien.getMaNhanVien()==id)
            {
                return false;
            }
        }
        return true;
    }

    public void Xoa() {
        if (ds.length == 0) {
            System.out.println("Danh sách trống");
            return;
        }
            System.out.print("Nhập mã nhân viên để xóa :");
            int maNhanVien = sc.nextInt();
            for (int i=0;i< ds.length;i++)
            {
                if (ds[i].getMaNhanVien()==maNhanVien)
                {
                    for(int j=i;j<ds.length-1;j++)
                    {
                        ds[j]=ds[j+1];
                    }
                    ds=Arrays.copyOf(ds,ds.length-1);
                    System.out.println("Xóa thành công");
                    Xoatofile(maNhanVien);
                    return;
                }
            }
                System.out.println("Mã nhân viên không tồn tại");
    }
    public void Xoa(int maNhanVien) {
        if (ds.length == 0) {
            return;
        }
        for (int i=0;i< ds.length;i++)
        {
            if (ds[i].getMaNhanVien()==maNhanVien)
            {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                Xoatofile(maNhanVien);
                return;
            }
        }
    }

    public void Timkiem(){
        if(ds.length == 0){
            System.out.println("Danh sách trống.");
            return ;
        }
          System.out.print("Nhập mã nhân viên :");
           int maNhanVien= sc.nextInt();
            for (int i = 0; i < ds.length; i++) {
                if (ds[i].getMaNhanVien() == maNhanVien) {
                    ds[i].Xuat();
                    return;
                }
            }
                System.out.println("Mã nhân viên không tồn tại");
    }
    public NhanVien Timkiem(int ma){
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaNhanVien() == ma) {
                return ds[i];
            }
        }
        return null;
    }
    public void XemDs()
    {
        for (int i=0;i< ds.length;i++)
        {
            System.out.println(".......Vị trí thứ "+(i+1)+"........");
            ds[i].Xuat();
        }
    }
    public void Sua() {
        if(ds.length == 0) {
            System.out.println("Danh sách trống");
            return;
        }
            System.out.print("Nhập mã nhân viên cần sửa: ");
            int maNhanVien = sc.nextInt();

           for (NhanVien nhanVien :ds)
           {
               if(nhanVien.getMaNhanVien()==maNhanVien)
               {
                   nhanVien.Sua();
                   Suatofile(nhanVien,maNhanVien);
                   System.out.println("Thông tin nhân viên đã được cập nhật!");

               }
           }
    System.out.println("Mã nhân viên không tồn tại.");
    }
    public void Sua(int ma) {
        if(ds.length == 0) {
            return;
        }
        for (NhanVien nhanVien :ds)
        {
            if(nhanVien.getMaNhanVien()==ma)
            {
                nhanVien.Sua();
                Suatofile(nhanVien,ma);
            }
        }
    }

public void Thongke()
{
    System.out.println("Có "+ds.length+" nhân viên.");

}
    public void ThongKeMucLuong() {
        if(ds.length == 0) {
            System.out.println("Danh sách trống");
            return;
        }
            float luongThongKe;
            int luaChon;
            do {
                System.out.println("Chọn loại thống kê");
                System.out.println("1. Thống kê nhân viên có lương lớn hơn");
                System.out.println("2. Thống kê nhân viên có lương nhỏ hơn");
                System.out.println("3. Thống kê nhân viên có lương từ A đến B");
                System.out.println("0. Kết thúc thống kê");
                System.out.print("Nhập lựa chọn của bạn: ");
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        System.out.print("Nhập lương để thống kê: ");
                        luongThongKe = sc.nextFloat();
                        sc.nextLine();
                        tinhLuongLonHon(luongThongKe);
                        break;
                    case 2:
                        System.out.print("Nhập lương để thống kê: ");
                        luongThongKe = sc.nextFloat();
                        sc.nextLine();
                        tinhLuongNhoHon(luongThongKe);
                        break;
                    case 3:
                        System.out.print("Nhập số lương bắt đầu: ");
                        float tienA = sc.nextFloat();
                        System.out.print("Nhập số lương kết thúc: ");
                        float tienB = sc.nextFloat();
                        tinhSoLuongTrongKhoan(tienA, tienB);
                        break;
                    case 0:
                        System.out.println("Kết thúc thống kê.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } while (luaChon != 0);
    }
    private void tinhLuongLonHon(float luongThongKe) {
        int count = 0;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getLuong() > luongThongKe) {
                count++;
            }
        }
        System.out.println("Có " + count + " nhân viên có mức lương lớn hơn "+luongThongKe);
    }
    private void tinhLuongNhoHon(float luongThongKe){
        int count = 0;
        for(int i = 0; i < ds.length; i++){
            if(ds[i].getLuong() < luongThongKe){
                count++;
            }
        }
        System.out.println("Có " + count + " nhân viên có mức lương nhỏ hơn "+luongThongKe);
    }
    private void tinhSoLuongTrongKhoan(float luongBatDau, float luongKetThuc){
        int count = 0;
        for(int i = 0; i < ds.length; i++){
            if(ds[i].getLuong() >= luongBatDau && ds[i].getLuong() <= luongKetThuc){
                count++;
            }
        }
        System.out.println("Có " + count + " nhân viên thỏa từ "+luongBatDau+" đến "+luongKetThuc);
    }
    public void Themtofile(NhanVien nhanVien)
    {
        File file=new File();
        String data=nhanVien.getMaNhanVien()+","+nhanVien.getHoNhanVien()+","+nhanVien.getTenNhanVien()+","+ nhanVien.getLuong();
        file.WriteNewLine(data,"dsnhanvien.txt");
    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dsnhanvien.txt",id);

    }
    public void Suatofile(NhanVien nhanVien,int id)
    {
        String data=nhanVien.getMaNhanVien()+","+nhanVien.getHoNhanVien()+","+nhanVien.getTenNhanVien()+","+ nhanVien.getLuong();
        File file=new File();
        file.UpdateRow(data,"dsnhanvien.txt",id);

    }
}
