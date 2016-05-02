package com.example.toshiba.myapplication1;

/**
 * Created by toshiba on 2/5/16.
 */
public class rowItem {

    private String name;
    private int profile_id;
    private String hobby;

    public rowItem(String name, int profile_id, String hobby)
    {
        this.name=name;
        this.hobby=hobby;
        this.profile_id=profile_id;
    }
    public  String getName(){return  name;}
    public  int getProfile_id(){return profile_id;}
    public String getHobby(){return hobby;}

    public void setName(String name){this.name=name;}
    public void setProfile_id(int profile_id){this.profile_id=profile_id;}
    public void setHobby(String hobby){this.hobby=hobby;}
}
