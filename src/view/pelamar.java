package view;

import java.awt.event.ActionListener;

public class pelamar extends javax.swing.JFrame implements View{

    public pelamar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin1 = new javax.swing.JButton();
        btnDaftar = new javax.swing.JButton();
        btnViewPelamar = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Anda memilih Akses Sebagai Pelamar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Pilih menu :");

        btnLogin1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnLogin1.setText("Log In");

        btnDaftar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDaftar.setText("Daftar Baru");

        btnViewPelamar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnViewPelamar.setText("List Pelamar Terdaftar");

        btnBack2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack2.setText("Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewPelamar, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel2)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(btnLogin1)
                .addGap(18, 18, 18)
                .addComponent(btnDaftar)
                .addGap(18, 18, 18)
                .addComponent(btnViewPelamar)
                .addGap(18, 18, 18)
                .addComponent(btnBack2)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btnViewPelamar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addListener(ActionListener e) {
        btnBack2.addActionListener(e);
        btnDaftar.addActionListener(e);
        btnLogin1.addActionListener(e);
        btnViewPelamar.addActionListener(e);
    }

    public Object getBtnBack2() {
        return btnBack2;    }

    public Object getBtnDaftar() {
        return btnDaftar;    }

    public Object getBtnLogin1() {
        return btnLogin1;    }

    public Object getBtnViewPelamar() {
        return btnViewPelamar;    }
    
    
}
