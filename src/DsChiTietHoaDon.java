import java.util.List;
import java.util.Scanner;

public class DsChiTietHoaDon {
    private ChiTietHoaDon[] danhSachChiTietHoaDon;
    static int soLuongChiTiet;
    private static int max = 10;
    Scanner sc = new Scanner(System.in);
    public DsChiTietHoaDon(){
        soLuongChiTiet = 0;
        danhSachChiTietHoaDon = new ChiTietHoaDon[max];
    }
    public void Them(){
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
        chiTietHoaDon.Nhap();

            danhSachChiTietHoaDon[soLuongChiTiet] = chiTietHoaDon;
            soLuongChiTiet++;

    }
    public void Them( ChiTietHoaDon chiTietHoaDon){

            danhSachChiTietHoaDon[soLuongChiTiet] = chiTietHoaDon;
            soLuongChiTiet++;

    }
    public void Them(int machitiet, int maHoaDon,int maSanPham,int soLuongMua,float donGia,float thanhTien){
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(machitiet,maHoaDon, maSanPham, soLuongMua, donGia, thanhTien);
        danhSachChiTietHoaDon[soLuongChiTiet] = chiTietHoaDon;
        soLuongChiTiet++;
    }
    public void xoaChiTietTheoMaHoaDon(){
        if(soLuongChiTiet == 0){
            System.out.println("Chưa có chi tiết hóa đơn");
        }else{
            HoaDon hoaDon = new HoaDon();
            int index = -1;
            for(int i = 0; i < soLuongChiTiet; i++){
                if(danhSachChiTietHoaDon[i].getMaHoaDon() == hoaDon.getMaHoaDon()){
                    index = i;
                    break;
                }
            }
            if(index != -1) {
                for (int i = 0; i < soLuongChiTiet; i++) {
                    danhSachChiTietHoaDon[i] = danhSachChiTietHoaDon[i + 1];
                }
                soLuongChiTiet--;
                System.out.println("Đã xóa chi tiết");
            }
            else {
                System.out.println("Mã hóa đơn không tồn tại");
            }
        }
    }
    public ChiTietHoaDon timChiTietTheoMaHoaDon(){
        System.out.print("Nhập mã hóa đơn:" );
        int maHoaDon = sc.nextInt();
        boolean found = false;
        for(int i = 0; i < soLuongChiTiet; i++){
            if(danhSachChiTietHoaDon[i].getMaHoaDon() == maHoaDon){
                danhSachChiTietHoaDon[i].Xuat();
                found = true;
            }
        }
        if(!found){
            System.out.println("Mã hóa đơn không tồn tại");
        }
        return null;
    }
    public void SuaChiTiet() {
        if (soLuongChiTiet == 0) {
            System.out.println("Chưa có chi tiết hóa đơn");
        } else {
            System.out.print("Nhập mã hóa đơn để sửa chi tiết: ");
            int maHoaDonCanSua = sc.nextInt();
            ChiTietHoaDon chiTietHoaDonCanSua = timMaHoaDonCanSuaChiTiet(maHoaDonCanSua);
            chiTietHoaDonCanSua.Xuat();
            if(chiTietHoaDonCanSua != null){
                boolean tiepTuSua = true;
                while(tiepTuSua){
                    System.out.println("------------------------");
                    System.out.println("Chọn thông tin cần sửa");
                    System.out.println("1.Mã sản phẩm");
                    System.out.println("2.Số lượng mua");
                    System.out.println("0.Kết thúc");
                    System.out.print("Nhập lựa chon: ");
                    int luachon = sc.nextInt();
                    sc.nextLine();
                    switch (luachon){
                        case 1:
                            System.out.print("Nhập mã sản phẩm mới: ");
                            int newMaSanPham = sc.nextInt();
                            chiTietHoaDonCanSua.setMaSanPham(newMaSanPham);
                            System.out.println("Đã cập nhập!");
                            break;
                        case 2:
                            System.out.print("Nhập số lượng mua mới: ");
                            int newSoLuongMua = sc.nextInt();
                            chiTietHoaDonCanSua.setSoLuongMua(newSoLuongMua);
                            System.out.println("Đã cập nhập!");
                            break;
                        case 0:
                            tiepTuSua = false;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }
                }
                System.out.println("Sửa chi tiết hóa đơn thành công");
            }
            else {
                System.out.println("Không tìm thấy chi tiết hóa đơn");
            }
        }
    }
    private ChiTietHoaDon timMaHoaDonCanSuaChiTiet(int maHoaDon){
        for(int i = 0;i < soLuongChiTiet; i++){
            if(danhSachChiTietHoaDon[i].getMaHoaDon() == maHoaDon){
                System.out.println("Tìm thành công");
                return danhSachChiTietHoaDon[i];
            }
        }
        return null;
    }
    public void hienThiChiTietHoaDon(){
        if(soLuongChiTiet == 0){
            System.out.println("Chưa có hóa đơn");
        }else{
            for(int i = 0; i < soLuongChiTiet; i++){
                danhSachChiTietHoaDon[i].Xuat();
            }
        }
    }
    public static void Themchitiethoadontofile(float  [][]arr,int mahd)
    {
        File file=new File();
        int maxid=file.getMaxId("dschitiethoadon");
        for(int i=0,j=(maxid+1);i< arr.length;i++,j++)
        {
            String data=j+","+mahd+ arr[i][0]+","+arr[i][3]+","+arr[i][4]+","+arr[i][5];
            file.WriteNewLine("dschitiethoadon",data);
        }


    }

}
