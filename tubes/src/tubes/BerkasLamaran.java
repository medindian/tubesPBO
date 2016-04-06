package tubes;
import java.util.Date;

public class BerkasLamaran{
    private String tglDibuat,CV, SLK,tempat, nama, alamat, noTelp, email,website;
    private String tglLahir; //format DD MMM YYYY
    
    //setter
    public void setTglDibuat(String tgl){
        this.tglDibuat = tgl; }
   
    public void setCV(String CV){
        this.CV = CV; }
    
    public void setSLK(String SLK){
        this.SLK = SLK; }
    
    public void setTempat(String tempat){
        this.tempat = tempat; }
    
    public void setTglLahir(String tglLahir){
        this.tglLahir = tglLahir; }
    
    public void setNama(String nama){
        this.nama = nama; }
    
    public void setAlamat(String alamat){
        this.alamat = alamat; }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp; }
    
    public void setEmail(String email){
        this.email = email; }
    
    public void setWebsite(String website){
        this.website = website; }

    //getter
    public String getTglDibuat(){
        return tglDibuat; }
   
    public String getCV(){
        return CV; }
    
    public String getSLK(){
        return SLK; }
    
    public String getTempat(){
        return tempat; }
    
    public String getTglLahir(){
        return tglLahir; }
    
    public String getNama(){
        return nama;    }
    
    public String getAlamat(){
        return alamat;  }
    
    public String getNoTelp(){
        return noTelp;  }
    
    public String getEmail(){
        return email;   }
    
    public String getWebsite(){
        return website;     }
    
    public void viewBerkasLamaran(){
        System.out.println("Isi Berkas Lamaran : ");
        System.out.println("    Nama     : "+getNama());
        System.out.println("    Alamat   : "+getAlamat());
        System.out.println("    tglLahir : "+getTglLahir());
        System.out.println("    noTelp   : "+getNoTelp());
        System.out.println("    Email    : "+getEmail());
        System.out.println("    Webite   : "+getWebsite());
        System.out.println("    CV       : "+getCV());
        System.out.println("    SLK      : "+getSLK());
    }
    
    public String toString(){
        System.out.println("Isi Berkas Lamaran : ");
        return ("    Nama     : "+getNama()+
                "\n    Alamat   : "+getAlamat()+
                "\n    tglLahir : "+getTglLahir()+
                "\n    noTelp   : "+getNoTelp()+
                "\n    Email    : "+getEmail()+
                "\n    Webite   : "+getWebsite()+
                "\n    CV       : "+getCV()+
                "\n    SLK      : "+getSLK());
    }
    
}
