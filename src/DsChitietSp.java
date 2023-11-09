import java.util.Arrays;
import java.util.Scanner;

public class DsChitietSp {
 ChitietSp[] ds;

    public DsChitietSp(ChitietSp[] ds) {
        this.ds = ds;
    }
    public DsChitietSp()
    {
      ds=new ChitietSp[0];
    }

    public ChitietSp[] getDs() {
        return ds;
    }

    public void setDs(ChitietSp[] ds) {
        this.ds = ds;
    }
    public void XemDs()
    {
        for (int i=0;i< ds.length;i++)
        {
            System.out.println("-----Vi tri Thu "+(i+1)+"-----");
            ds[i].Xuat();
        }
    }
    public void  Them()
    {
        ChitietSp chitietSp= new ChitietSp();
        chitietSp.Nhap();
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=chitietSp;
    }
    public void Them(ChitietSp ct)
    {
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=ct;

    }
    public void Xoa()
    {
        System.out.println("Nhap Ma Chi Tiet Can Xoa :");
        int ma=new Scanner(System.in).nextInt();
        for (int i=0; i<ds.length;i++) {
            if(ds[i].getMa()==ma)
            {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                return;
            }
        }
        System.out.println("Khong tim Thay ");
    }
    public void Xoa(int ma)
    {
        for (int i=0; i<ds.length;i++) {
            if(ds[i].getMa()==ma)
            {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                return;
            }
        }
        System.out.println("Khong tim Thay ");

    }

    public void Sua()
    {
        System.out.println("Nhap Ma Can Sua :");
        int ma=new Scanner(System.in).nextInt();
        for (ChitietSp ct : ds)
        {
            if(ct.getMa()==ma)
            {
                ct.Nhap();
                return;
            }
        }
          System.out.println("Khong Tim Thay .");
    }
    public void Sua(int ma)
    {
        for (ChitietSp ct : ds)
        {
            if(ct.getMa()==ma)
            {
                ct.Nhap();
                return;
            }
        }
        System.out.println("Khong Tim Thay .");
    }
    public void Timkiem()
    {
        System.out.println("Nhap Ma Chi Tiet Cam Tim");
        int ma=new Scanner(System.in).nextInt();
        for (ChitietSp ct:ds)
        {
            if(ct.getMa()==ma)
            {
                ct.Xuat();
                return;
            }
        }
        System.out.println("Khong Tim Thay");
    }
    public void Timkiem(int ma)
    {

        for (ChitietSp ct:ds)
        {
            if(ct.getMa()==ma)
            {
                ct.Xuat();
                return;
            }
        }
        System.out.println("Khong Tim Thay");
    }
    ChitietSp[]  TimkiemtheoDophangiai(String dophangiai)
    {
        ChitietSp[] dsct=new ChitietSp[0];

        for (ChitietSp ct:ds)
        {
            if(ct.getDophangiai().equals(dophangiai))
            {
                dsct= Arrays.copyOf(dsct,ds.length+1);
                ds[ds.length-1]=ct;
            }
        }
       return dsct;
    }
    ChitietSp[]  TimkiemtheoDophangiaireturn()
    {
        System.out.println("Nhap Do Phan Giai :");
        String dophangiai=new Scanner(System.in).nextLine();
        ChitietSp[] dsct=new ChitietSp[0];

        for (ChitietSp ct:ds)
        {
            if(ct.getDophangiai().equals(dophangiai))
            {
                dsct= Arrays.copyOf(dsct,ds.length+1);
                ds[ds.length-1]=ct;
            }
        }
        return dsct;
    }
    void   TimkiemtheoDophangiai()
    {
        System.out.println("Nhap Do Phan Giai :");
        String dophangiai=new Scanner(System.in).nextLine();
        ChitietSp[] dsct=new ChitietSp[0];

        for (ChitietSp ct:ds)
        {
            if(ct.getDophangiai().equals(dophangiai))
            {
                System.out.println("------------------");
                ct.Xuat();
            }
        }
    }
    void Thongke()
    {

        System.out.println("Co tong cong "+ds.length+" chi tiet san pham ");
        ThongkehotroCamera();
        ThongkeCongsac();
        ThongkehotroFlash();
    }
    void ThongketheohotroBluetooth()
    {
        int x=0;
        for (ChitietSp ct : ds)
        {
            if(ct.isBluetooth())
            {
               x++;
            }
        }
        System.out.println("Co "+x+" San pham ho tro Bluetooth");
    }
    void ThongkehotroCamera()
    {
        int x=0;
        for (ChitietSp ct : ds)
        {
            if(ct.isCamera())
            {
                x++;
            }
        }
        System.out.println("Co "+x+" San pham ho tro Camera");

    }
    void ThongkehotroFlash()
    {
        int x=0;
        for (ChitietSp ct : ds)
        {
            if(ct.isFlash())
            {
                x++;
            }
        }
        System.out.println("Co "+x+" San pham ho tro Flash");

    }
    void ThongkeCongsac()
    {
        int microUsb=0;
        int typeC=0;
        int lightNing=0;
        for (ChitietSp ct : ds)
        {
            if (ct.getCongsac().equals("microUsb"))
            {
               microUsb++;
            }
            if (ct.getCongsac().equals("typeC"))
            {
                typeC++;
            }
            if (ct.getCongsac().equals("microUsb"))
            {
                lightNing++;
            }
        }
        System.out.println("Co "+microUsb+" san pham ho tro cong sac microUsb"
                +"Co "+typeC+" san pham ho tro cong sac Type C"+
                "Co "+lightNing+" san pham ho tro cong sac lightNing"
        );

    }



}
