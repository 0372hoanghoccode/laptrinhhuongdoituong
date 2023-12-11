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
            System.out.println("-----Vị trí thứ "+(i+1)+"-----");
            ds[i].Xuat();
        }
    }
    public void  Them()
    {
        if(ds.length==0)
        {
            System.out.println("Danh sách trống");
            return;
        }
        ChitietSp chitietSp= new ChitietSp();
        chitietSp.Nhap();
        while (!checkid(chitietSp.getMa()))
        {
            System.out.print("Mã chi tiết sản phẩm trùng, vui lòng nhập lại :");
            chitietSp.setMa(new Scanner(System.in).nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=chitietSp;
        Themtofile(chitietSp);
        System.out.println("Thêm thành công");
    }
    public void Them(ChitietSp ct)
    {
        if(ds.length==0 ||checkid(ct.getMa()))
        {
            return;
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=ct;
        Themtofile(ct);
    }
    public void Them(int ma, boolean camera, int masp, boolean flash, String dophangiai, int bonho, boolean bluetooth, String congsac, String loaipin, int dungluongpin)
    {
        if(ds.length==0)
        {
            return;
        }
        ChitietSp chitietSp=new ChitietSp(ma,camera,masp,flash,dophangiai,bonho,bluetooth,congsac,loaipin,dungluongpin);
        while (!checkid(chitietSp.getMa()))
        {
            System.out.print("Mã chi tiết sản phẩm trùng, vui lòng nhập lại :");
            chitietSp.setMa(new Scanner(System.in).nextInt());
        }
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[ds.length-1]=chitietSp;
        Themtofile(chitietSp);
    }
    public void Xoa()
    {
        if(ds.length==0)
        {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.print("Nhập mã chi tiết sản phẩm cần xóa :");
        int ma=new Scanner(System.in).nextInt();
        for (int i=0; i<ds.length;i++) {
            if(ds[i].getMa()==ma)
            {
                for(int j=i;j<ds.length-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds=Arrays.copyOf(ds,ds.length-1);
                Xoatofile(ma);
                System.out.println("Xóa thành công.");
                return;
            }
        }
        System.out.println("Mã chi tiết sản phẩm không tồn tại.");
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
                Xoatofile(ma);
                return;
            }
        }
    }
    public boolean checkid(int id)
    {
        for (ChitietSp ct :ds)
        {
            if(ct.getMa()==id)
            {
                return false;
            }
        }
        return true;
    }


    public void Sua()
    {
        System.out.print("Nhập mã chi tiết sản phẩm cần sửa :");
        int ma=new Scanner(System.in).nextInt();
        for (ChitietSp ct : ds)
        {
            if(ct.getMa()==ma)
            {
                Scanner sc=new Scanner(System.in);
                String tr="";
                System.out.println("Nhập mã sản phẩm (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setMasp(Integer.parseInt(tr));tr="";}
                System.out.println("Nhập bộ nhớ (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setBonho(Integer.parseInt(tr));tr="";}
                System.out.println("Nhập dung lượng pin (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setDungluongpin(Integer.parseInt(tr));tr="";}
                System.out.println("Hỗ trợ camera true/false ? (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setCamera(Boolean.parseBoolean(tr));tr="";}
                System.out.println("Hỗ tr Bluetooth ? (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setBluetooth(Boolean.parseBoolean(tr));tr="";}
                System.out.println("Hỗ trợ Flash ? (enter để lấy đữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setFlash(Boolean.parseBoolean(tr));tr="";}
                System.out.print("Nhập độ phân giải (enter để lấy đữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setDophangiai(tr);tr="";}
                System.out.println("Nhập cổng sạc (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setCongsac(tr);tr="";}
                System.out.println("Nhập loại pin (enter để lấy dữ liệu cũ):");
                tr=sc.nextLine();
                if(!tr.isEmpty()){ct.setLoaipin(tr);tr="";}

                Suatofile(ct,ma);
                System.out.println("Sửa thành công.");
                return;
            }
        }
          System.out.println("mã chi tiết sản phẩm không tồn tại.");
    }
    public void Sua(int ma,ChitietSp chitietSp)
    {

        for (ChitietSp ct : ds)
        {
            if(ct.getMa()==ma)
            {
                ct=chitietSp;
                Suatofile(chitietSp,ma);
                return;
            }
        }
    }
    public void Timkiem()
    {
        System.out.print("Nhập mã chi tiết sản phẩm cần sửa");
        int ma=new Scanner(System.in).nextInt();
        for (ChitietSp ct:ds)
        {
            if(ct.getMa()==ma)
            {
                ct.Xuat();
                return;
            }
        }
        System.out.println("Mã chi tiết sản phẩm không tồn tại");
    }
    public ChitietSp Timkiem(int ma)
    {

        for (ChitietSp ct:ds)
        {
            if(ct.getMa()==ma)
            {

                return ct;
            }
        }
       return null;
    }


    void Thongke()
    {

        System.out.println("Có "+ds.length+" chi tiết sản phẩm ");
        ThongkehotroCamera();
        ThongkeCongsac();
        ThongkehotroFlash();
        ThongketheohotroBluetooth();
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
        System.out.println("Có "+x+" sản phẩm hỗ trợ Bluetooth");
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
        System.out.println("Có "+x+" sản phẩm hỗ trợ Camera");

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
        System.out.println("Có "+x+" sản phẩm hỗ trợ Flash");

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
        System.out.println("Có "+microUsb+" sản phẩm hỗ trợ ổng sạc microUsb "
                +"Có "+typeC+" sản phẩm hỗ trợ ổng sạc Type C "+
                "Có "+lightNing+" sản phẩm hỗ trợ ổng sạc lightning."
        );

    }
    public void Themtofile(ChitietSp chitietSp)
    {
        File file=new File();
        String data=chitietSp.getMa()+","+chitietSp.isCamera()+","+chitietSp.getMasp()+","+chitietSp.isFlash()+","+chitietSp.getDophangiai()+","+
        chitietSp.getBonho()+","+chitietSp.isBluetooth()+","+chitietSp.getCongsac()+","+chitietSp.getLoaipin()+","+chitietSp.getDungluongpin();
        file.WriteNewLine(data,"dschitietsanpham.txt");

    }
    public void Xoatofile(int id)
    {
        new File().deleterow("dschitietsanpham.txt",id);
    }
    public void Suatofile(ChitietSp chitietSp,int id)
    {
        File file=new File();
        String data=chitietSp.getMa()+","+chitietSp.isCamera()+","+chitietSp.getMasp()+","+chitietSp.isFlash()+","+chitietSp.getDophangiai()+","+
        chitietSp.getBonho()+","+chitietSp.isBluetooth()+","+chitietSp.getCongsac()+","+chitietSp.getLoaipin()+","+chitietSp.getDungluongpin();
        file.UpdateRow(data,"dschitietsanpham.txt",id);

    }
}
