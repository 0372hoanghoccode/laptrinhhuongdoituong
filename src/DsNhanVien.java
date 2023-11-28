import java.util.Scanner;

public class DsNhanVien {
    private NhanVien[] danhSachNhanVien;
    int soLuongNhanVien;
    private static int max = 100;
    Scanner sc = new Scanner(System.in);
    public DsNhanVien() {
        danhSachNhanVien = new NhanVien[max];
        soLuongNhanVien = 0;
    }
    public void themNhanVien() {
            NhanVien nhanVien = new NhanVien();
            nhanVien.Nhap();
            boolean kiemtraMaNhanVien = false;
            for (int i = 0; i < soLuongNhanVien; i++) {
                if (danhSachNhanVien[i].getMaNhanVien() == nhanVien.getMaNhanVien()) {
                    kiemtraMaNhanVien = true;
                    break;
                }
            }
            if (!kiemtraMaNhanVien) {
                if (soLuongNhanVien < danhSachNhanVien.length) {
                    danhSachNhanVien[soLuongNhanVien] = nhanVien;
                    soLuongNhanVien++;
                    System.out.println("Thêm thành công");
                } else {
                    System.out.println("Danh sách đã đầy");
                }
            } else {
                System.out.println("Mã nhân viên đã tồn tại");
            }
    }

    public void xoaNhanVien() {
        if (soLuongNhanVien == 0) {
            System.out.println("Chưa có nhân viên");
        } else {
            System.out.print("Nhập mã nhân viên để xóa: ");
            int maNhanVien = sc.nextInt();
            int index = -1;
            for (int i = 0; i < soLuongNhanVien; i++) {
                if (danhSachNhanVien[i].getMaNhanVien() == maNhanVien) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < soLuongNhanVien - 1; i++) {
                    danhSachNhanVien[i] = danhSachNhanVien[i + 1];
                }
                soLuongNhanVien--;
                System.out.println("Đã xóa thành công");
            } else {
                System.out.println("Mã nhân viên không tồn tại");
            }
        }
    }

    public NhanVien timNhanVienTheoMa(){
        if(soLuongNhanVien == 0){
            System.out.println("Chưa có nhân viên");
        }else {
            boolean found = false;
            System.out.print("Nhập mã nhân viên để tìm: ");
            int maNhanVien = sc.nextInt();
            for (int i = 0; i < soLuongNhanVien; i++) {
                if (danhSachNhanVien[i].getMaNhanVien() == maNhanVien) {
                    System.out.println("Tìm thành công");
                    danhSachNhanVien[i].Xuat();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Mã nhân viên không tồn tại");
            }
        }
        return null;
    }

    public void timNhanVienTheoTen() {
        if (soLuongNhanVien == 0) {
            System.out.println("Chưa có nhân viên");
        } else {
            System.out.print("Nhập tên nhân viên cần tìm: ");
            String tenNhanVien = sc.nextLine();
            boolean found = false;
            for (int i = 0; i < soLuongNhanVien; i++) {
                if (danhSachNhanVien[i].getTenNhanVien().equals(tenNhanVien)) {
                    System.out.println("Tìm thành công:");
                    danhSachNhanVien[i].Xuat();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Tên nhân viên không tồn tại");
            }
        }
    }
    private boolean kiemTraMaNhanVien(int maNhanVien) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].getMaNhanVien() == maNhanVien) {
                return false;
            }
        }
        return true;
    }
    public void suaNhanVien() {
        if(soLuongNhanVien == 0) {
            System.out.println("Chưa có nhân viên");
        }else {
            System.out.print("Nhập mã nhân viên cần sửa: ");
            int maNhanVien = sc.nextInt();
            NhanVien nhanVienCanSua = timNhanVienCanSua(maNhanVien);
            nhanVienCanSua.Xuat();
            if (nhanVienCanSua != null) {
                boolean tiepTucSua = true;
                while (tiepTucSua) {
                    System.out.println("----------------------------");
                    System.out.println("Chọn thông tin cần sửa");
                    System.out.println("1. Mã nhân viên");
                    System.out.println("2. Họ nhân viên");
                    System.out.println("3. Tên nhân viên");
                    System.out.println("4. Lương nhân viên");
                    System.out.println("0. Kết thúc sửa");
                    System.out.print("Nhập lựa chọn: ");
                    int luachon = sc.nextInt();
                    switch (luachon) {
                        case 1:
                            System.out.print("Nhập mã nhân viên mới: ");
                            int newMaNhanVien = sc.nextInt();
                            if (kiemTraMaNhanVien(newMaNhanVien)) {
                                nhanVienCanSua.setMaNhanVien(newMaNhanVien);
                                System.out.println("Đã cập nhập!");
                            } else {
                                System.out.println("Mã nhân viên đã tồn tại");
                            }
                            break;
                        case 2:
                            System.out.print("Nhập họ nhân viên mới: ");
                            String newHoNhanVien = sc.next();
                            nhanVienCanSua.setHoNhanVien(newHoNhanVien);
                            System.out.println("Đã cập nhập!");
                            break;
                        case 3:
                            System.out.print("Nhập tên nhân viên mới: ");
                            String newTenNhanVien = sc.next();
                            nhanVienCanSua.setTenNhanVien(newTenNhanVien);
                            System.out.println("Đã cập nhập!");
                            break;
                        case 4:
                            System.out.print("Nhập lương nhân viên mới: ");
                            float newLuong = sc.nextFloat();
                            nhanVienCanSua.setLuong(newLuong);
                            System.out.println("Đã cập nhập!");
                            break;
                        case 0:
                            tiepTucSua = false;
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                }
                System.out.println("Thông tin nhân viên đã được cập nhật!");
            } else {
                    System.out.println("Không tìm thấy mã nhân viên");
            }
        }
    }
    private NhanVien timNhanVienCanSua(int maNhanVien) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].getMaNhanVien() == maNhanVien) {
                System.out.println("Tìm thành công");
                return danhSachNhanVien[i];
            }
        }
        return null;
    }
    public void hienthiNhanVien() {
        if (soLuongNhanVien == 0) {
            System.out.println("Chưa có nhân vien");
        } else {
            for (int i = 0; i < soLuongNhanVien; i++) {
                danhSachNhanVien[i].Xuat();
            }
        }
    }
    public void thongKeMucLuong() {
        if(soLuongNhanVien == 0) {
            System.out.println("Chưa có nhân viên");
        }else{
            float luongThongKe;
            int luaChon;
            do {
                System.out.println("Chọn loại thống kê");
                System.out.println("1. Thống kê nhân viên có lương lớn hơn");
                System.out.println("2. Thống kê nhân viên có lương nhỏ hơn");
                System.out.println("3. Thống kê nhân viên có lương từ A đến B");
                System.out.println("0. Kết thúc thống kê");
                System.out.print("Nhập lựa chọn của bạn: ");
                luaChon = sc.nextInt();
                sc.nextLine();
                switch (luaChon) {
                    case 1:
                        System.out.print("Nhập lương để thống kê: ");
                        luongThongKe = sc.nextFloat();
                        sc.nextLine();
                        tinhLuongLonHon(luongThongKe);
                        break;
                    case 2:
                        System.out.print("Nhập lương để thống kê: ");
                        luongThongKe = sc.nextFloat();
                        sc.nextLine();
                        tinhLuongNhoHon(luongThongKe);
                        break;
                    case 3:
                        System.out.print("Nhập số lương bắt đầu: ");
                        float tienA = sc.nextFloat();
                        System.out.print("Nhập số lương kết thúc: ");
                        float tienB = sc.nextFloat();
                        tinhSoLuongTrongKhoan(tienA, tienB);
                        break;
                    case 0:
                        System.out.println("Kết thúc thống kê.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } while (luaChon != 0);
        }
    }
    private void tinhLuongLonHon(float luongThongKe) {
        int count = 0;
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i].getLuong() > luongThongKe) {
                count++;
            }
        }
        System.out.println("Có " + count + " nhân viên có mức lương lớn hơn lương thống kê");
    }
    private void tinhLuongNhoHon(float luongThongKe){
        int count = 0;
        for(int i = 0; i < soLuongNhanVien; i++){
            if(danhSachNhanVien[i].getLuong() < luongThongKe){
                count++;
            }
        }
        System.out.println("Có " + count + " nhân viên có mức lương nhỏ hơn lương thống kê");
    }
    private void tinhSoLuongTrongKhoan(float luongBatDau, float luongKetThuc){
        int count = 0;
        for(int i = 0; i < soLuongNhanVien; i++){
            if(danhSachNhanVien[i].getLuong() >= luongBatDau && danhSachNhanVien[i].getLuong() <= luongKetThuc){
                count++;
            }
        }
        System.out.println("Có " + count + " nhân viên thỏa");
    }

    public void xoaTatCaNhanVien() {
        if (soLuongNhanVien == 0) {
            System.out.println("Chưa có nhân viên");
        } else {
            danhSachNhanVien = new NhanVien[max];
            soLuongNhanVien = 0;
            System.out.println("Đã xóa tất cả nhân viên");
        }
    }
}
