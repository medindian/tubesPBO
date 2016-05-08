package control;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import view.*;
import model.*;

public class controller implements ActionListener {

    private aplikasi model;
    private login view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
    
    public controller(aplikasi app) {
        this.model = app;
        view = new login();
        view.setVisible(true);
        view.addListener(this);
    }
    
    public Pelamar getPelamar(){
        return p1;
    }
    
    public Perusahaan getPerusahaan(){
        return p2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        //login
        if (view instanceof login) {
            login p = (login) view;
            if (source.equals(p.getBtnBack())) {
                System.exit(0);
            } else if (source.equals(p.getBtnForgetPass())){
                new controllerLupaPass(model);
                view.dispose();
            } else if (source.equals(p.getBtnAkunBaruPel())) {
                new controllerAkunBaru(model);
                view.dispose();
            } else if (source.equals(p.getBtnLogin())){
                String idAkun = p.getIdAkun();
                String pass = String.valueOf(p.getPass());
                if (idAkun.equals(""))
                    JOptionPane.showMessageDialog((Component) view, "idAkun tidak boleh kosong");
                else if(pass.equals(""))
                    JOptionPane.showMessageDialog((Component) view, "password tidak boleh kosong");
                else {
                    int check = model.checkLogin(idAkun, pass);
                    if(check == 1){
                        Owner w = model.login(idAkun, pass);
                        System.out.println("idakun : " + w.getIdAkun());
                        System.out.println("nama akun : " + w.getNama());
                        if(w instanceof Pelamar)
                            p1 = (model.Pelamar) model.login(idAkun, pass);
                        else if (w instanceof Perusahaan)
                            p2 = (model.Perusahaan) model.login(idAkun, pass);
                        
                        if (p1 == null || p2 == null)
                            JOptionPane.showMessageDialog((Component) view, "login gagal");
                        else if (p1 != null) {
                            JOptionPane.showMessageDialog((Component) view, "login berhasil");
                            new ControllerMenuPelamar(model, p1);
                            p.dispose();    }
                        else if (p2 != null) {
                            JOptionPane.showMessageDialog((Component) view, "login berhasil");
                            new ControllerMenuPerusahaan(model, p2);
                            p.dispose();    }
                        
                    } else if (check == 2)
                        JOptionPane.showMessageDialog((Component) view, "password salah");
                    else
                        JOptionPane.showMessageDialog((Component) view, "akun tidak ada");
                }
                idAkun = "";
                pass = "";
        }
/*        
        //gui login
        else if (view instanceof login){
            login lp = (login) view;
            if (source.equals(lp.getBtnBack())){
                    MainMenu m = new MainMenu();
                    m.setVisible(true);
                    m.addListener(this);
                    lp.dispose();
                    view = (View) lp;
            } else if (source.equals(lp.getBtnLogin())){
                String idAkun = lp.getIdAkun();
                String pass = String.valueOf(lp.getPass());
                if (idAkun.equals(""))
                    JOptionPane.showMessageDialog((Component) view, "idAkun tidak boleh kosong");
                else if(pass.equals(""))
                    JOptionPane.showMessageDialog((Component) view, "password tidak boleh kosong");
                else {
                    int check = model.checkLogin(idAkun, pass);
                    if( check == 1){
                        if(model.login(idAkun, pass) instanceof Pelamar){
                        p1 = (model.Pelamar) model.login(idAkun, pass);
                        if (p1 == null)
                            JOptionPane.showMessageDialog((Component) view, "login gagal");
                        else {
                            JOptionPane.showMessageDialog((Component) view, "login berhasil");
                            MenuPelamar mp = new MenuPelamar();
                            mp.setVisible(true);
                            mp.addListener(this);
                            lp.dispose();
                            view = (View) mp;   }
                        }
                    } else if (check == 2)
                        JOptionPane.showMessageDialog((Component) view, "password salah");
                    else
                        JOptionPane.showMessageDialog((Component) view, "akun tidak ada");
                }
                idAkun = "";
                pass = "";
            } else if (source.equals(lp.getBtnForgetPass())){
                LupaPassPelamar s = new LupaPassPelamar();
                s.setVisible(true);
                s.addListener(this);
                lp.dispose();
                view = (View) s;
            } else if (source.equals(lp.getBtnAkunBaruPel())) {
                buatAkunBaru c = new buatAkunBaru();
                c.setVisible(true);
                c.addListener(this);
                lp.dispose();
                view = (View) c;
            }
        }
        //gui loginPerusahaan
        else if(view instanceof loginPerusahaan) {
            loginPerusahaan lr = (loginPerusahaan) view;
            if (source.equals(lr.getBtnBack())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                lr.dispose();
                view = lr;
            } else if (source.equals(lr.getBtnAkunBaru())) {
                daftarBaruPerusahaan db = new daftarBaruPerusahaan();
                db.setVisible(true);
                db.addListener(this);
                lr.dispose();
                view = db;
            } else if (source.equals(lr.getBtnForgetPass())){
                LupaPassPelamar s = new LupaPassPelamar();
                s.setVisible(true);
                s.addListener(this);
                lr.dispose();
                view = (View) s;   
            } else if (source.equals(lr.getBtnLogin())) {
                String idAkun = lr.getIdAkun();
                String pass = String.valueOf(lr.getPassPer());
                if (idAkun.equals(""))
                    JOptionPane.showMessageDialog((Component) view, "idAkun tidak boleh kosong");
                else if(pass.equals(""))
                    JOptionPane.showMessageDialog((Component) view, "password tidak boleh kosong");
                else {
                    if(model.login(idAkun, pass) instanceof Perusahaan){
                        p2 = (model.Perusahaan) model.login(idAkun, pass);
                        if (p2 == null){
                            JOptionPane.showMessageDialog((Component) view, "login gagal");
                        }
                        else {
                            JOptionPane.showMessageDialog((Component) view, "login berhasil");
                            MenuPerusahaan mp = new MenuPerusahaan();
                            mp.setVisible(true);
                            mp.addListener(this);
                            lr.dispose();
                            view = (View) mp;
                        }
                    }
                }
            }
        }
        //gui buatAkunBaru
        else if(view instanceof buatAkunBaru){
            buatAkunBaru h = (buatAkunBaru) view;
            if (source.equals(h.getBtnBack())){
                login p = new login();
                p.setVisible(true);
                p.addListener(this);
                h.dispose();
                view = (View) p;
            }
            else if (source.equals(h.getBtnSavePel())){
                String id = h.getIdAkunPel();
                String nama = h.getNamaPel();
                String pass = String.valueOf(h.getPassPel());
                if(p1 == null){
                    p1 = new Pelamar(id, nama, pass);
                    int a = model.addPelamar(p1.getIdAkun(), p1.getNama(), p1.getPassword());
                    if (a == 1)
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                    else
                        JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        //gui daftarBaruPerusahaan
        else if (view instanceof daftarBaruPerusahaan){
            daftarBaruPerusahaan dp = (daftarBaruPerusahaan) view;
            if (source.equals(dp.getBtnBack())){
                loginPerusahaan p = new loginPerusahaan();
                p.setVisible(true);
                p.addListener(this);
                dp.dispose();
                view = (View) p;
            }
            else if (source.equals(dp.getBtnSave2())){
                String id = dp.getIdAkun();
                String namaP = dp.getNamaPer();
                String passP = String.valueOf(dp.getPassPer());
                if(p2 == null){
                    p2 = new Perusahaan(id, namaP, passP);
                    int b = model.addPerusahaan(id, namaP, passP);
                    if (b == 1)  JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                    else JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                }
            }
        }        
        //gui MenuPelamar
        else if (view instanceof MenuPelamar){
            MenuPelamar j = (MenuPelamar) view;
            if (source.equals(j.getBtnCari())){
                cariLowongan c = new cariLowongan();
                c.setVisible(true);
                c.addListener(this);
                j.dispose();
                view = (View) c;   }
            else if (source.equals(j.getBtnCreateBerkas())){
                createBerkas cb = new createBerkas();
                cb.setVisible(true);
                cb.addListener(this);
                j.dispose();
                view = (View)cb;  }
            else if (source.equals(j.getBtnLogout())){
                login p = new login();
                p.setVisible(true);
                p.addListener(this);
                j.dispose();
                view = (View)p;
            } else if (source.equals(j.getBtnUbahBio())){
                editBioPelamar ed = new editBioPelamar();
                ed.setVisible(true);
                ed.addListener(this);
                j.dispose();
                view = (View) ed;
            } else if (source.equals(j.getBtnStatus())){
                
            }
        }
        //gui MenuPerusahaan
        else if (view instanceof MenuPerusahaan){
            MenuPerusahaan mp = (MenuPerusahaan) view;
            if (source.equals(mp.getBtnLogout())){
                loginPerusahaan a = new loginPerusahaan();
                a.setVisible(true);
                a.addListener(this);
                mp.dispose();
                view = (View) a;
            } else if (source.equals(mp.getBtnAturLowongan())){
                settingLowongan t = new settingLowongan();
                t.setVisible(true);
                t.addListener(this);
                mp.dispose();
                view = (View) t;
            } else if (source.equals(mp.getBtnAturPenerimaan())){
                viewBerkasDiterima v = new viewBerkasDiterima();
                v.setVisible(true);
                v.addListener(this);
                mp.dispose();
                view = (View) v;
            } else if (source.equals(mp.getBtnViewBerkasMasuk())){
                viewBerkasMasuk w = new viewBerkasMasuk();
                w.setVisible(true);
                w.addListener(this);
                mp.dispose();
                view = (View) w;
            } else if (source.equals(mp.getBtnAturBio())){
                editBioPerusahaan eb = new editBioPerusahaan();
                eb.setVisible(true);
                eb.addListener(this);
                mp.dispose();
                view = (View) eb;
            }
        }
        //gui editBioPelamar
        else if (view instanceof editBioPelamar){
            editBioPelamar pr = (editBioPelamar) view;
            if(source.equals(pr.getBtnBack())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                pr.dispose();
                view = (View) r;
            } else if (source.equals(pr.getBtnSimpan())){
                String nama = pr.getNama();
                String pLama = String.valueOf(pr.getPassOld());
                String pBaru = String.valueOf(pr.getPassNew());
                int a = model.ubahPelamar(p1, nama, pLama, pBaru);
                if (a == 1)  JOptionPane.showMessageDialog(null, "Perubahan data berhasil disimpan");
                else JOptionPane.showMessageDialog(null, "Perubahan data gagal disimpan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
            }
        }
        //gui editBioPerusahaan
        else if (view instanceof editBioPerusahaan){
            editBioPerusahaan pr = (editBioPerusahaan) view;
            if(source.equals(pr.getBtnBack())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                pr.dispose();
                view = (View) r;
            } else if (source.equals(pr.getBtnSimpan())){
                String nama = pr.getNamaPer();
                String passBaru = String.valueOf(pr.getPass());
                int a = model.ubahPerusahaan(p2, nama, passBaru);
                if (a == 1)  JOptionPane.showMessageDialog(null, "Password berhasil diganti");
                else JOptionPane.showMessageDialog(null, "Password gagal diganti", "Fail",
                                JOptionPane.WARNING_MESSAGE);
            }
        }
        //gui LupaPassPelamar
        else if (view instanceof LupaPassPelamar){
            LupaPassPelamar s = (LupaPassPelamar) view;
            if (source.equals(s.getBtnBack2())){
                login p = new login();
                p.setVisible(true);
                p.addListener(this);
                s.dispose();
                view = p;           
            } else if (source.equals(s.getBtnCheck())){
                String idAkun = s.getIdAkunDicari();
                String nama = s.getNamaDicari();
                String passBaru = String.valueOf(s.getPassBaru());
                boolean berhasil = model.lupaPassPelamar(idAkun, nama, passBaru);
                if (berhasil == true) JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                else JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                }
        }
        //gui LupaPassPerusahaan
        else if (view instanceof LupaPassPerusahaan){
            LupaPassPerusahaan h = (LupaPassPerusahaan) view;
            if (source.equals(h.getBtnBack2())){
                loginPerusahaan p = new loginPerusahaan();
                p.setVisible(true);
                p.addListener(this);
                h.dispose();
                view = p;
            } else if (source.equals(h.getBtnCheck())){
                String idPrsh = h.getIdAkun();
                String nama = h.getNamaDicari();
                String passBaru = String.valueOf(h.getPassBaru());
                boolean hasil = model.lupaPassPerusahaan(idPrsh, nama, passBaru);
                if (hasil == true) JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                else JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);
            }
        }
        //gui createBerkas
        else if (view instanceof createBerkas){
            createBerkas t = (createBerkas) view;
            if (source.equals(t.getBtnBack())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                t.dispose();
                view = r;
            } else if (source.equals(t.getBtnSaveBrk())){
                String cv = t.getCV();
                String slk = t.getSLK();
                try {
                    int a = model.buatBerkas(p1, cv, slk);
                    if (a == 1) JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                    else JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error", "Fail",JOptionPane.WARNING_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "CV dan SLK tidak dapat ditemukan", "Fail",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        /*
        //gui cariLowongan
        else if (view instanceof cariLowongan){
            cariLowongan c = (cariLowongan) view;
            if (source.equals(c.getBtnBack())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                c.dispose();
                view = r;
            } else if (source.equals(c.getBtnCariAll())){
                int arP = c.getPerusahaan();
                int low = c.getLowonganPilihan();
//                String hasil = model.cariPekerjaan(arP, low);
//                c.setTxtOutput(hasil);
                //mengambil teks nama & lowongan yg ada pada gui
                //bila salah satu kotak kosong, munculkan notif harus diisi semua
                //bila lowongan ada, maka munculkan pada output
                //bila tidak ada, munculkan notif 'lowongan tidak ada'
//            }
//            else if (source.equals(c.getBtnCariAll())){
//                int arP = c.getPerusahaan();
//                int low = c.getLowonganPilihan();
//                String hasil = model.cari
//                //mengambil teks nama lowongan yg ada pada gui
                //bila salah satu kotak nama lowongan kosong, munculkan 
                    //notif kotak nama lowongan harus diisi
                //bila lowongan ada, maka munculkan pada output
                //bila tidak ada, munculkan notif 'lowongan tidak ada'                
//            } else if (source.equals(c.getBtnCariPerusahaan())){
//                int arP = c.getPerusahaan();
//                p2 = model.getPrById(arP);
//                int id = 0;
//                String hasil = model.jobByPerusahaan(arP);
//                c.setTxtOutput(hasil);
//                JOptionPane.showMessageDialog(null, "Error", "Fail", JOptionPane.WARNING_MESSAGE);
                //mengambil teks nama perusahaan yg ada pada gui
                //bila salah satu kotak nama lowongan kosong, munculkan 
                    //notif kotak nama lowongan harus diisi
                //bila lowongan ada, maka munculkan pada output
                //bila tidak ada, munculkan notif 'lowongan tidak ada'
//            } else if (source.equals(c.getBtnDaftar())){
//                model.daftar(p1, p2, 0);
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
                //mengambil lowongan dari no urut yg dipilih
                //bila belum dipilih, maka notif akan muncul
                //bila sudah dan berhasil dilakukan, muncul notif 'anda berhasil terdaftar'
            }
////                String hasil = model.cariPekerjaan(arP, low);
//                c.setTxtOutput(hasil);
//                //mengambil teks nama & lowongan yg ada pada gui
//                //bila salah satu kotak kosong, munculkan notif harus diisi semua
//                //bila lowongan ada, maka munculkan pada output
//                //bila tidak ada, munculkan notif 'lowongan tidak ada'
//            }
//            else if (source.equals(c.getBtnCariNama())){
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
////                int low = c.getLowonganPilihan();
////                String hasil = model.cari
////                //mengambil teks nama lowongan yg ada pada gui
//                //bila salah satu kotak nama lowongan kosong, munculkan 
//                    //notif kotak nama lowongan harus diisi
//                //bila lowongan ada, maka munculkan pada output
//                //bila tidak ada, munculkan notif 'lowongan tidak ada'                
//            } else if (source.equals(c.getBtnCariPerusahaan())){
//                int arP = c.getPerusahaan();
//                p2 = model.getPrById(arP);
//                int id = 0;
//                String hasil = model.jobByPerusahaan(arP);
//                c.setTxtOutput(hasil);
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
//                //mengambil teks nama perusahaan yg ada pada gui
//                //bila salah satu kotak nama lowongan kosong, munculkan 
//                    //notif kotak nama lowongan harus diisi
//                //bila lowongan ada, maka munculkan pada output
//                //bila tidak ada, munculkan notif 'lowongan tidak ada'
//            } else if (source.equals(c.getBtnDaftar())){
//                model.daftar(p1, p2, 0);
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
//                //mengambil lowongan dari no urut yg dipilih
//                //bila belum dipilih, maka notif akan muncul
//                //bila sudah dan berhasil dilakukan, muncul notif 'anda berhasil terdaftar'
//            }
        }
        
        //gui settingLowongan
        else if (view instanceof settingLowongan){
            settingLowongan s = (settingLowongan) view;
            if (source.equals(s.getBtnBack())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                s.dispose();
                view = r;
            } else if (source.equals(s.getBtnOK())){
                String nama = s.getHapus();
                int hasil = model.deleteLowongan(p2, nama);
                if (hasil == 1) JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                else JOptionPane.showMessageDialog(null, "Data gagal dihapus", "Fail",
                            JOptionPane.WARNING_MESSAGE);
            } else if (source.equals(s.getBtnSaveLowongan())){
                String nama = s.getNamaBaru();
                Date dd = s.getDeadline();
                int hasil = model.addLowongan(p2, nama, dd);
                if (hasil == 1) JOptionPane.showMessageDialog(null, "Lowongan baru berhasil disimpan");
                else JOptionPane.showMessageDialog(null, "Lowongan baru gagal disimpan", "Fail",
                            JOptionPane.WARNING_MESSAGE);
            }     
        }
        //gui viewBerkasDiterima
        else if (view instanceof viewBerkasDiterima){
            viewBerkasDiterima ma = (viewBerkasDiterima) view;
            if (source.equals(ma.getBtnBack())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                ma.dispose();
                view = r;
            } else if (source.equals(ma.getBtnHapusBerkas())){
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
                //menghapus berkas berdasarkan no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
                //muncul notifikasi baik bila gagal maupun berhasil
            } else if (source.equals(ma.getBtnLihatIsiBerkas())){
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
                //melihat isi berkas berdasar no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
            }
        }
        //gui viewBerkasMasuk
        else if (view instanceof viewBerkasMasuk){
            viewBerkasMasuk ak = (viewBerkasMasuk) view;
            if (source.equals(ak.getBtnBack())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                ak.dispose();
                view = r;
            } else if (source.equals(ak.getBtnHapusBerkas())){
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
                //menghapus berkas berdasarkan no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
                //muncul notifikasi baik bila gagal maupun berhasil
            } else if (source.equals(ak.getBtnTerimaBerkas())){
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
                //menyimpan berkas berdasarkan no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
                //muncul notifikasi baik bila gagal maupun berhasil
            } else if (source.equals(ak.getBtnViewIsiBerkas())){
//                JOptionPane.showMessageDialog(null, "Error", "Fail",
//                            JOptionPane.WARNING_MESSAGE);
                //melihat isi berkas berdasar no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
            }
*/        }
    }
}