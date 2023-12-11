import java.util.List;
import java.util.Scanner;

public class MenuChiTietHoaDon {

    DsChiTietHoaDon danhSachChiTiet ;
    Scanner sc = new Scanner(System.in);
    MenuChiTietHoaDon()
    {
        File file=new File();
        List<String>  data=file.ReadFile("dschitiethoadon.txt");
        ChiTietHoaDon [] arr2=new ChiTietHoaDon[data.size()];
        for (int i=0;i<data.size();i++)
        {
            String arr[]=data.get(i).split(",");
            ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Float.parseFloat(arr[4]),Float.parseFloat(arr[5]));
            arr2[i]=chiTietHoaDon;
        }
        danhSachChiTiet=new DsChiTietHoaDon(arr2);
        menu();
    }
    public void menu(){
        int luachon;
        do{
            System.out.println("-----------Quản lí chi tiết hóa đơn---------");
            System.out.println("-- 0.Thoát                                --");
            System.out.println("-- 1.Xem danh sách chi tiết hóa đơn       --");
            System.out.println("-- 2.Thêm chi tiết hóa đơn                --");
            System.out.println("-- 3.Xóa chi tiết hóa đơn                 --");
            System.out.println("-- 4.Sửa chi tiết hóa đơn                 --");
            System.out.println("-- 5.Tìm kiếm chi tiết hóa đơn            --");
            System.out.println("-- 6.Thống kê chi tiết hóa đơn            --");
            System.out.println("-- 7.Thống kê theo sản phẩm               --");
            System.out.println("--------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            luachon = sc.nextInt();
            switch (luachon){
                case 0:
                    return;
                case 1:
                    danhSachChiTiet.XemDs();
                    break;
                case 2:
                    danhSachChiTiet.Them();
                    break;
                case 3:
                    danhSachChiTiet.Xoa();
                    break;
                case 4:
                    danhSachChiTiet.Sua();
                    break;
                case 5:
                    danhSachChiTiet.Timkiem();
                    break;
                case 6:
                    danhSachChiTiet.Thongke();
                    break;
                case 7:
                    danhSachChiTiet.ThongkeTheoSanpham();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }while(luachon!= 0);
    }
}
