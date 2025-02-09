package com.lasen.projectmanagementsystem.service;

import com.lasen.projectmanagementsystem.model.Message;

import java.util.List;


public interface MesageService {

    Message sendMessage(Long senderId, Long chatId, String content) throws Exception;

    List<Message> getMessageByProjectId(Long projectId) throws Exception;

}
