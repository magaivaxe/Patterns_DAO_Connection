
package datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFilmClubSQL
{
    //fields
    //URL connection
    private static final String url = "jdbc:mysql://localhost/filmclub";
    //User name
    private static final String user = "root";
    //Password
    private static final String password = "mp09s02g00";
    //Object connection
    private static Connection connect;
    
    public static Connection getInstance()
    {
        if (connect == null)
        {
            try
            {               
                connect = DriverManager.getConnection(url, user, password);
                
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
