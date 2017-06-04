package com.gechuangms.model;

import org.litepal.crud.DataSupport;

/**
 * Created by Ezra on 2017/5/29.
 */

public class GCUser extends DataSupport {

    private String userAccount;
    private String userPassword;
    private int userGroup;

    private String userName;
    private String userSignature;
    private int userGrade;
    private String userDepartment;
    private String userPhone;
    private int userIconUrl;

    public GCUser() {
    }

    public GCUser(String userAccount, String userPassword, int userGroup, String userPhone) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
        this.userPhone = userPhone;
    }

    public GCUser(String userAccount, String userPassword, int userGroup, String userName, String userSignature, int userGrade, String userDepartment, String userPhone, int userIconUrl) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
        this.userName = userName;
        this.userSignature = userSignature;
        this.userGrade = userGrade;
        this.userDepartment = userDepartment;
        this.userPhone = userPhone;
        this.userIconUrl = userIconUrl;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(int userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GCUser gcUser = (GCUser) o;

        if (userGroup != gcUser.userGroup) return false;
        if (userGrade != gcUser.userGrade) return false;
        if (userIconUrl != gcUser.userIconUrl) return false;
        if (userAccount != null ? !userAccount.equals(gcUser.userAccount) : gcUser.userAccount != null)
            return false;
        if (userPassword != null ? !userPassword.equals(gcUser.userPassword) : gcUser.userPassword != null)
            return false;
        if (userName != null ? !userName.equals(gcUser.userName) : gcUser.userName != null)
            return false;
        if (userSignature != null ? !userSignature.equals(gcUser.userSignature) : gcUser.userSignature != null)
            return false;
        if (userDepartment != null ? !userDepartment.equals(gcUser.userDepartment) : gcUser.userDepartment != null)
            return false;
        return userPhone != null ? userPhone.equals(gcUser.userPhone) : gcUser.userPhone == null;

    }

    @Override
    public int hashCode() {
        int result = userAccount != null ? userAccount.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + userGroup;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSignature != null ? userSignature.hashCode() : 0);
        result = 31 * result + userGrade;
        result = 31 * result + (userDepartment != null ? userDepartment.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + userIconUrl;
        return result;
    }

    @Override
    public String toString() {
        return "GCUser{" +
                "userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userGroup=" + userGroup +
                ", userName='" + userName + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userGrade=" + userGrade +
                ", userDepartment='" + userDepartment + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIconUrl=" + userIconUrl +
                '}';
    }
}
