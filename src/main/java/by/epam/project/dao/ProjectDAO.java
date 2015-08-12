package by.epam.project.dao;


import by.epam.project.domain.Member;
import by.epam.project.domain.Project;

import java.util.List;

public interface ProjectDAO {

    public void addProject(Project project);

    public List<Member> listMember();

    public List<Project> listProject();


}
