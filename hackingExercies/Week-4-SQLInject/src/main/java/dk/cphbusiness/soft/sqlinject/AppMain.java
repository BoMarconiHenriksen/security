package dk.cphbusiness.soft.sqlinject;

import static dk.cphbusiness.soft.sqlinject.PlaceHolders.string;
import static dk.cphbusiness.soft.sqlinject.PlaceHolders.field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppMain {

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        //String id = "2"; 
        //String name = "Jens"; 
        String id = "7 or 1 = 1; --";
        //String id = "2";
        
        String name = "Jens";
                
        injectSimpleStatement( id, name );
        injectPreparedStatement( id, name );
    }

    
    
    private static void injectSimpleStatement( String id, String name ) throws SQLException, ClassNotFoundException {
        String[] whitelist = {"Jens", "Gurli", "Hans", "1", "2", "3"};
                
        System.out.println( "Simple inject" );
        try ( Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(
                        // Denne giver problemer ift sql injections
                         "SELECT * FROM junk WHERE id=" + id + " and name ='" + name + "'" ) ) {
                        
                        //Escape '
                        //"SELECT * FROM junk WHERE id=" + string(id) + " and name ='" + string(name) + "'" ) ) {
                        
                        // Whitelist eksempel dog på brugernave i stedet for tabeller.
                       //"SELECT * FROM junk WHERE id=" + field(id, whitelist) + " and name ='" + field(name, whitelist) + "'" ) ) {
            while ( rs.next() ) {
                System.out.println( "--> " + rs.getInt( "id" )
                        + " " + rs.getString( "name" )
                        + " " + rs.getString( "role" ) );
            }
        }
    }

    // Prepared statement er gode iforhold til sql at undgå injections.
    private static void injectPreparedStatement( String id, String name ) throws SQLException, ClassNotFoundException {
        System.out.println( "Prepared statement" );
        try ( Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement( "SELECT * FROM junk WHERE id=? and name =?" ) ) {
            stmt.setInt( 1, Integer.parseInt( id ) );
            stmt.setString( 2, name );
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                System.out.println( "--> " + rs.getInt( "id" )
                        + " " + rs.getString( "name" )
                        + " " + rs.getString( "role" ) );
            }
        }
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName( "org.sqlite.JDBC" );
                       // C:\\Users\\Bo\\security\\hackingExercies\\Week-4-SQLInject\\tmpinject.db
        String path = "/Users/Bo/security/hackingExercies/Week-4-SQLInject/tmpinject.db";
        return DriverManager.getConnection( "jdbc:sqlite:" + path );
    }

}
