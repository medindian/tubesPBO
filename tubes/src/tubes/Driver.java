package tubes;

public class Driver {
    public static void main(String[] args) {
    AplikasiKonsol apKonsol = new AplikasiKonsol();
    apKonsol.addPerusahaan("huehue", "hahahaha", "092211", "ufufu@abc.com", "tidakAda.com");
    apKonsol.addPerusahaan("nainai", "lalala", "yohohoho", "03891321", "huhuhuuu");
    apKonsol.addPerusahaan("ushishishi", "ehehe", "---", "123", "huhuhuuu");
//    apKonsol.addPerusahaan("ijfiwea", "ihansd", "02133", "laiea", "kekeke");

//    apKonsol.deletePerusahaan("huehue");
//    int found = apKonsol.findPerusahaan("nainai");
//    System.out.println("Data ada pada array ke-"+found);
//    apKonsol.delPerusahaan(found);

    apKonsol.deletePerusahaan("ushishishi");
    for(int i=0; i<3; i++){
        if (apKonsol.perusahaan[i] == null)
            System.out.println("kosong");
        else
            apKonsol.perusahaan[i].printBio();
    }


    //apKonsol.callMainManu();
    }
}
