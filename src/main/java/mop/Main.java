package mop;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        // SQL 사용하는 방법 테스트
         */
        DatabaseConnect dc = new DatabaseConnect();

        Connection conn = null;
        ResultSet rs = null;
        String userid = "scott";
        String passwd = "tiger";

        try {

            conn = dc.serverConnect(userid, passwd);

            String sql = "select deptno, dname, loc from dept";

            rs = dc.getSQLResult(conn, sql);

            while (rs.next()) {
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                System.out.println(deptno + "\t" + dname + "\t" + loc);
            }

            dc.closeResources(rs, conn);

        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace to console
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();  // Print stack trace to console
            }
        }
    }
}