package tubes;

import java.text.ParseException;
import java.util.Date;

public class AplikasiKonsol {
    
    Perusahaan[] perusahaan = new Perusahaan[3];
    Pelamar[] pelamar = new Pelamar[20];
    int nPrsh = 0;
    int nPelamar = 0;
    int maxPerusahaan = 3;
    int maxPelamar = 20;
    
    //test
    public String helloWoorld(){
        return ("hello world");
    }
        
    //search Pelamar
    public int findPelamar(String nama){
        int ind = -1;
        for(int i = 0; i < pelamar.length; i++){
            if (pelamar[i].getNama().equals(nama)){
                ind = i;
            }
        }
        return ind;
    }
    
    public boolean foundPelamar(String nama){
        boolean ketemu = false;
        for (Pelamar pelamar1 : pelamar) {
            if (pelamar1.getNama().equals(nama)) {
                ketemu = true;
            }
        }
        return ketemu;
    }
    
    public void cariPelamar(String nama){
        boolean ketemu = foundPelamar(nama);
        System.out.println(ketemu);
        if (ketemu == true){
            int idx = findPelamar(nama); 
            perusahaan[idx].printBio();            
        }
        if(ketemu == false){
            System.out.println("Akun pelamar yang anda cari tidak terdaftar");
        }
    }
    
    //delete
    //dimulai dari id 0
    public void delPerusahaan(int i){
//            perusahaan[i] = null;
        int arAkhir = nPrsh-1;
//        System.out.println(nPrsh);
//        System.out.println(arAkhir);
        if (i == arAkhir) // array 0, 1, 2
            perusahaan[i] = null;
        else{
            for(int j = i; j < arAkhir; j++){
                int a = j+1;
                perusahaan[j] = perusahaan[a];
                System.out.println("index : "+j);
                System.out.println("isi   : "+a);
            }
            perusahaan[arAkhir] = null;
        }
        nPrsh--;
    }
    
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
                perusahaan[i] = null;
            else{
                for(int j = i; j < arAkhir; j++){
                    int a = j+1;
                    perusahaan[j] = perusahaan[a];
                    System.out.println("index : "+j);
                    System.out.println("isi   : "+a);
                }
                perusahaan[arAkhir] = null;
                }
            nPrsh--;
        }
        else{
            System.out.println("Perusahaan tidak ada");
        }        
    }
    
    //pelamar
    //login
    public void loginPelamar(String nama, String pass){
        if(foundPelamar(nama) == true){
            int ar = findPelamar(nama);
            if(pelamar[ar].getPassword() == pass){
                System.out.println("Proses login berhasil");    }
            else
                System.out.println("Password anda salah");  }
        else
            System.out.println("Username anda salah / belum terdaftar");    }
        //lupaPassword
        //setelah login
            //berkas
                //buatBerkas
                public void buatBerkas(String nama, String isiCV, String isiSLK) throws ParseException{
                    int ar = findPelamar(nama);
                    pelamar[ar].createBerkas(isiCV, isiSLK);
                    if(pelamar[ar].getBerkas().getCV() != null && pelamar[ar].getBerkas().getSLK() != null){
                        System.out.println("Berkas CV dan Surat Lamaran Kerja Berhasil disimpan");} }
                //viewBerkas
                public void viewBerkas(String nama){
                    int ar = findPelamar(nama);
                    pelamar[ar].getBerkas().viewBerkasLamaran();    }
            //lowongan
                //cariPerusahaan
                public int findPerusahaan(String namaPerusahaan){
                    int ind = -1;
                    for(int i = 0; i < perusahaan.length; i++){
                        if (perusahaan[i].getNama().equals(namaPerusahaan)){
                            ind = i;    }   }
                    return ind; }

                public boolean foundPerusahaan(String nama){
                    boolean ketemu = false;
                    for (Perusahaan perusahaan1 : perusahaan) {
                        if (perusahaan1.getNama().equals(nama)) {
                            ketemu = true;  }   }
                    return ketemu;  }

                public void cariPerusahaan(String namaPerusahaan){
                    boolean ketemu = foundPerusahaan(namaPerusahaan);
                    System.out.println(ketemu);
                    if (ketemu == true){
                        int idx = findPerusahaan(namaPerusahaan); 
                        perusahaan[idx].printBio(); }
                    if(ketemu == false){
                        System.out.println("Perusahaan yang anda cari tidak terdaftar");
                    }   }
                
                //cariLowongan
                    //byAll
                    public void cariPekerjaan(String namaPerusahaan, String namaLowongan){
                        boolean ketemu = false; //untuk lowongan
                        boolean find = false; //untuk perusahaan
                        for (int i = 0; i < perusahaan.length; i++) {
                            if(perusahaan[i].getNama() == namaPerusahaan){
                                find = true;
                                for (int j=0; j < perusahaan[i].getDaftarLowongan().length; j++) {
                                    if (perusahaan[i].getLowonganByIdx(j).getNamaPkrj() == namaLowongan) {
                                        perusahaan[i].getLowonganByIdx(j).getNamaPkrj();
                                        perusahaan[i].getLowonganByIdx(j).getDeadline();
                                        ketemu = true;  }   }   }   }
                        if(find == false && ketemu == false){
                            System.out.println("Perusahaan "+namaPerusahaan+" tidak terdartar "
                                    + "pada aplikasi");
                        }
                        if(ketemu == false){
                            System.out.println("Maaf, pekerjaan "+namaLowongan+"tidak tersedia "
                                    + "pada perusahaan "+namaPerusahaan);
                        }
                    }
                    //byPerusahaan
                    public void cariPekerjaanByPerusahaan(String namaPerusahaan){
                        boolean ketemu = false; //untuk lowongan
                        boolean find = false; //untuk perusahaan
                        for (int i = 0; i < perusahaan.length; i++) {
                            if(perusahaan[i].getNama() == namaPerusahaan){
                                find = true;
                                for (int j=0; j < perusahaan[i].getDaftarLowongan().length; j++) {
                                        perusahaan[i].getLowonganByIdx(j).getNamaPkrj();
                                        perusahaan[i].getLowonganByIdx(j).getDeadline();
                                        ketemu = true;  }   }   }   
                        if(find == false && ketemu == false){
                            System.out.println("Perusahaan "+namaPerusahaan+" tidak terdartar "
                                    + "pada aplikasi"); }   }
                    //byLowongan
                        public void cariPekerjaanByLowongan(String namaLowongan){
                            boolean ketemu = false; //untuk lowongan
                            for (int i = 0; i < perusahaan.length; i++) {
                                for (int j=0; j < perusahaan[i].getDaftarLowongan().length; j++) {
                                    if (perusahaan[i].getLowonganByIdx(j).getNamaPkrj() == namaLowongan) {
                                        perusahaan[i].getLowonganByIdx(j).getNamaPkrj();
                                        perusahaan[i].getLowonganByIdx(j).getDeadline();
                                    ketemu = true;  }   }   }
                            if(ketemu == false){
                                System.out.println("Lowongan yang anda cari tidak tersedia");   }   }
                //daftarkanDiri
                //lihat status penerimaan
            //setting hapus akun
            public void hapusAkunPel(String nama){
                
            }
            //keluar ato logout
    //daftarBaru
    public void addPelamar(String nama, String alamat, String noTelp, String email, String website
//            , String pass, String tempat, String tglLahir
            ){
        if (nPelamar < maxPelamar){
            int i = nPelamar;
            pelamar[i] = new Pelamar(nama, alamat, noTelp, email, website);
    /*          pelamar[i].setPassword(pass);
                pelamar[i].setTempat(tempat);
                pelamar[i].setTglLahir(tglLahir);
    */      nPelamar++;
        } else
            System.out.println("Daftar pelamar sudah penuh");        }
        //enter
    //daftar pelamar
        public void daftarPelamar(){
            System.out.println("No      Nama              Email");
            if(pelamar[0] == null)
                System.out.println("Daftar masih kosong");
            else{
                for(int i=0; i < pelamar.length; i++){
                    int nomor = i+1;
                    System.out.println(nomor+". "+pelamar[i].getNama()+"    "+
                            pelamar[i].getEmail());
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
            if(perusahaan[ar].getPassword() == pass){
                System.out.println("Proses login berhasil");
            }
            else
                System.out.println("Password anda salah");
        }
        else
            System.out.println("Username Perusahaan salah / belum terdaftar");
    }
        //lupaPassword
        //setelah login
            //lowongan
                //lihatDaftarLowongan
                public void viewDaftarLowongan(String nama){
                    if(foundPerusahaan(nama) == true){
                        int ar = findPerusahaan(nama);
                        if(perusahaan[ar].getLowonganByIdx(0) == null)
                            System.out.println("Belum ada lowongan pekerjaan yang terdaftar");
                        else{
                            for(int i=0; i < perusahaan[ar].getDaftarLowongan().length; i++){
                                int nomor = i+1;
                                if(perusahaan[ar].getLowonganByIdx(i).getNamaPkrj() == null){
                                    System.out.println(nomor+". Lowongan Kosong");
                                }
                                else{
                                    System.out.println(nomor+". Lowongan "+
                                        perusahaan[ar].getLowonganByIdx(i).getNamaPkrj());
                                    System.out.println("            "+
                                        perusahaan[ar].getLowonganByIdx(i).getDeadline());                            
                                }   }   }   }   }
                //tambahLowongan
                public void addLowongan(String nama, String nmLowongan, Date deadline){
                    if(foundPerusahaan(nama) == true){
                        int ar = findPerusahaan(nama);
                        perusahaan[ar].createLowongan(nmLowongan, deadline);    }   }
                //hapusLowongan berdasar nomor urut lowongan tsb
                public void hapusLowongan(String nama, int id){
                    if(foundPerusahaan(nama) == true){
                        int ar = findPerusahaan(nama);
                        perusahaan[ar].removeLowongan(id);  }   }
            //pelamar
                //lihat daftar pelamar
                
                //lihat daftar diterima
                //terima pelamar
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
            perusahaan[i] = new Perusahaan(nama, alamat, noTelp, email, website);
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
            if(perusahaan[0] == null)
                System.out.println("Daftar masih kosong");
            else{
                for(int i=0; i < perusahaan.length; i++){
                    int nomor = i+1;
                    if(perusahaan[i].getNama() != null){
                        System.out.println(nomor+". "+perusahaan[i].getNama()+"    "+
                            perusahaan[i].getEmail());                        
                    }
                    else                    
                        System.out.println(nomor+". Kosong");
                }
            }
    }
        //kembali
    //kembali
    
    //buat 1 menu untuk setiap 1 method
    //  tidak disarankan menggunakan proses i/o pada method menu
    //  menggunakan parameter & return value
    
    
    
}
