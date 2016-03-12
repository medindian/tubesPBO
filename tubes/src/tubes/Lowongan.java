package tubes;

import java.util.Date;

public class Lowongan {
    private String namaPekerjaan;
    private Date deadline;
    private BerkasLamaran[] berkasMasuk;
    private BerkasLamaran[] berkasDiterima;
    public int nBrkMasuk = 0;
    public int nBrkTerima = 0;
    
    public Lowongan(String nPk, Date dl){
        this.namaPekerjaan = nPk;
        this.deadline = dl;
    }

    public void setNamaPkrj(String nPk){
        this.namaPekerjaan = nPk;
    }
    
    public void setDeadline(Date dl){
        this.deadline = dl;
    }

    public String getNamaPkrj(){
        return namaPekerjaan;
    }
    
    public Date getDeadline(){
        return deadline;
    }
    
    public void addBerkas(BerkasLamaran b){
        int i = nBrkMasuk++;
        berkasMasuk[i] = b;
        nBrkMasuk++;
    }

    public void terimaBerkas(BerkasLamaran b){
        int i = nBrkTerima++;
        berkasMasuk[i] = b;
        nBrkTerima++;
    }
    
    public BerkasLamaran[] viewBerkasMasuk(){
        System.out.println("Berkas Lamaran yang Masuk");
        /*for (int j=0; j<= nBrkMasuk; j++){
            System.out.println("Berkas Lamaran ke-"+j+1);
            berkasMasuk[j].toString();
        }
        */
        return berkasMasuk;
    }

    public BerkasLamaran[] viewBerkasTerima(){
        System.out.println("Berkas Lamaran yang Diterima");
        /*for (int j=0; j<= nBrkTerima; j++){
            System.out.println("Berkas Lamaran ke-"+j+1);
            berkasDiterima[j].toString();
        }
        */
        return berkasDiterima;
    }

    //id ditulis dimulai dari 1
    public void hapusBerkas(int id){
        if (id > nBrkMasuk)
            System.out.println("Berkas Lamaran tidak ada");
        else {
            berkasMasuk[id-1] = null;
            if (id-1 >= 0 || id-1 <= 10){
                for (int i = id-1; i < nBrkMasuk; i++){
                    berkasMasuk[i] = berkasMasuk[i++]; }
                berkasMasuk[nBrkMasuk] = null;
            }
            nBrkMasuk--;}
    }
    
   
    
}
