package model;

public class Pelamar extends Owner{
    private BerkasLamaran berkas;
    private boolean statusDiterima = false;
    
    public Pelamar(int id, String nama, String pass){
        super(id, nama, pass);
    }
    
    public BerkasLamaran getBerkas(){
        return berkas;  }
    
    public boolean getStatus(){
        return statusDiterima;      }
        
    public void createBerkas(String cv, String slk){
        berkas = new BerkasLamaran(cv, slk);
//        berkas.setCV(isiCV);
//        berkas.setSLK(isiSLK);
    }
    
    public void updateBerkas(String cv, String slk){
        berkas.setFileCV(cv);
        berkas.setFileSLK(slk);
    }
    
    @Override
    public String toString(){
        return (" Nama  :"+getNama() + "(" + getIdAkun() + ")");
    }
    
}
