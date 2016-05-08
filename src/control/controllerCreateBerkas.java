package control;
import java.awt.event.*;
import model.*;
import view.*;

import model.aplikasi;

class controllerCreateBerkas implements ActionListener {

    private aplikasi model;
    private createBerkas view;
    private Pelamar p1 = null;
    
    public controllerCreateBerkas(aplikasi model, Pelamar p) {
        this.model = model;
        this.p1 = p;
        view = new createBerkas();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println("Lol");
        if(source.equals(view.getBtnBack())){
            new ControllerMenuPelamar(model, p1);
            view.dispose();
        } else if (source.equals(view.getBtnSaveBrk())){
            System.out.println("lol");
        }
        
    }
    
}
