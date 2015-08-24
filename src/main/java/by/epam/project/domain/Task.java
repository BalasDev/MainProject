package by.epam.project.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Roma on 18.08.2015.
 */
@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="PROJECTID")
    private Project project;

    @Column(name = "DESCRIPTION")
    private String description;

   /* @Column(name = "PSD")
    private Date psd;

    @Column(name = "PDD")
    private Integer pdd;

    @Column(name = "ASD")
    private Date asd;

    @Column (name ="AD")
    private Integer ad;*/

    @ManyToOne
    @JoinColumn(name="STATUSID")
    private Status status;

    @OneToOne(mappedBy="task", cascade=CascadeType.ALL)
    private Assigment assigment;

    @OneToMany(mappedBy = "task")
    private List<Attachment> attachments;

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Assigment getAssigment() {
        return assigment;
    }

    public void setAssigment(Assigment assigment) {
        this.assigment = assigment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /*public Date getPsd() {
        return psd;
    }

    public void setPsd(Date psd) {
        this.psd = psd;
    }

    public Integer getPdd() {
        return pdd;
    }

    public void setPdd(Integer pdd) {
        this.pdd = pdd;
    }

    public Date getAsd() {
        return asd;
    }

    public void setAsd(Date asd) {
        this.asd = asd;
    }

    public Integer getAd() {
        return ad;
    }

    public void setAd(Integer ad) {
        this.ad = ad;
    }*/
}
