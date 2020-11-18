package sample.dtos;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import sample.daos.OrderDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dung
 */
public class OrderDTO implements Serializable {

    private int orderID;
    private String getDate;
    private String returnDate;
    private ArrayList<OrderDetailsDTO> orderDetailsList;
    OrderDAO dao = new OrderDAO();
    private boolean status;

    public OrderDTO(int orderID, String getDate, String returnDate, boolean status) {
        this.orderID = orderID;
        this.getDate = getDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public OrderDTO(int orderID, String getDate, String returnDate) {
        this.orderID = orderID;
        this.getDate = getDate;
        this.returnDate = returnDate;
    }

    public OrderDTO(String getDate, String returnDate, boolean status) throws SQLException {
        this.orderID = autoGenerateID();
        this.getDate = getDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getGetDate() {
        return getDate;
    }

    public void setGetDate(String getDate) {
        this.getDate = getDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public ArrayList<OrderDetailsDTO> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(ArrayList<OrderDetailsDTO> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public int autoGenerateID() throws SQLException {
        int count = dao.countOrder();
        count++;
        return count;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
