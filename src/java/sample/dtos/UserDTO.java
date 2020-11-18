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
public class UserDTO implements Serializable {

    private String userID;
    private String password;
    private String userName;
    private String userRole;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String userName, String userRole) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.userRole = userRole;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
