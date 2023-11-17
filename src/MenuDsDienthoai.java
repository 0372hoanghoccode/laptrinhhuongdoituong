import java.util.Scanner;

public class MenuDsDienthoai {
    private Scanner scanner;
   DsDienthoai dsDienthoai=new DsDienthoai();
    public MenuDsDienthoai() {
        //doc tu file;
    }

    public void menu() {
        int choice;

        do {
            System.out.println(" Nhap lua chon :  1. Them dien thoai 2. Xoa dien thoai 3. Hien thi danh sach dien thoai 4. Sua thong tin dien thoai 5. Tim kiem dien thoai them ma  6. Tim kiem dien thoai them ten 7. thoat/nghi ");
            choice = scanner.nextInt();
            switch (choice) {
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
        } while (choice != 6);
    }
}
