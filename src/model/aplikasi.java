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
    public boolean cariOwner(String idAkun){
        for (int i = 0; i < nOwner; i++) {
            Owner p = (Owner) daftarOwner.get(i);
            if (p.getIdAkun().equals(idAkun)) {
                return true;    }
            }
        return false;
    }
    
    public Owner cariAkun(String idAkun, String nama){
        for (int i = 0; i < nOwner; i++) {
            Owner p = (Owner) daftarOwner.get(i);
            if ((p.getIdAkun()).equals(idAkun)) {
                if ((p.getNama()).equals(nama)){
//                    System.out.println("array ke-"+i);
                    return daftarOwner.get(i);
                }
            }
        }
        return null;
    }
    
    //untuk mendapat array dari idAkun Pelamar
    public int cariOwner2(String idAkun){
        for (int i = 0; i < nOwner; i++) {
            Owner p = (Owner) daftarOwner.get(i);
            if (p.getIdAkun().equals(idAkun))
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
    
    public int addPelamar(String idAkun, String nama, String pass){
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
            else  System.out.println("Sudah ada yang menggunakan id akun");
        }
        return hasil;
    }
    
    public int addPerusahaan(String idAkun, String nama, String pass){
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
                System.out.println("Sudah ada yang menggunakan id akun");
        }
        return hasil;
    }
    
    public int addLowongan(Perusahaan p, String nama, Date deadline){
        if (p.cariLowongan(nama) == -1){
            p.createLowongan(nama, deadline);
            db.saveLowongan(p.getIdAkun(), nama, deadline);
            return 1;
        } else System.out.println("Lowongan sudah tersedia");
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
//            System.out.println("true");
            if (!cekAngka(nama) && !cekTanda(nama)){
//                System.out.println("false, false");
//                String id = p.getIdAkun();
//                String pass = p.getPassword();
//                p.setNama(nama);
                p.setPassword(passBaru);
//                System.out.println("pass Lama : "+pass);
//                System.out.println("nama baru : "+p.getNama());
//                System.out.println("pass baru : "+p.getPassword());
                db.updatePerusahaan(p);
                return 1;
        } else 
            System.out.println("Nama hanya boleh diisi HURUF saja");
        }
        return -1;
    }
    
    public int ubahPelamar(Pelamar p, String nama, String passLama, String passBaru){
        if ((p.getPassword()).equals(passLama)){
            System.out.println("true");
            if (!cekAngka(nama) && !cekTanda(nama)){
                System.out.println("false, false");
                String id = p.getIdAkun();
                String pass = p.getPassword();
                p.setNama(nama);
                p.setPassword(passBaru);
                System.out.println("pass Lama : "+pass);
                System.out.println("nama baru : "+p.getNama());
                System.out.println("pass baru : "+p.getPassword());
                db.updatePelamar(p);
    //            if (a == 1)
                return 1;
        } else
            System.out.println("Nama hanya boleh diisi HURUF saja");
        }
        return -1;
    }
    
    public int checkLogin(String idAkun, String pass){
//        System.out.println("nOwner : "+ nOwner);
        for (int i = 0; i < nOwner; i++) {
//            System.out.println("i : "+ i);
            if ((daftarOwner.get(i).getIdAkun()).equals(idAkun)) {
                if ((daftarOwner.get(i).getPassword()).equals(pass)) {
                    return 1;   }
                else {
                    System.out.println("password salah");
                    return 2;   }
            }
        }
        return -1;
    }
    
    public Owner login(String idAkun, String pass){
        for (int i = 0; i < nOwner; i++) {
            if ((daftarOwner.get(i).getIdAkun()).equals(idAkun)) {
                if ((daftarOwner.get(i).getPassword()).equals(pass)) {
                    return daftarOwner.get(i);
                }
            } 
        }
        return null;
    }
    
    public void isPelamar(Owner p){
        if (p instanceof Pelamar)
            System.out.println("pelamar");
        else if (p instanceof Perusahaan)
            System.out.println("perusahaan");
    }
    
    //lupaPassword
    //String idAkun, String nama, String passBaru
    public boolean lupaPassPelamar(Owner p){
        Pelamar m = (Pelamar) p;
        int a = db.updatePassPelamar(m);
//        System.out.println("a : "+a);
        if (a == 1)
            return true;
        return false;
    }
    
    public boolean lupaPassPerusahaan(Owner p){
        Perusahaan h = (Perusahaan) p;
        int a = db.updatePassPerusahaan(h);
//        System.out.println("a : "+a);
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
    public String cariPekerjaan(String company){
        boolean ada = cariOwner(company);
        int ar = cariOwner2(company);
        if (ada == true && daftarOwner.get(ar) instanceof Perusahaan){
            String nmP = daftarOwner.get(ar).getNama();
        } else 
            System.out.println("Perusaaan yang anda cari tidak ada");
        return null;
    }

    public String cariPekerjaan2(String company, String lowong){
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
