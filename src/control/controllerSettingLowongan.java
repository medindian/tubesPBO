package control;

import java.awt.event.*;
import java.util.Date;
import javax.swing.JOptionPane;
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
            
        } else if (source.equals(view.getBtnSaveLowongan())) {
            int id = view.getIdLowongan();
            System.out.println("id : "+id);
            String nama = view.getLowonganBaru();
            System.out.println("nama : "+nama);
            
            Date dd = view.getDeadline();
            System.out.println(dd.toString());
            int hasil = model.addLowongan(p2, id, nama, dd);
            if (hasil == 1){
                JOptionPane.showMessageDialog(null, "data lowongan baru berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "data lowongan baru gagal disimpan");
            }

//            int day = view.getDay();
//            int month = view.getMonth();
//            int year = view.getYear();
//            System.out.println(day +" "+month+" "+year);
            

        } else if (source.equals(view.getBtnOK())){
            System.out.println("yohohoh");
            int idHapus = view.getHapus();
            
        }
    }
    
}
