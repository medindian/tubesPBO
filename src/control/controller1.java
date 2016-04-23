package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.AplikasiKonsol;
import view.MainMenu;
import view.View;
import view.daftarBaruPelamar;
import view.daftarBaruPerusahaan;
import view.viewPelamarTerdaftar;
import view.loginPelamar;
import view.loginPerusahaan;
import view.pelamar;
import view.perusahaan;
import viewApp.viewPerusahaanTerdaftar;

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
/*        else if (view instanceof pelamar) {
            pelamar a = (pelamar) view;
            if (source.equals(a.getBtnBack2())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                a.dispose();
                view = m;
            } else if (source.equals(a.getBtnDaftar())) {
                daftarBaruPelamar d = new daftarBaruPelamar();
                d.setVisible(true);
                d.addListener(this);
                a.dispose();
                view = d;
            } else if (source.equals(a.getBtnLogin())) {
                loginPelamar lp = new loginPelamar();
                lp.setVisible(true);
                lp.addListener(this);
                a.dispose();
                view = lp;
            } else if (source.equals(a.getBtnViewPelamar())) {
                viewPelamarTerdaftar vp = new viewPelamarTerdaftar();
                vp.setVisible(true);
                vp.addListener(this);
                a.dispose();
                view = vp;        }
            }
        else if(view instanceof perusahaan) {
            perusahaan b = (perusahaan) view;
            if (source.equals(b.getBtnBack2())) {
                MainMenu m = new MainMenu();
                m.setVisible(true);
                m.addListener(this);
                b.dispose();
                view = m;
            } else if (source.equals(b.getBtnDaftar())) {
                daftarBaruPerusahaan db = new daftarBaruPerusahaan();
                db.setVisible(true);
                db.addListener(this);
                b.dispose();
                view = db;
            } else if (source.equals(b.getBtnLogin2())) {
                loginPerusahaan c = new loginPerusahaan();
                c.setVisible(true);
                c.addListener(this);
                b.dispose();
                view = c;
            } else if (source.equals(b.getBtnViewDaftarPerusahaan())) {
                viewPerusahaanTerdaftar pp = new viewPerusahaanTerdaftar();
                pp.setVisible(true);
                pp.addListener(this);
                b.dispose();
                view = (View) pp;        }
            }
*/
    }

}

