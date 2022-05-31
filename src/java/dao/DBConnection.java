package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */
public abstract class DBConnection {

    public Connection connect() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/personel", "postgres", "12345");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

}
