package model;

import database.Database;
import java.io.FileNotFoundException;
import java.util.Date;
import java.sql.SQLException;
import java.util.*;

public class aplikasi{
//    public static void main(String[] args){

    private ArrayList<Owner> daftarOwner;
    private ArrayList<Lowongan> daftarLowongan;
    private Database db;
    private int nOwner = 0;
    private int nLowongan= 0;
    
    public aplikasi(){
        db = new Database();
        db.connect();
        daftarOwner = db.readDataOwner();
        daftarLowongan = db.readDataLowongan();
        this.nOwner = daftarOwner.size();
        this.nLowongan = daftarLowongan.size();
    }
        
    public ArrayList<Owner> listOwner(){
        return daftarOwner;
    }
    
    //untuk memeriksa idAkun Pelamar sudah dipakai atau belum
    public boolean cariOwner(int idAkun){
        for (int i = 0; i < nOwner; i++) {
            Owner p = (Owner) daftarOwner.get(i);
            if (p.getIdAkun() == idAkun) {
                return true;    }
            }
        return false;
    }
    
    public Owner cariAkun(int idAkun, String nama){
        for (int i = 0; i < nOwner; i++) {
            Owner p = (Owner) daftarOwner.get(i);
            if (p.getIdAkun() == idAkun) {
                if ((p.getNama()).equals(nama)){
                    return daftarOwner.get(i);
                }
            }
        }
        return null;
    }
    
    public ArrayList<String> getListPerusahaan(){
        return db.getListPerusahaan();
    }
    
    //untuk mendapat array dari idAkun Pelamar
    public int cariOwner2(int idAkun){
        for (int i = 0; i < nOwner; i++) {
            Owner p = (Owner) daftarOwner.get(i);
            if (p.getIdAkun() == idAkun)
                return i;
            }
        return -1;
    }
    
    public boolean cekAngka(String name){
        String[] angka = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String a : angka){
            if (name.contains(a))
                return true;
        }
        return false;
    }
    
    public boolean cekTanda(String name){
        String[] tanda = {"/", "[", "]", "{", "}", "+", "&", "#", "*", "!", "_", "-", "#"};
        for (String t : tanda){
            if (name.contains(t))
                return true;
        }
        return false;
    }
        
    public boolean cariNama(String nama){
        for(int i = 0; i < nOwner; i++){
            if (daftarOwner.get(i).getNama().equals(nama))
                return true;
        }
        return false;
    }
    
    public int checkLogin(int idAkun, String pass){
        for (int i = 0; i < nOwner; i++) {
            if ((daftarOwner.get(i).getIdAkun()) == idAkun) {
                if ((daftarOwner.get(i).getPassword()).equals(pass)) {
                    return 1;   }
                else {
                    System.out.println("password salah");
                    return 2;   }
            }
        }
        return -1;
    }
    
    public Owner login(int idAkun, String pass){
        for (int i = 0; i < nOwner; i++) {
            if ((daftarOwner.get(i).getIdAkun()) == idAkun) {
                if ((daftarOwner.get(i).getPassword()).equals(pass)) {
                    return daftarOwner.get(i);
                }
            } 
        }
        return null;
    }
    
    public int addPelamar(int idAkun, String nama, String pass){
        int hasil = -1;
        if (nOwner < 100){
            if (cariOwner(idAkun) == false){
                if(cariNama(nama) == false){
                    if (cekAngka(nama) == false && cekTanda(nama) == false){
                        Pelamar p = new Pelamar(idAkun, nama, pass);
                        daftarOwner.add(p);
                        db.savePelamar(p);
                        nOwner = daftarOwner.size();
                        System.out.println("Data berhasil disimpan");
                        hasil = 1;
                    }
                    else System.out.println("Nama hanya boleh HURUF saja");     
                }
                else System.out.println("Nama sudah dipakai");
            }
            else  System.out.println("Sudah ada yang menggunakan id yang sama");
        }
        return hasil;
    }
    
    public int addPerusahaan(int idAkun, String nama, String pass){
        int hasil = -1;
        if (nOwner < 100){           
            if (cariOwner(idAkun) == false) {
                if (cariNama(nama) == false){
                    if (cekAngka(nama) == false && cekTanda(nama) == false){
                        Perusahaan q = new Perusahaan(idAkun, nama, pass);
                        daftarOwner.add(q);
                        int a = db.savePerusahaan(q);
                        nOwner = daftarOwner.size();
                        System.out.println("Data berhasil disimpan");
                        hasil =  1;
                    } else
                        System.out.println("Nama hanya boleh HURUF saja");
                } else
                System.out.println("Nama sudah dipakai");
            } else
                System.out.println("Sudah ada yang menggunakan id yang sama");
        }
        return hasil;
    }
    
    public int addLowongan(Perusahaan p, int id, String nama, Date deadline){
        if (cekAngka(nama) == false){
            if (p.cariLowongan(nama) == -1){
                p.createLowongan(id, nama, deadline);
                Lowongan l = p.getLowongan(id);
                db.saveLowongan(p, l);

                System.out.println("id lowongan : " + l.getId());
                System.out.println("nama lowongan : " + l.getNamaPkrj());
                System.out.println("deadline ; " + l.getDeadline());

                return 1;
            } else System.out.println("Lowongan sudah tersedia");
        } else System.out.println("Nama hanya boleh HURUF saja");
        return -1;
    }
    
    public int deleteLowongan(Perusahaan p, String nama){
        if (p.cariLowongan(nama) == 1){
            p.removeLowongan(nama);
            db.deleteLowongan(p, nama);
            return 1;
        } else System.out.println("Lowongan tidak ada");
        return -1;
    }
    
    public int ubahPerusahaan(Perusahaan p, String nama, String passLama, String passBaru){
        if ((p.getPassword()).equals(passLama)){
            if (!cekAngka(nama) && !cekTanda(nama)){
                p.setNama(nama);
                p.setPassword(passBaru);
                db.updatePerusahaan(p);
                return 1;
            } else 
                System.out.println("Nama hanya boleh diisi HURUF saja");
        }
        return -1;
    }
    
    public int ubahPelamar(Pelamar p, String nama, String passLama, String passBaru){
        if ((p.getPassword()).equals(passLama)){
            if (!cekAngka(nama) && !cekTanda(nama)){
                p.setNama(nama);
                p.setPassword(passBaru);
                db.updatePelamar(p);
                return 1;
            } else
                System.out.println("Nama hanya boleh diisi HURUF saja");
        }
        return -1;
    }
    
    
//    public void isPelamar(Owner p){
//        if (p instanceof Pelamar)
//            System.out.println("pelamar");
//        else if (p instanceof Perusahaan)
//            System.out.println("perusahaan");
//    }
    
    //lupaPassword
    //String idAkun, String nama, String passBaru
    public boolean lupaPassPelamar(Pelamar p){
        int a = db.updatePassPelamar(p);
        if (a == 1)
            return true;
        return false;
    }
    
    public boolean lupaPassPerusahaan(Perusahaan p){
        int a = db.updatePassPerusahaan(p);
        if (a == 1)
            return true;
        return false;
    }

//        int ar = cariOwner2(idAkun);
//        Owner p = daftarOwner.get(ar);
//        if(p == null)
//            System.out.println("Akun tidak ada");
//        else {
////            if ((p.getNama()).equals(nama)){
////                p.setPassword(passBaru);
//                Perusahaan m = (Perusahaan) p;
//                System.out.println("pass dari owner : "+ p.getPassword());
//                System.out.println("pass dari obj pelamar : "+ m.getPassword());
//                int a = db.updatePassPelamar(p);
//                System.out.println("hasil proses : "+ a);
//                if (a == 1) {
//                    System.out.println("Data berhasil disimpan");
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    
    //String idAkun, String nama, String passBaru
//    public boolean lupaPassPerusahaan(Perusahaan p){
//        int ar = cariOwner2(idAkun);
//        Owner p = daftarOwner.get(ar);
//        if(p == null)
//            System.out.println("Akun tidak ada");
//        else {
//            if ((p.getNama()).equals(nama)){
//                p.setPassword(passBaru);
//                Perusahaan m = (Perusahaan) p;
//                System.out.println("pass dari owner : "+ p.getPassword());
//                System.out.println("pass dari obj pelamar : "+ m.getPassword());
//                int a = db.updatePassPerusahaan(p);
//                System.out.println("hasil proses : "+ a);
//                if (a == 1) {
//                    System.out.println("Data berhasil disimpan");
//                    return true;
////                }
////            }
//        }
//        return false;
//    }
    
    public int buatBerkas(Pelamar p, String cv, String slk) throws FileNotFoundException, SQLException{
        int proses;
        if (p.getBerkas() == null){
            p.createBerkas(cv, slk);
            System.out.println("p.getIdAkun() : "+p.getIdAkun());
            System.out.println("p.getBerkas().getFileCV() : "+p.getBerkas().getFileCV());
            System.out.println("p.getBerkas().getFileSLK() : "+p.getBerkas().getFileSLK());
            
            proses = db.saveBerkas(p);
            System.out.println("proses : "+proses);
            
        } else {
            System.out.println("Sebelum : ");
            System.out.println("p.getIdAkun() : "+p.getIdAkun());
            System.out.println("p.getBerkas().getFileCV() : "+p.getBerkas().getFileCV());
            System.out.println("p.getBerkas().getFileSLK() : "+p.getBerkas().getFileSLK());
            
            p.updateBerkas(cv, slk);
            System.out.println("Sesudah : ");
            System.out.println("p.getIdAkun() : "+p.getIdAkun());
            System.out.println("p.getBerkas().getFileCV() : "+p.getBerkas().getFileCV());
            System.out.println("p.getBerkas().getFileSLK() : "+p.getBerkas().getFileSLK());
            
            proses = db.updateBerkas(p);
            System.out.println("proses : "+proses);
        }
        if (proses != -1)
            return 1;
        return -1;
    }
    //viewBerkas
    public void viewBerkas(Pelamar p){
        p.getBerkas().viewBerkas();
    }
    
    //lowongan
    public String cariPekerjaan(int company){
        boolean ada = cariOwner(company);
        int ar = cariOwner2(company);
        if (ada == true && daftarOwner.get(ar) instanceof Perusahaan){
            String nmP = daftarOwner.get(ar).getNama();
        } else 
            System.out.println("Perusaaan yang anda cari tidak ada");
        return null;
    }

    public String cariPekerjaan2(int company, String lowong){
        boolean ada = cariOwner(company);
        int ar = cariOwner2(company);
        if (ada == true && daftarOwner.get(ar) instanceof Perusahaan){
//            if(p.getNama().equals(nama)){
//                for(int j = 0; j < p.getDaftarLowongan().size(); j++){
//                    if(p.getLowongan(j).getNamaPkrj().equals(lowong)){
//                        return p.getLowongan(j).viewLowongan();
//                    }
//                }
//            }
        }
        return null;
    }
                  
}
