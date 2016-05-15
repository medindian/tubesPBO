package control;

import java.awt.event.*;
import javax.swing.JOptionPane;
import model.*;
import view.*;

class controllerEditBio implements ActionListener {
    
    private aplikasi model;
    private editBio view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
    
    public controllerEditBio(aplikasi model, Pelamar p, Perusahaan pp) {
        this.model = model;
        this.p1 = p;
        this.p2 = pp;
        view = new editBio();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnBack())){
 //           if ( p1!= null && p2 == null ){
                new controllerMenuPelamar(model, p1);
                System.out.println("haha");
                view.dispose();
                
//            } else
//            if ( p2!= null && p1 == null ){
//                new controllerMenuPerusahaan(model, p2);
//                view.dispose();
//            }
//            
        } else if (source.equals(view.getBtnSimpan())){
            String nama = view.getNama();
            String passLama = String.valueOf(view.getPassOld());
            String passBaru = String.valueOf(view.getPassNew());
            
//            if ( p1!= null && p2 == null ){
////                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
//                int a = model.ubahPelamar(p1, nama, passLama, passBaru);
//                
//                if (a == 1)  {
//                    JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
//                                JOptionPane.WARNING_MESSAGE);
//                }
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
//            }
//            view.setKosongBio();
        }
        
    }
}
