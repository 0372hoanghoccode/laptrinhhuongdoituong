import java.util.Scanner;

public class MainMenu {
    MainMenu()
    {
        while (true)
        {
            System.out.println(
                    "0.Thoát/nghỉ 1. Mua hàng  2.Quản lí điện thoại 3.Quản lý chi tiết điện thoại 4.Quản lý khách hàng \n5.Quản lý nhân viên 6.Quản lý hóa đơn 7.Quản lý chi tiết hóa đơn 8.Quản lý hãng."
            );
            System.out.print("Vui lòng lựa chọn :");
            switch (new Scanner(System.in).nextInt())
            {
                case 0:
                    return;
                case 1:
                    new Muahang();
                    break;
                case 2:
                    new MenuDsDienthoai();
                    break;
                case 3:
                    new MenuDsChitietSp();
                    break;
                case 4:
                    new MenuDsKhachhang();
                    break;
                case 5:
                    new MenuDsNhanVien();
                    break;
                case 6:
                    new MenuHoaDon();
                    break;
                case 7:
                    new MenuChiTietHoaDon();
                case 8:
                    new MenuDsHang();
                default:
                    System.out.print("Giá trị không hợp lệ.");

            }

        }

    }
}
