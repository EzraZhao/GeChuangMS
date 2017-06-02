package com.gechuangms.model;

import org.litepal.crud.DataSupport;

/**
 * Created by Ezra on 2017/5/29.
 */

public class GCUser extends DataSupport {

    private int userId;
    private String userAccount;
    private String userPassword;
    private int userGroup;

    private String userNickName;
    private String userName;
    private String userSignature;
    private int userAge;
    private int userGrade;
    private String userDepartment;
    private String userPhone;
    private String userIconUrl;

    public GCUser() {
    }

    public GCUser(String userAccount, String userPassword, int userGroup, String userPhone) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
        this.userPhone = userPhone;
    }

    public GCUser(int userId, String userAccount, String userPassword, int userGroup, String userNickName, String userName, String userSignature, int userAge, int userGrade, String userDepartment, String userPhone, String userIconUrl) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
        this.userNickName = userNickName;
        this.userName = userName;
        this.userSignature = userSignature;
        this.userAge = userAge;
        this.userGrade = userGrade;
        this.userDepartment = userDepartment;
        this.userPhone = userPhone;
        this.userIconUrl = userIconUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
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

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
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

        if (userId != gcUser.userId) return false;
        if (userGroup != gcUser.userGroup) return false;
        if (userAge != gcUser.userAge) return false;
        if (userGrade != gcUser.userGrade) return false;
        if (userAccount != null ? !userAccount.equals(gcUser.userAccount) : gcUser.userAccount != null)
            return false;
        if (userPassword != null ? !userPassword.equals(gcUser.userPassword) : gcUser.userPassword != null)
            return false;
        if (userNickName != null ? !userNickName.equals(gcUser.userNickName) : gcUser.userNickName != null)
            return false;
        if (userName != null ? !userName.equals(gcUser.userName) : gcUser.userName != null)
            return false;
        if (userSignature != null ? !userSignature.equals(gcUser.userSignature) : gcUser.userSignature != null)
            return false;
        if (userDepartment != null ? !userDepartment.equals(gcUser.userDepartment) : gcUser.userDepartment != null)
            return false;
        if (userPhone != null ? !userPhone.equals(gcUser.userPhone) : gcUser.userPhone != null)
            return false;
        return userIconUrl != null ? userIconUrl.equals(gcUser.userIconUrl) : gcUser.userIconUrl == null;

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + userGroup;
        result = 31 * result + (userNickName != null ? userNickName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSignature != null ? userSignature.hashCode() : 0);
        result = 31 * result + userAge;
        result = 31 * result + userGrade;
        result = 31 * result + (userDepartment != null ? userDepartment.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userIconUrl != null ? userIconUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GCUser{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userGroup=" + userGroup +
                ", userNickName='" + userNickName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userAge=" + userAge +
                ", userGrade=" + userGrade +
                ", userDepartment='" + userDepartment + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIconUrl='" + userIconUrl + '\'' +
                '}';
    }
}
