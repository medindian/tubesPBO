package model;
import java.util.Date;

public class BerkasLamaran{
    private String fileCV, fileSLK;
    
    public BerkasLamaran( String cv, String slk){
//        this.idAkun = idAkun;
        this.fileCV = cv;
        this.fileSLK = slk;
    }
    
//    public void setIdAkun(String idAkun){
//        this.idAkun = idAkun;   }
    
    public void setFileCV(String CV){
        this.fileCV = CV; }
    
    public void setFileSLK(String SLK){
        this.fileSLK = SLK; }
    
//    public String getIdAkun(){
//        return idAkun;  }
    
    public String getFileCV(){
        return fileCV; }
    
    public String getFileSLK(){
        return fileSLK; }
    
    public void viewBerkas(){
//        System.out.println("    id Akun    : "+idAkun);
        System.out.println("  Nama file CV   : "+fileCV);
        System.out.println("  Nama file SLK  : "+fileSLK);
    }
    
    @Override
    public String toString(){
        return ("  file CV    : "+fileCV +"\n  file SLK    : "+fileSLK);
    }
    
}
