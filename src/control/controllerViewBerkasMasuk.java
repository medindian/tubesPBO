package control;

import java.awt.event.*;
import model.*;
import view.*;

class controllerViewBerkasMasuk implements ActionListener {

    private aplikasi model;
    private viewBerkasDiterima view;
    private Perusahaan p2 = null;
    
    public controllerViewBerkasMasuk(aplikasi model, Perusahaan p) {
        this.model = model;
        this.p2 = p2;
        view = new viewBerkasDiterima();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())){
            new controllerMenuPerusahaan(model, p2);
            view.dispose();
        } else if (source.equals(view.getBtnHapusBerkas())){
            //System.out.println("yohohohoho");
        } else if (source.equals(view.getBtnLihatIsiBerkas())){
            //System.out.println("yohohohoho");
        }
    }

    
}
