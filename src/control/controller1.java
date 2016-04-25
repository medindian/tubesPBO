package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class controller1 implements ActionListener{

    private AplikasiKonsol model;
    private View view;
    
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
                view = p; }
            else if (source.equals(menu.getBtnPerusahaan())){
                perusahaan pp = new perusahaan();
                pp.setVisible(true);
                pp.addListener(this);
                menu.dispose();
                view = pp; }
            }
        //gui pelamar
        else if (view instanceof pelamar) {
            pelamar a = (pelamar) view;
            if (source.equals(a.getBtnBack2())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                a.dispose();
                view = m;
            } else if (source.equals(a.getBtnLogin())) {
                loginPelamar lp = new loginPelamar();
                lp.setVisible(true);
                lp.addListener(this);
                a.dispose();
                view = lp;
            } else if (source.equals(a.getBtnDaftar())) {
                daftarBaruPelamar d = new daftarBaruPelamar();
                d.setVisible(true);
                d.addListener(this);
                a.dispose();
                view = d;
            } else if (source.equals(a.getBtnViewPelamar())) {
                viewPelamarTerdaftar vp = new viewPelamarTerdaftar();
                vp.setVisible(true);
                vp.addListener(this);
                a.dispose();
                view = vp;  }
            }
        //gui loginPelamar
        else if (view instanceof loginPelamar){
            loginPelamar n = (loginPelamar) view;
            if (source.equals(n.getBtnLogin2())){
                MenuPelamar mp = new MenuPelamar();
                mp.setVisible(true);
                mp.addListener(this);
                n.dispose();
                view = mp;  
            } else if (source.equals(n.getBtnBack())){
                pelamar pl = new pelamar();
                pl.setVisible(true);
                pl.addListener(this);
                n.dispose();
                view = pl;  }
            }
        //gui daftarBaruPelamar
        else if(view instanceof daftarBaruPelamar){
            daftarBaruPelamar dp = new daftarBaruPelamar();
            if (source.equals(dp.getBtnBack())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                dp.dispose();
                view = p;
            } else if (source.equals(dp.getBtnSignin())){
                MenuPelamar m = new MenuPelamar();
                m.setVisible(true);
                m.addListener(this);
                dp.dispose();
                view = m;       }
        }
        //gui viewPelamarTerdaftar
        else if(view instanceof viewPelamarTerdaftar){
            viewPelamarTerdaftar v = new viewPelamarTerdaftar();
            if(source.equals(v.getBtnBack2())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                v.dispose();
                view = p;
            }// else if (source.equals(v.getBtnRefresh())){
                //edit lg   }
            }
        //gui MenuPelamar
        else if (view instanceof MenuPelamar){
            MenuPelamar u = new MenuPelamar();
            if (source.equals(u.getBtnCari())){
                cariLowongan c = new cariLowongan();
                c.setVisible(true);
                c.addListener(this);
                u.dispose();
                view = c;   }
            else if (source.equals(u.getBtnCreateBerkas())){
                createBerkas cb = new createBerkas();
                cb.setVisible(true);
                cb.addListener(this);
                u.dispose();
                view = cb;  }
            else if (source.equals(u.getBtnLogout())){
                pelamar p = new pelamar();
                p.setVisible(true);
                p.addListener(this);
                u.dispose();
                view = p;
            } else if (source.equals(u.getBtnUbahBio())){
                editBioPelamar ep = new editBioPelamar();
                ep.setVisible(true);
                ep.addListener(this);
                u.dispose();
                view = ep;
            } else if (source.equals(u.getBtnUbahPass())){
                GantiPasswordPelamar g = new GantiPasswordPelamar();
                g.setVisible(true);
                g.addListener(this);
                u.dispose();
                view = g;
            } else if (source.equals(u.getBtnViewBerkas())){
                viewBerkas k = new viewBerkas();
                k.setVisible(true);
                k.addListener(this);
                u.dispose();
                view = (View) k;
            }//else if (source.equals(u.getBtnStatus()))
        }
        //gui perusahaan
        else if(view instanceof perusahaan) {
            perusahaan b = (perusahaan) view;
            if (source.equals(b.getBtnBack2())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                b.dispose();
                view = m;
            } else if (source.equals(b.getBtnLogin2())) {
                loginPerusahaan c = new loginPerusahaan();
                c.setVisible(true);
                c.addListener(this);
                b.dispose();
                view = c;
            } else if (source.equals(b.getBtnDaftar())) {
                daftarBaruPerusahaan db = new daftarBaruPerusahaan();
                db.setVisible(true);
                db.addListener(this);
                b.dispose();
                view = db;
            } else if (source.equals(b.getBtnViewDaftarPerusahaan())) {
                viewPerusahaanTerdaftar pp = new viewPerusahaanTerdaftar();
                pp.setVisible(true);
                pp.addListener(this);
                b.dispose();
                view = (View) pp;        }
            }
        //gui loginPerusahaan
        else if (view instanceof loginPerusahaan){
            
        }
        //gui daftarBaruPerusahaan
        else if (view instanceof daftarBaruPerusahaan){
            
        }
        //gui viewDaftarPerusahaan
        else if (view instanceof viewPerusahaanTerdaftar){
            
        }
    }
}

