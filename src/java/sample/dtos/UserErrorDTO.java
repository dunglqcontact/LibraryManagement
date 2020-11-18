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
public class UserErrorDTO {

    private String userIDError;
    private String passwordError;
    private String rePasswordError;
    private String userNameError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String passwordError, String rePasswordError, String userNameError) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
        this.rePasswordError = rePasswordError;
        this.userNameError = userNameError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRePasswordError() {
        return rePasswordError;
    }

    public void setRePasswordError(String rePasswordError) {
        this.rePasswordError = rePasswordError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

}
