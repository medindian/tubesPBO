package model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pelamar extends Orang{
    private BerkasLamaran berkas;
    private String gender;
    private String tglLahir; //DD MMM YYYY
    private String password;
    public boolean statBerkas = false;
    public int noPelamar=0;
//    private boolean statusDiterima=false;
    
    public Pelamar(String nama,String alamat,String noTelp,String email,String website){
        super(nama,alamat,noTelp,email,website);    }
    
    public void setPassword(String password){
        this.password = password;     }
    
    public void setGender(String gender){
        this.gender = gender;     }
    
    //String tglLahir
    public void setTglLahir(String tglLahir){
        this.tglLahir = tglLahir;     }
    
    public String getPassword(){
        return password;    }
    
    public String getGender(){
        return gender;  }
    
    public String getTglLahir(){
        return tglLahir;    }
    
    public BerkasLamaran getBerkas(){
        return berkas;  }
/* 
    public void printBiodata(){
        System.out.println("Biodata :   ");
        System.out.println("Nama                    :"+getNama());
        System.out.println("Tempat, tanggal lahir   : "+getTempat()
                            +", "+getTglLahir());
        System.out.println("Alamat                  : "+getAlamat());
        System.out.println("Nomor Telepon           : "+getNoTelp());
        System.out.println("Email                   : "+getEmail());
        System.out.println("Website                 : "+getWebsite());  }
*/    
    
    //tglBuat: DD MMM YY
    public String toString(){
        System.out.println("Biodata :   ");
        return ("Nama                    :"+getNama()+
                "Jenis Kelamin           :"+getGender()+
                "Tanggal lahir           : "+getTglLahir()+
                "Alamat                  : "+getAlamat()+
                "Nomor Telepon           : "+getNoTelp()+
                "Email                   : "+getEmail()+
                "Website                 : "+getWebsite()+
                "Isi Berkas              : "+berkas.toString());
    }
    
    public void createBerkas(String isiCV, String isiSLK){
        berkas = new BerkasLamaran();
        berkas.setCV(isiCV);
        berkas.setSLK(isiSLK);
        berkas.setNama(getNama());
        berkas.setAlamat(getAlamat());        
        berkas.setNoTelp(getNoTelp());
        berkas.setEmail(getEmail());
        berkas.setWebsite(getWebsite());
        SimpleDateFormat ft = new SimpleDateFormat("dd MMM yy");
        
        //untuk tgl dibuatnya berkas
        Date tgl = new Date();
        DateFormat fmt = new SimpleDateFormat("DD MM YY");
        String tglDibuat = fmt.format(tgl);
        berkas.setTglDibuat(tglDibuat);
        statBerkas = true;
    }
}
