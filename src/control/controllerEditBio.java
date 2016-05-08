package control;

import java.awt.event.*;
import javax.swing.*;
import model.*;
import view.*;

class controllerEditBio implements ActionListener {
    
    private aplikasi model;
    private editBio view;
    private Owner po = null;
    
    public controllerEditBio(aplikasi model, Owner p) {
        this.model = model;
        this.po = p;
        view = new editBio();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())){
            if (po instanceof Pelamar){
                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
                new controllerMenuPelamar(model, p1);
                this.po = null;
                view.dispose();
            } else if (po instanceof Perusahaan){
                Perusahaan p2 = new Perusahaan(po.getIdAkun(), po.getNama(), po.getPassword());
                new controllerMenuPerusahaan(model, p2);
                this.po = null;
                view.dispose();
            }
            
        } else if (source.equals(view.getBtnSimpan())){
            String nama = view.getNama();
            String passLama = String.valueOf(view.getPassOld());
            String passBaru = String.valueOf(view.getPassNew());
            if (po instanceof Pelamar){
                Pelamar p1 = new Pelamar(po.getIdAkun(), po.getNama(), po.getPassword());
                int a = model.ubahPelamar(p1, nama, passLama, passBaru);
                if (a == 1)  JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                else JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
            } else if (po instanceof Perusahaan){
                Perusahaan p2 = new Perusahaan(po.getIdAkun(), po.getNama(), po.getPassword());
                int a = model.ubahPerusahaan(p2, nama, passLama, passBaru);
                if (a == 1)  JOptionPane.showMessageDialog(null, "Password berhasil diganti");
                else JOptionPane.showMessageDialog(null, "Password gagal diganti", "Fail",
                                JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }
}
