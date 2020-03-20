package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    @Column(name = "book_ID")
    @GeneratedValue(generator = "increment")
    private int book_ID;

    @Column(name = "name")
    private String name;

    @Column(name = "author_ID")
    private int author_ID;


    public Book(String name, int author_ID) {
        this.name = name;
        this.author_ID = author_ID;
    }

    public Book() { }


    @ManyToOne
    @JoinColumn(name = "author_ID", insertable=false, updatable=false)
    private Author author;


    @OneToMany(mappedBy = "book")
    private Set<BookExample> bookExample;


    @ManyToMany
    @JoinTable(name = "coauthor_book", joinColumns = {@JoinColumn(name = "book_ID", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "author_ID")})
    private Set<Author> coauthors;


    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", name='" + name + '\'' +
                ", author_ID=" + author_ID +
                '}';
    }

}
