package control;

import java.awt.event.*;
import javax.swing.JOptionPane;
import view.*;
import model.*;

public class controllerAkunBaru implements ActionListener{
    
    private aplikasi model;
    private buatAkunBaru view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
    
    public controllerAkunBaru(aplikasi model) {
        this.model = model;
        view = new buatAkunBaru();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source.equals(view.getBtnBack())){
            new controller(model);
            view.dispose();
            
        } else if (source.equals(view.getBtnSave1())){
            String id = view.getIdAkunPel();
            int idAkun = Integer.parseInt(id);
            String nama = view.getNamaPel();
            String pass = String.valueOf(view.getPassPel());
            
            if(p1 == null){
                if(model.cekAngka(id) == true){
                    p1 = new Pelamar(idAkun, nama, pass);
                    int a = model.addPelamar(p1.getIdAkun(), p1.getNama(), p1.getPassword());
                    if (a == 1){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");    }
                    else {
                        JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);   }
                } else {
                    JOptionPane.showMessageDialog(null, "ID hanya boleh digit angka saja", "Fail",
                        JOptionPane.WARNING_MESSAGE);   }
                view.setKosongAkunBaru();
            }
            
        } else if (source.equals(view.getBtnSave2())){
            String id = view.getIdAkunPel();
            int idAkun = Integer.parseInt(id);
            String nama = view.getNamaPel();
            String pass = String.valueOf(view.getPassPel());
            if(p2 == null){
                if(model.cekAngka(id) == true){
                    p2 = new Perusahaan(idAkun, nama, pass);
                    int a = model.addPerusahaan(p2.getIdAkun(), p2.getNama(), p2.getPassword());
                    if (a == 1){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");    }
                    else {
                        JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);   }
                } else {
                    JOptionPane.showMessageDialog(null, "ID hanya boleh digit angka saja", "Fail",
                        JOptionPane.WARNING_MESSAGE);   }
                view.setKosongAkunBaru();
            }
            
        }   
    }
}
