/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dung
 */
public class OrderDetailsDTO implements Serializable {

    private Map<String, BookDTO> cart;
    private int orderID;
    private String bookName;
    private int quantity;

    public OrderDetailsDTO(int orderID, String bookName, int quantity) {
        this.orderID = orderID;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetailsDTO(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public void add(BookDTO dto) {
        if (this.cart == null) {
            this.cart = new HashMap<String, BookDTO>();
        }
        if (this.cart.containsKey(dto.getBookID())) {
            int quantity = this.cart.get(dto.getBookID()).getQuantityOfBook();
            dto.setQuantityOfBook(quantity + 1);
        }
        cart.put(dto.getBookID(), dto);
    }
}
