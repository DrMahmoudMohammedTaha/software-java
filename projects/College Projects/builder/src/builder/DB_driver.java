package builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB_driver {

    static Connection con;
    static Statement stmt;
    static String order = "";
    private static String SQL;

    
    

    public static String addOrder(String SQL) {
        SQL = (!"".equals(order)) ? SQL + " ORDER BY  " + order : SQL;
        order = "";
        return SQL;
    }

    public static void startDB(String url, String user, String password) throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        stmt = con.createStatement();
    }

    public static double selectGroup(String table, String func, String col) throws SQLException {

        String SQL = "SELECT " + func + " ( " + col + " )" + " FROM " + table;
        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);
        rs.next();
        return Integer.parseInt(rs.getString(1));
    }

    public static double selectGroup(String table, String func, String col, String cond) throws SQLException {

        String SQL = "SELECT " + func + " ( " + col + " )" + " FROM " + table;
        SQL += " WHERE " + cond;
        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);
        rs.next();
        return Integer.parseInt(rs.getString(1));
    }

    public static void insterROW(String table, String... values) throws SQLException {

        String SQL = "INSERT INTO  " + table + " VALUES ( ";
        for (int i = 0; i < values.length; i++) {
            SQL += values[i] + ((i == values.length - 1) ? " " : " , ");
        }
        SQL += " ) ";
        stmt.executeUpdate(SQL);

    }

    public static ArrayList<String> selectCols(String table, String... cols) throws SQLException {
        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT ";

        for (int i = 0; i < cols.length; i++) {
            SQL += cols[i].trim() + ((i == cols.length - 1) ? " " : " , ");
        }
        SQL += " FROM " + table;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add("");
            for (int i = 0; i < cols.length; i++) {
                data.set(data.size() - 1, data.get(data.size() - 1) + rs.getString(cols[i].trim()) + ((i == cols.length - 1) ? " " : " , "));
            }

        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> selectCols_cond(String table, String cond, String... cols) throws SQLException {
        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT ";

        for (int i = 0; i < cols.length; i++) {
            SQL += cols[i].trim() + ((i == cols.length - 1) ? " " : " , ");
        }
        SQL += " FROM " + table;

        SQL += " WHERE " + cond;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add("");
            for (int i = 0; i < cols.length; i++) {
                data.set(data.size() - 1, data.get(data.size() - 1) + rs.getString(cols[i].trim()) + ((i == cols.length - 1) ? " " : " , "));
            }

        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> selectColsModified(String table, String func, String col) throws SQLException {
        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT " + func + " ( " + col + " ) " + " FROM " + table;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add(rs.getString(1));
        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> selectColsModified_cond(String table, String func, String col, String cond) throws SQLException {
        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT " + func + " ( " + col + " ) " + " FROM " + table;

        SQL += " WHERE " + cond;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add(rs.getString(1));
        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> selectColsModified(String table, String func, String col, String... parm) throws SQLException {

        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT " + func + " ( " + col + " , ";

        for (int i = 0; i < parm.length; i++) {
            SQL += parm[i].trim() + ((i == parm.length - 1) ? " ) " : " , ");
        }
        SQL += " FROM " + table;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add(rs.getString(1));
        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> select(String SQL , int num )  throws SQLException {

        ArrayList<String> data = new ArrayList();

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add(rs.getString(1));
            
        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> select(String SQL, String cond) throws SQLException {
        ArrayList<String> data = new ArrayList();

        SQL += "WHERE " + cond;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add(rs.getString(1));

        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static void delete(String table, String cond) throws SQLException {

        String SQL = "DELETE FROM " + table + " WHERE " + cond;

        stmt.executeUpdate(SQL);
    }

    public static void empty(String table) throws SQLException {

        String SQL = "DELETE FROM " + table;
        stmt.executeUpdate(SQL);
    }

    public static void update(String table, String col, String value, String cond) throws SQLException {

        String SQL = "UPDATE " + table + " SET " + col + " = " + value + " WHERE " + cond;

        stmt.executeUpdate(SQL);
    }

    public static void delete_table(String table) throws SQLException {
        String SQL = "drop table " + table;
        stmt.execute(SQL);

    }

    public static void addTable(String table, String... cols) throws SQLException {

        String SQL = "create table ABOAHMED." + table + "  ( ";

        for (int i = 0; i < cols.length; i++) {
            cols[i] = cols[i].replaceAll(" number", " decimal").replaceAll(" varchar2", " varchar ");
            SQL += cols[i] + ((i == cols.length - 1) ? " " : " , ");
        }

        SQL += " )";
        stmt.execute(SQL);

    }

    public static void addTableCol_exe(String SQL) throws SQLException {

        SQL = SQL.replaceAll(" number", " decimal").replaceAll(" varchar2", " varchar")
                .replaceAll("\n", " ").replaceAll(";", "");
        stmt.execute(SQL);

    }

    public static void addCol(String table, String col) throws SQLException {

        col = col.replaceAll(" number", " decimal").replaceAll(" varchar2", " varchar");
        SQL = "ALTER TABLE " + table + " ADD COLUMN " + col;
        stmt.execute(SQL);

    }

    public static void deleteCol(String table, String col) throws SQLException {

        col = col.replaceAll(" number", " decimal").replaceAll(" varchar2", " varchar");
        SQL = "ALTER TABLE " + table + " drop COLUMN " + col;
        stmt.execute(SQL);

    }

    public static ArrayList<String> selectColsJoin(String table, String join, String... cols) throws SQLException {
        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT ";

        for (int i = 0; i < cols.length; i++) {
            SQL += cols[i].trim() + ((i == cols.length - 1) ? " " : " , ");
        }
        SQL += " FROM " + table;

        SQL += join;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add("");
            for (int i = 0; i < cols.length; i++) {
                data.set(data.size() - 1, data.get(data.size() - 1) + rs.getString(cols[i].trim()) + ((i == cols.length - 1) ? " " : " , "));
            }

        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

    public static ArrayList<String> selectColsJoin_cond(String table, String join, String cond, String... cols) throws SQLException {
        ArrayList<String> data = new ArrayList();

        String SQL = "SELECT ";

        for (int i = 0; i < cols.length; i++) {
            SQL += cols[i].trim() + ((i == cols.length - 1) ? " " : " , ");
        }
        SQL += " FROM " + table;

        SQL += join;

        SQL += " WHERE " + cond;

        SQL = addOrder(SQL);
        ResultSet rs = stmt.executeQuery(SQL);

        rs.next();
        do {
            data.add("");
            for (int i = 0; i < cols.length; i++) {
                data.set(data.size() - 1, data.get(data.size() - 1) + rs.getString(cols[i].trim()) + ((i == cols.length - 1) ? " " : " , "));
            }

        } while (rs.next());

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        return data;
    }

}
