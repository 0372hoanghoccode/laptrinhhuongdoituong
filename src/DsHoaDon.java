import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
public class DsHoaDon {
    Scanner sc = new Scanner(System.in);
    private HoaDon[] danhSachHoaDon;
    private static int soLuongHoaDon;
    private static int max = 100;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public DsHoaDon() {
        danhSachHoaDon = new HoaDon[max];
        soLuongHoaDon = 0;

    }


    public void themHoaDon(){
        HoaDon hoaDon = new HoaDon();
        hoaDon.Nhap();
        boolean kiemtraMaHoaDon = false;
        for(int i = 0; i < soLuongHoaDon; i++){
            if(danhSachHoaDon[i].getMaHoaDon() == hoaDon.getMaHoaDon()){
                kiemtraMaHoaDon = true;
                break;
            }
        }

        boolean kiemtraMaKhachHang = false;
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i].getMaKhachHang() == hoaDon.getMaKhachHang()) {
                kiemtraMaKhachHang = true;
                break;
            }
        }
        if(!kiemtraMaHoaDon && !kiemtraMaKhachHang) {
            if (soLuongHoaDon < danhSachHoaDon.length) {
                danhSachHoaDon[soLuongHoaDon] = hoaDon;
//                danhSachChiTietHoaDon[QuanLiChiTietHoaDon.soLuongChiTiet].setMaHoaDon(danhSachHoaDon[soLuongHoaDon].getMaHoaDon());
                soLuongHoaDon++;
                System.out.println("Thêm thành công");
            } else {
                System.out.println("Danh sách đã đầy");
            }
        }else{
            if (kiemtraMaHoaDon) {
                System.out.println("Mã hóa đơn đã tồn tại");
            }
            if (kiemtraMaKhachHang) {
                System.out.println("Mã khách hàng đã tồn tại");
            }
        }
    }
    public void xoaHoaDonTheoMaHoaDon() {
        if(soLuongHoaDon == 0){
            System.out.println("Chưa có hóa đơn");
        }else {
            System.out.print("Nhập mã hóa đơn cần xóa: ");
            int maHoaDon = sc.nextInt();
            int index = -1;
            for (int i = 0; i < soLuongHoaDon; i++) {
                if (danhSachHoaDon[i].getMaHoaDon() == maHoaDon) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < soLuongHoaDon - 1; i++) {
                    danhSachHoaDon[index] = danhSachHoaDon[index + 1];
                }
                soLuongHoaDon--;
                System.out.println("Đã xóa thành công");
            }else{
                System.out.println("Mã hóa đơn không tồn tại");
            }
        }
    }
    public void xoaHoaDonTheoMaKhachHang(){
        if(soLuongHoaDon == 0){
            System.out.println("Chưa có hóa đơn");
        }else{
            System.out.print("Nhập mã khách hàng cần xóa hóa đơn: ");
            int maKhachHang = sc.nextInt();
            int index = -1;
            for (int i = 0; i < soLuongHoaDon; i++) {
                if (danhSachHoaDon[i].getMaKhachHang() == maKhachHang) {
                    index = i;
                    break;

                }
            }
            if (index != -1) {
                for (int i = index; i < soLuongHoaDon - 1; i++) {
                    danhSachHoaDon[i] = danhSachHoaDon[i + 1];
                }
                soLuongHoaDon--;
                System.out.println("Đã xóa thành công");
            }else{
                System.out.println("Mã khách hàng không tồn tại");
            }
        }
    }
    public HoaDon timHoaDonTheoMaHoaDon() {
        if(soLuongHoaDon == 0){
            System.out.println("Chưa có hóa đơn");
        }else{
            boolean found = false;
            System.out.print("Nhập mã hóa đơn cần tìm: ");
            int maHoaDon = sc.nextInt();
            for (int i = 0; i < soLuongHoaDon; i++) {
                if (danhSachHoaDon[i].getMaHoaDon() == maHoaDon) {
                    System.out.println("Tìm thành công");
                    danhSachHoaDon[i].Xuat();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Mã hóa đơn không tồn tại");
            }
        }
        return null;
    }
    public HoaDon timHoaDonTheoMaKhachHang() {
        if(soLuongHoaDon == 0){
            System.out.println("Chưa có hóa đơn");
        }else{
            boolean found = false;
            System.out.print("Nhập mã khách hàng cần tìm hóa đơn: ");
            int maKhachHang = sc.nextInt();
            for (int i = 0; i < soLuongHoaDon; i++) {
                if (danhSachHoaDon[i].getMaKhachHang() == maKhachHang) {
                    System.out.println("Tìm thành công");
                    danhSachHoaDon[i].Xuat();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Mã khách hàng không tồn tại");
            }
        }
        return null;
    }
    public void suaHoaDon() {
        if(soLuongHoaDon == 0){
            System.out.println("Chưa có hóa đơn");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã hóa đơn cần sửa: ");
            int maHoaDonCanSua = sc.nextInt();
            HoaDon hoaDonCanSua = timMaHoaDonCanSua(maHoaDonCanSua);
            hoaDonCanSua.Xuat();
            if (hoaDonCanSua != null) {
                boolean tiepTucSua = true;

                while (tiepTucSua) {
                    System.out.println("-----------------------------");
                    System.out.println("Chọn thông tin cần sửa:");
                    System.out.println("1. Mã hóa đơn");
                    System.out.println("2. Mã nhân viên");
                    System.out.println("3. Mã khách hàng");
                    System.out.println("0. Kết thúc sửa");

                    int luaChon = sc.nextInt();

                    switch (luaChon) {
                        case 1:
                            System.out.print("Nhập mã hóa đơn mới: ");
                            int newMaHoaDon = sc.nextInt();
                            if (kiemTraMaHoaDonCanSua(newMaHoaDon)) {
                                hoaDonCanSua.setMaHoaDon(newMaHoaDon);
                                System.out.println("Đã cập nhập!");
                            } else {
                                System.out.println("Mã hóa đơn đã tồn tại");
                            }
                            break;
                        case 2:
                            System.out.print("Nhập mã nhân viên mới: ");
                            int newMaNhanVien = sc.nextInt();
                            hoaDonCanSua.setMaNhanVien(newMaNhanVien);
                            System.out.println("Đã cập nhập!");
                            break;

                        case 3:
                            System.out.print("Nhập mã khách hàng mới: ");
                            int newMaKhachHang = sc.nextInt();
                            if (kiemTraMaKhachHangCanSua(newMaKhachHang)) {
                                hoaDonCanSua.setMaKhachHang(newMaKhachHang);
                                System.out.println("Đã cập nhập!");
                            } else {
                                System.out.println("Mã khách hàng đã tồn tại. Vui lòng nhập lại.");
                            }
                            break;
                        case 0:
                            tiepTucSua = false;
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                    }
                }
                System.out.println("Hóa đơn đã được sửa thành công!");
            } else {
                System.out.println("Không tìm thấy hóa đơn có mã " + maHoaDonCanSua);
            }
        }
    }
    private HoaDon timMaHoaDonCanSua(int maHoaDon) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i].getMaHoaDon() == maHoaDon) {
                System.out.println("Tìm thành công");
                return danhSachHoaDon[i];
            }
        }
        return null;
    }
    private boolean kiemTraMaHoaDonCanSua(int maHoaDon) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i].getMaHoaDon() == maHoaDon) {
                return false;
            }
        }
        return true;
    }
    private boolean kiemTraMaKhachHangCanSua(int maKhachHang) {
        for (int i = 0; i < soLuongHoaDon; i++) {
            if (danhSachHoaDon[i].getMaKhachHang() == maKhachHang) {
                return false;
            }
        }
        return true;
    }

    // chưa tính được tổng tiền vì thanhTien chưa tính được (ghi sau)

    //    public void capNhatTongTien(int maHoaDon) {
//        for (int i = 0; i < soLuongHoaDon; i++) {
//            if (danhSachHoaDon[i].getMaHoaDon() == maHoaDon) {
//                float tongTienHoaDon = 0;
//                ChiTietHoaDon[] chiTietHoaDonArray = danhSachHoaDon[i].getDanhSachChiTietHoaDon();
//                for (ChiTietHoaDon chiTiet : chiTietHoaDonArray) {
//                 tongTienHoaDon += chiTiet.getThanhTien();
//                }
//                danhSachHoaDon[i].setTongTien(tongTienHoaDon);
//                break;
//            }
//        }
//    }
    public void thongKeVaHienthiHoaDonTheoNgay() {
        LocalDate fromDate = null;
        LocalDate toDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Nhập ngày bắt đầu (dd-MM-yyyy): ");
        String fromDateStr = sc.next();
        try {
            fromDate = LocalDate.parse(fromDateStr, formatter);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Định dạng: dd-MM-yyyy");
        }

        System.out.println("Nhập ngày kết thúc (dd-MM-yyyy): ");
        String toDateStr = sc.next();
        try {
            toDate = LocalDate.parse(toDateStr, formatter);
        } catch (Exception e) {
            System.out.println("Không hợp lệ. Định dạng: dd-MM-yyyy");
        }
        int count = 0;
        for (int i = 0; i < soLuongHoaDon; i++) {
            LocalDate ngayLap = danhSachHoaDon[i].getNgayLap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (!ngayLap.isBefore(fromDate) && !ngayLap.isAfter(toDate)) {
                count++;
            }
        }
        if(count != 0) {
            System.out.println("Có " + count + " hóa đơn từ " + fromDate.format(dateFormatter) + " đến " + toDate.format(dateFormatter) + " bao gồm: ");
            for (int i = 0; i < soLuongHoaDon; i++) {
                LocalDate ngayLap = danhSachHoaDon[i].getNgayLap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (!ngayLap.isBefore(fromDate) && !ngayLap.isBefore(toDate)) {
                    danhSachHoaDon[i].Xuat();
                }
            }
        }else{
            System.out.println("Không có hóa đơn từ " + fromDate.format(dateFormatter) + " đến " + toDate.format(dateFormatter));
        }
    }

    // chưa có tổng tiền
//    public float tinhTongTienTuNgayDenNgay(LocalDate fromDate, LocalDate toDate) {
//        float tongTien = 0;
//        for (int i = 0; i < soLuongHoaDon; i++) {
//            LocalDate ngayLap = danhSachHoaDon[i].getNgayLap().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            if (ngayLap.isEqual(fromDate) || (ngayLap.isAfter(fromDate) && ngayLap.isBefore(toDate))) {
//                tongTien += danhSachHoaDon[i].getTongTien();
//            }
//        }
//        return tongTien;
//    }



    public void xoaTatCaHoaDon() {
        danhSachHoaDon = new HoaDon[max];
        soLuongHoaDon = 0;
        System.out.println("Đã xóa tất cả hóa đơn");
    }
    public void hienThiHoaDon(){
        if(soLuongHoaDon == 0){
            System.out.println("Chưa có hóa đơn");
        }else{
            for(int i = 0; i < soLuongHoaDon; i++){
                danhSachHoaDon[i].Xuat();
            }
        }
    }
    public static int Themhoadontofile(int manv,int makh,int soluong,float tongtien)
    {
        File file=new File();
        int max=file.getMaxId("dshoadon");
        String ngaydat="";
      //  DateTime ngaydat=DateTime().now();
        String data=(max+1)+","+manv+","+makh+","+ngaydat+","+soluong+","+tongtien;
     return max+1;
    }
}
