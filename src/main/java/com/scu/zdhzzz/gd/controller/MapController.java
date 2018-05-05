package com.scu.zdhzzz.gd.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.scu.zdhzzz.gd.dto.*;
import com.scu.zdhzzz.gd.service.PointService;
import com.scu.zdhzzz.gd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class MapController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PointService pointService;

    @Autowired
    UserService userService;

    @RequestMapping("/historyTracks")
    @ResponseBody
    public TrackListDto getHistoryTracks(@RequestParam("id") String id) {
        logger.info("Request history tracks of " + id);
        TrackListDto result = pointService.getTracksByID(id);
        return result;
    }

    @RequestMapping("/getFence")
    @ResponseBody
    public MarkerList getFencePoint(@RequestParam("id") String id) {
        logger.info("Request fence list of " + id);
        MarkerList result = pointService.getFenceByID(id);

        return result;
    }

    @RequestMapping(value = "/updateFence", method = RequestMethod.POST)
    @ResponseBody
    public MarkerList updateFence(@RequestBody String json) {

        ObjectMapper mapper = new ObjectMapper();
        MarkerList list = new MarkerList();
        String id = null;
        try {
            JsonNode root = mapper.readTree(json);
            Iterator<Map.Entry<String, JsonNode>> elements = root.fields();
            while (elements.hasNext()) {
                Map.Entry<String, JsonNode> node = elements.next();
                String key = node.getKey();
                if (key.equals("id")) {
                    id = node.getValue().toString();
                    logger.info("Update fence list of " + id);
                    continue;
                }
                if (key.equals("markers")) {
                    if (node.getValue() instanceof ArrayNode){
                        List<MarkerDto> markerDtoList = mapper.readValue(node.getValue().toString(),new TypeReference<List<MarkerDto>>() {});
                        list.setMarkers(markerDtoList);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        pointService.updateFenceById(id, list);
        return list;
    }


    @RequestMapping("/getMessage")
    @ResponseBody
    public MessageList getMessageList(@RequestParam("id") String id, @RequestParam("page") int page){

        return userService.getMessageListByID(id,page);
    }

    @RequestMapping(value = "/interests", method = RequestMethod.GET)
    @ResponseBody
    public List<MarkerDto> getInterest(@RequestParam("id") String id){
        List<MarkerDto> list = pointService.getInterest(id);
        return list;
    }

    @RequestMapping(value = "/interests", method = RequestMethod.DELETE)
    @ResponseBody
    public void delInterest(@RequestParam("id") String id){
        logger.info("Delete id: "+id);
    }

    @RequestMapping(value = "/interests", method = RequestMethod.POST)
    @ResponseBody
    public void createInterest(@RequestBody MarkerDto markerDto){
        logger.info("Add interest: "+ markerDto.getName());
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "\t\"id\":1,\n" +
                "\t\"markers\":[\n" +
                "\t\t{\"name\":\"\",\"lnglat\":[104.064679,30.65816]},\n" +
                "\t\t{\"name\":\"\",\"lnglat\":[104.066529,30.657976]},\n" +
                "\t\t{\"name\":\"\",\"lnglat\":[104.066647,30.656707]},\n" +
                "\t\t{\"name\":\"\",\"lnglat\":[104.064791,30.656642]}\n" +
                "    ]\n" +
                "\t\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        MarkerList list = new MarkerList();
        String id = null;
        try {
            JsonNode root = mapper.readTree(json);
            Iterator<Map.Entry<String, JsonNode>> elements = root.fields();
            while (elements.hasNext()) {
                Map.Entry<String, JsonNode> node = elements.next();
                String key = node.getKey();
                if (key.equals("id")) {
                    id = node.getValue().toString();
                    continue;
                }
                if (key.equals("markers")) {
                    if (node.getValue() instanceof ArrayNode){
                        List<MarkerDto> markerDtoList = mapper.readValue(node.getValue().toString(),new TypeReference<List<MarkerDto>>() {});
                        list.setMarkers(markerDtoList);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

       /* try {
            *//*FenceRequestDto object = mapper.readValue(json, FenceRequestDto.class);
            System.out.println(object.getId());*//*
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try {
            JsonNode root = mapper.readTree(json);
            Iterator<Map.Entry<String, JsonNode>> elements = root.fields();
            while (elements.hasNext()){
                Map.Entry<String,JsonNode> node = elements.next();
                String key = node.getKey();
                if (key.equals("id")){
                    System.out.println("id:"+node.getValue());
                }
                if (key.equals("markers")){

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}


