import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
public class Muahang {

Muahang()
{
    new DsDienthoai();

}
   void mua()
    {
        System.out.println("Nhap so luong san pham can mua");
        int sl=new Scanner(System.in).nextInt();
        float arr[][]=new float[sl][6];
        float tongtien=0;int tongsoluong=0;
        for(int i=0;i<sl;i++)
        {
            //o ma sp , 1 ma nv ,2 ma kh  ,3 so luong, 4 don gia  , 5 thanh tien,
            System.out.println("......Sản phẩm thứ "+(i+1)+".....");
            System.out.print("Nhập mã sản phẩm : ");
            arr[i][0]=new Scanner(System.in).nextInt();
        Dienthoai dt=DsDienthoai.getDienthoai((int)arr[i][0]);

            if(i==0) {
                System.out.print("Nhập mã nhân viên");
                arr[i][1] = new Scanner(System.in).nextInt();
                System.out.print("Nhập mã khách hàng : ");
                arr[i][2]=new Scanner(System.in).nextInt();
            }else {
                arr[i][1]=arr[0][1];
                arr[i][2]=arr[0][2];
            }
            System.out.print("Nhập số lượng");
            arr[i][3]=new Scanner(System.in).nextInt();
            while (arr[i][1]>dt.getSoLuong()){
                System.out.println("Vui lòng nhập lại : phải bé hơn hoặc bằng "+dt.getSoLuong());
                arr[i][3]=new Scanner(System.in).nextInt();
            }
            arr[i][4]=dt.getDonGia();
            arr[i][5]=arr[i][3]*arr[i][4];

            tongtien+=arr[i][5];
            tongsoluong+=(int)arr[i][3];
        }
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = now.format(formatter);
      int mahd=DsHoaDon.Themhoadontofile((int)arr[0][1],(int)arr[0][2],tongsoluong,tongtien,formattedDate);
        for (int i=0;i<sl;i++)
        {
            DsDienthoai.Muahang((int)arr[i][0],(int)arr[i][3]);

        }
        DsChiTietHoaDon.Themchitiethoadontofile(arr,mahd);
    }
}
