package control;

import model.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import view.*;

class controllerEditBio implements ActionListener {
    
    private aplikasi model;
    private editBio view;
    private Owner r = null;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;

//    public controllerEditBio(aplikasi model, Pelamar p, Perusahaan pp) {
    public controllerEditBio(aplikasi model, Owner p) {
        this.model = model;
        view = new editBio();
        this.r = p;
//        this.p1 = p;
//        this.p2 = pp;
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnBack())){
//           if ( p1!= null && p2 == null ){
            if ( r instanceof Pelamar ){
                p1 = (Pelamar) r;
//                System.out.println("button kembali");
                new controllerMenuPelamar(model, p1);
//               System.out.println("button kembali");
                view.dispose();                
            } else 
//           if ( p2!= null && p1 == null ){
            if ( r instanceof Perusahaan ){
                System.out.println("button kembali ke menu perusahaan");
                new controllerMenuPerusahaan(model, p2);
                view.dispose();
            }
            
        } else if (source.equals(view.getBtnSimpan())){
//            System.out.println("button simpan");
            String nama = view.getNama();
            String passLama = String.valueOf(view.getPassOld());
            String passBaru = String.valueOf(view.getPassNew());
            
            System.out.println(nama);
            System.out.println(passLama);
            System.out.println(passBaru);
            
            if ( p1!= null && p2 == null ){
                System.out.println("p2 null");
////                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
                int a = model.ubahPelamar(p1, nama, passLama, passBaru);
                System.out.println("hasil : "+a);
                if (a == 1)  {
                    JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                }
//            } else if (p2!= null && p1 == null){
////                Perusahaan p2 = new Perusahaan(po.getIdAkun(), po.getNama(), po.getPassword());
//                int a = model.ubahPerusahaan(p2, nama, passLama, passBaru);
//                if (a == 1) {
//                    JOptionPane.showMessageDialog(null, "Password berhasil diganti");
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Password gagal diganti", "Fail",
//                                JOptionPane.WARNING_MESSAGE);
//                }
            }
            view.setKosongBio();
        }
        
    }
}
