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

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhap he dieu hanh: ");
        heDieuHanh = scanner.nextLine();
        System.out.println("Nhap RAM: ");
        ram = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Nhap chip: ");
        chip = scanner.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.printf("He dieu hanh: %s\nRAM: %d\nChip: %s\n", heDieuHanh, ram, chip);
    }
    public void Sua()
    {

    }
    public void Goi(){
        System.out.println(" Dang Goi Video call............ ");
    }
}