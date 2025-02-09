package com.lasen.projectmanagementsystem.service;

import com.lasen.projectmanagementsystem.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MesageService {
    @Override
    public Message sendMessage(Long senderId, Long chatId, String content) throws Exception {
//        User sender;
        return null;
    }

    @Override
    public List<Message> getMessageByProjectId(Long projectId) throws Exception {
        return null;
    }
}
