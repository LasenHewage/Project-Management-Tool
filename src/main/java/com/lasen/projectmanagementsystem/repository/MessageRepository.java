package com.lasen.projectmanagementsystem.repository;

import com.lasen.projectmanagementsystem.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
