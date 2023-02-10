import java.sql.*;

public class InitiateDatabase {
    private String url = "jdbc:mysql://localhost:3306/MotherShip";
    private String uName = "root";
    private String pass = "12345678";
    public void display() throws Exception{

        String Data = "";
        String query = "select * from student";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uName,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rm = rs.getMetaData();
        System.out.println(rm.getColumnName(1)+" : "+rm.getColumnName(2));
        while (rs.next()) {
            Data = rs.getInt(1)+" : "+rs.getString(2);
            System.out.println(Data);
        }
        st.close();
        con.close();
    }
    public synchronized void add(int SID,String SN) throws Exception{
        int studId = SID;
        String studName = SN;
        String query = "insert into student values (?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uName,pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, studId);
        st.setString(2, studName);
        int count = st.executeUpdate();
        System.out.println(count+" rows affected");
        st.close();
        con.close();
    }
    public void remove(String SN) throws Exception{
        String studName = SN;
        String query = "delete from student where studName ='"+studName+"'";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uName,pass);
        Statement st = null;
        st = con.createStatement();
        st.executeUpdate(query);
        int count = st.getUpdateCount();
        System.out.println(count+" row(s) affected");
        st.close();
        con.close();
    }
}