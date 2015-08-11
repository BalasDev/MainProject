package by.epam.project.service;


import by.epam.project.domain.Member;
import by.epam.project.domain.Project;

import java.util.List;

public interface ProjectService {

    public void addProject(Project project);

    public List<Member> listMember();
}
