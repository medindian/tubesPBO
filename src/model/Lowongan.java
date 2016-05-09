package model;

import java.util.ArrayList;
import java.util.Date;

public class Lowongan {
    
    private String namaPekerjaan;
    private Date deadline;
    private ArrayList<BerkasLamaran> berkasMasuk;
    private ArrayList<BerkasLamaran> berkasDiterima;
//    private int max1=0, max2=0;
    private int nBMasuk = 0;
    private int nBTerima = 0;
    
    public Lowongan(String nPk, Date dl){
        this.namaPekerjaan = nPk;
        this.deadline = dl;
//        this.max1 = max1;
//        this.max2 = max2;
    }

    public void setNamaPkrj(String nPk){
        this.namaPekerjaan = nPk;   }
    
    public void setDeadline(Date dl){
        this.deadline = dl;     }

    public String getNamaPkrj(){
        return namaPekerjaan;   }
    
    public Date getDeadline(){
        return deadline;    }
    
    public String viewLowongan(){
        return "Nama Lowongan : "+ namaPekerjaan +
                "Deadline      : "+ deadline.toString();
    }
    
    public ArrayList<BerkasLamaran> getBerkasMasuk(){
        return berkasMasuk;
    }
    
    public ArrayList<BerkasLamaran> getBerkasDiterima(){
        return berkasDiterima;
    }
    
//    public int cariBerkasMasuk(String idAkun){
//        for(int i = 0; i < nBMasuk; i++){
//            if(berkasMasuk.get(i).getIdAkun().equals(idAkun)){
//                return i;
//            }
//        }
//        return -1;
//    }
//    
//    public int cariBerkasDiterima(String idAkun){
//        for(int i = 0; i < nBTerima; i++){
//            if(berkasDiterima.get(i).getIdAkun().equals(idAkun)){
//                return i;
//            }
//        }
//        return -1;
//    }

    public BerkasLamaran getBerkasMasuk(int index){
        return berkasMasuk.get(index);
    }
    
    public BerkasLamaran getBerkasDiterima(int index){
        return berkasDiterima.get(index);
    }
    
    public void addBerkasMasuk(BerkasLamaran b){
//        int ada = cariBerkasMasuk(b.getIdAkun());
//        if (ada == -1){
//            System.out.println("Berkas tidak ada");
//        } else {
//            berkasMasuk.add(b);
//            nBMasuk = berkasMasuk.size();
//            max1 = max1 - nBMasuk;
//        }
    }
        
    public void addBerkasDiterima(BerkasLamaran b){
//        int ada = cariBerkasMasuk(b.getIdAkun());
//        if (ada != -1){
//            berkasDiterima.add(b);
//            nBTerima = berkasDiterima.size();
//            max2 = max2 - nBTerima;
//        } else
//            System.out.println("Berkas tidak ditemukan");
    }
    
    public void viewBerkasMasuk(){
        for (int i = 0; i < nBMasuk; i++) {
            berkasMasuk.get(i).viewBerkas();
            System.out.println("");
        }
    }

    public void viewBerkasTerima(){
        for (int i = 0; i < nBTerima; i++) {
            berkasDiterima.get(i).viewBerkas();
            System.out.println("");
        }
    }

    public void removeBerkasMasuk(String idAkun){
//        int ada = cariBerkasMasuk(idAkun);
//        if (ada == -1){
//            System.out.println("Berkas tidak ada");
//        } else {
//            BerkasLamaran bl = getBerkasMasuk(ada);
//            berkasMasuk.remove(bl);
//            nBMasuk = berkasMasuk.size();
////            max1 = max1 - nBMasuk;
//        }
    }
    
    public void removeBerkasDiterima(String idAkun){
//        int ada = cariBerkasMasuk(idAkun);
//        if (ada == -1){
//            System.out.println("Berkas tidak ada");
//        } else {
//            BerkasLamaran bl = getBerkasDiterima(ada);
//            berkasDiterima.remove(bl);
//            nBTerima = berkasDiterima.size();
//            max2 = max2 - nBTerima;
//        }
    }
    
}