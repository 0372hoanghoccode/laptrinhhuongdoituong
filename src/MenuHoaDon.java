import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuHoaDon {
    DsHoaDon danhsachHoaDon;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    MenuHoaDon() {
        File file = new File();
        List<String> data = file.ReadFile("dshoadon.txt");
        HoaDon[] arr = new HoaDon[data.size()];
        for (int i = 0; i < data.size(); i++) {
            String splitarr[] = data.get(i).split(",");
            try {
                arr[i] = new HoaDon(Integer.parseInt(splitarr[0]),
                        format.parse(splitarr[1]), Integer.parseInt(splitarr[2]), Integer.parseInt(splitarr[3]), Integer.parseInt(splitarr[4]), Float.parseFloat(splitarr[5])
                );
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        danhsachHoaDon = new DsHoaDon(arr);
        Menu();
    }

    Scanner sc = new Scanner(System.in);

    public void Menu() {
        while (true) {
            System.out.println("----------------Quản lí hóa đơn-------------");
            System.out.println("-- 0.Thoát                                --");
            System.out.println("-- 1.Xem danh sách hóa đơn                --");
            System.out.println("-- 2.Thêm hóa đơn                         --");
            System.out.println("-- 3.Xóa hóa đơn                          --");
            System.out.println("-- 4.Sửa hóa đơn                          --");
            System.out.println("-- 5.Tìm kiếm hóa đơn                     --");
            System.out.println("-- 6.Thống kê hóa đơn                     --");
            System.out.println("-- 7.Tìm hóa đơn từ ngày đến ngày         --");
            System.out.println("-- 8.Thống kê hóa đơn theo quý            --");
            System.out.println("-- 9.Tìm 3 hàng mua nhiều nhất năm        --");
            System.out.println("-- 10.Tìm kiếm hoóa đơn theo mã khách hàng--");
            System.out.println("--------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            switch (new Scanner(System.in).nextInt()) {
                case 0:
                    return;
                case 1:
                    danhsachHoaDon.XemDs();
                    break;
                case 2:
                    danhsachHoaDon.Them();
                    break;
                case 3:
                    danhsachHoaDon.Xoa();
                    break;
                case 4:
                    danhsachHoaDon.Sua();
                    break;
                case 5:
                    danhsachHoaDon.Timkiem();
                    break;
                case 6:
                    danhsachHoaDon.Thongke();
                    break;
                case 7:
                    danhsachHoaDon.TimHoaDonTheoNgay();
                    break;
                case 8:
                    danhsachHoaDon.ThongKedoanhthutheoquy();
                    break;
                case 9:
                    danhsachHoaDon.Timkiembakhachhangmuadonlonnhat();
                    break;
                case 10:
                    danhsachHoaDon.Timkiemtheomakh();
                    break;
                default:
                    System.out.println("Giá trị không hợp lệ.");
            }
        }
    }
}
