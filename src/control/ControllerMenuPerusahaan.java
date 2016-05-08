package control;
import java.awt.event.*;
import model.*;
import view.*;

class ControllerMenuPerusahaan implements ActionListener{

    private aplikasi model;
    private MenuPerusahaan view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
        
    public ControllerMenuPerusahaan(aplikasi model, Perusahaan p) {
        this.model = model;
        this.p2 = p;
        view = new MenuPerusahaan();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogout())){
            new controller(model);
            view.dispose();
        } else if (source.equals(view.getBtnAturBio())){
            new controllerEditBio(model, p2);
            view.dispose();
        } else if (source.equals(view.getBtnAturLowongan())){
            new controllerSettingLowongan(model, p2);
            view.dispose();
        } else if (source.equals(view.getBtnAturPenerimaan())){
            new controllerViewBerkasDiterima(model, p2);
            view.dispose();
        } else if (source.equals(view.getBtnViewBerkasMasuk())){
            new controllerViewBerkasMasuk(model, p2);
            view.dispose();
        }
    }
    
}
