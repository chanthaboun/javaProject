package ApplicationForm;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import mysql_connect.MysqlConnect;
import validation.Validation;

public class PanelCustomer extends javax.swing.JPanel {

    String id, name, status;
    Connection conn = null; // ເກັບການເໍໍືຊືອມຕໍ່
    PreparedStatement pst = null; // ໄວ້ກຽມຄຳສັ່ງsql
    ResultSet rs = null; // ເກັບຜົນໄດ້ຮັບຈາກການquery ຫຼື ການດຶງຂໍ້ມມູນຂື້ນມາ

    // constuctor
    public PanelCustomer(String i, String n, String s) {
        initComponents();
        id = i;
        name = n;
        status = s;

        //ປ່ຽນສີພື້ນຫົວຕາຕະລາງ
        JTableHeader header = jTable1.getTableHeader();
        header.setOpaque(false);
        header.setBackground(new Color(108, 117, 125));
        header.setForeground(new Color(243, 243, 243));

        //ເສັ້ນຕາຕະລາງ
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setGridColor(new Color(139, 138, 137));

        //ສະແດງຜົນຢູ່ກາງຖັນ
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(jLabel1.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); //ໃຫ້ຂໍ້ມູນຢູ່ຖັນ ລະຫັດສະແດງທີ່ກາງຫ້ອງ
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); //ໃຫ້ຂໍ້ມູນຢູ່ຖັນ ເພດ ສະແດງທີ່ກາງຫ້ອງ

        //ສະແດງຜົນຂໍ້ມູນຢູ່ຕິດດ້ານຂວາຂອງຖັນ
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(jLabel1.RIGHT);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

        // ເຊື່ອມຕໍ່database
        conn = MysqlConnect.connectDB();

        // ເອີ້ນMethod or Function ໃຊ້
        tableUpdate();
        // ເອີ້ນMethod or Function ໃຊ້ 
        autoID();

        // ກຳນົດຄ່າໃຫ້ປຸ່ມ ຊາຍ ແລະ ຍິງ
        txtMale.setActionCommand("ຊາຍ");
        txtFemale.setActionCommand("ຍິງ");

        //PlaceHolder ຕົວຍືດ
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ຄົ້ນຫາ");
        txtTelephone.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "020 55667788");

        //ໃສ່ຮູບໃນ txtUser ແລະ txtPass
        ImageIcon icon1 = new ImageIcon(getClass().getResource("../image/search_text.png"));
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, icon1);

        // ກຳນົດຄ່າເລີ່ມຕົ້ນຂອງປຸ່ມແກ້ໄຂ ແລະ ລືບ ບໍ່ສາມາດໃຫ້ໃຊ້ງານໄດ້
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    // ຂຽນMethod ສະແດງຂໍ້ມູນໃນຕາຕະລາງ
    private void tableUpdate() {
        try {
            // ເຮົາໃຊ້ from or FROM ອັນດຽວກັນ
            String sql = "SELECT *FROM customer ORDER BY cus_id DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            jTable1.setRowHeight(30); // ຄວາມສູງຂອງແຖວຕາຕະລາງ
            d.setRowCount(0); // ລືບແຖວຕາຕະລາງອອກໝົດ

            // ພາກສ່ວນຂອງການດຶງຂໍ້ມູນມາຈາກdatabaseອອກມາໂຊໃນຕາຕະລາງ
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("cus_id"));
                v.add(rs.getString("cus_name"));
                v.add(rs.getString("cus_lname"));
                v.add(rs.getString("gender"));
                v.add(rs.getString("address"));
                v.add(rs.getString("tel"));
                d.addRow(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //ສ້າງເມັດທອດສ້າງ id ເພີ່ມຂຶ້ນອັດຕະໂນມັດ
    private void autoID() {

        try {
            String sql = "SELECT MAX(cus_id) AS max_id FROM customer";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            if (rs.getString("max_id") == null) {
                txtId.setText("CUS0000001");
            } else {
                int id = Integer.parseInt(rs.getString("max_id").substring(3, rs.getString("max_id").length()));
                id++;
                txtId.setText("CUS" + String.format("%07d", id));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //ລືບຂໍ້ມູນໃນຟອມ
    private void clearForm() {
        autoID();
        txtFirstname.setText("");
        txtLastname.setText("");
        gender.clearSelection();
        txtAddress.setText("");

        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

        jTable1.clearSelection();
    }

    //ກວດສອບທຸກຊ່ອງຂອງຟອມໄດ້ຖືກເລືອກຫຼືບໍ່
    private boolean checkInputs() {
        return txtFirstname.getText().isEmpty() || txtLastname.getText().isEmpty() || gender.getSelection() == null
                || txtAddress.getText().isEmpty() || txtTelephone.getText().isEmpty();
    }

    // section generation 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFemale = new javax.swing.JRadioButton();
        txtMale = new javax.swing.JRadioButton();
        txtTelephone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ລະຫັດລູກຄ້າ", "ຊື່ລູກຄ້າ", "ນາມສະກຸນ", "ເພດ", "ທີ່ຢູ່", "ເບີໂທ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ຈັດການຂໍ້ມູນລູກຄ້າ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao_SomVang", 0, 18))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel1.setText("ເພດ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel2.setText("ເບີໂທລະສັບ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, -1));

        jLabel3.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel3.setText("ຊື່ລູກຄ້າ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        txtFirstname.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel2.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 210, -1));

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Lao_SomVang", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 260, 70));

        jLabel4.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel4.setText("ລະຫັດລູກຄ້າ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel5.setText("ທີ່ຢູ່");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        gender.add(txtFemale);
        txtFemale.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        txtFemale.setText("ຍິງ");
        jPanel2.add(txtFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        gender.add(txtMale);
        txtMale.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        txtMale.setText("ຊາຍ");
        jPanel2.add(txtMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        txtTelephone.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 260, -1));

        jLabel7.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel7.setText("ນາມສະກຸນ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        jLabel8.setText("ນາມສະກຸນ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        txtLastname.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N
        jPanel2.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 210, -1));

        btnEdit.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        btnEdit.setText("ແກ້ໄຂ");
        jPanel2.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        btnCancel.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        btnCancel.setText("ຍົກເລີກ");
        jPanel2.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, -1, -1));

        btnAdd.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        btnAdd.setText("ເພີ້ມ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 70, -1));

        btnDelete.setFont(new java.awt.Font("Saysettha Web", 0, 16)); // NOI18N
        btnDelete.setText("ລືບ");
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 60, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtSearch.setFont(new java.awt.Font("Lao_SomVang", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // ກວດສອບວ່າປ້ອນຂໍ້ມູນຄົບຖ້ວນ ຫຼື ບໍ່
        if (checkInputs()) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຂໍ້ມູນໃຫ້ຄົບດ້ວຍ", "ຫວ່າງເປົ່າ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtId.getText());
            pst.setString(2, txtFirstname.getText());
            pst.setString(3, txtLastname.getText());
            pst.setString(4, gender.getSelection().getActionCommand());
            pst.setString(5, txtAddress.getText());
            pst.setString(6, txtTelephone.getText());

            pst.executeUpdate();
            tableUpdate();
            clearForm();
            ImageIcon icon = new ImageIcon(getClass().getResource("../image/ok.png"));
            JOptionPane.showMessageDialog(null, "ຂໍ້ມູນບັນທືກລົງໃນຖານຂໍ້ມູນສຳເລັດ","ສຳເລັດ",JOptionPane.WIDTH,icon);
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        // ກວດສອບເບີໂທ
        if (!Validation.TelephoneValidation(txtTelephone.getText())) {
            JOptionPane.showMessageDialog(null, "ກະລຸນາປ້ອນຂໍ້ມູນເບີໂທໃຫ້ຖືກຕ້ອງດ້ວຍ", "ຜິດຜາດ", JOptionPane.WARNING_MESSAGE);
            txtTelephone.requestFocus();
            return;
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JRadioButton txtFemale;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JRadioButton txtMale;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
