package ApplicationForm;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

import java.sql.*;  // .* ເປັນນຳເຂົ້າທັງໝົດ
import javax.swing.UIManager;
import mysql_connect.MysqlConnect;
import passwordHashing.PasswordHashing;

public class Login extends javax.swing.JFrame {

    Connection conn = null; // ເກັບການເໍໍືຊືອມຕໍ່
    PreparedStatement pst = null; // ໄວ້ກຽມຄຳສັ່ງsql
    ResultSet rs = null; // ເກັບຜົນໄດ້ຮັບຈາກການquery ຫຼື ການດຶງຂໍ້ມມູນຂື້ນມາ

    public Login() {
        initComponents(); // ມັນເປັນອ໋ອບເຈັກ
        this.setLocationRelativeTo(this);// ເຮັດໜ້າທີ່ການຈັດໃຫ້ໄປຢູ່ເຄິ່ງກາງ ເວລາ ຣັນໂຄ້ດ
        this.setTitle("ໂປຣແກລມຂາຍສິນຄ້າ");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image/logo2.jpg")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຟອມເຂົ້າໃຊ້ລະບົບ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel1.setText("ລະຫັດຜ່ານ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel2.setText("ບັນຊີເຂົ້າໃຊ້");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, -1));

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 220, 30));

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 220, 30));

        btnCancel.setFont(new java.awt.Font("Lao_SomVang", 0, 16)); // NOI18N
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        btnLogin.setFont(new java.awt.Font("Lao_SomVang", 0, 16)); // NOI18N
        btnLogin.setText("ເຂົ້າໃຊ້ງານ");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed


    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        // getText ຮັບຄ່າຈາກ txtUser
        if (txtUser.getText().isEmpty() || txtPass.getText().isEmpty()) {

            //String msg = "<html><h3 style=\" font-family: Saysettha OT; font-weight: none\"></h3></html>";
            JOptionPane.showMessageDialog(rootPane, "ກະລຸນາປ້ອນຂໍ້ມູນໃຫ້ຄົບດ້ວຍ", "Empty", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            //ເຊື່ອມຖານຂໍ້ມູນ
            conn = MysqlConnect.connectDB();
            String sql = "SELECT emp_id, CONCAT(emp_name, ' ', emp_lname) AS name, status FROM employee WHERE username=? AND password=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtUser.getText().trim());
            pst.setString(2, PasswordHashing.doHashing(txtPass.getText().trim()));
            rs = pst.executeQuery();

            if (rs.next()) {
                //ສ້າງ ອ໋ອບເຈັກຈາກຄລາດ Main
                Main m = new Main(rs.getString("emp_id"), rs.getString("name"), rs.getString("status"));
                m.setVisible(true);
                dispose(); // ປິດໜ້າlogin
            } else {
                //String msg = "<html><h3 style=\" font-family: Saysettha web; font-weight: none\">ບັນຊີເຂົ້າໃຊ້ ແລະ ລະຫັດຜ່ານບໍ່ຖືກຕ້ອງ</h3></html>";
                JOptionPane.showMessageDialog(rootPane, "ບັນຊີເຂົ້າໃຊ້ ແລະ ລະຫັດຜ່ານບໍ່ຖືກຕ້ອງ", "Error", JOptionPane.ERROR_MESSAGE);
                txtUser.requestFocus();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_btnLoginActionPerformed


    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        txtPass.requestFocus(); // if Enter on  txtUser ໃຫ້ຕົວຊີ້ເມົ້າມາຊີ້ຢູ່ txtPass

    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    public static void main(String args[]) {
        //FlatDarkLaf.setup();   // ເຮັດໜ້າທີ່ໃນການປ່ຽນຕິມສີຟອມ
        FlatLightLaf.setup();
        //ກໍານົດ Font ໃຫ້ກັບ JOptionPane
        UIManager.put("defaultFont", new Font("Saysettha web", Font.PLAIN, 16));
        UIManager.put("OptionPane.okButtonText", "ຕົກລົງ");
        UIManager.put("OptionPane.cancelButtonText", "ຍົກເລີກ");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
