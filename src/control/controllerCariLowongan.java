package control;

import java.awt.event.ActionListener;
import model.aplikasi;
import java.awt.event.*;
import model.*;
import view.*;

class controllerCariLowongan implements ActionListener{

    private aplikasi model;
    private cariLowongan view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
    
    public controllerCariLowongan(aplikasi model, Pelamar p) {
        this.model = model;
        this.p1 = p;
        view = new cariLowongan();
        view.setVisible(true);
        view.addListener(this);    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        view.setListPerusahaan(model.getListPerusahaan());
        
        if (source.equals(view.getBtnBack())){
            System.out.println("button kembali");
            new controllerMenuPelamar(model, p1);
            view.dispose();
            
        } else if (source.equals(view.getBtnCari())){
            System.out.println("cari dari getPerusahaan()");
            
        } else if (source.equals(view.getBtnDaftar())){
//            int nama = view.getLowonganPilihan();
            System.out.println("cari dari getPerusahaan() + getLowonganPilihan()");
        
        }
        
    }
    
}
