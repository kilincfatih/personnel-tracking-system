package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Taha Kubilay ÖZDOĞAN - 02205076007
 * @author Fatih KILINÇ - 02205076006
 * @author Eren ALPARSLAN - 02205076019
 */
public abstract class DBConnection {

    private Connection connect;

    public Connection getConnect() {
        if (this.connect == null) {
            try {
                Class.forName("org.postgresql.Driver");
                this.connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/personel", "postgres", "12345");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }

}
