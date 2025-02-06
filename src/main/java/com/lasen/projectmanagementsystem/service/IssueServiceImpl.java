package com.lasen.projectmanagementsystem.service;

import com.lasen.projectmanagementsystem.model.Issue;
import com.lasen.projectmanagementsystem.model.Project;
import com.lasen.projectmanagementsystem.model.User;
import com.lasen.projectmanagementsystem.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import request.IssueRequest;

import java.util.List;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService{

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Override
    public Issue getIssueById(Long issueId) throws Exception {
        Optional<Issue> issue = issueRepository.findById(issueId);
        if(issue.isPresent()){
            return issue.get();
        }
        throw new Exception("No issue found with issueId " + issueId);
    }

    @Override
    public List<Issue> getIssueByProjectId(Long projectId) throws Exception {
        return issueRepository.findByProjectID(projectId);
    }

    @Override
    public Issue createIssue(IssueRequest issueRequest, User user) throws Exception {
       Project project = projectService.getProjectById(issueRequest.getProjectId());

       Issue issue = new Issue();
       issue.setTitle(issueRequest.getTitle());
       issue.setDescription(issueRequest.getDescription());
       issue.setStatus(issueRequest.getStatus());
       issue.setIssuepProjectId(issueRequest.getProjectId());
       issue.setPriority(issueRequest.getPriority());
       issue.setDueDate(issueRequest.getDueDate());

       issue.setProject(project);
        return issueRepository.save(issue);
    }

    @Override
    public void deleteIssue(Long issueId, Long userId) throws Exception {
        getIssueById(issueId);
        issueRepository.deleteById(issueId);
    }

    @Override
    public Issue addUserToIssue(Long issueid, Long userId) throws Exception {
        User user = userService.findUserById(userId);
        Issue issue = getIssueById(issueid);
        issue.setAssignee(user);

        return issueRepository.save(issue);
    }

    @Override
    public Issue updateStatus(Long issueId, String status) throws Exception {
        Issue issue = getIssueById(issueId);
        issue.setStatus(status);
        return issueRepository.save(issue);
    }
}
