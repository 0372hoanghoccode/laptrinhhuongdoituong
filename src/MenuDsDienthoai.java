import java.util.List;
import java.util.Scanner;

public class MenuDsDienthoai {
    private DsDienthoai dsDienthoai ;

    public MenuDsDienthoai() {
        DocTuFile();
    }
    private void DocTuFile() {
        File file = new File();
        List<String> data = file.ReadFile("dsdienthoai.txt");
        Dienthoai[] arr=new Dienthoai[data.size()];
        for (int i = 0; i < data.size(); i++) {
            String[] splitarr = data.get(i).split(",");
                if (Integer.parseInt(splitarr[1])==0) {
                   arr[i]=new DTPT(Integer.parseInt(splitarr[0]),Integer.parseInt(splitarr[2]),Float.parseFloat(splitarr[3]),Integer.parseInt(splitarr[4]),splitarr[5],splitarr[6],splitarr[7]);
                } else
                {
                   arr[i]=new Smartphone(Integer.parseInt(splitarr[0]),Integer.parseInt(splitarr[2]),Float.parseFloat(splitarr[3]),Integer.parseInt(splitarr[4]),splitarr[5],splitarr[6],splitarr[7],Integer.parseInt(splitarr[8]),splitarr[9]);
                }
            }
        dsDienthoai=new DsDienthoai(arr);
        }

    public void menu() {
        while(true) {
            System.out.println("--------------------------------------------");
            System.out.println("-- 0.Thoát                                --");
            System.out.println("-- 1.Xem danh sách điện thoại             --");
            System.out.println("-- 2.Thêm điện thoại                      --");
            System.out.println("-- 3.Xóa điện thoại                       --");
            System.out.println("-- 4.Sửa điện thoại                       --");
            System.out.println("-- 5.Tìm kiếm điện thoại                  --");
            System.out.println("-- 6.Thống kê điện thoại                  --");
            System.out.println("-- 7.Gọi                                  --");
            System.out.println("--------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    return;
                case 1:
                    dsDienthoai.XemDs();
                    break;
                case 2:
                    dsDienthoai.Them();
                    break;
                case 3:
                    dsDienthoai.Xoa();
                    break;
                case 4:
                    dsDienthoai.Sua();
                    break;
                case 5:
                    dsDienthoai.Timkiem();
                    break;
                case 6:
                    dsDienthoai.Thongke();
                    break;
                case 7:
                    dsDienthoai.Gọi();
                    break;
                default:
                    System.out.println("Giá trị không hợp lệ.");
            }
        }
    }
}