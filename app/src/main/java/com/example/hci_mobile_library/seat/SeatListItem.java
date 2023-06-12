package com.example.hci_mobile_library.seat;

public class SeatListItem {
    private String floor;
    private String name;
    private String image;

    public SeatListItem(String floor, String name, String image) {
        this.floor = floor;
        this.name = name;
        this.image = image;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
