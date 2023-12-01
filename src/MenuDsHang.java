import java.util.List;
import java.util.Scanner;

public class MenuDsHang {
   DsHang dshang;
    public MenuDsHang() {
        File file=new File();
     List<String> data=file.ReadFile("dshang.txt");
     Hang arr[]=new Hang[data.size()];
     for (int i=0;i<data.size();i++)
     {
         String splitarr[]=data.get(i).split(",");
         arr[i]=new Hang(Integer.parseInt(splitarr[0]),splitarr[1],splitarr[2]);
     }
     dshang=new DsHang(arr);
    }

    void  Menu()
    {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("-- 0.Thoát                                --");
            System.out.println("-- 1.Xem danh sách hãng                   --");
            System.out.println("-- 2.Thêm chi tiết hãng                   --");
            System.out.println("-- 3.Xóa chi tiết hãng                    --");
            System.out.println("-- 4.Sửa chi tiết hãng                    --");
            System.out.println("-- 5.Tìm kiếm hãng                        --");
            System.out.println("-- 6.Thống kê hãng                        --");
            System.out.println("--------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    return;
                case 1:
                    dshang.XemDs();
                    break;
                case 2:
                    dshang.Them();
                    break;
                case 3:
                    dshang.Xoa();
                    break;
                case 4:
                    dshang.Sua();
                    break;
                case 5:
                    dshang.Timkiem();
                    break;
                case 6:
                    dshang.Thongke();
                    break;
                default:
                    System.out.println("Giá trị khng hợp lệ.");
            }
        }

    }

}
