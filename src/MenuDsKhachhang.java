
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDsKhachhang {
    DsKhachhang dsKhachhang;
    MenuDsKhachhang()
    {
        File file =new File();
        List<String>data= file.ReadFile("dskhachhang.txt");
        Khachhang[] arr=new Khachhang[data.size()];
        for(int i=0;i<data.size();i++)
        {
            String splitarr[]=data.get(i).split(",");
            arr[i]=new Khachhang(Integer.parseInt(splitarr[0]),splitarr[1],splitarr[2],splitarr[3],splitarr[4]);

        }
        dsKhachhang=new DsKhachhang(arr);
    }




    void  Menu()
    {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("-- 0.Thoát                                --");
            System.out.println("-- 1.Xem danh sách khách hàng             --");
            System.out.println("-- 2.Thêm khách hàng                      --");
            System.out.println("-- 3.Xóa xóa khách hàng                   --");
            System.out.println("-- 4.Sửa khách hàng                       --");
            System.out.println("-- 5.Tìm kiếm khaách hàng                 --");
            System.out.println("-- 6.Thống kê khách hàng                  --");
            System.out.println("--------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    return;
                case 1:
                    dsKhachhang.XemDs();
                    break;
                case 2:
                    dsKhachhang.Them();
                    break;
                case 3:
                    dsKhachhang.Xoa();
                    break;
                case 4:
                    dsKhachhang.Sua();
                    break;
                case 5:
                    dsKhachhang.Timkiem();
                    break;
                case 6:
                    dsKhachhang.Thongke();
                    break;
                default:
                    System.out.println("Giá trị không hợp lệ.");


            }
        }

    }
}
