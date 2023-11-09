import java.io.*;
import java.util.Scanner;

public class MenuDsKhachhang {
    DsKhachhang dsKhachhang;
    MenuDsKhachhang()
    {
        Khachhang [] arr=new Khachhang[3];

        arr[0]= new Khachhang(1,"nguyen","toan","123 nguen thi minh khai p13 q8 tphcm","12246868687");
        arr[1]= new Khachhang(2,"tran","quang","973/34 do thua luan p12 q tan binh","112847655");
        arr[2]= new Khachhang(3,"nguyen","minh trang","123 giai phong don da hanoi","49859595");
        dsKhachhang=new DsKhachhang(arr);
    }




    void  Menu()
    {
        while (true) {
            System.out.println("Vui long chon 0 : Thong ke 1: xem DS 2: Them 3: Sua 4 : Xoa 5 : Tim Kiem 6 : Thong ke theo ho 7 : Thong ke theo ten 8 : Nghi/Thoat");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    dsKhachhang.Thongke();
                    break;
                case 1:
                    dsKhachhang.Xem();
                    break;
                case 2:
                    dsKhachhang.Them();
                    break;
                case 3:
                    dsKhachhang.Sua();
                    break;
                case 4:
                    dsKhachhang.Xoa();
                    break;
                case 5:
                    dsKhachhang.Timkiem();
                    break;
                case 6:
                    dsKhachhang.ThongketheoHo();
                    break;
                case 7:
                    dsKhachhang.ThongketheoTen();
                case 8:
                    return;
                default:
                    System.out.println("Gia Tri Khong Hop Le");


            }
        }

    }
}
