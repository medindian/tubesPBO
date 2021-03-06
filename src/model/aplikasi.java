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
    
    //mencari id lowongan dari setiap perusahaan
    public boolean cariLowongan1(int id){
        for (int i = 0; i < nLowongan ; i++) {
            Lowongan l = (Lowongan) daftarLowongan.get(i);
            if (l.getId() == id)
                return true;
        }
        return false;
    }
    
    //untuk mencari nama lowongan dari satu perusahaan
//    public boolean cariLowongan2(Perusahaan p, String nama){
//        System.out.println("isempty? : " + (p.getDaftarLowongan()).isEmpty() );
//        if ( !(p.getDaftarLowongan()).isEmpty() ) {
//            for(int i = 0; i < p.getDaftarLowongan().size(); i++){
//                Lowongan w = p.getLowongan(i);
//                if (w.getNamaPkrj().equals(nama))
//                    return true;
//            }
//        }
//        return false;
//    }
    
    public int addLowongan(Perusahaan p, int id, String nama, Date deadline){
        if(cekAngka(nama) == false){
            if(cariLowongan1(id) == false){
                if (p.cariLowonganByName(nama) == true)
                    System.out.println("lowongan dengan nama "+nama+" sudah terdaftar");
                else {
                    p.createLowongan(id, nama, deadline);
                    Lowongan l = p.getLowongan(id);
                    int date = deadline.getDate();
                    int month = deadline.getMonth();
                    int year = deadline.getYear();                    
                    java.sql.Date datesql = new java.sql.Date(year, month, date);
                    int hasil = db.saveLowongan(p, l, datesql);
                    System.out.println("hasil : "+hasil);
                    if (hasil == 1)
                        return 1;
                }
            } else if (cariLowongan1(id) == true){
                if (p.cariLowonganById(id) != -1){
                    p.updateDataLowongan(id, nama, deadline);
                    Lowongan l = p.getLowongan(id);
                    int date = deadline.getDate();
                    int month = deadline.getMonth();
                    int year = deadline.getYear();                    
                    java.sql.Date datesql = new java.sql.Date(year, month, date);
                    int hasil = db.updateLowongan(p, l, datesql);
                    if (hasil == 1)
                        return 2;
                } else System.out.println("Id sudah digunakan");
            }
        } else System.out.println("Nama hanya boleh HURUF saja");
        return -1;
    }
    
//kalo true, update dataLowongan
//                if (p.getLowongan(id) != null){
//                    p.updateDataLowongan(id, nama, deadline);
//                System.out.println("id lowongan : " + l.getId());
//                System.out.println("nama lowongan : " + l.getNamaPkrj());
//                System.out.println("deadline ; " + l.getDeadline());
//                    Lowongan l = p.getLowongan(id);
//                    int hasil = db.updateLowongan(p, l);
//                    if (hasil == 1)
//                        return 1;
//                //kalo false, muncul notif id sudah digunakan
//                } else
//                    System.out.println("id sudah ada yang menggunakan");
//            }


    public int deleteLowongan(Perusahaan p, int id, String nama){
//        if (cariLowongan1(id) == true && cariLowongan2(p,nama) == true){
//            p.removeLowongan(nama);
//            db.deleteLowongan(p, nama);
//            return 1;
//        } else System.out.println("Lowongan tidak ada");
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
