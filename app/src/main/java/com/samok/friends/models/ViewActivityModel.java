package com.samok.friends.models;

public class ViewActivityModel {
    //Variables.
    private String id;
    private String friendName;
    private String phone;
    private String email;
    private String friendLocation;
    private String friendDesc;
    private String friendPeriod;
    private String friendPhoto;

    //Empty constructor.
    public ViewActivityModel(){

    }

    //Constructor.
    public ViewActivityModel(String id, String friendName, String phone, String email, String friendLocation, String friendDesc, String friendPeriod){
        this.id = id;
        this.friendName = friendName;
        this.phone = phone;
        this.email = email;
        this.friendLocation = friendLocation;
        this.friendDesc = friendDesc;
        this.friendPeriod = friendPeriod;
        this.friendPhoto = friendPhoto;
    }
//    Getters and setters.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFriendLocation() {
        return friendLocation;
    }

    public void setFriendLocation(String friendLocation) {
        this.friendLocation = friendLocation;
    }

    public String getFriendDesc() {
        return friendDesc;
    }

    public void setFriendDesc(String friendDesc) {
        this.friendDesc = friendDesc;
    }

    public String getFriendPeriod() {
        return friendPeriod;
    }

    public void setFriendPeriod(String friendPeriod) {
        this.friendPeriod = friendPeriod;
    }

    public String getFriendPhoto() {
        return friendPhoto;
    }

    public void setFriendPhoto(String friendPhoto) {
        this.friendPhoto = friendPhoto;
    }
}
