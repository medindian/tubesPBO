package model;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Perusahaan extends Owner{
    
    private ArrayList<Lowongan> daftarLowonganP;
    private int nLowongan=0;
	
    public Perusahaan (int id, String nama, String pass){
        super(id, nama, pass);
        daftarLowonganP = new ArrayList<>();
    }
        
    public void createLowongan(int id, String nmLowongan, Date deadline){
        Lowongan l = new Lowongan(id, nmLowongan, deadline);
        daftarLowonganP.add(l);
        nLowongan = daftarLowonganP.size();
    }
    
    public Lowongan getLowongan(int id) {
        for(int i=0; i < nLowongan; i++){
            Lowongan l = daftarLowonganP.get(i);
            if (l.getId() == id)
                return l;
        }
        return null;
    }
    
    //mencari ada tidaknya data lowongan pada suatu perusahaan
    public int cariLowonganById(int n) {
        for (int i=0; i < nLowongan; i++){
            Lowongan w = daftarLowonganP.get(i);
            if (w.getId() == n)
                return i;
        }
        return -1;
    }
    
    //mencari nama lowongan yg ada pada suatu perusahaan
    public boolean cariLowonganByName(String nama) {
        for(int i=0; i < nLowongan; i++){
            Lowongan l = daftarLowonganP.get(i);
            if (l.getNamaPkrj() == nama)
                return true;
        }
        return false;
    }
    
    //mencari array dari id lowongan suatu perusahaan
    public int cariArLowongan(int id) {
        for(int i=0; i < nLowongan; i++){
            Lowongan l = daftarLowonganP.get(i);
            if (l.getId() == id)
                return i;
        }
        return -1;
    }
    
    public int updateDataLowongan(int id, String nm, Date deadline){
        int ar = cariArLowongan(id);
        Lowongan l = daftarLowonganP.get(ar);
        l.setNamaPkrj(nm);
        l.setDeadline(deadline);
        if (l.getNamaPkrj().equals(nm) && l.getDeadline().equals(deadline))
            return 1;
        return -1;
    }
    
    public ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowonganP;
    }
    
    @Override
    public String toString(){
        return ("Nama          :"+super.getNama());   }
    
    public void viewLowongan(){
        for (int i = 0; i < nLowongan; i++) {
//                daftarLowongan.get(i);
                System.out.println();
            }
    }
    
    //id mulai dari 1
    public void removeLowongan(int id){
        int find = cariArLowongan(id);
        if (find == 0) {
            System.out.println("Data Lowongan Pekerjaan tidak ada");
        } else {
            daftarLowonganP.remove(find);
            nLowongan = daftarLowonganP.size();
        }
    }

   public void terimaPelamar(int id, int idPelamar){
        int ada = cariArLowongan(id);
        if (ada == -1){
           System.out.println("Lowongan yang anda cari tidak ada");
        } 
//        else {   
//           daftarLowongan.get(ada).addBerkasDiterima(b);
//       }
   }

}
