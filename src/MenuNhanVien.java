import java.util.Scanner;

public class MenuNhanVien {
    DsNhanVien danhSachNhanVien = new DsNhanVien();
    public void menu() {
        int luachon;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------------");
            System.out.println("---   1.Xem thông tin nhân viên      ----");
            System.out.println("---   2.Thêm nhân viên               ----");
            System.out.println("---   3.Sửa Thông tin nhân viên      ----");
            System.out.println("---   4.Xóa nhân viên                ----");
            System.out.println("---   5.Tìm nhân viên theo mã        ----");
            System.out.println("---   6.Tìm nhân viên theo tên       ----");
            System.out.println("---   7.Thống kê mức lương nhân viên ----");
            System.out.println("---   8.Xóa tất cả nhân viên         ----");
            System.out.println("---   0.Thoát chương trình           ----");
            System.out.println("-----------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextInt();
            switch (luachon) {
                case 1:
                    danhSachNhanVien.hienthiNhanVien();
                    break;
                case 2:
                    danhSachNhanVien.themNhanVien();
                    break;
                case 3:
                    danhSachNhanVien.suaNhanVien();
                    break;
                case 4:
                    danhSachNhanVien.xoaNhanVien();
                    break;
                case 5:
                    danhSachNhanVien.timNhanVienTheoMa();
                    break;
                case 6:
                    danhSachNhanVien.timNhanVienTheoTen();
                    break;
                case 7:
                    danhSachNhanVien.thongKeMucLuong();
                    break;
                case 8:
                    danhSachNhanVien.xoaTatCaNhanVien();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while (luachon != 0);
    }
}

