package control;

import model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import view.*;


class controllerLupaPass implements ActionListener{
    
    private aplikasi model;
    private lupaPass view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;

    public controllerLupaPass(aplikasi model) {
        this.model = model;
        view = new lupaPass();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        if (source.equals(view.getBtnBack2())){
            new controller(model);
            view.dispose();
        } else if (source.equals(view.getBtnCheck())){
            String idAkun = view.getIdAkunDicari();
            String nama = view.getNamaDicari();
            String passBaru = String.valueOf(view.getPassBaru());
            Owner p = model.cariAkun(idAkun, nama);
            if (p == null){
                JOptionPane.showMessageDialog(null, "Akun tidak terdaftar", "Fail",
                                JOptionPane.WARNING_MESSAGE);
            } else {
//                if (p instanceof Pelamar){
//                    Pelamar r = (model.Pelamar) p;
                    p.setPassword(passBaru);
                    boolean hasil = model.lupaPassPelamar(p);
                    if (hasil == false){
                        JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                    }
//                } else if (p instanceof Perusahaan){
//                    Perusahaan h = (model.Perusahaan) p;
//                    boolean hasil = model.lupaPassPerusahaan(h);
//                    if (hasil == false){
//                        JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
//                                JOptionPane.WARNING_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
//                    }
//                }
            }
            view.setKosongForget();
        }
    }
    
}
