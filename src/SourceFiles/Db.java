package SourceFiles;
import java.sql.*;
/**
 *
 * @author jhw
 */
public class Db {
    public static Statement getStatement() throws Exception{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb","root","");
            Statement stat = con.createStatement();
            return stat;
    }
}

