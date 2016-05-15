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
        System.out.println("perusahaan : " + p2.getNama() + " " + p2.getIdAkun());
        Object source = e.getSource();
        
        if (source.equals(view.getBtnBack())){
            System.out.println("button kembali ke menu perusahaan");
            new controllerMenuPerusahaan(model, p2);
            view.dispose();
            
        } else if (source.equals(view.getBtnSaveLowongan())) {
            System.out.println("button simpan");
            int id = view.getIdLowongan();
            String nama = view.getLowonganBaru();
            Date dd = view.getDeadline();
            int hasil = model.addLowongan(p2, id, nama, dd);
            if (hasil == 1){
                JOptionPane.showMessageDialog(null, "data lowongan baru berhasil disimpan");
            } else {
                JOptionPane.showMessageDialog(null, "data lowongan baru gagal disimpan");
            }

        } else if (source.equals(view.getBtnOK())){
            System.out.println("yohohoh");
            int idHapus = view.getHapus();
            
        }
    }
    
}
