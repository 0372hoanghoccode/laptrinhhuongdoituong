import java.util.List;
import java.util.Scanner;

public class MenuHoaDon {
    DsHoaDon danhsachHoaDon;

    MenuHoaDon()
    {File file=new File();
      List<String> data= file.ReadFile("dshoadon");
        danhsachHoaDon = new DsHoaDon();
        for(String line :data)
        {
            String arr[]=line.split(",");
            HoaDon hd=new HoaDon((int)arr[0],(int)arr[1]);
        }
    }
    Scanner sc = new Scanner(System.in);
    public void menu(){
        int luachon ;
        do{
            System.out.println("-----------------------------------------------------------");
            System.out.println("---   1.Xem thông tin hóa đơn                           ---");
            System.out.println("---   2.Thêm hóa đơn                                    ---");
            System.out.println("---   3.Sửa hóa đơn                                     ---");
            System.out.println("---   4.Xóa hóa đơn theo mã hóa đơn                     ---");
            System.out.println("---   5.Xóa hóa đơn theo mã khách hàng                  ---");
            System.out.println("---   6.Tìm hóa đơn theo mã hóa đơn                     ---");
            System.out.println("---   7.Tìm hóa đơn theo mã khách hàng                  ---");
            System.out.println("---   8.Thống kê và tìm hóa đơn từ ngày A đến ngày B    ---");
            System.out.println("---   9.Xóa tất cả hóa đơn                              ---");
    //      System.out.println("---   Thống kê tổng tiền từ ngày A đến ngày B           ---");
            System.out.println("---   0. Thoát                                          ---");
            System.out.println("-----------------------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextInt();
            switch (luachon) {
                case 1:
                    danhsachHoaDon.hienThiHoaDon();
                    break;
                case 2:
                    danhsachHoaDon.themHoaDon();
                    break;
                case 3:
                    danhsachHoaDon.suaHoaDon();
                    break;
                case 4:
                    danhsachHoaDon.xoaHoaDonTheoMaHoaDon();
                    break;
                case 5:
                    danhsachHoaDon.xoaHoaDonTheoMaKhachHang();
                    break;
                case 6:
                    danhsachHoaDon.timHoaDonTheoMaHoaDon();
                    break;
                case 7:
                    danhsachHoaDon.timHoaDonTheoMaKhachHang();
                    break;
                case 8:
                    danhsachHoaDon.thongKeVaHienthiHoaDonTheoNgay();
                    break;
                case 9:
                    danhsachHoaDon.xoaTatCaHoaDon();
                    break;
                case 0:
                    System.out.println("Thoát chương trỉnh");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }while(luachon != 0);
    }
}
