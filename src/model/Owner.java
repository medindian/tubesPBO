package model;

public abstract class Owner{

    private String idAkun, nama, password;
	
    public Owner(String idAkun, String nama, String pass){
        this.idAkun = idAkun;
        this.nama = nama;
        this.password = pass;
    }
	
    public void setIdAkun(String idAkun){
        this.idAkun = idAkun;   }
    
    public void setNama(String nama){
        this.nama = nama;   }

    public String getIdAkun() {
        return idAkun;    }

    public String getNama(){
        return nama;    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    abstract public String toString();
}

