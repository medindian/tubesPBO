package model;

//import java.text.ParseException;
import database.Database;
import java.util.Date;
//import database.DatabaseConnection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pelamar;

public class aplikasi{
//    public static void main(String[] args){

    public ArrayList<Pelamar> daftarPelamar;
    public ArrayList<Perusahaan> daftarPerusahaan;
    public Database db;
    public int nPrsh = 0;
    public int nPelamar = 0;
    
    public aplikasi(){
        db = new Database();
        db.connect();
        daftarPelamar = db.readDataPelamar();
        daftarPerusahaan = db.readDataPerusahaan();
        this.nPelamar = daftarPelamar.size();
        this.nPrsh = daftarPerusahaan.size();
    }
    
    public int nPelamar(){
        return nPelamar = daftarPelamar.size();
    }
    
    public int nPrsh(){
        return nPrsh = daftarPerusahaan.size();
    }
    
    public Database getDB(){
        return db;
    }
    
    public ArrayList<Pelamar> listPelamar(){
        return daftarPelamar;
    }
    
    public ArrayList<Perusahaan> listPerusahaan(){
        return daftarPerusahaan;
    }
    
    //untuk memeriksa idAkun Pelamar sudah dipakai atau belum
    public boolean getPelamar(String idAkun){
        for (int i = 0; i < nPelamar; i++) {
            Pelamar p = (Pelamar) daftarPelamar.get(i);
            if (p.getIdAkun().equals(idAkun)) {
                return true;    }
            }
        return false;
    }
    
    //untuk mendapat array dari idAkun Pelamar
    public int getPelamar2(String idAkun){
        for (int i = 0; i < nPelamar; i++) {
            Pelamar p = (Pelamar) daftarPelamar.get(i);
            if (p.getIdAkun().equals(idAkun))
                return i;
            }
        return -1;
    }
    
    //untuk memeriksa idAkun perusahaan sudah terpakai atau belum
    public boolean getPerusahaan(String idAkun){
        for (int i = 0; i < nPrsh; i++) {
            Perusahaan p = daftarPerusahaan.get(i);
            if (p.getIdAkun().equals(idAkun)) {
                return true;    }
            }
        return false;
    }
    
    //untuk mengambil array idAkun perusahaan
    public int getPerusahaan2(String idAkun){
        int hasil = -1;
        for (int i = 0; i < nPrsh; i++){
            Perusahaan p = daftarPerusahaan.get(i);
            System.out.println("i : " + i);
            if (p.getIdAkun() == idAkun)
                hasil = i;   
        }
        return hasil;
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
        String[] tanda = {"/", "[", "]", "{", "}", "+", "&", "#", "*", "!"};
        for (String t : tanda){
            if (name.contains(t))
                return true;
        }
        return false;
    }
    
    public boolean cariNama(String nama){
        for(int i = 0; i < nPelamar; i++){
            if (daftarPelamar.get(i).getNama().equals(nama))
                return true;
        }
        return false;
    }
    
    public boolean cariNama2(String nama){
        for(int i = 0; i < nPrsh; i++){
            if (daftarPerusahaan.get(i).getNama().equals(nama))
                return true;
        }
        return false;
    }

    public int addPelamar(String idAkun, String nama, String pass){
        int hasil = -1;
        if (nPelamar < 100){
            if (getPelamar(idAkun) == false){
                if(cariNama(nama) == false){
                    if (cekAngka(nama) == false && cekTanda(nama) == false){
                        Pelamar p = new Pelamar(idAkun, nama, pass);
                        daftarPelamar.add(p);
                        db.savePelamar(p.getIdAkun(), p.getNama(), p.getPassword());
                        nPelamar = daftarPelamar.size();
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
        if (nPrsh < 100){
            if (getPerusahaan(idAkun) == false) {
                if (cariNama2(nama) == false){
                    if (cekAngka(nama) == false && cekTanda(nama) == false){
                        Perusahaan h = new Perusahaan(idAkun, nama, pass);
//                        System.out.println(h.getIdAkun() + " " + h.getNama() + " " + h.getPassword());                        
                        daftarPerusahaan.add(h);
                        int ar = getPerusahaan2(h.getIdAkun());
                        System.out.println("ar : "+ ar);
//                        int a = db.savePerusahaan(h.getIdAkun(), h.getNama(), h.getPassword());
//                        nPrsh = daftarPerusahaan.size();
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
    
    public void addLowongan(String idAkun, String nama, Date deadline){
        int ar = getPerusahaan2(idAkun);
        Perusahaan p = daftarPerusahaan.get(ar);
        if (p != null){
            for(int i = 0; i < p.getDaftarLowongan().size(); i++){
                if (!(p.getDaftarLowongan().get(i).getNamaPkrj().equals(nama))){
                    p.createLowongan(nama, deadline);
                    db.saveLowongan(idAkun, nama, deadline);
                } else System.out.println("Lowongan sudah tersedia");
            }
        }
    }
    
    public void ubahPerusahaan(String idAkun, String nama, String pass){
        int ar = getPerusahaan2(idAkun);
        Perusahaan p = daftarPerusahaan.get(ar);
        if (!cekAngka(nama) && !cekTanda(nama)){
            p.setIdAkun(idAkun);
            p.setNama(nama);
            p.setPassword(pass);
        } else 
            System.out.println("Nama hanya boleh diisi HURUF saja");
    }
    
    public void ubahPelamar(String idAkun, String nama, String pass){
        int ar = getPelamar2(idAkun);
        Pelamar p = daftarPelamar.get(ar);
        if (!cekAngka(nama) && !cekTanda(nama)){
            p.setIdAkun(idAkun);
            p.setNama(nama);
            p.setPassword(pass);
        } else 
            System.out.println("Nama hanya boleh diisi HURUF saja");
    }
    
    public Perusahaan loginPerusahaan(String id, String pass){
//        boolean log = false;
        int i = 0;
        while (i < nPrsh) {
            if (daftarPerusahaan.get(i).getIdAkun().equals(id)) {
                if (daftarPerusahaan.get(i).getPassword().equals(pass)) {
                    return daftarPerusahaan.get(i); }
            }
            i++;
        }
        return null;
    }
    
    public Pelamar loginPelamar(String id, String pass){
        int i = 0;
        while (i < nPelamar) {
            if (daftarPelamar.get(i).getIdAkun().equals(id)) {
                if (daftarPelamar.get(i).getPassword().equals(pass)) {
                    return daftarPelamar.get(i);
                }
            }
            i++;
        }
        return null;
    }
    
    public void deletePerusahaan(String id){
        for (int i = 0; i < nPrsh; i++) {
            Perusahaan p = (Perusahaan) daftarPerusahaan.get(i);
            if (p.getIdAkun().equals(id)){
                daftarPerusahaan.remove(i);
                db.deletePerusahaan(id);
                nPrsh = daftarPerusahaan.size();
                break;
            }
        }
    }
    
    public void deletePelamar(String id){
        for (int i = 0; i < nPelamar; i++) {
            Pelamar p = (Pelamar) daftarPelamar.get(i);
            if (p.getIdAkun().equals(id)){
                daftarPelamar.remove(i);
                db.deletePelamar(id);
                nPelamar = daftarPelamar.size();
                break;
            }
        }
    }
    
    //lupaPassword
    public boolean lupaPassPelamar(String idAkun, String nama, String passBaru){
        boolean berhasil = false;
        int ar = getPelamar2(idAkun);
        Pelamar p = daftarPelamar.get(ar);
        if(p != null){
            if (p.getNama().equals(nama)){
                p.setPassword(passBaru);
                db.updatePassPelamar(idAkun, passBaru);
                berhasil = true;
            }
        }
        return berhasil;
    }
    
    public boolean lupaPassPerusahaan(String idAkun, String nama, String passBaru){
        boolean berhasil = false;
        int ar = getPerusahaan2(idAkun);
        Perusahaan p = daftarPerusahaan.get(ar);
        if(p != null){
            if (p.getNama().equals(nama)){
                p.setPassword(passBaru);
                db.updatePassPerusahaan(idAkun, passBaru);
                berhasil = true;
            }
        }
        return berhasil;
    }
    
    //berkas
    //buatBerkas
    public void buatBerkas(String idAkun, String cv, String slk){
        int ar = getPelamar2(idAkun);
        Pelamar p = daftarPelamar.get(ar);
        p.createBerkas(cv, slk);
        db.saveBerkas(idAkun, cv, slk);
    }
    //viewBerkas
    public void viewBerkas(String idAkun){
        int ar = getPelamar2(idAkun);
        Pelamar p = daftarPelamar.get(ar);
        p.getBerkas().viewBerkas();
    }
    
    //lowongan
    public String jobByPerusahaan(String nama){
        for(int i=0; i< nPrsh; i++){
            Perusahaan p = daftarPerusahaan.get(i);
            if(p.getNama().equals(nama)){
                return p.getDaftarLowongan().toString();
            }
        }
        return null;
    }

    public String cariPekerjaan(String nama, String lowong){
        for(int i=0; i< nPrsh; i++){
            Perusahaan p = daftarPerusahaan.get(i);
            if(p.getNama().equals(nama)){
                for(int j = 0; j < p.getDaftarLowongan().size(); j++){
                    if(p.getLowongan(j).getNamaPkrj().equals(lowong)){
                        return p.getLowongan(j).viewLowongan();
                    }
                }
            }
        }
        return null;
    }
                  
}
