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
                new controllerMenuPelamar(model, p1);
                view.dispose();                
            } else 
//           if ( p2!= null && p1 == null ){
            if ( r instanceof Perusahaan ){
                System.out.println("button kembali ke menu perusahaan");
                new controllerMenuPerusahaan(model, p2);
                view.dispose();
            }
            
        } else if (source.equals(view.getBtnSimpan())){
            String name = view.getNama();
            String pLama = String.valueOf(view.getPassOld());
            String pBaru = String.valueOf(view.getPassNew());
            
            System.out.println(name);
            System.out.println(pLama);
            System.out.println(pBaru);
            
            if ( r instanceof Pelamar ){
                System.out.println("p2 null");
                p1 = (Pelamar) r;
//                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
                int a = model.ubahPelamar(p1, name, pLama, pBaru);
                System.out.println("hasil : "+a);
                if (a == 1)  {
                    JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                }
                view.setKosongBio();
            } else if (r instanceof Perusahaan ){
//                Perusahaan p2 = new Perusahaan(po.getIdAkun(), po.getNama(), po.getPassword());
                p2 = (Perusahaan) r;
                int a = model.ubahPerusahaan(p2, name, pLama, pBaru);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "Password berhasil diganti");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Password gagal diganti", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                }
                view.setKosongBio();
            }
        }
        
    }
}
