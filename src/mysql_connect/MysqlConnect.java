package mysql_connect;



import java.sql.*;   // ການນຳເຂົ້າdatabase
import javax.swing.JOptionPane;

public class MysqlConnect {
    
    // MysqlConnect ຊື່class 
    // connectDB() ຊື່ method
   public static Connection connectDB() {
       // 3306 ເປັນ port ຂອງ Xampp
        String host = "jdbc:mysql://localhost:3306/3com_1?useSSL=true&useUnicode=yes&characterEncoding=UTF-8";
        String username = "root";
        String password = "";
        Connection conn = null;
       
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(host, username, password);
           //JOptionPane.showMessageDialog(null, "Connected");
        }catch(Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        return conn;
        
    }
    //ທົດສອບການເຊື່ອມຕໍ່ຖານຂໍ້ມູນ
    public static void main(String[] args) {
        MysqlConnect.connectDB();
    }
    
}