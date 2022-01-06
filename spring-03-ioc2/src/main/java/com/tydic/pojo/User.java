package com.tydic.pojo;

public class User {
    private String userName;
    private String userId;

    public User(){
        System.out.println("User 无参构造");
    }
    public User(String userName,String userId){
        System.out.println("User 有参构造");
        this.userName = userName;
        this.userId=userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
