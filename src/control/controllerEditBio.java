package control;

import java.awt.event.*;
import model.*;
import view.*;

class controllerEditBio implements ActionListener {
    
    private aplikasi model;
    private editBio view;
    private Owner p = null;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
    
//    public controllerEditBio(aplikasi model, Pelamar p, Perusahaan pp) {
    public controllerEditBio(aplikasi model, Owner n) {
        this.model = model;
        this.p = n;
        view = new editBio();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if (source.equals(view.getBtnBack())){
            
            System.out.println("button back");
            if (p instanceof Pelamar){
                p1 = (Pelamar) p;
//            if ( p1!= null && p2 == null ){
//                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
                new controllerMenuPelamar(model, p1);
                this.p = null;
                view.dispose();
            } else 
                
            if (p instanceof Perusahaan){
                p2 = (Perusahaan) p;
//          else if ( p2!= null && p1 == null ){
////                Perusahaan p2 = new Perusahaan(po.getIdAkun(), po.getNama(), po.getPassword());
                new controllerMenuPerusahaan(model, p2);
                this.p = null;
                view.dispose();
            }
            
        } else if (source.equals(view.getBtnSimpan())){
            System.out.println("ubah data");
            String nama = view.getNama();
            String passLama = String.valueOf(view.getPassOld());
            String passBaru = String.valueOf(view.getPassNew());
            
//            if ( p1!= null && p2 == null ){
////                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
//                int a = model.ubahPelamar(p1, nama, passLama, passBaru);
//                
//                if (a == 1)  {
//                    JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
//                    view.setKosongBio();
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
//                                JOptionPane.WARNING_MESSAGE);
//                    view.setKosongBio();
//                }
//            } else if (p2!= null && p1 == null){
////                Perusahaan p2 = new Perusahaan(po.getIdAkun(), po.getNama(), po.getPassword());
//                int a = model.ubahPerusahaan(p2, nama, passLama, passBaru);
//                if (a == 1) {
//                    JOptionPane.showMessageDialog(null, "Password berhasil diganti");
//                    view.setKosongBio();
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Password gagal diganti", "Fail",
//                                JOptionPane.WARNING_MESSAGE);
//                    view.setKosongBio();
//                }
//            }
        }
        
    }
}
