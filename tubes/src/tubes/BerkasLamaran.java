package tubes;
import java.util.Date;

public class BerkasLamaran{
    private Date tglDibuat;
    private String CV;
    private String SLK;
    private String tempat;
    private Date tglLahir;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private String website;
    
    //setter
    public void setTglDibuat(Date tgl){
        this.tglDibuat = tgl; }
   
    public void setCV(String CV){
        this.CV = CV; }
    
    public void setSLK(String SLK){
        this.SLK = SLK; }
    
    public void setTempat(String tempat){
        this.tempat = tempat; }
    
    public void setTglLahir(Date tglLahir){
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
    public Date getTglDibuat(){
        return tglDibuat; }
   
    public String getCV(){
        return CV; }
    
    public String getSLK(){
        return SLK; }
    
    public String getTempat(){
        return tempat; }
    
    public Date getTglLahir(){
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
}
