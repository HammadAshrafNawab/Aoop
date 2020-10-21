/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guilabclasshammad;

import java.sql.*;

/**
 *
 * @author student
 */
public class TransactionDAO {

    Connection con = null;

    void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    int insert(TRANSACT s) {
        int res = 0;
        try {
            Connection();
            String qry = "insert into transaction  (id,date,amt,acc) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.id);
            pst.setString(2, s.date);

            pst.setInt(3, s.amt);
            pst.setInt(4, s.acc);

            res = pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return res;
    }

    int update(TRANSACT s) {
        int res = 0;
        try {
            Connection();
            String qry = "update  transaction set date=?,amt=?,date=? where id=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(4, s.id);
            pst.setString(3, s.date);
            //  pst.setString(3, s.type);
            pst.setInt(2, s.amt);
            pst.setInt(1, s.acc);
            //pst.setString(6, s.served);
            res = pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return res;
    }

    int delete(TRANSACT s) {
        int res = 0;
        try {
            Connection();
            String qry = "delete from transaction where id=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.id);

            res = pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return res;
    }

    ResultSet selectall() {
        ResultSet rs = null;
        try {
            Connection();
            String qry = "select * from transaction";
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return rs;

    }

    ResultSet selectbyid(TRANSACT s) {
        ResultSet rs = null;
        try {
            Connection();
            String qry = "select * from transaction where id=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.id);
            rs = pst.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return rs;

    }

    ResultSet combo() {
        ResultSet rs = null;
        try {
            Connection();
            String qry = "select * from transaction ";
            Statement pst = con.createStatement();

            rs = pst.executeQuery(qry);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return rs;

    }
}
