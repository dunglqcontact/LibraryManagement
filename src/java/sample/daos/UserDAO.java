/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sample.dtos.UserDTO;
import sample.utils.DBUtil;

/**
 *
 * @author Dung
 */
public class UserDAO implements Serializable {

    public boolean checkExistedID(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT userName FROM tblUsers WHERE userID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public UserDTO checkRole(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT roleName, userName FROM tblRoles r JOIN tblUsers u on u.roleID = r.roleID WHERE userID=? AND password=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String userRole = rs.getString("roleName");
                    String userName = rs.getString("userName");
                    user = new UserDTO(userID, password, userName, userRole);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public ArrayList<UserDTO> getListUser(String searchName) throws SQLException {
        ArrayList<UserDTO> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, userName, password, roleName "
                        + "FROM tblUsers u JOIN tblRoles r ON u.roleID = r.roleID "
                        + "WHERE userName LIKE '%" + searchName + "%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String roleName = rs.getString("roleName");
                    userList.add(new UserDTO(userID, password, userName, roleName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return userList;
    }

    public void deleteUserByUserID(String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "delete tblUsers where userID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, userID);
                pst.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void insertCustomer(UserDTO customer) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(userID,userName,password,roleID) values (?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, customer.getUserID());
                pst.setString(2, customer.getUserName());
                pst.setString(3, customer.getPassword());
                pst.setInt(4, 2);
                pst.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void insertAdmin(UserDTO admin) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(userID,userName,password,roleID) values (?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, admin.getUserID());
                pst.setString(2, admin.getUserName());
                pst.setString(3, admin.getPassword());
                pst.setInt(4, 1);
                pst.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
