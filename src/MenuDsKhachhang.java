
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDsKhachhang {
    DsKhachhang dsKhachhang;
    MenuDsKhachhang()
    {
        dsKhachhang=new DsKhachhang();
        List<String>data =new ArrayList<>();
        File file =new File();
        data= file.ReadFile("dsKhachhang.txt");
        for(int i=0;i<data.size();i++)
        {
            String arr[]=data.get(i).split(",");
            Khachhang khachhang=new Khachhang(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4]);
            dsKhachhang.Them(khachhang);

        }

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
