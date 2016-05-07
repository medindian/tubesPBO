package model;

//import java.text.ParseException;
import database.Database;
import java.util.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String[] tanda = {"/", "[", "]", "{", "}", "+", "&", "#", "*", "!"};
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
                        db.savePelamar(p.getIdAkun(), p.getNama(), p.getPassword());
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
                        int a = db.savePerusahaan(q.getIdAkun(), q.getNama(), q.getPassword());
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
    
    public int ubahPerusahaan(Perusahaan p, String nama, String pass){
        if (!cekAngka(nama) && !cekTanda(nama)){
            p.setNama(nama);
            p.setPassword(pass);
            db.updatePerusahaan(p.getIdAkun(), nama, pass);
            return 1;
        } else 
            System.out.println("Nama hanya boleh diisi HURUF saja");
        return -1;
    }
    
    public int ubahPassPerusahaan(Perusahaan p, String passLama, String passBaru){
        if ((p.getPassword()).equals(passLama)){
            p.setPassword(passBaru);
            db.updatePassPelamar(p.getIdAkun(), passBaru);
            return 1;
        }
        return -1;
    }
    
    public int ubahPelamar(Pelamar p, String nama, String pass){
        if (!cekAngka(nama) && !cekTanda(nama)){
            p.setNama(nama);
            p.setPassword(pass);
            db.updatePelamar(p.getIdAkun(), nama, pass);
            return 1;
        } else
            System.out.println("Nama hanya boleh diisi HURUF saja");
        return -1;
    }
    
    public int ubahPassPelamar(Pelamar p, String passLama, String passBaru){
        if ((p.getPassword()).equals(passLama)){
            p.setPassword(passBaru);
            db.updatePassPerusahaan(p.getIdAkun(), passBaru);
            return 1;
        }
        return -1;
    }
    
    public Owner login(String idAkun, String pass){
        boolean access = false;
        for (int i = 0; i < nOwner; i++) {
            if ((daftarOwner.get(i).getIdAkun()).equals(idAkun)) {
                if ((daftarOwner.get(i).getPassword()).equals(pass)) {
                    return daftarOwner.get(i);
                }
            }
        }
        return null;
    }
        
    //lupaPassword
    public boolean lupaPassPelamar(String idAkun, String nama, String passBaru){
        boolean berhasil = false;
        int ar = cariOwner2(idAkun);
        Owner p = daftarOwner.get(ar);
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
        int ar = cariOwner2(idAkun);
        Owner p = daftarOwner.get(ar);
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
    public void buatBerkas(Pelamar p, String cv, String slk){
        p.createBerkas(cv, slk);
        db.saveBerkas(p.getIdAkun(), cv, slk);
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
