package by.epam.project.dao;


import by.epam.project.domain.Attachment;
import by.epam.project.domain.Project;
import by.epam.project.domain.Task;

import java.util.List;

public interface AttachmentDAO {
    Attachment getAttachment (Integer id);
    void addAttachment(String name, String size, String description, Project project, Task task);
    List<Attachment> listAttachTask (Integer id);
}
