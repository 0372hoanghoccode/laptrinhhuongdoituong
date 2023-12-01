import java.util.List;
import java.util.Scanner;

public class MenuDsNhanVien {
    DsNhanVien danhSachNhanVien;
    public MenuDsNhanVien()
    {
        File file =new File();
        List<String> data= file.ReadFile("dsnhanvien.txt");
        NhanVien[] arr=new NhanVien[data.size()];
        for(int i=0;i<data.size();i++)
        {
            String splitarr[]=data.get(i).split(",");
            arr[i]=new NhanVien(Integer.parseInt(splitarr[0]),splitarr[1],splitarr[2],Float.parseFloat(splitarr[3]));

        }
        danhSachNhanVien=new DsNhanVien(arr);
    }
    public void menu() {
        int luachon;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------------");
            System.out.println("---   1.Xem thông tin nhân viên      ----");
            System.out.println("---   2.Thêm nhân viên               ----");
            System.out.println("---   3.Sửa Thông tin nhân viên      ----");
            System.out.println("---   4.Xóa nhân viên                ----");
            System.out.println("---   5.Tìm kiếm nhân viên           ----");
            System.out.println("---   6.Thống kê mức lương nhân viên ----");
            System.out.println("---   0.Thoát chương trình           ----");
            System.out.println("-----------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextInt();
            switch (luachon) {
                case 0:
                   return;
                case 1:
                    danhSachNhanVien.XemDs();
                    break;
                case 2:
                    danhSachNhanVien.Them();
                    break;
                case 3:
                    danhSachNhanVien.Xoa();
                    break;
                case 4:
                    danhSachNhanVien.Sua();
                    break;
                case 5:
                    danhSachNhanVien.Timkiem();
                    break;
                case 6:
                    danhSachNhanVien.Thongke();
                    break;
                case 7:
                    danhSachNhanVien.ThongKeMucLuong();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (true);
    }
}

