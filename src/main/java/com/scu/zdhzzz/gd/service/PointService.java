package com.scu.zdhzzz.gd.service;

import com.scu.zdhzzz.gd.dto.MarkerDto;
import com.scu.zdhzzz.gd.dto.MarkerList;
import com.scu.zdhzzz.gd.dto.TrackListDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointService {
    TrackListDto getTracksByID(String id);

    MarkerList getFenceByID(String id);

    void updateFenceById(String id,MarkerList markerList);

    List<MarkerDto> getInterest(String id);
}
