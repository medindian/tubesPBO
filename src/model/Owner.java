package model;

public abstract class Owner{

    private int idAkun;
    private String nama, password;
	
    public Owner(int idAkun, String nama, String pass){
        this.idAkun = idAkun;
        this.nama = nama;
        this.password = pass;
    }
	
    public void setIdAkun(int idAkun){
        this.idAkun = idAkun;   }
    
    public void setNama(String nama){
        this.nama = nama;   }

    public int getIdAkun() {
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

