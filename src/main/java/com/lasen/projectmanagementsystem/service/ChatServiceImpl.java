package com.lasen.projectmanagementsystem.service;

import com.lasen.projectmanagementsystem.model.Chat;
import com.lasen.projectmanagementsystem.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat){
        return chatRepository.save(chat);
    }

}
