import jdk.dynalink.linker.LinkerServices;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MenuDsChitietSp {
  DsChitietSp dsChitietSp;
    MenuDsChitietSp()
    {
        File file=new File();
      List<String> data= file.ReadFile("dschitietsanpham.txt");
      ChitietSp[] arr=new ChitietSp[data.size()];
      for (int i=0;i<data.size();i++)
      {
          String[] sliparr=data.get(i).split(",");
          arr[i]=new ChitietSp(Integer.parseInt(sliparr[0]),Boolean.parseBoolean(sliparr[1]),Integer.parseInt(sliparr[2]),Boolean.parseBoolean(sliparr[3]),sliparr[4],Integer.parseInt(sliparr[5]),Boolean.parseBoolean(sliparr[6]),String.valueOf(sliparr[7]),String.valueOf(sliparr[8]),Integer.parseInt(sliparr[9]));
      }
      dsChitietSp=new DsChitietSp(arr);
    }


    void  Menu()
    {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("-- 0.Thoát                                --");
            System.out.println("-- 1.Xem danh sách chi tiết sản phẩm      --");
            System.out.println("-- 2.Thêm chi tiết sản phẩm               --");
            System.out.println("-- 3.Xóa chi tiết sản phẩm                --");
            System.out.println("-- 4.Sửa chi tiết sản phẩm                --");
            System.out.println("-- 5.Tìm kiếm chi tiết sản phẩm           --");
            System.out.println("-- 6.Thống kê chi tiết sản phẩm           --");
            System.out.println("--------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    return;
                case 1:
                    dsChitietSp.XemDs();
                    break;
                case 2:
                    dsChitietSp.Them();
                    break;
                case 3:
                    dsChitietSp.Xoa();
                    break;
                case 4:
                    dsChitietSp.Sua();
                    break;
                case 5:
                    dsChitietSp.Timkiem();
                    break;
                case 6:
                    dsChitietSp.Thongke();
                    break;
                default:
                    System.out.println("Giá trị không hợp lệ");


            }
        }

    }
}
