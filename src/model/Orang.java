package model;

public abstract class Orang{

    private String idAkun;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private String website;
	
    public Orang (String idAkun, String nama, String alamat, String noTelp, String email, String website){
        this.idAkun = idAkun;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.website = website;     }
	
    public void setIdAkun(String idAkun){
        this.idAkun = idAkun;   }
    
    public void setNama(String nama){
        this.nama = nama;   }
	
    public void setAlamat(String alamat){
        this.alamat = alamat;   }
	
    public void setNoTelp(String telp){
        this.noTelp = noTelp;   }
	
    public void setEmail(String email){
        this.email = email;     }
	
    public void setWebsite(String website){
        this.website = website;     }

    public String getIdAkun() {
        return idAkun;    }

    public String getNama(){
        return nama;    }
	
    public String getEmail(){
        return email;   }
	
    public String getAlamat(){
        return alamat;	}
	
    public String getNoTelp(){
        return noTelp;	}
	
    public String getWebsite (){
        return website; }
    
    @Override
    abstract public String toString();
}

