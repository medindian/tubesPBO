package control;

import java.awt.event.*;
import model.*;
import view.*;

class controllerViewBerkasDiterima implements ActionListener {
    
    private aplikasi model;
    private viewBerkasDiterima view;
    private Perusahaan p2 = null;

    public controllerViewBerkasDiterima(aplikasi model, Perusahaan p) {
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
            new controller(model);
            view.dispose();
        } else if (source.equals(view.getBtnHapusBerkas())){
            //System.out.println("hohoho");
        } else if (source.equals(view.getBtnLihatIsiBerkas())){
            //System.out.println("hohoho");
        }
    }
        
}
