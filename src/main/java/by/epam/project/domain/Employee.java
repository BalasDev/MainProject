package by.epam.project.domain;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lasttName;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "POSITIONID")
    private Integer positionId;

   /* @OneToOne
    @JoinTable(name="POSITION",
    joinColumns = {@JoinColumn(name="ID", referencedColumnName="POSITIONID")},
    inverseJoinColumns = {@JoinColumn(name = "POSITIONID", referencedColumnName = "ID")})
    Position position;*/

    /*
        @OneToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "MEMBER",
                joinColumns = {@JoinColumn(name = "EMPLOYEEID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "ID", referencedColumnName = "EMPLOYEEID")}
        )
        private Set<Role> roles;

        @OneToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "MEMBER",
                joinColumns = {@JoinColumn(name = "EMPLOYEEID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "ID", referencedColumnName = "EMPLOYEEID")}
        )
        private Set<Project> projects;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

   /* public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }*/
}
