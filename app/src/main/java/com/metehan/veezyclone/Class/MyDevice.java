package com.metehan.veezyclone.Class;

public class MyDevice {

    String name;
    String room;
    int image;

    public MyDevice() {
    }

    public MyDevice(String name, String room, int image) {
        this.name = name;
        this.room = room;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
