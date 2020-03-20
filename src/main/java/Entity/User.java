package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @Column(name = "user_ID")
    @GeneratedValue(generator = "increment")
    private int user_ID;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;


    @Basic
    @Column(name = "deregisteredDate")
    private LocalDate deregisteredDate;


    @Basic
    @Column(name = "registeredDate")
    private LocalDate registeredDate;

    @OneToMany(mappedBy = "users")
    private Set<Usage> usageSet;

    public User(String name, int age, LocalDate registeredDate, LocalDate deregisteredDate) {
        this.name = name;
        this.age = age;
        this.registeredDate = registeredDate;
        this.deregisteredDate = deregisteredDate;
    }

    public User(String name, int age, LocalDate registeredDate) {
        this.name = name;
        this.age = age;
        this.registeredDate = registeredDate;
    }

    public User() {
    }


    public Optional<LocalDate> getDeregisteredDate() {
        return Optional.ofNullable(deregisteredDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_ID=" + user_ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registeredDate='" + registeredDate + '\'' +
                ", deregisteredDate='" + deregisteredDate + '\'' +
                '}';
    }

}
