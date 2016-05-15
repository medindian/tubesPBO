package control;

import model.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import view.*;

class controllerLupaPass implements ActionListener{
    
    private aplikasi model;
    private lupaPass view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;

    public controllerLupaPass(aplikasi model) {
        this.model = model;
        view = new lupaPass();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(view.getBtnBack())){
            new controller(model);
            System.out.println("back to login");
            view.dispose();
            
        } else if (source.equals(view.getBtnCheck())){
//            System.out.println("hahahahaha");
            String id = view.getIdAkunDicari();
            int idAkun = Integer.parseInt(id);
            String nama = view.getNamaDicari();
            String passBaru = String.valueOf(view.getPassBaru());
            
            Owner p = model.cariAkun(idAkun, nama);
            
            if (p == null){
                JOptionPane.showMessageDialog(null, "Akun tidak terdaftar", "Fail",
                                JOptionPane.WARNING_MESSAGE);
            } else {
                p.setPassword(passBaru);
                if (p instanceof Pelamar){
                    p1 = (model.Pelamar) p;
                    boolean hasil = model.lupaPassPelamar(p1);
                    if (hasil == false)
                        JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                } else 
                if (p instanceof Perusahaan){
//                    model.isPelamar(p);
                    p2 = (model.Perusahaan) p;
                    boolean hasil = model.lupaPassPerusahaan(p2);
                    
                    if (hasil == false)
                        JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                }
            }
            view.setKosong();
        }
    }
    
    
}
