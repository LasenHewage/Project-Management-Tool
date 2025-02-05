package com.lasen.projectmanagementsystem.service;

import com.lasen.projectmanagementsystem.model.Project;
import com.lasen.projectmanagementsystem.model.User;

public interface UserService {

    Project createProject(Project project, User user) throws Exception;

    User findUserProfileByJwt(String jwt) throws Exception;

    User findUserByEmail(String email) throws Exception;

    User findUserById(Long userId) throws Exception;

    User updateUsersProjectSize(User user, int number);



}
