/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.User;
import sanjeevaniapp.pojo.UserPojo;

public class UserDao {

    public static String validateUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select user_name from users where login_id=? AND password=? AND user_type=?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        String username = null;
        if (rs.next()) {
            username = rs.getString("user_name");
        }
        return username;
    }

    public static void updateName(String currName, String newName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update users set user_name=? where user_name=?");
        ps.setString(1, newName);
        ps.setString(2, currName);
        ps.executeUpdate();
    }

    public static void deleteUserByName(String name) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from users where user_name=?");
        ps.setString(1, name);
        ps.executeUpdate();
    }

    public static boolean addUser(UserPojo user) throws SQLException {
          Connection conn = DBConnection.getConnection();
          PreparedStatement ps = conn.prepareStatement("Insert into users values(?,?,?,?)");
          ps.setString(1, user.getLoginId());
          ps.setString(2, user.getUserName());
          ps.setString(3, user.getPassword());
          ps.setString(4, user.getUserType());
          return ps.executeUpdate() == 1;
    }
    
    public static UserPojo getUserDetails(String userName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from users where user_name=?");
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        rs.next();
        UserPojo user = new UserPojo();
        user.setLoginId(rs.getString(1));
        user.setUserName(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setUserType(rs.getString(4));
        return user;
    }
    
    public static boolean updateUser(UserPojo user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Update users set login_id=?,user_type=?,password=? where user_name=?");
        ps.setString(1, user.getLoginId());
        ps.setString(2, user.getUserType());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUserName());
        return ps.executeUpdate() == 1;
    }
}
