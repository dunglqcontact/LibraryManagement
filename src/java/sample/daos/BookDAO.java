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
import sample.utils.DBUtil;

/**
 *
 * @author Dung
 */
public class BookDAO implements Serializable {

    public ArrayList<BookDTO> getBookList(String bookSearch) throws SQLException {
        ArrayList<BookDTO> bookList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, bookTitle, quantityOfBook, price, author, currentQuantityOfBook  FROM tblBooks  WHERE bookTitle LIKE N'%" + bookSearch + "%'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookTitle = rs.getString("bookTitle");
                    int quantityOfBook = rs.getInt("quantityOfBook");
                    int price = rs.getInt("price");
                    String author = rs.getString("author");
                    int currentQuantityOfBook = rs.getInt("currentQuantityOfBook");
                    bookList.add(new BookDTO(bookID, bookTitle, quantityOfBook, currentQuantityOfBook, price, author));
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
        return bookList;
    }

    public void delete(String bookID) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "delete tblBooks where bookID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, bookID);
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

    public void update(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "update tblBooks set bookTitle=?, author=?, quantityOfBook=?, price=? WHERE bookID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, book.getBookTitle());
                pst.setString(2, book.getAuthor());
                pst.setInt(3, book.getQuantityOfBook());
                pst.setInt(4, book.getPrice());
                pst.setString(5, book.getBookID());
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

    public void insertBook(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblBooks(bookID, bookTitle, author, price, quantityOfBook, currentQuantityOfBook) VALUES(?,?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, book.getBookID());
                pst.setString(2, book.getBookTitle());
                pst.setString(3, book.getAuthor());
                pst.setInt(4, book.getPrice());
                pst.setInt(5, book.getQuantityOfBook());
                pst.setInt(6, book.getCurrentQuantityOfBook());
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

    public boolean checkBookIDExisted(String bookID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID FROM tblBooks WHERE bookID=?";
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

}
