package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "bookexample_table")
public class BookExample {
    @Id
    @Column(name = "bookExample_ID")
    @GeneratedValue(generator = "increment")
    private int bookExample_ID;

    @Column(name = "book_id")
    private int book_ID;

    @Column(name = "year")
    private int year;

    @Column(name = "existence")
    private String existence;


    public BookExample(int book_ID, int year, String existence) {
        this.book_ID = book_ID;
        this.year = year;
        this.existence = existence;
    }

    public BookExample() {
    }

    @ManyToOne
    @JoinColumn(name = "book_ID", insertable = false, updatable = false)
    private Book book;


    @OneToMany(mappedBy = "bookExamples")
    private Set<Usage> usageSet;


    @Override
    public String toString() {
        return "BookExample{" +
                "bookExample_ID=" + bookExample_ID +
                ", book_ID=" + book_ID +
                ", year=" + year +
                ", existence='" + existence + '\'' +
                '}';
    }

}
