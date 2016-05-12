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
//            System.out.println("hoho1");
            view.dispose();
            
        } else if (source.equals(view.getBtnSave1())){
            String id = view.getIdAkunPel();
            String nama = view.getNamaPel();
            String pass = String.valueOf(view.getPassPel());
            
            if(p1 == null){
                p1 = new Pelamar(id, nama, pass);
                int a = model.addPelamar(p1.getIdAkun(), p1.getNama(), p1.getPassword());
                if (a == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
//                    view.setKosongAkunBaru();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                        JOptionPane.WARNING_MESSAGE);
//                    view.setKosongAkunBaru();
                }
                view.setKosongAkunBaru();
            }
            
        } else if (source.equals(view.getBtnSave2())){
            String id = view.getIdAkunPel();
            String nama = view.getNamaPel();
            String pass = String.valueOf(view.getPassPel());
            if(p2 == null){
                p2 = new Perusahaan(id, nama, pass);
                int a = model.addPerusahaan(p2.getIdAkun(), p2.getNama(), p2.getPassword());
                if (a == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
//                    view.setKosongAkunBaru();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                        JOptionPane.WARNING_MESSAGE);
 //                   view.setKosongAkunBaru();
                }
                view.setKosongAkunBaru();
            }
            
        }   
    }
}
