package by.epam.project.domain;


import java.util.Date;

public class ActivityStream {
    private String lastName;
    private String firstName;
    private String project;
    private String task;
    private String comment;
    private Date date;


    public ActivityStream(String lastName, String firstName, String project, String task, String comment, Date date) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.project = project;
        this.task = task;
        this.comment = comment;
        this.date = date;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
