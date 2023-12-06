package ApplicationForm;
import java.sql.*;


public class PanelHome extends javax.swing.JPanel {

    String id, name, status;
    Connection conn = null; // ເກັບການເໍໍືຊືອມຕໍ່
    PreparedStatement pst = null; // ໄວ້ກຽມຄຳສັ່ງsql
    ResultSet rs = null; // ເກັບຜົນໄດ້ຮັບຈາກການquery ຫຼື ການດຶງຂໍ້ມມູນຂື້ນມາ


    public PanelHome(String i, String n, String s) {
        initComponents();
        id = i;
        name = n;
        status = s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lao_SomVang", 0, 20)); // NOI18N
        jLabel1.setText("ຍິນດີຕ້ອນຮັບສູ່ໂປຣແກຣມຂ້າຍເຄື່ອງໜ້າຮ້ານ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
