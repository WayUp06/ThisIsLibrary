package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
/*  book - from OneToMany relation with author
 *   books - fro ManyToMany relationship with coauthors*/
@Getter
@Setter
@Entity
@Table(name = "author_table", schema = "library")
public class Author {
    @Id
    @Column(name = "author_ID")
    @GeneratedValue(generator = "increment")
    private int author_ID;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;


    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author() {
    }

    @OneToMany(mappedBy = "author", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> book;


    @ManyToMany(mappedBy = "coauthors")
    private Set<Book> books;


    @Override
    public String toString() {
        return "Author{" +
                "author_ID=" + author_ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", book=" + book +
                ", books=" + books +
                '}';
    }
}
