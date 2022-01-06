package com.tydic.pojo;

import java.util.*;

public class UserT {
    private String userTName;
    private User user;
    private String[] strings;
    private List<String> list;
    private Map<String,String> maps;
    private Set<String> sets;
    private String TheNull;
    private Properties info;

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String
    toString() {
        return "UserT{" +
                "userTName='" + userTName + '\'' +
                ", user=" + user +
                ", strings=" + Arrays.toString(strings) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                ", TheNull='" + TheNull + '\'' +
                ", info=" + info +
                '}';
    }
    //会自动调用其中类的toString

    public String getTheNull() {
        return TheNull;
    }

    public void setTheNull(String theNull) {
        TheNull = theNull;
    }

    public String getUserTName() {
        return userTName;
    }

    public void setUserTName(String userTName) {
        this.userTName = userTName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }
}
