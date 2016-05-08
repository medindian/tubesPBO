package model;
import java.util.Date;

public class BerkasLamaran{
    private String idAkun, CV, SLK;
    
    public BerkasLamaran(String idAkun, String cv, String slk){
        this.idAkun = idAkun;
        this.CV = cv;
        this.SLK = slk;
    }
    
    public void setIdAkun(String idAkun){
        this.idAkun = idAkun;   }
    
    public void setCV(String CV){
        this.CV = CV; }
    
    public void setSLK(String SLK){
        this.SLK = SLK; }
    
    public String getIdAkun(){
        return idAkun;  }
    
    public String getCV(){
        return CV; }
    
    public String getSLK(){
        return SLK; }
    
    public void viewBerkas(){
        System.out.println("    id Akun    : "+getIdAkun());
        System.out.println("      CV       : "+getCV());
        System.out.println("      SLK      : "+getSLK());
    }
    
    @Override
    public String toString(){
        return ("    id Akun    : "+getIdAkun());
    }
    
}
