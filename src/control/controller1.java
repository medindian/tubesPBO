package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import view.GantiPasswordPelamar;
import view.MainMenu;
import view.MenuPelamar;
import view.View;
import view.cariLowongan;
import view.createBerkas;
import view.daftarBaruPelamar;
import view.daftarBaruPerusahaan;
import view.editBioPelamar;
import view.viewPelamarTerdaftar;
import view.loginPelamar;
import view.loginPerusahaan;
import view.pelamar;
import view.perusahaan;
import view.viewBerkas;
import view.viewPerusahaanTerdaftar;
import model.AplikasiKonsol;
import model.Pelamar;
import model.Perusahaan;
import view.GantiPasswordPerusahaan;
import view.LupaPassPelamar;
import view.LupaPassPerusahaan;
import view.MenuPerusahaan;
import view.editBioPerusahaan;
import view.settingLowongan;
import view.viewBerkasDiterima;
import view.viewBerkasMasuk;
//import database.DatabaseConnection;

public class controller1 implements ActionListener{

    private AplikasiKonsol model;
    private View view;
    private Pelamar p1;
    private Perusahaan p2;
    
    public controller1(AplikasiKonsol ap) {
        this.model = ap;
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        menu.addListener((ActionListener) this);
        view = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //gui MainMenu
        if (view instanceof MainMenu) {
            MainMenu menu = (MainMenu) view;
            if (source.equals(menu.getBtnExit())) {
                System.exit(0);
            }
            else if (source.equals(menu.getBtnPelamar())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                menu.dispose();
                view = (View) p; }
            else if (source.equals(menu.getBtnPerusahaan())){
                perusahaan pp = new perusahaan();
                pp.setVisible(true);
                pp.addListener(this);
                menu.dispose();
                view = (View) pp; }
            }
        //gui pelamar
        else if (view instanceof pelamar) {
            pelamar a = (pelamar) view;
            if (source.equals(a.getBtnBack2())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                a.dispose();
                view =  (View)m;
            } else if (source.equals(a.getBtnLogin())) {
                loginPelamar b = new loginPelamar();
                b.setVisible(true);
                b.addListener(this);
                a.dispose();
                view = (View) b;
            } else if (source.equals(a.getBtnDaftar())) {
                daftarBaruPelamar c = new daftarBaruPelamar();
                c.setVisible(true);
                c.addListener(this);
                a.dispose();
                view = (View) c;
            } else if (source.equals(a.getBtnViewPelamar())) {
                viewPelamarTerdaftar d = new viewPelamarTerdaftar();
                d.setVisible(true);
                d.addListener(this);
                a.dispose();
                view = (View) d;  }
            }
        //gui loginPelamar
        else if (view instanceof loginPelamar){
            loginPelamar f = (loginPelamar) view;
            if (source.equals(f.getBtnBack())){
                    pelamar pl = new pelamar();
                    pl.setVisible(true);
                    pl.addListener(this);
                    f.dispose();
                    view = (View) pl;  
            } else if (source.equals(f.getBtnLogin2())){
                String idAkun = f.getIdAkun();
                char[] pass = f.getPass();
                if (idAkun.equals("") || pass.equals("")){
                    JOptionPane.showMessageDialog((Component) view, "idAKun / password tidak boleh kosong");
                }
                p1 = model.loginPelamar(idAkun, pass);
//                idAkun = "";
//                pass = "";
//                if (hasil == false){
//                    JOptionPane.showMessageDialog((Component) view, "login gagal");
//                }
                MenuPelamar mp = new MenuPelamar();
                mp.setVisible(true);
                mp.addListener(this);
                f.dispose();
                view = mp;
            } else if (source.equals(f.getBtnForgetPass())){
                LupaPassPelamar s = new LupaPassPelamar();
                s.setVisible(true);
                s.addListener(this);
                f.dispose();
                view = (View) s;   }
        }
        //gui daftarBaruPelamar
        else if(view instanceof daftarBaruPelamar){
            daftarBaruPelamar h = (daftarBaruPelamar) view;
            if (source.equals(h.getBtnBack())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                h.dispose();
                view = (View) p;
            } 
            else if (source.equals(h.getBtnSignin())){
                String id = h.getIdAkun();
                String nama = h.getNamaPel();
                String alamat = h.getAddPel();
                String tlp = h.getTelpPel();
                String email = h.getEmailPel();
                String web = h.getWebPel();
                String tgl = h.getTglLahir();
                char[] pass = h.getPassPel();
                int a = model.addPelamar(id, nama, alamat, tlp, email, web, tgl, pass);
                if (a != 0){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);   }
                MenuPelamar mp = new MenuPelamar();
                mp.setVisible(true);
                mp.addListener(this);
                h.dispose();
                view = mp;
            }
        }
        //gui viewPelamarTerdaftar
        else if(view instanceof viewPelamarTerdaftar){
            viewPelamarTerdaftar i = (viewPelamarTerdaftar) view;
            i.setViewListPelamar(model.daftarPelamar());
            if(source.equals(i.getBtnBack2())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                i.dispose();
                view = (View)p; }
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
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                j.dispose();
                view = (View)p;
            } else if (source.equals(j.getBtnUbahBio())){
                editBioPelamar ep = new editBioPelamar();
                ep.setVisible(true);
                ep.addListener(this);
                j.dispose();
                view = (View)ep;
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
        //gui perusahaan
        else if(view instanceof perusahaan) {
            perusahaan k = (perusahaan) view;
            if (source.equals(k.getBtnBack2())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                k.dispose();
                view = m;
            } else if (source.equals(k.getBtnLogin2())) {
                loginPerusahaan c = new loginPerusahaan();
                c.setVisible(true);
                c.addListener(this);
                k.dispose();
                view = c;
            } else if (source.equals(k.getBtnDaftar())) {
                daftarBaruPerusahaan db = new daftarBaruPerusahaan();
                db.setVisible(true);
                db.addListener(this);
                k.dispose();
                view = db;
            } else if (source.equals(k.getBtnViewDaftarPerusahaan())) {
                viewPerusahaanTerdaftar pp = new viewPerusahaanTerdaftar();
                pp.setVisible(true);
                pp.addListener(this);
                k.dispose();
                view = (View) pp;        }
            }
        //gui loginPerusahaan
        else if (view instanceof loginPerusahaan){
            loginPerusahaan lo = (loginPerusahaan) view; 
            if (source.equals(lo.getBtnBack())){
                perusahaan p = new perusahaan();
                p.setVisible(true);
                p.addListener(this);
                lo.dispose();
                view = (View) p;
            } else if (source.equals(lo.getBtnLogin2())){
                String user = lo.getIdAkun();
                char[] pass = lo.getPassPer();
                p2 = model.loginPerusahaan(user, pass);
                if (user.equals("") || pass.equals("")){
                    JOptionPane.showMessageDialog((Component) view, "idAKun / password tidak boleh kosong");
                }
//                user = "";
//                pass = "";
                MenuPerusahaan mp = new MenuPerusahaan();
                mp.setVisible(true);
                mp.addListener(this);
                lo.dispose();
                view = (View) mp;
            } else if (source.equals(lo.getBtnForgetPass())){
                LupaPassPerusahaan r = new LupaPassPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                lo.dispose();
                view = (View) r;   }
        }
        //gui daftarBaruPerusahaan
        else if (view instanceof daftarBaruPerusahaan){
            daftarBaruPerusahaan dp = (daftarBaruPerusahaan) view;
            if (source.equals(dp.getBtnBack())){
                perusahaan p = new perusahaan();
                p.setVisible(true);
                p.addListener(this);
                dp.dispose();
                view = (View) p;
            } else if (source.equals(dp.getBtnSignin())){
                String id = dp.getIdAkun();
                String nama = dp.getNamaPer();
                String alamat = dp.getAddressPer();
                String tlp = dp.getTelpPer();
                String email = dp.getEmailPer();
                String web = dp.getWebPer();
                int thn = 0;
                String bank = dp.getBank();
                char[] pass = dp.getPassPer();
                int a = model.addPerusahaan(id, nama, alamat, tlp, web, email, thn, bank, pass);
                if (a != 0){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Diinputkan", "Fail",
                            JOptionPane.WARNING_MESSAGE);   }
                MenuPerusahaan mp = new MenuPerusahaan();
                mp.setVisible(true);
                mp.addListener(this);
                dp.dispose();
                view = (View) mp;  }
        }
        //gui viewPerusahaanTerdaftar
        else if (view instanceof viewPerusahaanTerdaftar){
            viewPerusahaanTerdaftar vp = (viewPerusahaanTerdaftar) view;
            vp.setViewList(model.daftarPerusahaan());
            if (source.equals(vp.getBtnBack2())){
                perusahaan p = new perusahaan();
                p.setVisible(true);
                p.addListener(this);
                vp.dispose();
                view = (View) p;
            }
        }
        //gui MenuPerusahaan
        else if (view instanceof MenuPerusahaan){
            MenuPerusahaan mp = (MenuPerusahaan) view;
            if (source.equals(mp.getBtnAturBio())){
                editBioPerusahaan b = new editBioPerusahaan();
                b.setVisible(true);
                b.addListener(this);
                mp.dispose();
                view = (View) b;
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
            } else if (source.equals(mp.getBtnLogout())){
                perusahaan a = new perusahaan();
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
                char[] lama = g.getPassOld();
                char[] baru = g.getPassNew();
                model.gantiPasswordPelamar(p1.getIdAkun(), lama, baru);
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
                char[] lama = d.getPassLama();
                char[] baru = d.getPassBaru();
                model.gantiPasswordPerusahaan(p2.getIdAkun(), lama, baru);            }
        }
        //gui LupaPassPelamar
        else if (view instanceof LupaPassPelamar){
            LupaPassPelamar s = (LupaPassPelamar) view;
            if (source.equals(s.getBtnBack2())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                s.dispose();
                view = p;                
            } else if (source.equals(s.getBtnCheck())){
                //cek password
                String nama = s.getIdAkunDicari();
                String email = s.getTxtEmailDicari();
                char[] passBaru = s.getTxtPassBaru();
                model.lupaPassPelamar(nama, email, passBaru);                    
                }
                //else muncul notif gagal
        }
        //gui LupaPassPerusahaan
        else if (view instanceof LupaPassPerusahaan){
            LupaPassPerusahaan h = (LupaPassPerusahaan) view;
            if (source.equals(h.getBtnBack2())){
                perusahaan p = new perusahaan();
                p.setVisible(true);
                p.addListener(this);
                h.dispose();
                view = p;
            } else if (source.equals(h.getBtnCheck())){
                String nama = h.getIdAkun();
                int thn = h.getThnDicari();
                char[] passBaru = h.getPassBaru();
                model.lupaPassPrsh(nama, thn, passBaru);
            }
        }
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
                String hasil = model.cariPekerjaan(arP, low);
                c.setTxtOutput(hasil);
                //mengambil teks nama & lowongan yg ada pada gui
                //bila salah satu kotak kosong, munculkan notif harus diisi semua
                //bila lowongan ada, maka munculkan pada output
                //bila tidak ada, munculkan notif 'lowongan tidak ada'
            } else if (source.equals(c.getBtnCariNama())){
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
//                int low = c.getLowonganPilihan();
//                String hasil = model.cari
//                //mengambil teks nama lowongan yg ada pada gui
                //bila salah satu kotak nama lowongan kosong, munculkan 
                    //notif kotak nama lowongan harus diisi
                //bila lowongan ada, maka munculkan pada output
                //bila tidak ada, munculkan notif 'lowongan tidak ada'                
            } else if (source.equals(c.getBtnCariPerusahaan())){
                int arP = c.getPerusahaan();
                p2 = model.getPrById(arP);
                int id = 0;
                String hasil = model.jobByPerusahaan(arP);
                c.setTxtOutput(hasil);
//                JOptionPane.showMessageDialog(null, "Error", "Fail", JOptionPane.WARNING_MESSAGE);
                //mengambil teks nama perusahaan yg ada pada gui
                //bila salah satu kotak nama lowongan kosong, munculkan 
                    //notif kotak nama lowongan harus diisi
                //bila lowongan ada, maka munculkan pada output
                //bila tidak ada, munculkan notif 'lowongan tidak ada'
            } else if (source.equals(c.getBtnDaftar())){
                model.daftar(p1, p2, 0);
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                //mengambil lowongan dari no urut yg dipilih
                //bila belum dipilih, maka notif akan muncul
                //bila sudah dan berhasil dilakukan, muncul notif 'anda berhasil terdaftar'
            }
        }
        //gui createBerkas
        else if (view instanceof createBerkas){
            createBerkas t = (createBerkas) view;
            if (source.equals(t.getBtnBack3())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                t.dispose();
                view = r;
            } else if (source.equals(t.getBtnSaveBrk())){
                String cv = t.getIsiCV();
                String slk = t.getIsiSLK();
                model.getPelamar(p1.getNama()).createBerkas(cv, slk);
                //mengambil isi kotak cv & slk
                //bila salah satu atau keduanya kosong, muncul notifikasi 'kotak tidak boleh kosong'
            }
        }
        //gui editBioPelamar
        else if (view instanceof editBioPelamar){
            editBioPelamar b = (editBioPelamar) view;
            if (source.equals(b.getBtnBack())){
                MenuPelamar r = new MenuPelamar();
                r.setVisible(true);
                r.addListener(this);
                b.dispose();
                view = r;
            } else if (source.equals(b.getBtnSimpan())){
                String nama = b.getNamaPel();
                String address = b.getAddPel();
                String email = b.getEmailPel();
                String telp = b.getTelpPel();
                String tgl = b.getTglLahir();
                String web = b.getWebPel();
                model.gantiBioPelamar(p1, nama, nama, telp, email, web);
                //menyimpan data baru dgn no urut array sama
                //akan dimunculkan data sebelumnya pada masing2 kotak
                //seluruh kotak tidak boleh kosong                
            }
        }
        //gui editBioPerusahaan
        else if (view instanceof editBioPerusahaan){
            editBioPerusahaan a = (editBioPerusahaan) view;
            if (source.equals(a.getBtnBack())){
                MenuPerusahaan r = new MenuPerusahaan();
                r.setVisible(true);
                r.addListener(this);
                a.dispose();
                view = r;
            } else if (source.equals(a.getBtnSimpan())){
                String nama = a.getNamaPer();
                String address = a.getAddressPer();
                String email = a.getEmailPer();
                String telp = a.getTelpPer();
                int tahun = 0;
                String web = a.getWebPer();
                String bank = a.getTxtbank();
                model.gantiBioPerusahaan(p2, nama, nama, telp, web, email, tahun, bank);
                //menyimpan data baru dgn no urut array sama
                //akan dimunculkan data sebelumnya pada masing2 kotak
                //seluruh kotak tidak boleh kosong
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
                model.hapusLowongan(p2, id);
                //mengambil no urut array dari no urut pilihan
                //data dgn array tst dihapus
            } else if (source.equals(o.getBtnSaveLowongan())){
                String nama = o.getName();
                Date dd = o.getDeadline();
                model.getPerusahaan(p2.getNama()).createLowongan(nama, dd);
                //menyimpan data lowongan baru pada array tertentu
                //bila lowongan penuh, maka muncul notifikasi 'daftar lowongan sudah penuh'
            }            
        }
        //gui viewBerkas
        else if (view instanceof viewBerkas){
            viewBerkas k = (viewBerkas) view;
            String output = model.getPelamar(p1.getIdAkun()).toString();
            k.setTxtOutput(output);
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
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                //menghapus berkas berdasarkan no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
                //muncul notifikasi baik bila gagal maupun berhasil
            } else if (source.equals(ma.getBtnLihatIsiBerkas())){
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                //menghapus berkas berdasarkan no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
                //muncul notifikasi baik bila gagal maupun berhasil
            } else if (source.equals(ak.getBtnTerimaBerkas())){
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                //menyimpan berkas berdasarkan no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
                //muncul notifikasi baik bila gagal maupun berhasil
            } else if (source.equals(ak.getBtnViewIsiBerkas())){
                JOptionPane.showMessageDialog(null, "Error", "Fail",
                            JOptionPane.WARNING_MESSAGE);
                //melihat isi berkas berdasar no urut berkas
                //mengambil no urut lowongan
                //mengambil no urut berkas
            }                    
        }
    }
    
}

