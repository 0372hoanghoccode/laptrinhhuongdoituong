import java.util.List;
import java.util.Scanner;

public class MenuDsDienthoai {
    private DsDienthoai dsDienthoai = new DsDienthoai();

    public MenuDsDienthoai() {
        DocTuFile();
    }
    private void DocTuFile() {
        File file = new File();
        List<String> data = file.ReadFile("dsdienthoai.txt");
        for (int i = 0; i < data.size(); i++) {
            String[] arr = data.get(i).split(",");
            if (arr.length >= 6) {
                String loaiDienThoai = arr[6].trim();
                if (loaiDienThoai.equals("Điện thoại phổ thông")) {
                    String banPhim = arr[7].trim();
                    DTPT dtpt = new DTPT(banPhim);
                    dtpt.setMaSanPham(Integer.parseInt(arr[0].trim()));
                    dtpt.setSoLuong(Integer.parseInt(arr[1].trim()));
                    dtpt.setDonGia(Float.parseFloat(arr[2].trim()));
                    dtpt.setMaHang(Integer.parseInt(arr[3].trim()));
                    dtpt.setTen(arr[4].trim());
                    dtpt.setKichThuoc(arr[5].trim());
                    dsDienthoai.Them(dtpt);
                } else if (loaiDienThoai.equals("Smartphone")) {
                    String heDieuHanh = arr[7].trim();
                    int ram = Integer.parseInt(arr[8].trim());
                    String chip = arr[9].trim();
                    Smartphone smartphone = new Smartphone(heDieuHanh, ram, chip);
                    smartphone.setMaSanPham(Integer.parseInt(arr[0].trim()));
                    smartphone.setSoLuong(Integer.parseInt(arr[1].trim()));
                    smartphone.setDonGia(Float.parseFloat(arr[2].trim()));
                    smartphone.setMaHang(Integer.parseInt(arr[3].trim()));
                    smartphone.setTen(arr[4].trim());
                    smartphone.setKichThuoc(arr[5].trim());
                    dsDienthoai.Them(smartphone);
                }
            }
        }
    }
    public void menu() {
        while(true) {
            System.out.println(" Nhap lua chon :  1. Them dien thoai 2. Xoa dien thoai 3. Hien thi danh sach dien thoai 4. Sua thong tin dien thoai 5. Tim kiem dien thoai them ma  6. Tim kiem dien thoai them ten 7. thoat/nghi ");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    dsDienthoai.Them();
                    break;
                case 2:
                    dsDienthoai.Xoa();
                    break;
                case 3:
                    dsDienthoai.Xuat();
                    break;
                case 4:
                    dsDienthoai.Sua();
                    break;
                case 5:
                    dsDienthoai.timVaInSanPham();
                    break;
                case 6:
                    dsDienthoai.TimkiemTheoTen();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}