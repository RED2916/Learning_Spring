package com.tydic.pojo;

public class iF1Impl implements iF1{
    private String symbol = "iF1Impl:";

    public void add() {
        System.out.println(symbol+"add");
    }

    public void delete() {
        System.out.println(symbol+"delete");
    }

    public void query() {
        System.out.println(symbol+"query");
    }

    public void update() {
        System.out.println(symbol+"update");

    }
}
