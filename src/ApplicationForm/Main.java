package ApplicationForm;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class Main extends javax.swing.JFrame {

    String id, name, status;
    
    public Main() {
        initComponents();
        
    }

    // Overloading Construtor
    // ຖ້າຊຶ່ຕ່າງກັນເຮົາຕ້ອງໃຊ້ this  (i and name)
    public Main(String i, String n, String s) {
        initComponents();
        id = i;
        name = n;
        status = s;
        
        // ການດືງຊື່ຜູ້ໃຊ້ງານມາໂສ
        this.setTitle("ຜູ້ໃຊ້ງານ: " + name);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../image/logo2.jpg")));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // ສະແດງຜົນເຕັມໜ້າຈໍ
        
        
        //ກຳນົດສິດໃນການເຂົ້າໃຊ້ໂປຣແກລມ or Determine the right to access the program
        if(!status.equals("Admin")){
            jMenuData.setVisible(false);
            jMenuOrderImport.setVisible(false);
            jMenuReport.setVisible(false);
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuData = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuOrderImport = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuReport = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMain.setBackground(new java.awt.Color(204, 204, 204));
        PanelMain.setLayout(new java.awt.BorderLayout());

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home_page.png"))); // NOI18N
        jMenu1.setText("ໜ້າຫຼັກ");
        jMenu1.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu1);

        jMenuData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/server.png"))); // NOI18N
        jMenuData.setText("ຈັດການຂໍ້ມູນ");
        jMenuData.setToolTipText("");
        jMenuData.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenuData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuData.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem1.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem1.setText("ຈັດການຂໍ້ມູນລູກຄ້າ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem2.setText("ຈັດການຂໍ້ມູນພະນັກງານ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem3.setText("ຈັດການຂໍ້ມູນສິນຄ້າ");
        jMenuData.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem4.setText("ຈັດການຂໍ້ມູນປະເພດສິນຄ້າ");
        jMenuData.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem5.setText("ຈັດການຂໍ້ມູນຍີ່ຫໍ້");
        jMenuData.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem6.setText("ຈັດການຂໍ້ມູນອັດຕາແລກປ່ຽນ");
        jMenuData.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem7.setText("ຈັດການຂໍ້ມູນຜູ້ສະໜອງ");
        jMenuData.add(jMenuItem7);

        jMenuBar1.add(jMenuData);

        jMenuOrderImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/order.png"))); // NOI18N
        jMenuOrderImport.setText("ສັ່ງຊື້-ນຳເຂົ້າ");
        jMenuOrderImport.setToolTipText("");
        jMenuOrderImport.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenuOrderImport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuOrderImport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem8.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem8.setText("ຈັດການຂໍ້ມູນສັ່ງຊື້ສິນຄ້າ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuOrderImport.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem9.setText("ຈັດການຂໍ້ມູນນຳເຂົ້າສິນຄ້າ");
        jMenuOrderImport.add(jMenuItem9);

        jMenuBar1.add(jMenuOrderImport);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customer.png"))); // NOI18N
        jMenu4.setText("ລູກຄ້າ");
        jMenu4.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sale.png"))); // NOI18N
        jMenu5.setText("ຂາຍສິນຄ້າ");
        jMenu5.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jMenu6.setText("ຄົ້ນຫາ");
        jMenu6.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu6);

        jMenuReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report.png"))); // NOI18N
        jMenuReport.setText("ລາຍງານ");
        jMenuReport.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenuReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMenuItem12.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem12.setText("ລາຍງານຂໍ້ມູນການຂາຍ");
        jMenuReport.add(jMenuItem12);

        jMenuItem15.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem15.setText("ລາຍງານຂໍ້ມູນສິນຄ້າໃນຮ້ານ");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenuReport.add(jMenuItem15);

        jMenuItem18.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem18.setText("ລາຍງານຂໍ້ມູນສິນຄ້າໄກ້ໝົດ");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenuReport.add(jMenuItem18);

        jMenuItem17.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem17.setText("ໃບບິນ");
        jMenuReport.add(jMenuItem17);

        jMenuItem20.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem20.setText("ລາຍງານຂໍ້ມູນນຳເຂົ້າສິນຄ້າ");
        jMenuReport.add(jMenuItem20);

        jMenuItem16.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem16.setText("ລາຍງານຂໍ້ມູນສັ່ງຊື້ສິນຄ້າ");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenuReport.add(jMenuItem16);

        jMenuItem14.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem14.setText("ລາຍງານຂໍ້ມູນລູກຄ້າ");
        jMenuReport.add(jMenuItem14);

        jMenuItem13.setFont(new java.awt.Font("Saysettha Web", 0, 14)); // NOI18N
        jMenuItem13.setText("ລາຍງານຂໍ້ມູນພະນັກງານ");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenuReport.add(jMenuItem13);

        jMenuBar1.add(jMenuReport);

        jMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        jMenuExit.setText("ອອກຈາກລະບົບ");
        jMenuExit.setFont(new java.awt.Font("Saysettha OT", 0, 16)); // NOI18N
        jMenuExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    
    // Logout section or Exit section 
    private void jMenuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuExitMouseClicked
        int data = JOptionPane.showConfirmDialog(rootPane, "ທ່ານຕ້ອງການອອກຈາກລະບົບແທ້ ຫຼື ບໍ່", "ຢືນຢັນ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(data == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuExitMouseClicked

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuData;
    private javax.swing.JMenu jMenuExit;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuOrderImport;
    private javax.swing.JMenu jMenuReport;
    // End of variables declaration//GEN-END:variables
}
