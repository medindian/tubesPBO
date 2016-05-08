package control;

import java.awt.event.*;
import model.*;
import view.*;

class controllerSettingLowongan implements ActionListener{
    
    private aplikasi model;
    private settingLowongan view;
    private Perusahaan p2 = null;

    public controllerSettingLowongan(aplikasi model, Perusahaan p) {
        this.model = model;
        this.p2 = p;
        view = new settingLowongan();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())){
            new controllerMenuPerusahaan(model, p2);
            view.dispose();
        } else if (source.equals(view.getBtnOK())){
            //System.out.println("yohohoh");
        } else if (source.equals(view.getBtnSaveLowongan())){
            //System.out.println("yohohoh");
        }
    }
    
}
