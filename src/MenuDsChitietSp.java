import java.io.*;
import java.util.Scanner;

public class MenuDsChitietSp {
  DsChitietSp dsChitietSp;
    MenuDsChitietSp()
    {
  ChitietSp[] arr=new ChitietSp[3];
  arr[0]= new ChitietSp(1,true,3,true,"320X720px",32,false,"typeC","lipo",3200);
  arr[1]= new ChitietSp(2,false,4,true,"420X420px",12,false,"microUsb","lion",120);
  arr[2]= new ChitietSp(3,true,9,true,"920X720px",128,false,"typeC","lipo",6000);
   dsChitietSp=new DsChitietSp(arr);
    }


    void  Menu()
    {
        while (true) {
            System.out.println("Vui long chon 0 : Thong ke 1: xem DS 2: Them 3: Sua 4 : Xoa 5 : Tim Kiem 6 : Tim kiem Theo Do Phan Giai 7 : Thong ke ho tro camera 8 : Nghi/Thoat");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    dsChitietSp.Thongke();
                    break;
                case 1:
                    dsChitietSp.XemDs();
                    break;
                case 2:
                    dsChitietSp.Them();
                    break;
                case 3:
                    dsChitietSp.Sua();
                    break;
                case 4:
                    dsChitietSp.Xoa();
                    break;
                case 5:
                    dsChitietSp.Timkiem();
                    break;
                case 6:
                    dsChitietSp.TimkiemtheoDophangiai();
                    break;
                case 7:
                    dsChitietSp.ThongkehotroCamera();
                case 8:
                    return;
                default:
                    System.out.println("Gia Tri Khong Hop Le");


            }
        }

    }
}
