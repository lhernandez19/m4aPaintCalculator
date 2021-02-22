package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    //Method addRoom
    public void addRoom (double length, double width, double height){
        Room room = new Room(length, width, height);
        roomList.add(room);
    }

    //Method toString
    @Override
    public String toString() {
        String display = "";
        if( roomList.isEmpty())
            return "There are not rooms to be painted.";

        for( Room room : roomList )
        {
            display += room.getAreas() + "\n";
        }
        return display;
    }
}
