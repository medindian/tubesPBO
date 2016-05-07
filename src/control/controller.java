package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.Date;
import javax.swing.JOptionPane;
import view.MainMenu;
//urutan gui pelamar
import view.loginPelamar;
import view.LupaPassPelamar;
import view.daftarBaruPelamar;
import view.MenuPelamar;
import view.viewBerkas;
import view.cariLowongan;
import view.createBerkas;
import view.GantiPasswordPelamar;
//urutan gui perusahaan
import view.loginPerusahaan;
import view.LupaPassPerusahaan;
import view.daftarBaruPerusahaan;
import view.MenuPerusahaan;
import view.settingLowongan;
import view.viewBerkasDiterima;
import view.viewBerkasMasuk;
import view.GantiPasswordPerusahaan;

import view.View;
//import model.AplikasiKonsol;
import model.Pelamar;
import model.Perusahaan;
import model.aplikasi;

public class controller implements ActionListener {//implements ActionListener{

    private aplikasi model;
    private View view;
    private Pelamar p1 = null;
    private Perusahaan p2 = null;
    
    public controller(aplikasi app) {
        this.model = app;
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        menu.addListener(this);
        view = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        //gui MainMenu
        if (view instanceof MainMenu) {
            MainMenu menu = (MainMenu) view;
            if (source.equals(menu.getBtnExit())) {
                System.exit(0);
            }
            else if (source.equals(menu.getBtnPelamar())){
                loginPelamar p = new loginPelamar();
                p.setVisible(true);
                p.addListener(this);
                menu.dispose();
                view = (View) p; }
            else if (source.equals(menu.getBtnPerusahaan())){
                loginPerusahaan p = new loginPerusahaan();
                p.setVisible(true);
                p.addListener(this);
                menu.dispose();
                view = (View) p; }
        }
        //gui loginPelamar
        else if (view instanceof loginPelamar){
            loginPelamar lp = (loginPelamar) view;
            if (source.equals(lp.getBtnBack())){
                    MainMenu m = new MainMenu();
                    m.setVisible(true);
                    m.addListener(this);
                    lp.dispose();
                    view = (View) lp;
            } else if (source.equals(lp.getBtnLogin())){
                String idAkun = lp.getIdAkun();
                String pass = String.valueOf(lp.getPass());
                if (idAkun.equals("")){
                    JOptionPane.showMessageDialog((Component) view, "idAkun tidak boleh kosong");
                } else if(pass.equals("")){
                    JOptionPane.showMessageDialog((Component) view, "password tidak boleh kosong");
                }
                p1 = model.loginPelamar(idAkun, pass);
                if (p1 == null)
                    JOptionPane.showMessageDialog((Component) view, "login gagal");
                else {
                    JOptionPane.showMessageDialog((Component) view, "login berhasil");
                    MenuPelamar mp = new MenuPelamar();
                    mp.setVisible(true);
                    mp.addListener(this);
                    view = (View) mp;
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
                daftarBaruPelamar c = new daftarBaruPelamar();
                c.setVisible(true);
                c.addListener(this);
                lp.dispose();
                view = (View) c;
            }
        }
        //gui daftarBaruPelamar
        else if(view instanceof daftarBaruPelamar){
            daftarBaruPelamar h = (daftarBaruPelamar) view;
            if (source.equals(h.getBtnBack())){
                loginPelamar p = new loginPelamar();
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
                loginPelamar p = new loginPelamar();
                p.setVisible(true);
                p.addListener(this);
                j.dispose();
                view = (View)p;
            } else if (source.equals(j.getBtnUbahPass())){
                GantiPasswordPelamar g = new GantiPasswordPelamar();
                g.setVisible(true);
                g.addListener(this);
                j.dispose();
                view = (View)g;
            } else if (source.equals(j.getBtnViewBerkas())){
                viewBerkas k = new viewBerkas();
                k.setVisible(true);
                k.addListener(this);
                j.dispose();
                view = (View) k;
            } //else if (source.equals(u.getBtnStatus()))
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
                p2 = model.loginPerusahaan(idAkun, pass);
                if (p2 == null){
                    JOptionPane.showMessageDialog((Component) view, "login gagal");
                }
//                else {
//                    JOptionPane.showMessageDialog((Component) view, "login berhasil");
//                    MenuPerusahaan mp = new MenuPerusahaan();
//                    mp.setVisible(true);
//                    mp.addListener(this);
//                    view = (View) mp;
//                }
                idAkun = "";
                pass = "";
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
                String idAkun = dp.getIdAkun();
                String namaP = dp.getNamaPer();
                String passP = String.valueOf(dp.getPassPer());
                if(p2 == null){
                    p2 = new Perusahaan(idAkun, namaP, passP);
                    int b = model.addPerusahaan(p2.getIdAkun(), p2.getNama(), p2.getPassword());
                    if (b == 1)
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                    else
                        JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                                JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        //gui MenuPerusahaan
        else if (view instanceof MenuPerusahaan){
            MenuPerusahaan mp = (MenuPerusahaan) view;
            if (source.equals(mp.getBtnAturLowongan())){
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
            } else if (source.equals(mp.getBtnLogout())){
                loginPerusahaan a = new loginPerusahaan();
                a.setVisible(true);
                a.addListener(this);
                mp.dispose();
                view = (View) a;
            } else if (source.equals(mp.getBtnUbahPassword())){
                GantiPasswordPerusahaan g = new GantiPasswordPerusahaan();
                g.setVisible(true);
                g.addListener(this);
                mp.dispose();
                view = (View) g;
            } else if (source.equals(mp.getBtnViewBerkasMasuk())){
                viewBerkasMasuk w = new viewBerkasMasuk();
                w.setVisible(true);
                w.addListener(this);
                mp.dispose();
                view = (View) w;   }
        }
        //gui GantiPasswordPelamar
        else if (view instanceof GantiPasswordPelamar){
            GantiPasswordPelamar g = (GantiPasswordPelamar) view;
            if (source.equals(g.getBtnBack2())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                g.dispose();
                view = (View) r;
            } else if (source.equals(g.getBtnVerivikasi())){
                //simpan password baru
                String lama = String.valueOf(g.getPassOld());
                String baru = String.valueOf(g.getPassNew());
//                model.gantiPasswordPelamar(p1.getIdAkun(), lama, baru);
            }
        }
        //gui GantiPasswordPerusahaan
        else if (view instanceof GantiPasswordPerusahaan){
            GantiPasswordPerusahaan d = (GantiPasswordPerusahaan) view;
            if (source.equals(d.getBtnBack2())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                d.dispose();
                view = (View) r;
            } else if (source.equals(d.getBtnVerivikasi())){
                //simpan password baru
                String lama = String.valueOf(d.getPassLama());
                String baru = String.valueOf(d.getPassBaru());
//                model.gantiPasswordPerusahaan(p2.getIdAkun(), lama, baru);  
            }
        }
        //gui LupaPassPelamar
        else if (view instanceof LupaPassPelamar){
            LupaPassPelamar s = (LupaPassPelamar) view;
            if (source.equals(s.getBtnBack2())){
                loginPelamar p = new loginPelamar();
                p.setVisible(true);
                p.addListener(this);
                s.dispose();
                view = p;           
            } else if (source.equals(s.getBtnCheck())){
                String idAkun = s.getIdAkunDicari();
                String nama = s.getNamaDicari();
                String passBaru = String.valueOf(s.getPassBaru());
                boolean berhasil = model.lupaPassPelamar(idAkun, nama, passBaru);
                if (berhasil == true)
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);   }
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
                if (hasil == true)
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);   }
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
                String idAkun = p1.getIdAkun();
                String cv = t.getIsiCV();
                String slk = t.getIsiSLK();
                model.buatBerkas(idAkun, cv, slk);
//                model.getPelamar(p1.getNama()).createBerkas(cv, slk);
                //mengambil isi kotak cv & slk
                //bila salah satu atau keduanya kosong, muncul notifikasi 'kotak tidak boleh kosong'
            }
        }
        //gui settingLowongan
        else if (view instanceof settingLowongan){
            settingLowongan o = (settingLowongan) view;
            if (source.equals(o.getBtnBack())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                o.dispose();
                view = r;
            } else if (source.equals(o.getBtnOK())){
                int id = o.getIdxLowongan();
//                model.hapusLowongan(p2, id);
                //mengambil no urut array dari no urut pilihan
                //data dgn array tst dihapus
            } else if (source.equals(o.getBtnSaveLowongan())){
                String nama = o.getName();
//                Date dd = o.getDeadline();
//                model.getPerusahaan(p2.getNama()).createLowongan(nama, dd);
                //menyimpan data lowongan baru pada array tertentu
                //bila lowongan penuh, maka muncul notifikasi 'daftar lowongan sudah penuh'
            }            
        }
        //gui viewBerkas
        else if (view instanceof viewBerkas){
            viewBerkas k = (viewBerkas) view;
//            String output = model.getPelamar(p1.getIdAkun()).toString();
//            k.setTxtOutput(output);
            if (source.equals(k.getBtnBack3())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                k.dispose();
                view = r;
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
        }
    }
        }
*/    
    }
}