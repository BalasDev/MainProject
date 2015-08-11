package by.epam.project.domain;


import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PROJECTID")
    private Project project;


    @OneToOne
    @JoinColumn(name = "EMPLOYEEID")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "ROLEID")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
