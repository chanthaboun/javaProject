package ApplicationForm;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

import java.sql.*;  // .* ເປັນນຳເຂົ້າທັງໝົດ
import javax.swing.ImageIcon;
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
        this.setTitle("ໂປຣແກຣມຂາຍສິນຄ້າ");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image/logo2.jpg")));
        
        
        //ປຽນສີແຖບ Title bar ດ້ານເທິງ
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(220, 220, 220));
        


        //PlaceHolder
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ບັນຊີເຂົ້າໃຊ້");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ລະຫັດຜ່ານ");

        //ລືບ
        txtUser.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        txtPass.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);

        //ໃສ່ຮູບໃນ txtUser ແລະ txtPass
        ImageIcon icon1 = new ImageIcon(getClass().getResource("../image/user_login.png"));
        ImageIcon icon2 = new ImageIcon(getClass().getResource("../image/key.png"));
        txtUser.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, icon1);
        txtPass.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, icon2);

      //ສະແດງລະຫັດຜ່ານ ເປັນການສ້າງ Events
       txtPass.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຟອມເຂົ້າໃຊ້ລະບົບ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 220, 30));

        txtPass.setFont(new java.awt.Font("Lao_SomVang", 0, 16)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Cancel
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

    // Password
    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        btnLogin.doClick(); // if Enter on  txtPassword ໃຫ້ຕົວຊີ້ເມົ້າມາຊີ້ຢູ່ btn
    }//GEN-LAST:event_txtPassActionPerformed

    public static void main(String args[]) {
        //FlatDarkLaf.setup();   // ເຮັດໜ້າທີ່ໃນການປ່ຽນຕິມສີຟອມ
        FlatLightLaf.setup();
        //ກໍານົດ Font ໃຫ້ກັບ JOptionPane
        //ກໍານົດຟ້ອນເລີ້ມຕົ້ນໃຫ້ກັບຟອມ
        UIManager.put("defaultFont", new Font("Lao_SomVang", Font.PLAIN, 16));
        UIManager.put("OptionPane.messageFont", new Font("Lao_SomVang", Font.PLAIN, 14));
        UIManager.put("OptionPane.okButtonText", "ຕົກລົງ");
        UIManager.put("OptionPane.cancelButtonText", "ຍົກເລີກ");

        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put( "ScrollBar.showButtons", true );

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
