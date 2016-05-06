package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Perusahaan extends Owner{
    
    private ArrayList<Lowongan> daftarLowongan;

//    public boolean isi = false;
    private int nLowongan=0;
    private int max = 10;
	
    public Perusahaan (String id, String nama, String pass){
        super(id, nama, pass);
    }
        
    public void createLowongan(String nmLowongan, Date deadline, int max1, int max2){
        daftarLowongan.add(new Lowongan(nmLowongan, deadline, max1, max2));
        nLowongan = daftarLowongan.size();
    }
    
    public ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }
    
    public Lowongan getLowongan(int n) {
        return daftarLowongan.get(n);
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
        return 0;
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

//   public void terimaPelamar(int idLowongan, int idPelamar){}
//   public void cekPassword (String password){}


}
