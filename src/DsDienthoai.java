import java.util.Scanner;

public class DsDienthoai {
    private Dienthoai[] ds;
    Scanner scanner=new Scanner(System.in);
public DsDienthoai(){
ds= new Dienthoai[0];
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
              //////////////add dtpt
                break;
            case 2:
                Smartphone smartphone = new Smartphone();
                smartphone.Nhap();
                // add dtmartphone
                break;
            default:
                System.out.print("Khong hop le ");
                break;
        }

    }
    public void Them(Dienthoai dt) {
        //add dt
    }
    public void Them(Dienthoai[] dienthoai)
    {
        //them 1 ds
    }
    public void Xoa() {

        if (ds.length == 0) { System.out.println("Danh sach rong."); return;}
                    System.out.println("Nhap ma san pham can xoa : ");
                    int maSanPham = scanner.nextInt();
                   for (int i=0;i< ds.length;i++)
                   {
                       if(ds[i].getMaSanPham()==maSanPham)
                       {
                           //xoa
                           return;
                       }
                   }
             System.out.println("Khong tim thay");
    }

    public void Xoa(int maSanPham) {

        for (int i=0;i< ds.length;i++)
        {
            if(ds[i].getMaSanPham()==maSanPham)
            {
                //xoa
                return;
            }
        }

    }
    public void Sua()
    {

    }
    public void Sua(int maSanpham)
    {

    }



    public Dienthoai getDienthoai(int maSanPham) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham() == maSanPham) {
                return ds[i];
            }
        }
        return null;
    }

    public void Thongke() {
    int dtpt=0;
    int dtsmp=0;
    for(Dienthoai d : ds)
    {
        if (d instanceof Smartphone) {
           dtsmp++;
        }
        if (d instanceof DTPT) {
            dtpt++;
        }

    }
      System.out.println("Co : "+ds.length+" dien thoai trong do co "+dtpt+" dien thoai pho thong va "+dtsmp+" dien thoai smartphone");

    }

    public void Xuat(String loai) {
        System.out.println("Danh sách " + loai + ":");
        for (Dienthoai d : ds) {
                if (d instanceof Smartphone) {
                   System.out.print("SMARTPHONE : "); d.Xuat();
                }
                if (d instanceof DTPT) {
                    System.out.print("DTPT : "); d.Xuat();
                }
        }
    }
    public void Xuat() {
        for (Dienthoai d : ds) {
            if (d instanceof Smartphone) {
                System.out.print("SMARTPHONE : "); d.Xuat();
            }
            if (d instanceof DTPT) {
                System.out.print("DTPT : "); d.Xuat();
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
        int maSanPham=new Scanner(System.in).nextInt();
        for (Dienthoai d : ds) {
            if (d.getMaSanPham() == maSanPham) {
                d.Xuat();
            }
        }

        System.out.println("Khong tim thay san pham voi ma: " + maSanPham);

    }
    public void TimkiemTheoTen() {
    boolean empty=false;
        System.out.println("Nhap ten san pham");
        String tenSanPham=new Scanner(System.in).nextLine();
        for (Dienthoai d : ds) {
            empty=true;
            if (d.getTen().equals(tenSanPham)) {
                d.Xuat();
            }
        }

      if(!empty)
          System.out.println("Khong tim thay san pham voi ten: " + tenSanPham);

    }
}

    