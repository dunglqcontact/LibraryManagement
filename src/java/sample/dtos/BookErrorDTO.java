/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

/**
 *
 * @author Dung
 */
public class BookErrorDTO {

    private String bookIDError;
    private String bookTitleError;
    private String quantityOfBookError;
    private String currentQuantityOfBookError;
    private String priceError;
    private String authorError;

    public BookErrorDTO() {
    }

    public BookErrorDTO(String bookIDError, String bookTitleError, String quantityOfBookError, String currentQuantityOfBookError, String priceError, String authorError) {
        this.bookIDError = bookIDError;
        this.bookTitleError = bookTitleError;
        this.quantityOfBookError = quantityOfBookError;
        this.currentQuantityOfBookError = currentQuantityOfBookError;
        this.priceError = priceError;
        this.authorError = authorError;
    }

    public String getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(String bookIDError) {
        this.bookIDError = bookIDError;
    }

    public String getBookTitleError() {
        return bookTitleError;
    }

    public void setBookTitleError(String bookTitleError) {
        this.bookTitleError = bookTitleError;
    }

    public String getQuantityOfBookError() {
        return quantityOfBookError;
    }

    public void setQuantityOfBookError(String quantityOfBookError) {
        this.quantityOfBookError = quantityOfBookError;
    }

    public String getCurrentQuantityOfBookError() {
        return currentQuantityOfBookError;
    }

    public void setCurrentQuantityOfBookError(String currentQuantityOfBookError) {
        this.currentQuantityOfBookError = currentQuantityOfBookError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getAuthorError() {
        return authorError;
    }

    public void setAuthorError(String authorError) {
        this.authorError = authorError;
    }
}
