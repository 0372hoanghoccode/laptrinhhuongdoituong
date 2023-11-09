import java.util.List;
import java.util.Scanner;

public class MenuDsHang {
   DsHang dshang;
    public MenuDsHang() {
        dshang=new DsHang();
        File file=new File();
     List<String> data=file.ReadFile("dshang.txt");
     for (int i=0;i<data.size();i++)
     {
         String arr[]=data.get(i).split(",");
         Hang hang=new Hang(Integer.parseInt(arr[0]),arr[1],arr[2]);
         dshang.Them(hang);

     }
    }

    void  Menu()
    {
        while (true) {
            System.out.println("Vui long chon 0 : Thong ke 1: xem DS 2: Them 3: Sua 4 : Xoa 5 : Tim Kiem 6 :  Nghi/Thoat");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    dshang.Thongke();
                    break;
                case 1:
                    dshang.Xem();
                    break;
                case 2:
                    dshang.Them();
                    break;
                case 3:
                    dshang.Sua();
                    break;
                case 4:
                    dshang.Xoa();
                    break;
                case 5:
                    dshang.Timkiem();
                    break;
                case 6:
                  return;
                default:
                    System.out.println("Gia Tri Khong Hop Le");


            }
        }

    }

}
