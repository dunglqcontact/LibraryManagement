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
public class DateErrorDTO {

    private String getDateError;
    private String returnDateError;
    private String compareDate;

    public DateErrorDTO(String getDateError, String returnDateError, String compareDate) {
        this.getDateError = getDateError;
        this.returnDateError = returnDateError;
        this.compareDate = compareDate;
    }

    public DateErrorDTO() {
    }

    public String getGetDateError() {
        return getDateError;
    }

    public void setGetDateError(String getDateError) {
        this.getDateError = getDateError;
    }

    public String getReturnDateError() {
        return returnDateError;
    }

    public void setReturnDateError(String returnDateError) {
        this.returnDateError = returnDateError;
    }

    public String getCompareDate() {
        return compareDate;
    }

    public void setCompareDate(String compareDate) {
        this.compareDate = compareDate;
    }

}
