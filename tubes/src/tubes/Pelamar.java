package tubes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pelamar extends Orang{
    private BerkasLamaran berkas;
    public int noPelamar=0;
    private String tempat;
    private Date tglLahir;
    private String password;
    public boolean statBerkas = false;
//    private boolean statusDiterima=false;
    
    public Pelamar(String nama,String alamat,String noTelp,String email,String website){
        super(nama,alamat,noTelp,email,website);    }
    
    public void setPassword(String password){
        this.password = password;     }
    
    public void setTempat(String tempat){
        this.tempat = tempat;     }
    
    public void setTglLahir(Date tglLahir){
        this.tglLahir = tglLahir;     }
    
    public String getPassword(){
        return password;    }
    
    public String getTempat(){
        return tempat;  }
    
    public Date getTglLahir(){
        return tglLahir;    }
    
    public BerkasLamaran getBerkas(){
        return berkas;  }
    
    //public getNoPel(){}
    
    public void createBerkas() throws ParseException{
        berkas = new BerkasLamaran();
        //sementara
        berkas.setCV("Heloo World, my name is ");
        berkas.setSLK("Saya ingin melamar menjadi superman");
        
        //fix
        berkas.setNama(getNama());
        berkas.setAlamat(getAlamat());        
        berkas.setNoTelp(getNoTelp());
        berkas.setEmail(getEmail());
        berkas.setWebsite(getWebsite());
        SimpleDateFormat ft = new SimpleDateFormat("dd MMM yy");
        
        //sementara
        Date tgl = ft.parse("25 Apr 16");
        
        //fix
        berkas.setTglDibuat(tgl);
        statBerkas = true;
    }
}
