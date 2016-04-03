package tubes;
public class AplikasiKonsol {
    
    Perusahaan[] perusahaan = new Perusahaan[3];
    Pelamar[] pelamar = new Pelamar[20];
    int nPrsh = 0;
    int nPelamar = 0;
    int maxPerusahaan = 3;
    int maxPelamar = 20;
    
    public void addPerusahaan(String nama, String alamat, String noTelp, String email, String website){
    if (nPrsh < maxPerusahaan){
        int i = nPrsh;
        perusahaan[i] = new Perusahaan(nama, alamat, noTelp, email, website);
        nPrsh++;
//        System.out.println(nPrsh);
    } else
        System.out.println("Daftar perusahaan sudah penuh");
    }
    
    public void addPelamar(String nama, String alamat, String noTelp, String email, String website){
    if (nPelamar < maxPelamar){
        int i = nPelamar;
        pelamar[i] = new Pelamar(nama, alamat, noTelp, email, website);
        nPelamar++;
    } else
        System.out.println("Daftar pelamar sudah penuh");        
    }
    
    //search    
    public int findPerusahaan(String namaPerusahaan){
        int ind = -1;
        for(int i = 0; i < perusahaan.length; i++){
            if (perusahaan[i].getNama().equals(namaPerusahaan)){
                ind = i;
            }
        }
        return ind;
    }
        
    public boolean foundPerusahaan(String nama){
        boolean ketemu = false;
        for (Perusahaan perusahaan1 : perusahaan) {
            if (perusahaan1.getNama().equals(nama)) {
                ketemu = true;
            }
        }
        return ketemu;
    }
    
    public void cariPerusahaan(String namaPerusahaan){
        boolean ketemu = foundPerusahaan(namaPerusahaan);
        System.out.println(ketemu);
        if (ketemu == true){
            int idx = findPerusahaan(namaPerusahaan); 
            perusahaan[idx].printBio();            
        }
        if(ketemu == false){
            System.out.println("Perusahaan yang anda cari tidak terdaftar");
        }
    }
    
/*    public boolean findPelamar(String nama){  
        boolean ketemu = false;
        for(int i = 0; i < pelamar.length; i++){
            if (pelamar[i].getNama() == nama){
                ketemu = true;
            }
        }
        return ketemu;
    }
*/    
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
    
    //buat 1 menu untuk setiap 1 method
    //  tidak disarankan menggunakan proses i/o pada method menu
    //  menggunakan parameter & return value
    
    
    
}
