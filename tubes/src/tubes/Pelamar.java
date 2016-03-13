package tubes;
import java.util.Date;

public class Pelamar extends Orang{
    private BerkasLamaran berkas;
    public int noPelamar=0;
    private String tempat;
    private Date tglLahir;
    private String password;
//    private boolean statusDiterima=false;
    
    public Pelamar(String nama,String alamat,String noTelp,String email,String website){
        super(nama,alamat,noTelp,email,website);
    }
    
	public void setPassword(String password){
        this.password=password;
    }
    
	public void setTempat(String tempat){
        this.tempat=tempat;
    }
    
	public void setTglLahir(Date tglLahir){
        this.tglLahir=tglLahir;
    }
    
	public String getPassword(){
        return password;
    }
    
	public String getTempat(){
        return tempat;
    }
    
	public Date getTglLahir(){
        return tglLahir;
    }
    
	//public getNoPel(){}
    
    public void createBerkas(){
        if (noPelamar<20){
           berkas = new BerkasLamaran();
        }
    }
}
