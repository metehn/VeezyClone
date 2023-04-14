package com.metehan.veezyclone.Class;

import androidx.annotation.DrawableRes;

public class Room {
    String roomName;
    int deviceNumber;
    @DrawableRes
    private int image;

    public Room(){
    }

    public Room(String roomName, int deviceNumber, int image) {
        this.roomName = roomName;
        this.deviceNumber = deviceNumber;
        this.image = image;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(int deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
