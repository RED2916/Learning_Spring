package classes;

public class UserInformation {
    private String userId;
    private String userName;
    private String age;
    private String address;
    private String exInf;

    public UserInformation(){
    }
    public UserInformation(String userId, String userName,String age,String address,String exInf){
        this.setUserId(userId);;
        this.setUserName(userName);;
        this.setAge(age);
        this.setAddress(address);
        this.setExInf(exInf);
    }
    //this不能省，连接处大写
    public String getUserId(){
        return userId;
    }
    public void setUserId(String input){
        this.userId = input;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String input){
        this.userName = input;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String input){
        this.age = input;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String input){
        this.address = input;
    }
    public String getExInf(){
        return exInf;
    }
    public void setExInf(String input){
        this.exInf = input;
    }
}
