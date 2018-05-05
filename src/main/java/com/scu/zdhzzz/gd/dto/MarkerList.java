package com.scu.zdhzzz.gd.dto;

import java.util.ArrayList;
import java.util.List;

public class MarkerList {

    List<MarkerDto> markers;

    public MarkerList() {
        this.markers = new ArrayList<>();
    }

    public void addMarker(MarkerDto markerDto){
        markers.add(markerDto);
    }
    public void addMarker(double... lnglat) {
        markers.add(new MarkerDto(lnglat));
    }
    public List<MarkerDto> getMarkers() {
        return markers;
    }

    public void setMarkers(List<MarkerDto> markers) {
        this.markers = markers;
    }
}
