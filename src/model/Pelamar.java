package model;

public class Pelamar extends Owner{
    private BerkasLamaran berkas;
    private boolean statBerkas = false;
    private boolean statusDiterima = false;
    
    public Pelamar(String id, String nama, String pass){
        super(id, nama, pass);
    }
    
    public BerkasLamaran getBerkas(){
        return berkas;  }
    
    public boolean getStatus(){
        return statusDiterima;      }
    
    public String toString(){
        return (" Nama  :"+getNama() + "(" + getIdAkun() + ")");
    }
    
    public void createBerkas(String isiCV, String isiSLK){
        berkas = new BerkasLamaran(getIdAkun(), isiCV, isiSLK);
        berkas.setCV(isiCV);
        berkas.setSLK(isiSLK);
        statBerkas = true;
    }
}
