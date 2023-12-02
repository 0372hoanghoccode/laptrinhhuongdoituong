import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
public class Muahang {

Muahang()
{
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
    new DsDienthoai(arr);
}
   void mua()
    {
        System.out.print("Nhập số lượng cần mua :");
        int sl=new Scanner(System.in).nextInt();
        float arr[][]=new float[sl][4];
        float tongtien=0;int tongsoluong=0;
        int manv;int makh;
        System.out.print("Nhập mã nhân viên :");
        manv=new Scanner(System.in).nextInt();
        System.out.print("Nhập mã khách hàng :");
        makh=new Scanner(System.in).nextInt();
        for(int i=0;i<sl;i++)
        {
            //o ma sp ,1 so luong, 2 don giam, 3 thanh tien
            System.out.println("......Sản phẩm thứ "+(i+1)+".....");
            System.out.print("Nhập mã sản phẩm :");
            arr[i][0]=new Scanner(System.in).nextInt();
            Dienthoai dt=DsDienthoai.getDienthoai((int)arr[i][0]);
            if(dt==null){System.err.println("Điện thoại null lỗi................");}
            System.out.print("Nhập số lượng :");
            arr[i][1]=new Scanner(System.in).nextInt();
            while (arr[i][1]>dt.getSoLuong()){
                System.out.println("Vui lòng nhập lại : phải bé hơn hoặc bằng "+dt.getSoLuong());
                arr[i][1]=new Scanner(System.in).nextInt();
            }
            arr[i][2]=dt.getDonGia();
            arr[i][3]=arr[i][1]*arr[i][2];
            tongtien+=arr[i][3];
            tongsoluong+=(int)arr[i][1];
        }

        int mahd=DsHoaDon.Themhoadontofile(new HoaDon(-1,new Date(),manv,makh,tongsoluong,tongtien));
        List<ChiTietHoaDon> chiTietHoaDons=new ArrayList<>();
        for (int i=0;i<sl;i++)
        {
            ChiTietHoaDon chitiet=new ChiTietHoaDon(-1,mahd,(int)arr[i][0],(int)arr[i][1],arr[i][2],arr[i][3]);
            chiTietHoaDons.add(chitiet);
            DsDienthoai.Muahang((int)arr[i][0],(int)arr[i][1]);
        }
        DsChiTietHoaDon.ThemDschitiethoadontofile(chiTietHoaDons);
        System.out.println("Mua hàng thành công.");
    }
}
