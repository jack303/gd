package com.scu.zdhzzz.gd.impl;

import com.scu.zdhzzz.gd.dto.MessageDto;
import com.scu.zdhzzz.gd.dto.MessageList;
import com.scu.zdhzzz.gd.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public MessageList getMessageListByID(String id, int page) {
        MessageList messageList = new MessageList();
        List<MessageDto> list = new ArrayList<>();
        list.add(new MessageDto("2018/4/22 "+page,"A 走出了围栏"));
        messageList.setMessageList(list);
        return messageList;
    }
}
