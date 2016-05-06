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
    private Database db;
    int nPrsh = 0;
    int nPelamar = 0;
    
    public aplikasi(){
        db = new Database();
        db.connect();
        nPelamar = daftarPelamar.size();
        nPrsh = daftarPerusahaan.size();
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

    public void addPelamar(String idAkun, String nama, String pass){
        if (nPelamar < 100){
            if (getPelamar(idAkun) == null) {
                for(int i = 0; i < nPelamar; i++){
                    if (daftarPelamar.get(i).getIdAkun().equals(nama)){
                        System.out.println("Nama sudah dipakai");
                    } else {
                        if (cekAngka(nama) == false && cekTanda(nama) == false){
                            Pelamar p = new Pelamar(idAkun, nama, pass);
                            daftarPelamar.add(p);
                            db.savePelamar(p);
                            nPelamar = daftarPelamar.size();
                            System.out.println("Data berhasil disimpan");
                        } else {
                            System.out.println("Nama hanya boleh HURUF saja");
                        }
                    }
                }
            } else {
                System.out.println("Sudah ada yang menggunakan id akun");
            }
        }
    }
    
    public void addPerusahaan(String idAkun, String nama, String pass){
        if (nPrsh < 100){
            if (getPerusahaan(idAkun) == null) {
                for(int i = 0; i < nPrsh; i++){
                    if (daftarPerusahaan.get(i).getIdAkun().equals(nama)){
                        System.out.println("Nama sudah dipakai");
                    } else {
                        if (cekAngka(nama) == false && cekTanda(nama) == false){
                            Perusahaan p = new Perusahaan(idAkun, nama, pass);
                            daftarPerusahaan.add(p);
                            db.savePerusahaan(p);
                            nPrsh=daftarPerusahaan.size();
                            System.out.println("Data berhasil disimpan");
                        } else {
                            System.out.println("Nama hanya boleh HURUF saja");
                        }
                    }
                }
            } else {
                System.out.println("Sudah ada yang menggunakan id akun");
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
    
    public Perusahaan loginPerusahaan(String id, char[] pass){
        if (foundPerusahaan(id) == true){
            int i = findPerusahaan(id);
            if (daftarPerusahaan[i].getPassword()== pass){
                return daftarPerusahaan[i];}
        }
        return null;
    }
    
    public Pelamar loginPelamar(String id, char[] pass){
        if (foundPelamar(id) == true){
            int i = findPelamar(id);
            if (daftarPelamar[i].getPassword()== pass){
                return daftarPelamar[i]; }
        }
        return null;
    }
        
    public String daftarPerusahaan(){
//        con.getListIDPerusahaan();
        String list = "";
        for (int i=0; i < nPrsh; i++){
            int a = i+1;
            list = (a+". "+daftarPerusahaan[i].getIdAkun());
        }
        return list;
    }
    
    public int findPelamar(String idAkun){
        int ind = -1;
        for(int i = 0; i < daftarPelamar.length; i++){
            if (daftarPelamar[i].getIdAkun().equals(idAkun)){
                ind = i;    }    }
        return ind;    }
    
    public boolean foundPelamar(String idAkun){
        boolean ketemu = false;
        for (Pelamar pelamar1 : daftarPelamar) {
            if (pelamar1.getIdAkun().equals(idAkun)) {
                ketemu = true;    }    }
        return ketemu;    }
    
    public Pelamar getPelamar(String id){
//        return con.getPelamar(id);
        int i = findPelamar(id);
        return daftarPelamar[i];
    }
    
    public int addPelamar(String id, String nama, String alamat, String noTelp, String email,
        String website, String tglLahir, char[] pass    ){
        int hasil = 0;
        if (nPelamar < maxPelamar){
            int i = nPelamar;
            Pelamar p = new Pelamar(id, nama, alamat, noTelp, email, website, tglLahir, pass);
            daftarPelamar[i] = p;
//            con.savePelamar(p);
            nPelamar++;
            hasil = 1;
        }
        return hasil;
    }
    
    public void deletePelamar(String id){
        boolean find = foundPelamar(id);
        if (find == true){
            int i = findPelamar(id);
            int arAkhir = nPrsh-1;
//            System.out.println(nPrsh);
//            System.out.println(arAkhir);
            if (i == arAkhir) // array 0, 1, 2
                daftarPelamar[i] = null;
            else{
                for(int j = i; j < arAkhir; j++){
                    int a = j+1;
                    daftarPelamar[j] = daftarPelamar[a];    }
                    daftarPelamar[arAkhir] = null;    }
            nPrsh--;    }
    }
    
    public void hapusAkunPel(String id){
        deletePelamar(id);
//        con.deletePelamar(getPelamar(id));  
    }
    
    public String daftarPelamar(){
        //con.getListIDPelamar();
        String list = "";
        for(int i=0; i< nPelamar; i++){
            int a = i+1;
            list = (a+". "+ daftarPelamar[i].getIdAkun()+"\n"); }
        return list;
    }
    
    public void cariPelamar(String nama){
        boolean ketemu = foundPelamar(nama);
        System.out.println(ketemu);
        if (ketemu == true){
            int idx = findPelamar(nama); 
            daftarPerusahaan[idx].toString();    }
        if(ketemu == false){
            System.out.println("Akun pelamar yang anda cari tidak terdaftar");    
        }    }
    
//    public boolean loginPelamar(String id, char[] pass){
//        boolean berhasil = false;
//        int i = 0;
//        
//        Pelamar p = getPelamar(id);
//        if(foundPelamar(id) == true){
//            int ar = findPelamar(id);
//            if(daftarPelamar[ar].getPassword() == pass)
//                berhasil = true;
//        }
//        return berhasil;
//    }
    
    //lupaPassword
    public boolean lupaPassPelamar(String idAkun, String email, char[] passBaru){
        boolean berhasil = false;
        int ar = findPelamar(idAkun);
        if(daftarPelamar[ar].getEmail() == email){
            daftarPelamar[ar].setPassword(passBaru);
            berhasil = true;
        }
        return berhasil;
    }
        //setelah login

    //berkas
    //buatBerkas
    public void buatBerkas(String idAkun, String cv, String slk){
        int ar = findPelamar(idAkun);
        daftarPelamar[ar].createBerkas(cv, slk);
        if(daftarPelamar[ar].getBerkas().getCV() != null && daftarPelamar[ar].getBerkas().getSLK() != null){
            System.out.println("Berkas CV dan Surat Lamaran Kerja Berhasil disimpan");} }
                
    //viewBerkas
    public void viewBerkas(String nama){
        int ar = findPelamar(nama);
        daftarPelamar[ar].getBerkas().toString();    }
    
    //lowongan
    //cariPerusahaan
    public String jobByPerusahaan(int idP){
        Perusahaan p = daftarPerusahaan[idP];
        for (int i = 0; i< p.nLowongan; i++){
            String hasil = "Lowongan : " + p.getLowonganByIdx(i).getNamaPkrj() + "\n"
                    + "Deadline : " + p.getLowonganByIdx(i).getDeadline().toString();
            return hasil;
        }
//        boolean ketemu = foundPerusahaan(namaPerusahaan);
////        System.out.println(ketemu);
//        if (ketemu == true){
//            int idx = findPerusahaan(namaPerusahaan); 
//             return daftarPerusahaan[idx].toString(); }
//        if(ketemu == false){
//            System.out.println("Perusahaan yang anda cari tidak terdaftar"); }   
        return null;
    }
                
    //cariLowongan
    //byAll
    public String cariPekerjaan(int idP, int lowong){
        Lowongan l = daftarPerusahaan[idP].getLowonganByIdx(lowong);
        String find = "Nama lowongan : " + l.getNamaPkrj() + " \n" +
                " Deadline : " + l.getDeadline().toString();
        return find;
//        for (int i = 0; i < daftarPerusahaan.length; i++) {
//            if(daftarPerusahaan[i].getNama() == namaPerusahaan){
//                find = true;
//                for (int j=0; j < daftarPerusahaan[i].getDaftarLowongan().length; j++) {
//                    if (daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj() == namaLowongan) {
//                        System.out.println("Nama Pekerjaan : "+
//                            daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj());
//                        System.out.println("Deadline : "
//                             +daftarPerusahaan[i].getLowonganByIdx(j).getDeadline());
//                    ketemu = true;  }   }   }   }
//                    if(find == false && ketemu == false)
//                        System.out.println("Perusahaan "+namaPerusahaan+" tidak terdartar "
//                            + "pada aplikasi");
//                    if(ketemu == false)
//                        System.out.println("Maaf, pekerjaan "+namaLowongan+"tidak tersedia "
//                            + "pada perusahaan "+namaPerusahaan);   
    }
                    
    //byPerusahaan
//    public void cariPekerjaanByPerusahaan(String namaPerusahaan){
//        boolean ketemu = false; //untuk lowongan
//        boolean find = false; //untuk perusahaan
//        for (int i = 0; i < daftarPerusahaan.length; i++) {
//            if(daftarPerusahaan[i].getNama() == namaPerusahaan){
//                find = true;
//                for (int j=0; j < daftarPerusahaan[i].getDaftarLowongan().length; j++) {
//                    System.out.println("Nama Pekerjaan : "+
//                        daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj());
//                    System.out.println("Deadline : "
//                        +daftarPerusahaan[i].getLowonganByIdx(j).getDeadline());
//                    ketemu = true;  }   }   }   
//                if(find == false && ketemu == false){
//                    System.out.println("Perusahaan "+namaPerusahaan+" tidak terdartar "
//                        + "pada aplikasi"); }   }
//                    
//    //byLowongan
//    public void cariPekerjaanByLowongan(String namaLowongan){
//        boolean ketemu = false; //untuk lowongan
//        for (int i = 0; i < daftarPerusahaan.length; i++) {
//            for (int j=0; j < daftarPerusahaan[i].getDaftarLowongan().length; j++) {
//                if (daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj() == namaLowongan) {
//                    System.out.println("Nama Pekerjaan : "+
//                        daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj());
//                    System.out.println("Deadline : "
//                        +daftarPerusahaan[i].getLowonganByIdx(j).getDeadline());
//                        ketemu = true;  }   }   }
//                    if(ketemu == false){
//                        System.out.println("Lowongan yang anda cari tidak tersedia");   }   }
                
    //daftarkanDiri
    public void daftar(Pelamar p, Perusahaan ph, int idLowongan){
        int np = findPelamar(p.getNama());
        int pr = findPerusahaan(ph.getNama());
        if (daftarPerusahaan[pr].getLowonganByIdLowongan(idLowongan) != null){
            daftarPerusahaan[pr].getLowonganByIdLowongan(idLowongan).addBerkasMasuk(daftarPelamar[np].getBerkas());
        }
    }
    //lihat status penerimaan
    public boolean statusDiterima(String namaPelamar, String namaPerusahaan, int idLowongan){
        int np = findPelamar(namaPelamar);
        int pr = findPerusahaan(namaPerusahaan);
        if (daftarPerusahaan[pr].getLowonganByIdLowongan(idLowongan) != null){
            for (int i= 0; i < daftarPerusahaan[pr].getLowonganByIdLowongan(idLowongan).getBerkasDiterima().length; i++){
                if (daftarPerusahaan[pr].getLowonganByIdLowongan(idLowongan).getBerkasDiterimaByIndex(i) == daftarPelamar[np].getBerkas()){
                    daftarPelamar[np].setStatus();
                }
            }
        }
        return daftarPelamar[np].getStatus();
    }
    
    public void hapusLowongan(Perusahaan p, int id){
        if (p.getLowonganByIdx(id) != null){
            p.getLowonganByIdx(id).setNamaPkrj("");
            p.getLowonganByIdx(id).setDeadline(null);
        }
    }
    
//perusahaan
    //login
//    public boolean loginPerusahaan(String id, char[] pass){
//        boolean berhasil = false;
//        Perusahaan p = getPerusahaan(id);
//        if(foundPerusahaan(id) == true){
//            int ar = findPerusahaan(id);
//            if(daftarPerusahaan[ar].getPassword() == pass)
//                berhasil = true;
//        }
//        return berhasil;
//    }

    //lupaPassword
    public void lupaPassPrsh(String nama, int thn, char[] passBaru){
        int ar = findPelamar(nama);
        if(daftarPerusahaan[ar].getThnBerdiri() == thn){
            daftarPerusahaan[ar].setPassword(passBaru);
//            con.updatePassPer(daftarPerusahaan[ar]);
        }
    }
    
    //setelah login
        //lowongan
            //lihatDaftarLowongan
    public void viewDaftarLowongan(String nama){
        if(foundPerusahaan(nama) == true){
            int ar = findPerusahaan(nama);
            if(daftarPerusahaan[ar].getLowonganByIdx(0) == null)
                System.out.println("Belum ada lowongan pekerjaan yang terdaftar");
            else{
                for(int i=0; i < daftarPerusahaan[ar].getDaftarLowongan().length; i++){
                    int nomor = i+1;
                    if(daftarPerusahaan[ar].getLowonganByIdx(i).getNamaPkrj() == null){
                        System.out.println(nomor+". Lowongan Kosong");  }
                    else{
                        System.out.println(nomor+". Lowongan "+
                            daftarPerusahaan[ar].getLowonganByIdx(i).getNamaPkrj());
                        System.out.println("            "+
                            daftarPerusahaan[ar].getLowonganByIdx(i).getDeadline());    }   }   }   }   }
                
            //tambahLowongan
//    public void addLowongan(String nama, String nmLowongan, Date deadline){
//        if(foundPerusahaan(nama) == true){
//            int ar = findPerusahaan(nama);
//            daftarPerusahaan[ar].createLowongan(nmLowongan, deadline);    }   }
            
            //hapusLowongan berdasar nomor urut lowongan tsb
    public void hapusLowongan(String nama, int id){
        if(foundPerusahaan(nama) == true){
            int ar = findPerusahaan(nama);
            daftarPerusahaan[ar].removeLowongan(id);  }   }
            
    //pelamar
    //lihat daftar pelamar
    
    //lihat daftar diterima
                
    //terima pelamar
    public void addDiterima(String namaPrsh, int idlowongan, int id){
        int ar = 0;
        if(foundPerusahaan(namaPrsh) == true){
            ar = findPerusahaan(namaPrsh);
            daftarPerusahaan[ar].getLowonganByIdx(idlowongan).addBerkasDiterima(daftarPelamar[id].getBerkas());
        }
        //daftarPelamar[id];
    }
    
    public void gantiPasswordPelamar(String idAkun, char[] lama, char[] baru){
        int i = findPelamar(idAkun);
        if (daftarPelamar[i].getPassword() == lama){
            daftarPelamar[i].setPassword(baru);
        }
    }
    
    public void gantiPasswordPerusahaan(String idAkun, char[] lama, char[] baru){
        int i = findPerusahaan(idAkun);
        if (daftarPerusahaan[i].getPassword() == lama){
            daftarPerusahaan[i].setPassword(baru);
        }
    }
    //tolak(?)
    //lihat berkas pelamar
    
    //setting
    //password
    //deletePerusahaan
    //kembali ato logout
    
    //lihatPerusahaan terdaftar
    public void viewDaftarPerusahaan(){
        System.out.println("No      Nama              Email");
            if(daftarPerusahaan[0] == null) System.out.println("Daftar masih kosong");
            else{
                for(int i=0; i < daftarPerusahaan.length; i++){
                    int nomor = i+1;
                    if(daftarPerusahaan[i].getNama() != null){
                        System.out.println(nomor+". "+daftarPerusahaan[i].getNama()+"    "+
                            daftarPerusahaan[i].getEmail());    }
                    else    System.out.println(nomor+". Kosong");   }   }   }
        //kembali
    //kembali
    
}
