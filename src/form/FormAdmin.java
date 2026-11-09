package form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAdmin.class.getName());

    /**
     * Creates new form FormAdmin
     */
public FormAdmin() {
    initComponents();
    tampilkanMenu();

    // Memilih baris tabel untuk mengisi form
    tblMenu.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()
                && tblMenu.getSelectedRow() != -1) {

            int baris = tblMenu.getSelectedRow();

            txtNamaMenu.setText(
                tblMenu.getValueAt(baris, 1).toString()
            );

            txtHarga.setText(
                tblMenu.getValueAt(baris, 2).toString()
            );

            cmbKategori.setSelectedItem(
                tblMenu.getValueAt(baris, 3).toString()
            );
        }
    });
}

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

private void bersihkanForm() {
    txtNamaMenu.setText("");
    txtHarga.setText("");
    cmbKategori.setSelectedIndex(0);
    tblMenu.clearSelection();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesanan = new javax.swing.JTable();
        txtHarga = new javax.swing.JTextField();
        txtNamaMenu = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(tblPesanan);

        txtHarga.setText("Input Harga");

        txtNamaMenu.setText("Input Nama Menu");

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Pesanan Masuk");

        jLabel2.setText("Dashboard Admin");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(this::btnTambahActionPerformed);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnBersih.setText("Bersih");
        btnBersih.addActionListener(this::btnBersihActionPerformed);

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
        jScrollPane2.setViewportView(tblMenu);

        jLabel3.setText("Daftar Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(23, 23, 23)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBersih))
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNamaMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(388, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(466, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(671, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnBersih)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(218, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jLabel3)
                    .addContainerGap(483, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    try {
        String nama = txtNamaMenu.getText();
        String harga = txtHarga.getText();
        String kategori = cmbKategori.getSelectedItem().toString();

        if (nama.isEmpty() || harga.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Nama dan harga menu wajib diisi!"
            );
            return;
        }

        int hargaMenu = Integer.parseInt(harga);

        if (hargaMenu <= 0) {
            JOptionPane.showMessageDialog(
                this, "Harga harus lebih dari 0!"
            );
            return;
        }

        Connection conn = koneksi.Koneksi.configDB();

        String sql = "INSERT INTO menu "
                + "(nama_menu, harga, kategori) VALUES (?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, nama);
        pst.setInt(2, hargaMenu);
        pst.setString(3, kategori);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
            this, "Menu berhasil ditambahkan!"
        );

        tampilkanMenu();
        bersihkanForm();

        pst.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            this, "Harga harus berupa angka!"
        );

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal menambahkan menu: " + e.getMessage()
        );
    }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int baris = tblMenu.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(
            this, "Pilih menu yang ingin diedit!"
        );
        return;
    }

    try {
        int id = Integer.parseInt(
            tblMenu.getValueAt(baris, 0).toString()
        );

        String nama = txtNamaMenu.getText();
        int harga = Integer.parseInt(txtHarga.getText());
        String kategori = cmbKategori.getSelectedItem().toString();

        if (nama.isEmpty() || harga <= 0) {
            JOptionPane.showMessageDialog(
                this, "Periksa kembali nama dan harga menu!"
            );
            return;
        }

        Connection conn = koneksi.Koneksi.configDB();

        String sql = "UPDATE menu SET nama_menu=?, "
                + "harga=?, kategori=? WHERE id=?";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, nama);
        pst.setInt(2, harga);
        pst.setString(3, kategori);
        pst.setInt(4, id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
            this, "Menu berhasil diperbarui!"
        );

        tampilkanMenu();
        bersihkanForm();

        pst.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Gagal mengedit menu: " + e.getMessage()
        );
    }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

       int baris = tblMenu.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(
            this, "Pilih menu yang ingin dihapus!"
        );
        return;
    }

    int pilihan = JOptionPane.showConfirmDialog(
        this,
        "Apakah kamu yakin ingin menghapus menu ini?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION
    );

    if (pilihan == JOptionPane.YES_OPTION) {

        try {
            int id = Integer.parseInt(
                tblMenu.getValueAt(baris, 0).toString()
            );

            Connection conn = koneksi.Koneksi.configDB();

            String sql = "DELETE FROM menu WHERE id=?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                this, "Menu berhasil dihapus!"
            );

            tampilkanMenu();
            bersihkanForm();

            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, "Gagal menghapus menu: " + e.getMessage()
            );
        }
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
    bersihkanForm();
    }//GEN-LAST:event_btnBersihActionPerformed


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
        java.awt.EventQueue.invokeLater(() -> new FormAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTable tblPesanan;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNamaMenu;
    // End of variables declaration//GEN-END:variables
}
