/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.io.Serializable;

/**
 *
 * @author Dung
 */
public class BookDTO implements Serializable {

    private String bookID;
    private String bookTitle;
    private int quantityOfBook;
    private int currentQuantityOfBook;
    private int price;
    private String author;

    public BookDTO(String bookID, String bookTitle, int quantityOfBook, int currentQuantityOfBook, int price, String author) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.quantityOfBook = quantityOfBook;
        this.currentQuantityOfBook = currentQuantityOfBook;
        this.price = price;
        this.author = author;
    }

    public BookDTO() {
    }

    public BookDTO(String bookID, String bookTitle, int price, String author) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.price = price;
        this.author = author;
    }

    public BookDTO(String bookID, String bookTitle, int quantityOfBook, int price, String author) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.quantityOfBook = quantityOfBook;
        this.price = price;
        this.author = author;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getQuantityOfBook() {
        return quantityOfBook;
    }

    public void setQuantityOfBook(int quantityOfBook) {
        this.quantityOfBook = quantityOfBook;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCurrentQuantityOfBook() {
        return currentQuantityOfBook;
    }

    public void setCurrentQuantityOfBook(int currentQuantityOfBook) {
        this.currentQuantityOfBook = currentQuantityOfBook;
    }

}
