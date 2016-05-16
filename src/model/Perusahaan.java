package model;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Perusahaan extends Owner{
    
    private ArrayList<Lowongan> daftarLowongan;
    private int nLowongan=0;
	
    public Perusahaan (int id, String nama, String pass){
        super(id, nama, pass);
        daftarLowongan = null;
    }
        
    public void createLowongan(int id, String nmLowongan, Date deadline){
        daftarLowongan.add(new Lowongan(id, nmLowongan, deadline));
        nLowongan = daftarLowongan.size();
    }
        
    public ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }
    
    public Lowongan getLowongan(int n) {
        for (int i=0; i < nLowongan; i++){
            Lowongan w = daftarLowongan.get(i);
            if (w.getId() == n)
                return w;
        }
        return null;
    }
    
    @Override
    public String toString(){
        return ("Nama          :"+super.getNama());        }
    
    public void viewLowongan(){
        for (int i = 0; i < nLowongan; i++) {
//                daftarLowongan.get(i);
                System.out.println();
            }
    }
    
    public int cariLowongan(String namaLowongan) {
        for(Lowongan l : daftarLowongan){
            if (l.getNamaPkrj().equals(namaLowongan))
                return daftarLowongan.indexOf(l);
        }
        return -1;
    }
    
    //id mulai dari 1
    public void removeLowongan(String namaLowongan){
        int find = cariLowongan(namaLowongan);
        if (find == 0) {
            System.out.println("Data Lowongan Pekerjaan tidak ada");
        } else {
            daftarLowongan.remove(find);
            nLowongan = daftarLowongan.size();
        }
    }

   public void terimaPelamar(String namaLowongan, int idPelamar){
        int ada = cariLowongan(namaLowongan);
        if (ada == -1){
           System.out.println("Lowongan yang anda cari tidak ada");
        } 
//        else {   
//           daftarLowongan.get(ada).addBerkasDiterima(b);
//       }
   }

}
