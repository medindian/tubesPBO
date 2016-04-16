package viewApp;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class hakPerusahaan extends javax.swing.JPanel {

    public hakPerusahaan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin2 = new javax.swing.JButton();
        btnDaftar = new javax.swing.JButton();
        btnViewDaftarPerusahaan = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Anda memilih Akses Sebagai Perusahaan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Pilih menu :");

        btnLogin2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnLogin2.setText("Log In");

        btnDaftar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDaftar.setText("Daftar Baru");

        btnViewDaftarPerusahaan.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnViewDaftarPerusahaan.setText("List Perusahaan Terdaftar");

        btnBack2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack2.setText("Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLogin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewDaftarPerusahaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel2)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(btnLogin2)
                .addGap(18, 18, 18)
                .addComponent(btnDaftar)
                .addGap(18, 18, 18)
                .addComponent(btnViewDaftarPerusahaan)
                .addGap(18, 18, 18)
                .addComponent(btnBack2)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnLogin2;
    private javax.swing.JButton btnViewDaftarPerusahaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    public void addListener(ActionListener e){
        btnBack2.addActionListener(e);
        btnDaftar.addActionListener(e);
        btnLogin2.addActionListener(e);
        btnViewDaftarPerusahaan.addActionListener(e);
    }

    public JButton getBtnBack2() {
        return btnBack2;
    }

    public JButton getBtnDaftar() {
        return btnDaftar;
    }

    public JButton getBtnLogin2() {
        return btnLogin2;
    }

    public JButton getBtnViewDaftarPerusahaan() {
        return btnViewDaftarPerusahaan;
    }

    

}
