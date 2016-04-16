package viewApp;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MenuPerusahaan extends javax.swing.JPanel {

    public MenuPerusahaan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLowongan = new javax.swing.JButton();
        btnPelamar = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Selamat Datang, ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Pilih menu :");

        btnLowongan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnLowongan.setText("Lowongan");

        btnPelamar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnPelamar.setText("Pelamar");

        btnSetting.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSetting.setText("Setting");

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnLogout.setText("Log Out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPelamar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLowongan, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(btnLowongan)
                .addGap(18, 18, 18)
                .addComponent(btnPelamar)
                .addGap(18, 18, 18)
                .addComponent(btnSetting)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLowongan;
    private javax.swing.JButton btnPelamar;
    private javax.swing.JButton btnSetting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
    public void addListener(ActionListener e){
        btnLowongan.addActionListener(e);
        btnPelamar.addActionListener(e);
        btnSetting.addActionListener(e);
        btnLogout.addActionListener(e);
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JButton getBtnLowongan() {
        return btnLowongan;
    }

    public JButton getBtnPelamar() {
        return btnPelamar;
    }

    public JButton getBtnSetting() {
        return btnSetting;
    }
    
    

}
