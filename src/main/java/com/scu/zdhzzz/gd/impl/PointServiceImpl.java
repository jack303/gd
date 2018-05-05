package com.scu.zdhzzz.gd.impl;

import com.scu.zdhzzz.gd.dto.MarkerDto;
import com.scu.zdhzzz.gd.dto.MarkerList;
import com.scu.zdhzzz.gd.dto.TrackListDto;
import com.scu.zdhzzz.gd.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    @Override
    public TrackListDto getTracksByID(String id) {
        TrackListDto result = new TrackListDto();
        // todo:query database
        /*
        [104.064679,30.65816],
        [104.066529,30.657976],
        [104.066647,30.656707],
        [104.064791,30.656642]
         */
        result.addTrack(104.064679,30.65816);
        result.addTrack(104.066529,30.657976);
        result.addTrack(104.066647,30.656707);
        result.addTrack(104.064791,30.656642);

        return result;
    }

    @Override
    public MarkerList getFenceByID(String id) {
        MarkerList result = new MarkerList();
        // todo:query fence point in database

        result.addMarker(new MarkerDto(104.064679,30.65816));
        result.addMarker(104.066529,30.657976);
        result.addMarker(104.066647,30.656707);
        result.addMarker(104.064791,30.656642);

        return result;
    }

    @Override
    public void updateFenceById(String id, MarkerList markerList) {
        // todo: update certain user's fence list in db


    }

    @Override
    public List<MarkerDto> getInterest(String id) {
        /*
        {
            "name": "zdh",
            "id": "zdhzzz",
            "lnglat": [103.871414, 30.937263],
        },
        {
            "name": "tf",
            "id": "tfboys",
            "lnglat": [104.325974, 30.775752],
        },
        {
            "name": "zdh",
            "id": "zdhzz",
            "lnglat": [103.830216, 30.553676],
        },
        {
            "name": "tf",
            "id": "tfbys",
            "lnglat": [104.394638, 30.359534],
        },
        {
            "name": "测试添加电子围栏",
            "id": "test01",
            "lnglat": [104.065392, 30.657099],
        }
         */

        List<MarkerDto> list = new ArrayList<>();
        list.add(new MarkerDto("测试添加电子围栏","test01",104.065392, 30.657099));
        return list;
    }
}
