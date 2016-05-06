package com.example.toshiba.myapplication1;

/**
 * Created by toshiba on 2/5/16.
 */
public class rowItem_tabbar1 {

    private String name;
    private int profile_id;
    private String hobby;
    private String status;

    public rowItem_tabbar1(String name, int profile_id, String hobby, String status)
    {
        this.name=name;
        this.hobby=hobby;
        this.profile_id=profile_id;
        this.status=status;
    }
    public  String getName(){return  name;}
    public  int getProfile_id(){return profile_id;}
    public String getHobby(){return hobby;}
    public String getStatus(){return status;}
    public void setName(String name){this.name=name;}
    public void setProfile_id(int profile_id){this.profile_id=profile_id;}
    public void setHobby(String hobby){this.hobby=hobby;}
    public void setStatus(String status){this.status=status;}
}
