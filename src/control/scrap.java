package control;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import model.AplikasiKonsol;
import viewApp.GantiPasswordPelamar;
import viewApp.GantiPasswordPerusahaan;
import viewApp.LupaPassPelamar;
import viewApp.LupaPassPerusahaan;
import viewApp.PanelFrame;
import viewApp.cariByPerusahaan;
import viewApp.daftarBaru1;
import viewApp.daftarBaru2;
import viewApp.editBio1;
import viewApp.editBio2;
import viewApp.formLogin1;
import viewApp.formLogin2;
import viewApp.hakPelamar;
import viewApp.hakPerusahaan;
import viewApp.viewBerkas;
import viewApp.viewBerkasDiterima;
import viewApp.viewBerkasMasuk;
import viewApp.viewLowongan;
import viewApp.viewPelamarTerdaftar;
import viewApp.viewPerusahaanTerdaftar;

public class scrap {
/*        private AplikasiKonsol model;
    private PanelFrame view;
    private String currView;
    private JPanel mainPanel;

    private MainMenu m;    private hakPelamar pa;    private hakPerusahaan pb;
    private GantiPasswordPelamar ga;    private GantiPasswordPerusahaan gb;
    private LupaPassPelamar ppa;    private LupaPassPerusahaan ppb;
    private cariByPerusahaan c;
    private daftarBaru1 da;    private daftarBaru2 db;
    private editBio1 ba;    private editBio2 bb;
    private formLogin1 fa;    private formLogin2 fb;
    private viewBerkas vbb;    private viewBerkasDiterima vb1;
    private viewBerkasMasuk vb2;    private viewLowongan vl;
    private viewPelamarTerdaftar va;    private viewPerusahaanTerdaftar vb;
    
    public controller1(AplikasiKonsol model){
        this.model = model;
        this.view = new PanelFrame(); //mengambil JFrame bernama panelContrainer

        m = new MainMenu(); //mengambil GUI MainMenu
        pa = new hakPelamar(); //mengambil GUI hakPelamar  
        pb = new hakPerusahaan(); //mengambil GUI hakPerusahaan
        ga = new GantiPasswordPelamar(); //mengambil GUI GantiPasswordPelamar 
//        gb = new GantiPasswordPerusahaan(); //mengambil GUI GantiPasswordPerusahaan
        ppa = new LupaPassPelamar(); //mengambil GUI LupaPassPelamar
//        ppb = new LupaPassPerusahaan(); //mengambil GUI LupaPassPerusahaan
        c = new cariByPerusahaan(); //mengambil GUI cariByPerusahaan
        da = new daftarBaru1(); //mengambil GUI daftarBaru1 u/ pelamar
//        db = new daftarBaru2(); //mengambil GUI daftarBaru2 u/ perusahaan
        ba = new editBio1(); //mengambil GUI editBio1 u/ pelamar
//        bb = new editBio2(); //mengambil GUI editBio2 u/ perusahaan
        fa = new formLogin1(); //mengambil GUI formLogin1 u/ pelamar
//        fb = new formLogin2(); //mengambil GUI formLogin2 u/ perusahaan
//        vbb = new viewBerkas(); //mengambil GUI viewBerkas
//        vb1 = new viewBerkasDiterima(); //mengambil GUI viewBerkasDiterima
//        vb2 = new viewBerkasMasuk(); //mengambil GUI viewBerkasMasuk
//        vl = new viewLowongan(); //mengambil GUI viewLowongan
        va = new viewPelamarTerdaftar(); //mengambil GUI viewPelamarterdaftar
//        vb = new viewPerusahaanTerdaftar(); //mengambil GUI viewPerusahaanTerdaftar
        
        m.addListener(this);
        pa.addListener(this); //pelamar
        pb.addListener(this); //perusahaan
        ga.addListener(this); //gantiPass
//        gb.addListener(this);
        ppa.addListener(this); //lupaPass
//        ppb.addListener(this);
//        c.addListener(this);
        da.addListener(this); //daftar baru
//        db.addListener(this);
        ba.addListener(this); //edit bio
//        bb.addListener(this);
        fa.addListener(this); //login pelamar
//        fb.addListener(this);
//        vbb.addListener(this);
//        vb1.addListener(this);
//        vb2.addListener(this);
//        vl.addListener(this);
        va.addListener(this); //view daftar pelamar
//        vb.addListener(this);

        mainPanel = view.getMainPanel();
        mainPanel.add(m, "0");
        mainPanel.add(pa, "1");
        mainPanel.add(pb, "2");
        mainPanel.add(ga, "3");
        mainPanel.add(ppa, "4");
        mainPanel.add(da, "5");
        mainPanel.add(ba, "6");
        mainPanel.add(fa, "7");
        mainPanel.add(va, "8");
        
        currView = "0";   //posisi user di main menu

        view.getCardLayout()
                .show(mainPanel, currView); //untuk pertama tampil PanelContainer & MainMenu
        view.setVisible(true); //supaya keliatan
        view.addListener(this); //memberi interaksi
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            System.exit(0);        }
        if (currView.equals("0")) { //current view = Main Menu
            if (source.equals(m.getBtnPelamar())) {
                currView = "1";
                view.getCardLayout().show(mainPanel, currView);
            } else if (source.equals(m.getBtnPerusahaan())) {
                currView = "2";
                view.getCardLayout().show(mainPanel, currView);
            }
        } else if (currView.equals("1")) {
            //current view = Insert Employee
            if (source.equals(pa.getBtnBack2())) {
                currView = "0";
                view.getCardLayout().show(mainPanel, currView);
            } else if (source.equals(pa.getBtnLogin1())) {
                currView = ""
            }
                
            }
        } else if (currentView.equals("2")) {
            //current view = View Employee


    }
   */     
}
