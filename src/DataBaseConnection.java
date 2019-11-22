import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class DataBaseConnection {

    private Connection connection;
    private static DataBaseConnection dBConnection;
    private DataBaseConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/DOCUMENTATION", "root", "12345");
    }
    static DataBaseConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new DataBaseConnection();
        }
        return dBConnection;
    }
    Connection getConnection(){
        return connection;
    }
}
