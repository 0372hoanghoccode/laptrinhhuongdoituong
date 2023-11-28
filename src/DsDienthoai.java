import java.util.Arrays;
import java.util.Scanner;

public class DsDienthoai {
   static private Dienthoai[] ds;
    private Scanner scanner = new Scanner(System.in);

    public DsDienthoai() {
        ds = new Dienthoai[0];
    }

    public DsDienthoai(Dienthoai[] dienthoai) {
        ds = new Dienthoai[dienthoai.length];
        ds = dienthoai;
    }

    public void Them() {
        System.out.println("Ban muon them ?");
        System.out.println("1. Dien thoai pho thong");
        System.out.println("2. Smartphone");
        int loai1 = scanner.nextInt();
        scanner.nextLine();

        switch (loai1) {
            case 1:
                DTPT dtpt = new DTPT();
                dtpt.Nhap();
                Them(dtpt);
                break;
            case 2:
                Smartphone smartphone = new Smartphone();
                smartphone.Nhap();
                Them(smartphone);
                break;
            default:
                System.out.print("Khong hop le ");
                break;
        }
    }

    public void Them(Dienthoai dt) {
        Dienthoai[] newDs = new Dienthoai[ds.length + 1];
        for (int i = 0; i < ds.length; i++) {
            newDs[i] = ds[i];
        }
        newDs[ds.length] = dt;
        ds = newDs;
    }

    public void Them(Dienthoai[] dienthoai) {
        Dienthoai[] newDs = new Dienthoai[ds.length + dienthoai.length];
        for (int i = 0; i < ds.length; i++) {
            newDs[i] = ds[i];
        }
        System.arraycopy(dienthoai, 0, newDs, ds.length, dienthoai.length);
        ds = newDs;
    }

    public void Xoa() {
        System.out.println("Nhap Ma");
        int x = new Scanner(System.in).nextInt();
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Xoa Thanh Cong");
                return;
            }
        }
        System.out.println("Khong Tim Thay");
    }

    public void Xoa(int x) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == x) {
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Xoa thanh cong");
                return;
            }
        }
        System.out.println("Xoa that bai");
    }


    public void Sua() {
        System.out.println("Nhap ma san pham can sua: ");
        int maSanPham = scanner.nextInt();

        Dienthoai dt = getDienthoai(maSanPham);

        if (dt != null) {

            System.out.println("Thong tin hien tai cua dien thoai:");
            dt.Xuat();

            System.out.println("Nhap thong tin moi cho dien thoai:");
            dt.Sua();

            System.out.println("Cap nhat thong tin thanh cong!");
        } else {
            System.out.println("Khong tim thay dien thoai co ma " + maSanPham);
        }
    }

    public void Sua(int maSanPham) {
        Dienthoai dt = getDienthoai(maSanPham);

        if (dt != null) {

            System.out.println("Thong tin hien tai cua dien thoai:");
            dt.Xuat();

            System.out.println("Nhap thong tin moi cho dien thoai:");
            dt.Sua();

            System.out.println("Cap nhat thong tin thanh cong!");
        } else {
            System.out.println("Khong tim thay dien thoai co ma " + maSanPham);
        }
    }

    public static Dienthoai getDienthoai(int maSanPham) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == maSanPham) {
                return ds[i];
            }
        }
        return null;
    }

    public void Thongke() {
        int dtpt = 0;
        int dtsmp = 0;
        for (Dienthoai d : ds) {
            if (d instanceof Smartphone) {
                dtsmp++;
            }
            if (d instanceof DTPT) {
                dtpt++;
            }
        }
        System.out.println("Co : " + ds.length + " dien thoai trong do co " + dtpt + " dien thoai pho thong va " + dtsmp + " dien thoai smartphone");
    }

    public void Xuat(String loai) {
        System.out.println("Danh sách " + loai + ":");
        for (Dienthoai d : ds) {
            if (d instanceof Smartphone) {
                System.out.print("SMARTPHONE : ");
                d.Xuat();
            }
            if (d instanceof DTPT) {
                System.out.print("DTPT : ");
                d.Xuat();
            }
        }
    }

    public void Xuat() {
        for (Dienthoai d : ds) {
            if (d instanceof Smartphone) {
                System.out.print("SMARTPHONE : ");
                d.Xuat();
            }
            if (d instanceof DTPT) {
                System.out.print("DTPT : ");
                d.Xuat();
            }
        }
    }

    public Dienthoai Timkiem(int maSanPham) {
        for (Dienthoai d : ds) {
            if (d.getMaSanPham() == maSanPham) {
                return d;
            }
        }
        return null;
    }

    public void timVaInSanPham(int maSanPham) {
        for (Dienthoai d : ds) {
            if (d.getMaSanPham() == maSanPham) {
                d.Xuat();
            }
        }

        System.out.println("Khong tim thay san pham voi ma: " + maSanPham);
    }

    public void timVaInSanPham() {
        System.out.println("Nhap ma san pham");
        int maSanPham = new Scanner(System.in).nextInt();
        for (Dienthoai d : ds) {
            if (d.getMaSanPham() == maSanPham) {
                d.Xuat();
            }
        }

        System.out.println("Khong tim thay san pham voi ma: " + maSanPham);
    }

    public void TimkiemTheoTen() {
        boolean empty = false;
        System.out.println("Nhap ten san pham");
        String tenSanPham = new Scanner(System.in).nextLine();
        for (Dienthoai d : ds) {
            empty = true;
            if (d.getTen().equals(tenSanPham)) {
                d.Xuat();
            }
        }

        if (!empty)
            System.out.println("Khong tim thay san pham voi ten: " + tenSanPham);
    }
    public static void Muahang(int ma,int sl)
    {
        for(int i=0;i<ds.length;i++)
        {
           if( ds[i].getMaSanPham()==ma)
           {
               ds[i].setSoLuong(ds[i].getSoLuong()-sl);
               File file=new File();
               String newdata="";
               if(ds[i] instanceof DTPT){
                   newdata+=String.valueOf(ma)+","+ String.valueOf(0)+","+ds[i].getSoLuong()+","+ ds[i].getDonGia()+","+ ds[i].getMaHang()+","+ds[i].getTen()+","+ds[i].getKichThuoc()+","+((DTPT) ds[i]).getBanPhim();

               }else {
                   newdata+= String.valueOf(ma)+","+String.valueOf(1)+","+ds[i].getSoLuong()+","+ ds[i].getDonGia()+","+ ds[i].getMaHang()+","+ds[i].getTen()+","+ds[i].getKichThuoc()+","+((Smartphone)ds[i]).getHeDieuHanh()+","+((Smartphone)ds[i]).getRam()+","+((Smartphone)ds[i]).getChip();
               }

              file.UpdateRow(newdata,"dsdienthoai",ds[i].getMaSanPham());
               return;
           }

        }
    }
    public  void Themtofile()
    {

    }
    public  void Xoatofile()
    {

    }
    public  void Suatofile()
    {

    }

}