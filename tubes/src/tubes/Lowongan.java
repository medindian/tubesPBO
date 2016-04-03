package tubes;

import java.util.Date;

public class Lowongan {
    
    private String namaPekerjaan;
    private Date deadline;
    private BerkasLamaran[] berkasMasuk;
    private BerkasLamaran[] berkasDiterima;
    public int nBMasuk = 0;
    public int nBTerima = 0;
    public int max = 10;
    
    public Lowongan(String nPk, Date dl){
        this.namaPekerjaan = nPk;
        this.deadline = dl;
        berkasMasuk = new BerkasLamaran[max];
        berkasDiterima = new BerkasLamaran[max];    }

    public void setNamaPkrj(String nPk){
        this.namaPekerjaan = nPk;   }
    
    public void setDeadline(Date dl){
        this.deadline = dl;     }

    public String getNamaPkrj(){
        return namaPekerjaan;   }
    
    public Date getDeadline(){
        return deadline;    }
    
    public void addBerkasMasuk(BerkasLamaran b){
        int i = nBMasuk;
        if (nBMasuk < max+1){
            berkasMasuk[i] = b;     }
        nBMasuk++;
    }

    //index dimulai dari 0
    public BerkasLamaran getBerkasMasukByIndex(int index){
        /*int i=0;
        boolean ketemu = false;
        while (berkasMasuk[i] != b)
            i++;
        if (berkasMasuk[i] != null)
            ketemu = true;
        return ketemu; */
        return berkasMasuk[index];
    }
    
    //idBerkas dimulai dari 1
    public BerkasLamaran getBerkasMasukByIdBerkas(int idBerkas){
        return berkasMasuk[idBerkas-1];
    }
    
/*    public void terimaBerkas(BerkasLamaran b){
        int i = nBTerima;
        boolean cari = cariBerkas(b);
        if (cari == true){
            if (nBTerima <= max){
                berkasDiterima[i] = b;
                nBTerima++;
//                System.out.println("i : "+i);
            }
        }
        else{
            System.out.println("Berkas tidak ada");
            System.out.println("");     }
    }
*/    
    public void viewBerkasMasuk(){
        System.out.println("Berkas Lamaran yang Masuk :");
        for (int i=0; i < nBMasuk; i++){
            int ar = i+1;
            System.out.println("Berkas Lamaran ke-"+ar);
            berkasMasuk[i].viewBerkasLamaran();
            System.out.println("");     } 
    }

    //menampilkan berkas2 yg ada pada berkasDiterima
    public void viewBerkasTerima(){
        System.out.println("Berkas Lamaran yang Diterima :");
        for (int j = 0; j < nBTerima; j++){
            int tr = j+1;
//            System.out.println(j);
            System.out.println("Berkas Lamaran ke-"+tr);
            berkasDiterima[j].viewBerkasLamaran();
            System.out.println("");     }
    }

    //id ditulis dimulai dari 1
    //untuk menghapus berkas yang ada pada berkasMasuk bila berkas tersebut
    // ditolak untuk diterima aka disimpan pada berkasDiterima
    public void removeBerkas(int id){
        if (id > nBMasuk)
            System.out.println("Berkas Lamaran tidak ada");
        else {
            if (id == nBMasuk){
                berkasMasuk[id-1] = null;   }
            else {
                for (int i = id-1; i < nBMasuk; i++){
                    int a = i+1;
//                    System.out.println("array : "+i);
//                    System.out.println("diisi array : "+a);
                    berkasMasuk[i] = berkasMasuk[a];    }
                berkasMasuk[nBMasuk] = null;  }
            nBMasuk--;    }
    }
    
    public void BerkasMasukToBerkasDiterima(){
        int i = 0;
        while(i <= nBMasuk){
            berkasDiterima[i] = berkasMasuk[i];
            i++;
        }
    }
    
    //index dimuali dari 0
    public BerkasLamaran getBerkasDiterimaByIndex(int index){
        return berkasDiterima[index];
    }
    
    //id dimulai dari angka 1
    //berfungsi menghapus berkas yg ada di berkasDiterima sekaligua menghapus
    // berkas yg sama yg ada pada berkasMasuk
/*    public void hapusBerkasDiterima(int id){
        int i = id-1;
        boolean cari = cariBerkas(berkasDiterima[i]);
        if (cari == true){
            BerkasLamaran temp = berkasDiterima[i];
            if ( id == nBTerima){
                berkasDiterima[i] = null;   }
            else{
//                System.out.println("nBrkTerima sebelumnya : "+ nBrkTerima);
//                System.out.println("Proses : ");
                for (int j = i; j < nBTerima; j++){
                    int k = j+1;
//                    System.out.println("Array : "+ j);
//                    System.out.println("Diisi oleh array : "+k);
                    berkasDiterima[j] = berkasDiterima[k];    }
                }
            nBTerima--;
//            System.out.println("nBrkTerima setelahnya: "+ nBrkTerima);
            //cari data yg sama yg ada pada BerkasMasuk
            int a = 0;
            while (berkasMasuk[a] != temp)
                a++;
            System.out.println("Posisi array a yg nilanya sama dgn array yg "
                    + "dihapus : "+a);
            tolakBerkas(a+1);
            viewBerkasMasuk();
            nBMasuk--;    }
        else
            System.out.println("Perintah tidak dapat dilakukan \n");
    }
*/    
}