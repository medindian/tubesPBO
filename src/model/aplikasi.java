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
    
    private ArrayList<Pelamar> daftarPelamar;
    private ArrayList<Perusahaan> daftarPerusahaan;
//    private ArrayList<Lowongan> daftarLowongan;
    private Database db;
    private int nPrsh = 0;
    private int nPelamar = 0;
//    private int nLowong = 0;
    
    public aplikasi(){
        db = new Database();
        db.connect();
//        nPelamar = daftarPelamar.size();
//        nPrsh = daftarPerusahaan.size();
    }
    
    public Pelamar getPelamar(String idAkun){
        for (int i = 0; i < nPelamar; i++) {
                Pelamar p = (Pelamar) daftarPelamar.get(i);
                if (p.getIdAkun().equals(idAkun)) {
                    return p;
                }
            }
        return null;
    }
    
    public Perusahaan getPerusahaan(String idAkun){
        for (int i = 0; i < nPrsh; i++) {
                Perusahaan p = (Perusahaan) daftarPerusahaan.get(i);
                if (p.getIdAkun().equals(idAkun)) {
                    return p;
                }
            }
        return null;
    }
    
//    public Lowongan getLowongan(String nama){
//        for (int i = 0; i < nLowong; i++) {
//                Lowongan w = (Lowongan) daftarLowongan.get(i);
//                if (w.getNamaPkrj().equals(nama)) {
//                    return w;
//                }
//            }
//        return null;
//    }
    
    public boolean cekAngka(String name){
        boolean hasil = true;
        String[] angka = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String a : angka){
            if (name.contains(a))
                hasil = false;
        }
        return hasil;
    }
    
    public boolean cekTanda(String name){
        boolean hasil = true;
        String[] tanda = {"/", "[", "]", "{", "}", "+", "&", "#", "*", "!"};
        for (String t : tanda){
            if (name.contains(t))
                hasil = false;
        }
        return hasil;
    }

    public int addPelamar(String idAkun, String nama, String pass){
        int hasil = 0;
        if (nPelamar < 100){
            if (getPelamar(idAkun) == null) {
                for(int i = 0; i < nPelamar; i++){
                    if (!daftarPelamar.get(i).getIdAkun().equals(nama)){
                        if (cekAngka(nama) == false && cekTanda(nama) == false){
                            Pelamar p = new Pelamar(idAkun, nama, pass);
                            daftarPelamar.add(p);
                            db.savePelamar(p.getIdAkun(), p.getNama(), p.getPassword());
                            nPelamar = daftarPelamar.size();
                            System.out.println("Data berhasil disimpan");
                            hasil = 1;
                        } else
                            System.out.println("Nama hanya boleh HURUF saja");
                    } else
                        System.out.println("Nama sudah dipakai");
                }
            } else 
                System.out.println("Sudah ada yang menggunakan id akun");
        }
        return hasil;
    }
    
    public int addPerusahaan(String idAkun, String nama, String pass){
        int hasil = 0;
        if (nPrsh < 100){
            if (getPerusahaan(idAkun) == null) {
                for(int i = 0; i < nPrsh; i++){
                    if (daftarPerusahaan.get(i).getNama().equals(nama)){
                        System.out.println("Nama sudah dipakai");
                    } else {
                        if (cekAngka(nama) == false && cekTanda(nama) == false){
                            Perusahaan p = new Perusahaan(idAkun, nama, pass);
                            daftarPerusahaan.add(p);
                            db.savePerusahaan(p.getIdAkun(), p.getNama(), p.getPassword());
                            nPrsh = daftarPerusahaan.size();
                            System.out.println("Data berhasil disimpan");
                            hasil = 1;
                        } else {
                            System.out.println("Nama hanya boleh HURUF saja");
                        }
                    }
                }
            } else {
                System.out.println("Sudah ada yang menggunakan id akun");
            }
        }
        return hasil;
    }
    
    public void addLowongan(String idAkun, String nama, Date deadline){
        Perusahaan p = getPerusahaan(idAkun);
        if (p != null){
            for(int i = 0; i < p.getDaftarLowongan().size(); i++){
                if (!p.getDaftarLowongan().get(i).getNamaPkrj().equals(nama)){
                    p.createLowongan(nama, deadline);
                    db.saveLowongan(idAkun, nama, deadline);
                }
            }
        }
    }
    
    public void ubahPerusahaan(String idAkun, String nama, String pass){
        Perusahaan p = getPerusahaan(idAkun);
        if (!cekAngka(nama) && !cekTanda(nama)){
            p.setIdAkun(idAkun);
            p.setNama(nama);
            p.setPassword(pass);
        } else 
            System.out.println("Nama hanya boleh diisi HURUF saja");
    }
    
    public void ubahPelamar(String idAkun, String nama, String pass){
        Pelamar p = getPelamar(idAkun);
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
        Pelamar p = getPelamar(idAkun);
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
        Perusahaan p = getPerusahaan(idAkun);
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
        Pelamar p = getPelamar(idAkun);
        p.createBerkas(cv, slk);
        db.saveBerkas(idAkun, cv, slk);
    }
    //viewBerkas
    public void viewBerkas(String idAkun){
        Pelamar p = getPelamar(idAkun);
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
