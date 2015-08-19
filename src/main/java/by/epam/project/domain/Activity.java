package by.epam.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ACTIVITY")
public class Activity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "_DATE")
    private Date date;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "COMMENT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "MEMBERID")
    @JsonIgnore
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ASSIGMENTID")
    @JsonIgnore
    private Assigment assigment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Assigment getAssigment() {
        return assigment;
    }

    public void setAssigment(Assigment assigment) {
        this.assigment = assigment;
    }
}
