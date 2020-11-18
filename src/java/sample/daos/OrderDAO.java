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
import sample.dtos.BookDTO;
import sample.dtos.OrderDTO;
import sample.dtos.OrderDetailsDTO;
import sample.utils.DBUtil;

/**
 *
 * @author Dung
 */
public class OrderDAO implements Serializable {

    public void addOrder(int orderID, String userID, String getDate, String returnDate, boolean status, OrderDetailsDTO orderDetails) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrders(orderID, userID, get_Date, return_Date, status) VALUES(?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, orderID);
                pst.setString(2, userID);
                pst.setString(3, getDate);
                pst.setString(4, returnDate);
                pst.setBoolean(5, status);
                pst.executeUpdate();
                addOrderDetails(orderID, orderDetails);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void addOrderDetails(int orderID, OrderDetailsDTO orderDetails) throws SQLException {

        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrderDetails (quantityOfOrderedBook, bookID, orderID) VALUES (?,?,?)";
                pst = conn.prepareStatement(sql);
                for (BookDTO dto : orderDetails.getCart().values()) {
                    pst.setInt(1, dto.getQuantityOfBook());
                    pst.setString(2, dto.getBookID());
                    pst.setInt(3, orderID);
                    BookDTO book = selectBook(dto);
                    updateCurrentQuantity(dto, book);
                    pst.addBatch();
                }
                pst.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private BookDTO selectBook(BookDTO bookOrder) throws SQLException {
        BookDTO book = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, bookTitle, quantityOfBook, price, author, currentQuantityOfBook  FROM tblBooks  WHERE bookID LIKE N'%" + bookOrder.getBookID() + "%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookTitle = rs.getString("bookTitle");
                    int quantityOfBook = rs.getInt("quantityOfBook");
                    int price = rs.getInt("price");
                    String author = rs.getString("author");
                    int currentQuantityOfBook = rs.getInt("currentQuantityOfBook");
                    book = new BookDTO(bookID, bookTitle, quantityOfBook, currentQuantityOfBook, price, author);
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
        return book;
    }

    private void updateCurrentQuantity(BookDTO dto, BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "update tblBooks set currentQuantityOfBook=? WHERE bookID=?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, book.getCurrentQuantityOfBook() - dto.getQuantityOfBook());
                pst.setString(2, book.getBookID());
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public int countOrder() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT count(orderID) AS c FROM tblOrders";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("c");
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
        return result;
    }

    public void DeleteByBookID(String bookID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE tblOrderDetails WHERE bookID='" + bookID + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void deleteOrderDetailsByOrderID(int orderID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE tblOrderDetails WHERE orderID='" + orderID + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean checkOrderDetailsExistByBookID(String bookID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT orderID FROM tblOrderDetails WHERE bookID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, bookID);
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

    public void deleteOrderDetailsIDByUserID(String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT orderID FROM tblOrderDetails WHERE userID='" + userID + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    deleteOrderDetailsByOrderID(rs.getInt("orderID"));
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
    }

    public void deleteOrderIDByUserID(String userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE tblOrders WHERE userID='" + userID + "'";
                stm = conn.prepareStatement(sql);
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public ArrayList<OrderDTO> getReturnOrder(String searchReturnBook) throws SQLException {
        ArrayList<OrderDTO> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT orderID, get_date, return_date FROM tblOrders WHERE status=1 and get_date like '%" + searchReturnBook + "%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String get_date = rs.getString("get_date");
                    String return_date = rs.getString("return_date");
                    orderList.add(new OrderDTO(orderID, get_date, return_date));
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
        return orderList;
    }

    public void updateOrderStatus(int orderID, boolean status) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "update tblOrders set status=? WHERE orderID=?";
                pst = conn.prepareStatement(sql);
                pst.setBoolean(1, status);
                pst.setInt(2, orderID);
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

    public void ChangeCurrentQuantityByOrderID(int orderID) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, quantityOfOrderedBook from tblOrderDetails where orderID =?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, orderID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int quantityOfOrderedBook = rs.getInt("quantityOfOrderedBook");
                    String bookID = rs.getString("bookID");
                    int quantityOfCurentBook = SelectCurentQuantityOfOfBook(bookID);
                    UpdateCurrentQuantityOfBook(quantityOfCurentBook, quantityOfOrderedBook, bookID);
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
    }

    private int SelectCurentQuantityOfOfBook(String bookID) throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT currentQuantityOfBook from tblBooks where bookID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, bookID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("currentQuantityOfBook");
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
        return result;
    }

    public ArrayList<OrderDetailsDTO> getOrderDetailsByOrderID(int orderID) throws SQLException {
        ArrayList<OrderDetailsDTO> orderDetailsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT bookTitle, quantityOfOrderedBook FROM tblOrderDetails o join tblBooks b on o.bookID = b.bookID where orderID ='" + orderID + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookTitle = rs.getString("bookTitle");
                    int quantityOfOrdered = rs.getInt("quantityOfOrderedBook");
                    orderDetailsList.add(new OrderDetailsDTO(orderID, bookTitle, quantityOfOrdered));
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
        return orderDetailsList;
    }

    public ArrayList<OrderDTO> getHistoryOrder(String userID) throws SQLException {
        ArrayList<OrderDTO> orderList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT orderID, get_date, return_date, status FROM tblOrders WHERE userID='" + userID + "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String get_date = rs.getString("get_date");
                    String return_date = rs.getString("return_date");
                    boolean status = rs.getBoolean("status");
                    orderList.add(new OrderDTO(orderID, get_date, return_date, status));
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
        return orderList;
    }

    private void UpdateCurrentQuantityOfBook(int quantityOfCurrentBook, int quantityOfOrderedBook, String bookID) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "update tblBooks set currentQuantityOfBook=? WHERE bookID=?";
                pst = conn.prepareStatement(sql);
                int update = quantityOfOrderedBook + quantityOfCurrentBook;
                pst.setInt(1, update);
                pst.setString(2, bookID);
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
