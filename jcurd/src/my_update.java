
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class my_update{

 void my_db_update(String str1, String str2,String str3,String str4) {
 try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection con=DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/coffe","root","");
 Statement st=con.createStatement();
 int Ordernum = Integer.parseInt(str1); // Mark is an integer
 int Ordertime = Integer.parseInt(str2); // Mark is an integer
 int Amount = Integer.parseInt(str4); // Mark is an integer

 // Adding record
 String query1="INSERT INTO `order`"
 + " (`Ordernum`, `Ordertime`, `Item`, `Amount`)"
 + "VALUES('" +Ordernum+"','"+Ordertime+"',"+str3+",'"+Amount+"')";
 st.executeUpdate(query1); // record added.
 con.close();
 }catch(Exception e){ System.out.println(e);}
 }
} */

