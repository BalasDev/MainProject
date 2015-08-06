package by.epam.project.domain;


import javax.persistence.*;

//@Entity
//@Table(name = "PROJECT")
public class Project {
   /* @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(name="MEMBER",
            joinColumns = {@JoinColumn(name="PROJECTID", referencedColumnName="ID")},
            inverseJoinColumns = {@JoinColumn(name="ID", referencedColumnName="PROJECTID")}
    )
    private Employee employee;*/
}
