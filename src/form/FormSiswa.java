package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormSiswa extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormSiswa.class.getName());

    /**
     * Creates new form FormSiswa
     */
    public FormSiswa(int idUser, String username) {
        initComponents();

        this.idUser = idUser;
        this.username = username;

        lblUsername.setText("Halo, " + username);

        tampilkanMenu();
        tampilkanPesanan();

    }
    
    private int idUser;
    private String username;

    private void tampilkanMenu() {
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("ID");
    model.addColumn("Nama Menu");
    model.addColumn("Harga");
    model.addColumn("Kategori");

    try {
        Connection conn = koneksi.Koneksi.configDB();

        String sql = "SELECT * FROM menu";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama_menu"),
                rs.getInt("harga"),
                rs.getString("kategori")
            });
        }

        tblMenu.setModel(model);

        rs.close();
        pst.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal menampilkan menu: " + e.getMessage()
        );
    }
}
    
private void tampilkanPesanan() {
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("ID Pesanan");
    model.addColumn("Nama Menu");
    model.addColumn("Jumlah");
    model.addColumn("Total Harga");
    model.addColumn("Status");

    try {
        Connection conn = koneksi.Koneksi.configDB();

        String sql = "SELECT p.id, m.nama_menu, p.jumlah, "
                + "p.total_harga, p.status "
                + "FROM pesanan p "
                + "JOIN menu m ON p.menu_id = m.id "
                + "WHERE p.user_id = ? "
                + "ORDER BY p.id DESC";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idUser);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama_menu"),
                rs.getInt("jumlah"),
                rs.getInt("total_harga"),
                rs.getString("status")
            });
        }

        jScrollPane3.setModel(model);

        rs.close();
        pst.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal menampilkan pesanan: " + e.getMessage()
        );
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        btnPesan = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPesanan = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsername.setText("Dashboard Siswa");

        btnLogout.setText("Logout");

        jLabel1.setText("Jumlah");

        txtJumlah.setText("1");

        btnPesan.setText("Pesan");
        btnPesan.addActionListener(this::btnPesanActionPerformed);

        tblPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblPesanan);

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblMenu);

        jLabel4.setText("Menu");

        jLabel5.setText("Pesanan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPesan)
                                .addGap(134, 134, 134)
                                .addComponent(btnLogout))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(451, 451, 451)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesan)
                    .addComponent(btnLogout))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed

    int baris = tblMenu.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(
            this, "Pilih menu yang ingin dipesan!"
        );
        return;
    }

    try {
        int idMenu = Integer.parseInt(
            tblMenu.getValueAt(baris, 0).toString()
        );

        int harga = Integer.parseInt(
            tblMenu.getValueAt(baris, 2).toString()
        );

        int jumlah = Integer.parseInt(txtJumlah.getText());

        if (jumlah <= 0) {
            JOptionPane.showMessageDialog(
                this, "Jumlah pesanan harus lebih dari 0!"
            );
            return;
        }

        int totalHarga = harga * jumlah;

        Connection conn = koneksi.Koneksi.configDB();

        String sql = "INSERT INTO pesanan "
                + "(user_id, menu_id, jumlah, total_harga) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, idUser);
        pst.setInt(2, idMenu);
        pst.setInt(3, jumlah);
        pst.setInt(4, totalHarga);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
            this, "Pesanan berhasil dibuat!"
        );

        txtJumlah.setText("1");

        tampilkanPesanan();

        pst.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            this, "Jumlah harus berupa angka!"
        );

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal membuat pesanan: " + e.getMessage()
        );
    }

    }//GEN-LAST:event_btnPesanActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormSiswa(2, "budi_siswa").setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTable tblPesanan;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
