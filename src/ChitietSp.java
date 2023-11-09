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
        System.out.println("Nhap Ma");
        this.ma=new Scanner(System.in).nextInt();
        System.out.println("Nhap Ma Sp");
        this.masp=new Scanner(System.in).nextInt();
        System.out.println("Nhap Bo Nho");
        this.bonho=new Scanner(System.in).nextInt();
        System.out.println("Nhap Dung Luong Pin");
        this.dungluongpin=new Scanner(System.in).nextInt();
        System.out.println("Co Ho Tro Camera ? true/false ");
        this.camera=new Scanner(System.in).nextBoolean();
        System.out.println("Co Ho Tro Bluetooth ? true/false ");
        this.bluetooth=new Scanner(System.in).nextBoolean();
        System.out.println("Co Ho Tro Flash ? true/false");
        this.flash=new Scanner(System.in).nextBoolean();
        System.out.println("Nhap Do Phan Giai");
        this.dophangiai=new Scanner(System.in).nextLine();
        System.out.println("Nhap Cong Sac");
        this.congsac=new Scanner(System.in).nextLine();
        System.out.println("Nhap Loai Pin");
        this.loaipin=new Scanner(System.in).nextLine();
    }
    public void Xuat()
    {
        System.out.print("Ma Chi Tiet "+ma+"\t");
        System.out.print("Ma Sp : "+masp+"\t");
        System.out.print("Camera : "+camera+"\t");
        System.out.print("Flash : "+flash+"\t");
        System.out.print("Bluetooth : "+bluetooth+"\t");
        System.out.print("Bo nho : "+bonho+"\t");
        System.out.print("Dung luong pin : "+dungluongpin+"\t");
        System.out.print("Do phan giai : "+dophangiai+"\t");
        System.out.print("Cong sac : "+congsac+"\t");
        System.out.println("Loai pin : "+loaipin+"\t");

    }
    public void Sua()
    {
        Scanner sc=new Scanner(System.in);
        String tr="";
        int x=-1;
        System.out.println("Nhap Ma Sp (enter de bo qua) :");
        x=sc.nextInt();
        if(x!=-1){this.masp=x;x=-1;}
        System.out.println("Nhap Bo Nho (enter de bo qua) :");
        x=sc.nextInt();
        if(x!=-1){this.bonho=x;x=-1;}
        System.out.println("Nhap Dung Luong Pin (enter de bo qua) :");
        x=sc.nextInt();
        if(x!=-1){this.bonho=x;x=-1;}
        System.out.println("Co Ho Tro Camera true/false ? (enter de bo qua) :");
        if (new Scanner(System.in).hasNextBoolean()){this.camera=sc.nextBoolean();}
        System.out.println("Co Ho Tro Bluetooth ?");
        if (new Scanner(System.in).hasNextBoolean()){this.bluetooth=sc.nextBoolean();}
        System.out.println("Co Ho Tro Flash ?");
        if (new Scanner(System.in).hasNextBoolean()){this.flash=sc.nextBoolean();}
        System.out.println("Nhap Do Phan Giai");
        tr=sc.nextLine();
        if(tr.isEmpty()){this.dophangiai=tr;tr="";}
        System.out.println("Nhap Cong Sac");
        tr=sc.nextLine();
        if(tr.isEmpty()){this.congsac=tr;tr="";}
        System.out.println("Nhap Loai Pin");
        tr=sc.nextLine();
        if(tr.isEmpty()){this.loaipin=tr;}

    }
}
