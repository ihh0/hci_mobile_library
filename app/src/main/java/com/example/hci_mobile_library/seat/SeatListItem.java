package com.example.hci_mobile_library.seat;

public class SeatListItem {
    private String floor;
    private String name;
    private int image;
    private int count;
    private int max;

    public SeatListItem(String floor, String name, int image, int count, int max) {
        this.floor = floor;
        this.name = name;
        this.image = image;
        this.count = count;
        this.max = max;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
