package com.example.zmc_recycler_view;

public class Data {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_IMAGE = 2;


    public int type;
    public String title;
    public String description;
    public int number;
    public String avatar;

    public Data(int type, String title, String description, int number, String avatar) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.number = number;
        this.avatar = avatar;
    }

}
