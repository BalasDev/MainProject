package by.epam.project.domain;

import javax.persistence.*;


//@Entity
//@Table(name = "ROLE")
public class Role {

    /*@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="MEMBER",
            joinColumns = {@JoinColumn(name="ROLEID", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name="ID", referencedColumnName="ROLEID")}
    )
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/
}
