package by.epam.project.service;


import by.epam.project.dao.IssueDAO;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService{

    @Autowired
    IssueDAO issueDAO;

    @Transactional
    public List<Project> getProject(String login) {
        return issueDAO.getProject(login);
    }

    @Transactional
    public List<Member> getMember(Integer id) {
        return issueDAO.getMember(id);
    }


}
