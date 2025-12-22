package org.example;

public class Cell {
    private Marker marker;

    public Cell(){
        this.marker = Marker.NONE;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public Marker getMarker() {
        return marker;
    }

    @Override
    public String toString() {
        if (marker.equals(Marker.NONE)){
            return " ";
        }
        return marker.toString();
    }
    
}
