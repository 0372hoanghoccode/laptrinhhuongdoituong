import java.util.Scanner;
public class Smartphone extends Dienthoai implements doituong {
    private String heDieuHanh;
    private int ram;
    private String chip;

    public Smartphone() {
        super();
    }

    public Smartphone(String heDieuHanh, int ram, String chip) {
        this.heDieuHanh = heDieuHanh;
        this.ram = ram;
        this.chip = chip;
    }

    public Smartphone(int maSanPham, int soLuong, float donGia, int maHang, String ten, String kichThuoc, String heDieuHanh, int ram, String chip) {
        super(maSanPham, soLuong, donGia, maHang, ten, kichThuoc);
        this.heDieuHanh = heDieuHanh;
        this.ram = ram;
        this.chip = chip;
    }
    public Smartphone(Dienthoai dienthoai, String heDieuHanh, int ram, String chip) {
        super(dienthoai);
        this.heDieuHanh = heDieuHanh;
        this.ram = ram;
        this.chip = chip;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.print("Nhập hệ điều hành :");
        heDieuHanh = scanner.nextLine();
        System.out.print("Nhập dung lương RAM (Gb) :");
        ram = scanner.nextInt();
        System.out.print("Nhập chip :");
        chip = scanner.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.printf("Hệ điều hành: %s\nRAM: %d\nChip: %s\n", heDieuHanh, ram, chip);
    }
    public void Sua()
    {
        super.Sua();
        String x="";
        System.out.print("Nhập hệ điều hành (enter để lấy dữ liệu cũ) :");
        x = scanner.nextLine();
        if(!x.isEmpty()){
            heDieuHanh=x;x="";
        }
        System.out.print("Nhập dung lương RAM (Gb) (enter để lấy dữ liệu cũ) :");
        x = scanner.nextLine();
        if(!x.isEmpty()){
            ram=Integer.parseInt(x);x="";
        }
        System.out.print("Nhập chip (enter để lấy dữ liệu cũ) :");
        x = scanner.nextLine();
        if(!x.isEmpty()){
            chip=x;
        }


    }
    public void Goi(){
        System.out.println("Đang gọi video call............ ");
    }
}