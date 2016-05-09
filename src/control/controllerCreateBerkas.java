package control;
import java.awt.Component;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
//        System.out.println("yay");
        if(source.equals(view.getBtnBack())){
            new controllerMenuPelamar(model, p1);
            view.dispose();
        } else if (source.equals(view.getBtnSaveBrk())){
            System.out.println("lol");
            String cv = view.getCV();
            String slk = view.getSLK();
            if (cv == "")
                JOptionPane.showMessageDialog(view, "file CV tidak boleh kosong");
            else if (slk == "")
                JOptionPane.showMessageDialog(view, "file SLK tidak boleh kosong!");
            int hasil;
            try {
                hasil = model.buatBerkas(p1, cv, slk);
//                JOptionPane.showMessageDialog(view, source);
                if (hasil == -1){
                    JOptionPane.showMessageDialog( view, "Data Gagal Disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                    view.setKosongBerkas();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    view.setKosongBerkas();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(controllerCreateBerkas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(controllerCreateBerkas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
