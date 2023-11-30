import java.util.Scanner;

public class ChitietSp implements doituong {
   private int ma;
  private   boolean camera;
  private   int masp;
  private   boolean flash;
  private   String dophangiai;
  private int bonho;
  private   boolean bluetooth;
  private   String congsac;
  private   String loaipin;
  private   int dungluongpin;
    public ChitietSp()
    {

    }
    public ChitietSp(int ma, boolean camera, int masp, boolean flash, String dophangiai, int bonho, boolean bluetooth, String congsac, String loaipin, int dungluongpin) {
        this.ma = ma;
        this.camera = camera;
        this.masp = masp;
        this.flash = flash;
        this.dophangiai = dophangiai;
        this.bonho = bonho;
        this.bluetooth = bluetooth;
        this.congsac = congsac;
        this.loaipin = loaipin;
        this.dungluongpin = dungluongpin;
    }
    public ChitietSp(ChitietSp ctsp)
    {
        this.ma = ctsp.ma;
        this.camera =  ctsp.camera;
        this.masp = ctsp.masp;
        this.flash = ctsp.flash;
        this.dophangiai = ctsp.dophangiai;
        this.bonho = ctsp.bonho;
        this.bluetooth = ctsp.bluetooth;
        this.congsac = ctsp.congsac;
        this.loaipin = ctsp.loaipin;
        this.dungluongpin = ctsp.dungluongpin;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public boolean isFlash() {
        return flash;
    }


    public void setFlash(boolean flash) {
        this.flash = flash;
    }

    public void setflash(boolean flash) {
        this.flash = flash;
    }

    public String getDophangiai() {
        return dophangiai;
    }

    public void setDophangiai(String dophangiai) {
        this.dophangiai = dophangiai;
    }

    public int getBonho() {
        return bonho;
    }

    public void setBonho(int bonho) {
        this.bonho = bonho;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getCongsac() {
        return congsac;
    }

    public void setCongsac(String congsac) {
        this.congsac = congsac;
    }

    public String getLoaipin() {
        return loaipin;
    }

    public void setLoaipin(String loaipin) {
        this.loaipin = loaipin;
    }

    public int getDungluongpin() {
        return dungluongpin;
    }

    public void setDungluongpin(int dungluongpin) {
        this.dungluongpin = dungluongpin;
    }
    public void Nhap()
    {
        System.out.print("Nhập mã chi tiết sản phẩm :");
        this.ma=new Scanner(System.in).nextInt();
        System.out.print("Nhập mã sản phẩm :");
        this.masp=new Scanner(System.in).nextInt();
        System.out.print("Nhập bộ nhớ (Gb) :");
        this.bonho=new Scanner(System.in).nextInt();
        System.out.print("Nhập dung lượng pin (mAh):");
        this.dungluongpin=new Scanner(System.in).nextInt();
        System.out.print("Hỗ trợ camera ? true/false: ");
        this.camera=new Scanner(System.in).nextBoolean();
        System.out.print("Hỗ trợ Bluetooth ? true/false: ");
        this.bluetooth=new Scanner(System.in).nextBoolean();
        System.out.print("Hỗ trợ Flash ? true/false:");
        this.flash=new Scanner(System.in).nextBoolean();
        System.out.print("Nhập độ phân giải(pixel) :");
        this.dophangiai=new Scanner(System.in).nextLine();
        System.out.print("Nhập cổng sạc :");
        this.congsac=new Scanner(System.in).nextLine();
        System.out.print("Nhập loaại pin :");
        this.loaipin=new Scanner(System.in).nextLine();
    }
    public void Xuat()
    {

        System.out.println("Mã chi tiết sản phẩm :"+ma);
        System.out.println("Mã san phẩm : "+masp);
        System.out.println("Camera : "+camera);
        System.out.println("Flash : "+flash);
        System.out.println("Bluetooth : "+bluetooth);
        System.out.println("Bộ nhớ : "+bonho+" Gb");
        System.out.println("Dung lượng pin : "+dungluongpin+" mAh");
        System.out.println("Dộ phân giải : "+dophangiai+" pixel");
        System.out.println("Cổng sạc : "+congsac);
        System.out.println("Loại pin : "+loaipin);

    }
    public void Sua()
    {
        Scanner sc=new Scanner(System.in);
        String tr="";
        System.out.println("Nhập mã chi sản phẩm (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.ma=Integer.parseInt(tr);tr="";}
        System.out.println("Nhập mã sản phẩm (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.masp=Integer.parseInt(tr);tr="";}
        System.out.println("Nhập bộ nhớ (enter để lấy dữ liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.bonho=Integer.parseInt(tr);tr="";}
        System.out.println("Nhập dung lượng pin (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.dungluongpin=Integer.parseInt(tr);tr="";}
        System.out.println("Hỗ trợ camera true/false ? (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.camera=Boolean.parseBoolean(tr);tr="";}
        System.out.println("Hỗ tr Bluetooth ? (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.bluetooth=Boolean.parseBoolean(tr);tr="";}
        System.out.println("Hỗ trợ Flash ? (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.flash=Boolean.parseBoolean(tr);tr="";}
        System.out.print("Nhập độ phân giải (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.dophangiai=tr;tr="";}
        System.out.println("Nhập cổng sạc (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.congsac=tr;tr="";}
        System.out.println("Nập loại pin (enter để lấy dưc liệu cũ):");
        tr=sc.nextLine();
        if(!tr.isEmpty()){this.loaipin=tr;}
    }
}
