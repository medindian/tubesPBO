package control;

import java.awt.event.*;
import model.*;
import view.*;

class controllerMenuPelamar implements ActionListener{

    private aplikasi model;
    private MenuPelamar view;
    private Pelamar p1 = null;
//    private Perusahaan p2 = null;
            
    public controllerMenuPelamar(aplikasi model, Pelamar p) {
        this.model = model;
        this.p1 = p;
        view = new MenuPelamar();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if (source.equals(view.getBtnLogout())){
            new controller(model);
            this.p1 = null;
            view.dispose();
            
        } else if (source.equals(view.getBtnCreateBerkas())){
            new controllerCreateBerkas(model, p1);
            view.dispose();
            
        } else if (source.equals(view.getBtnUbahBio())){
            new controllerEditBio(model, p1, null);
//            new controllerEditBio(model, p1);
            view.dispose();
            
        } else if(source.equals(view.getBtnCari())){
            new controllerCariLowongan(model, p1);
            view.dispose();
            
        } else if (source.equals(view.getBtnStatus())){
            //System.out.println("hohoho");
        }
        
    }
    
}
