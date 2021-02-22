package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList = new ArrayList<>();

    //Ask Stacey
    public Room(double length, double width, double height) {
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getAreas(){
        double total = 0;

        for( Wall wall : wallList  ) {
            total += wall.getArea();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Room with area" + "wallList=" + getAreas();
    }
}
