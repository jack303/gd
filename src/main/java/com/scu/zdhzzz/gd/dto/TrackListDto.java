package com.scu.zdhzzz.gd.dto;


import java.util.ArrayList;
import java.util.List;

public class TrackListDto {

    private List<double[]> tracks;

    public TrackListDto() {
        this.tracks = new ArrayList<>();
    }


    public List<double[]> getTracks() {
        return tracks;
    }

    public void setTracks(List tracks) {
        this.tracks = tracks;
    }

    public void addTrack(double longitude, double latitude){
        tracks.add(new double[]{longitude, latitude});
    }
    /*@Repository
    class Track {
        double[] lnglat = new double[2];

        public Track(double longitude, double latitude) {
            // 经度
            this.lnglat[0] = longitude;

            // 纬度
            this.lnglat[1] = latitude;
        }
    }*/
}
