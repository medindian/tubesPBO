package model;

import java.text.ParseException;
import java.util.Date;

public class AplikasiKonsol {
    
    private Perusahaan[] daftarPerusahaan = new Perusahaan[3];
    private Pelamar[] daftarPelamar = new Pelamar[20];
    int nPrsh = 0;
    int nPelamar = 0;
    //private int nDiterima = 0;
    private int maxPerusahaan = 3;
    private int maxPelamar = 20;
    
    //search Pelamar
    public int findPelamar(String nama){
        int ind = -1;
        for(int i = 0; i < daftarPelamar.length; i++){
            if (daftarPelamar[i].getNama().equals(nama)){
                ind = i;    }    }
        return ind;    }
    
    public boolean foundPelamar(String nama){
        boolean ketemu = false;
        for (Pelamar pelamar1 : daftarPelamar) {
            if (pelamar1.getNama().equals(nama)) {
                ketemu = true;    }    }
        return ketemu;    }
    
    public int findPerusahaan(String namaPerusahaan){
        int ind = -1;
        for(int i = 0; i < daftarPerusahaan.length; i++){
            if (daftarPerusahaan[i].getNama().equals(namaPerusahaan)){
                ind = i;    }   }
        return ind; }
    
    public boolean foundPerusahaan(String nama){
        boolean ketemu = false;
        for (Perusahaan perusahaan1 : daftarPerusahaan) {
            if (perusahaan1.getNama().equals(nama)) {
                ketemu = true;  }   }
        return ketemu;  }
    
    public void cariPelamar(String nama){
        boolean ketemu = foundPelamar(nama);
        System.out.println(ketemu);
        if (ketemu == true){
            int idx = findPelamar(nama); 
            daftarPerusahaan[idx].toString();    }
        if(ketemu == false){
            System.out.println("Akun pelamar yang anda cari tidak terdaftar");    }    }
    
    //delete
    //dimulai dari id 0
    public void delPerusahaan(int i){
//            perusahaan[i] = null;
        int arAkhir = nPrsh-1;
//        System.out.println(nPrsh);
//        System.out.println(arAkhir);
        if (i == arAkhir) // array 0, 1, 2
            daftarPerusahaan[i] = null;
        else{
            for(int j = i; j < arAkhir; j++){
                int a = j+1;
                daftarPerusahaan[j] = daftarPerusahaan[a];
                System.out.println("index : "+j);
                System.out.println("isi   : "+a);    }
            daftarPerusahaan[arAkhir] = null;    }
        nPrsh--;    }
    
    public void deletePerusahaan(String nama){
        boolean find = foundPerusahaan(nama);
        if (find == true){
            int i = findPerusahaan(nama);
//            System.out.println("data ada pada array ke-"+idx);
//            delPerusahaan(idx);
            int arAkhir = nPrsh-1;
            System.out.println(nPrsh);
            System.out.println(arAkhir);
            if (i == arAkhir) // array 0, 1, 2
                daftarPerusahaan[i] = null;
            else{
                for(int j = i; j < arAkhir; j++){
                    int a = j+1;
                    daftarPerusahaan[j] = daftarPerusahaan[a];
                    System.out.println("index : "+j);
                    System.out.println("isi   : "+a);    }
                daftarPerusahaan[arAkhir] = null;    }
            nPrsh--;    }
        else      System.out.println("Perusahaan tidak ada");    }
    
    //pelamar
    //login
    public void loginPelamar(String nama, String pass){
        if(foundPelamar(nama) == true){
            int ar = findPelamar(nama);
            if(daftarPelamar[ar].getPassword() == pass)
                System.out.println("Proses login berhasil");    
            else
                System.out.println("Password anda salah");  }
        else
            System.out.println("Username anda salah / belum terdaftar");    
    }
    
    //lupaPassword
    public void lupaPassPelamar(String nama, String email, String passBaru){
        int ar = findPelamar(nama);
        if(daftarPelamar[ar].getEmail() == email)
            daftarPelamar[ar].setPassword(passBaru);    }
        //setelah login

    //berkas
    //buatBerkas
    public void buatBerkas(String nama, String cv, String slk){
        int ar = findPelamar(nama);
        daftarPelamar[ar].createBerkas(cv, slk);
        if(daftarPelamar[ar].getBerkas().getCV() != null && daftarPelamar[ar].getBerkas().getSLK() != null){
            System.out.println("Berkas CV dan Surat Lamaran Kerja Berhasil disimpan");} }
                
    //viewBerkas
    public void viewBerkas(String nama){
        int ar = findPelamar(nama);
        daftarPelamar[ar].getBerkas().toString();    }
    
    //lowongan
    //cariPerusahaan
    public void cariPerusahaan(String namaPerusahaan){
        boolean ketemu = foundPerusahaan(namaPerusahaan);
//        System.out.println(ketemu);
        if (ketemu == true){
            int idx = findPerusahaan(namaPerusahaan); 
            daftarPerusahaan[idx].toString(); }
        if(ketemu == false){
            System.out.println("Perusahaan yang anda cari tidak terdaftar"); }   }
                
    //cariLowongan
    //byAll
    public void cariPekerjaan(String namaPerusahaan, String namaLowongan){
        boolean ketemu = false; //untuk lowongan
        boolean find = false; //untuk perusahaan
        for (int i = 0; i < daftarPerusahaan.length; i++) {
            if(daftarPerusahaan[i].getNama() == namaPerusahaan){
                find = true;
                for (int j=0; j < daftarPerusahaan[i].getDaftarLowongan().length; j++) {
                    if (daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj() == namaLowongan) {
                        System.out.println("Nama Pekerjaan : "+
                            daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj());
                        System.out.println("Deadline : "
                             +daftarPerusahaan[i].getLowonganByIdx(j).getDeadline());
                    ketemu = true;  }   }   }   }
                    if(find == false && ketemu == false)
                        System.out.println("Perusahaan "+namaPerusahaan+" tidak terdartar "
                            + "pada aplikasi");
                    if(ketemu == false)
                        System.out.println("Maaf, pekerjaan "+namaLowongan+"tidak tersedia "
                            + "pada perusahaan "+namaPerusahaan);   }
                    
    //byPerusahaan
    public void cariPekerjaanByPerusahaan(String namaPerusahaan){
        boolean ketemu = false; //untuk lowongan
        boolean find = false; //untuk perusahaan
        for (int i = 0; i < daftarPerusahaan.length; i++) {
            if(daftarPerusahaan[i].getNama() == namaPerusahaan){
                find = true;
                for (int j=0; j < daftarPerusahaan[i].getDaftarLowongan().length; j++) {
                    System.out.println("Nama Pekerjaan : "+
                        daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj());
                    System.out.println("Deadline : "
                        +daftarPerusahaan[i].getLowonganByIdx(j).getDeadline());
                    ketemu = true;  }   }   }   
                if(find == false && ketemu == false){
                    System.out.println("Perusahaan "+namaPerusahaan+" tidak terdartar "
                        + "pada aplikasi"); }   }
                    
    //byLowongan
    public void cariPekerjaanByLowongan(String namaLowongan){
        boolean ketemu = false; //untuk lowongan
        for (int i = 0; i < daftarPerusahaan.length; i++) {
            for (int j=0; j < daftarPerusahaan[i].getDaftarLowongan().length; j++) {
                if (daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj() == namaLowongan) {
                    System.out.println("Nama Pekerjaan : "+
                        daftarPerusahaan[i].getLowonganByIdx(j).getNamaPkrj());
                    System.out.println("Deadline : "
                        +daftarPerusahaan[i].getLowonganByIdx(j).getDeadline());
                        ketemu = true;  }   }   }
                    if(ketemu == false){
                        System.out.println("Lowongan yang anda cari tidak tersedia");   }   }
                
    //daftarkanDiri
    //lihat status penerimaan
    
    //setting hapus akun
    public void hapusAkunPel(String nama){
            //melakukan hapus akun pelamar berdasarkan nama/ nomor urutnya pada array
            //lakukan sorting
            
            }
            //keluar ato logout
    
    //daftarBaru
    public void addPelamar(String nama, String alamat, String noTelp, String email, String website
//            , String pass, String tempat, String tglLahir
            ){
        if (nPelamar < maxPelamar){
            int i = nPelamar;
            daftarPelamar[i] = new Pelamar(nama, alamat, noTelp, email, website);
    /*      pelamar[i].setTempat(tempat);
            pelamar[i].setTglLahir(tglLahir);
            pelamar[i].setPassword(pass);
    */      nPelamar++;
        } else
            System.out.println("Daftar pelamar sudah penuh");        }
        //enter

    //daftar pelamar
        public void daftarPelamar(){
            System.out.println("No      Nama              Email");
            if(daftarPelamar[0] == null)
                System.out.println("Daftar masih kosong");
            else{
                for(int i=0; i < daftarPelamar.length; i++){
                    int nomor = i+1;
                    System.out.println(nomor+". "+daftarPelamar[i].getNama()+"    "+
                            daftarPelamar[i].getEmail());
                }
            }
        }
        //kembali
    //kembali
    
    //perusahaan
    //login
    public void loginPerusahaan(String nama, String pass){
        if(foundPerusahaan(nama) == true){
            int ar = findPerusahaan(nama);
            if(daftarPerusahaan[ar].getPassword() == pass){
                System.out.println("Proses login berhasil");
            }
            else
                System.out.println("Password anda salah");
        }
        else
            System.out.println("Username Perusahaan salah / belum terdaftar");
    }

    //lupaPassword
    public void lupaPassPrsh(String nama, String email, String passBaru){
        int ar = findPelamar(nama);
        if(daftarPerusahaan[ar].getEmail() == email)
            daftarPerusahaan[ar].setPassword(passBaru);
        if(daftarPerusahaan[ar].getPassword() == passBaru)
            System.out.println("Password berhasil diubah");
        else
            System.out.println("Password gagal diubah, harap coba lagi");
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
    public void addLowongan(String nama, String nmLowongan, Date deadline){
        if(foundPerusahaan(nama) == true){
            int ar = findPerusahaan(nama);
            daftarPerusahaan[ar].createLowongan(nmLowongan, deadline);    }   }
            
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
    
    //tolak(?)
    //lihat berkas pelamar
    
    //setting
    //password
    //deletePerusahaan
    //kembali ato logout
    
    //daftar baru
    public void addPerusahaan(String nama, String alamat, String noTelp, String email, String website
//            , String jnsUsaha, String bank, String pass, int thnBerdiri
        ){
        if (nPrsh < maxPerusahaan){
            int i = nPrsh;
            daftarPerusahaan[i] = new Perusahaan(nama, alamat, noTelp, email, website);
/*            perusahaan[i].setJnsUsaha(jnsUsaha);
            perusahaan[i].setThnBerdiri(thnBerdiri);
            perusahaan[i].setBank(bank);
            perusahaan[i].setPassword(pass);
*/            nPrsh++;
//        System.out.println(nPrsh);
        } else
            System.out.println("Daftar perusahaan sudah penuh");
    }
        //enter
    
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
    
    //buat 1 menu untuk setiap 1 method
    //  tidak disarankan menggunakan proses i/o pada method menu
    //  menggunakan parameter & return value
    
    
    
}
