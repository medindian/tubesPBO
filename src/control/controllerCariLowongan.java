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
        if (source.equals(view.getBtnBack())){
            new MenuPelamar();
            view.dispose();
        } else if (source.equals(view.getBtnCariPerusahaan())){
        
        } else if (source.equals(view.getBtnCariAll())){
            
        } else if (source.equals(view.getBtnDaftar())){
            
        }
        
    }
    
}
