package com.scu.zdhzzz.gd.service;

import com.scu.zdhzzz.gd.dto.MessageList;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    MessageList getMessageListByID(String id, int page);
}
