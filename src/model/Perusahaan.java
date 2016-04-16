package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Perusahaan extends Orang{
    
    private Lowongan[] daftarLowongan;
    private int thnBerdiri;
    private String jenisUsaha;
    private String namaBank;
    private String password;
    public boolean isi = false;
    public int nLowongan=0;
    public int max = 10;
	
    public Perusahaan (String nama, String alamat, String noTelp, String email, String website){
        super(nama, alamat, noTelp, email, website);
        daftarLowongan = new Lowongan[max];
        isi = true;
    }
        
    public void createLowongan(String nmLowongan, Date deadline){
        if (nLowongan != max){
            daftarLowongan[nLowongan] = new Lowongan(nmLowongan, deadline);
            nLowongan++;
        }
        else{
            System.out.println("Daftar Lowongan sudah penuh");
            System.out.println("");
        }
    }
    
    public Lowongan[] getDaftarLowongan(){
        return daftarLowongan;    }
        
    //id dimulai dari 1
    public Lowongan getLowonganByIdLowongan(int idLowongan){
        return daftarLowongan[idLowongan-1];    }
    
    //dimulai dari 0
    public Lowongan getLowonganByIdx(int idx){
        return daftarLowongan[idx];    }
	
    public void setThnBerdiri (int thn){
	this.thnBerdiri = thn;    }
	
    public void setJnsUsaha (String jenisUsaha){
        this.jenisUsaha = jenisUsaha;     }
	
    public void setBank (String bank){
	this.namaBank = bank;	}
	
    public void setPassword (String pass){
	this.password = pass;     }
	
    public int getThnBerdiri(){
	return thnBerdiri;      }
	
    public String getJnsUsaha(){
        return jenisUsaha;  }
	
    public String getBank(){
        return namaBank;    }
	
    public String getPassword(){
        return password ;   }
	
    public String toString(){
        System.out.println("Biodata Perusahaan");
        return ("Nama          :"+super.getNama()+
                "\nAlamat        :"+super.getAlamat()+
                "\nNo. Telp      :"+super.getNoTelp()+
                "\nBank          :"+getBank()+
                "\nJenis Usaha   :"+getJnsUsaha());    }
    
    public void viewLowongan(){
        SimpleDateFormat ft = new SimpleDateFormat("dd MMM yy");
        System.out.println("Daftar Lowongan Pekerjaan : ");
        for (int i = 0; i < nLowongan; i++){
            System.out.println(i+1+". "+daftarLowongan[i].getNamaPkrj());
            System.out.println("   Deadline : "+
                    ft.format(daftarLowongan[i].getDeadline()));        }    }
    
    //id mulai dari 1
    public void removeLowongan(int id){
      if (id <= 0 || id > nLowongan){
          System.out.println("Lowongan tidak dapat dihapus karena lowongan"+
                  " yang anda cari tidak tersedia");      }
      else{     if(id > 0 && id < nLowongan){
                for (int i = id-1; i < nLowongan-1; i++){
                    //System.out.println("i = "+ i);
                    int a = i+1;
                    //System.out.println("isi dari array i = "+ a);
                    daftarLowongan[i] = daftarLowongan[a];    }
                daftarLowongan[nLowongan-1] = null;    }
            else    daftarLowongan[id-1] = null;
            nLowongan--;    }    }
    

//   public void terimaPelamar(int idLowongan, int idPelamar){}
//   public void cekPassword (String password){}


}
