package com.lasen.projectmanagementsystem.service;

import com.lasen.projectmanagementsystem.model.Issue;
import com.lasen.projectmanagementsystem.model.User;
import request.IssueRequest;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    Issue getIssueById(Long issueId) throws Exception;

    List<Issue> getIssueByProjectId(Long projectId) throws Exception;

    Issue createIssue(IssueRequest issue, User user) throws Exception;

    void deleteIssue(Long issueId, Long userId) throws Exception;

    Issue addUserToIssue(Long issueid, Long userId) throws Exception;

    Issue updateStatus(Long isueId, String status) throws Exception;

}
