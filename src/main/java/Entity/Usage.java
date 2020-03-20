package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;


@Getter
@Setter
@Entity
@Table(name = "usage_table")
public class Usage {
    @Id
    @Column(name = "usage_ID")
    @GeneratedValue(generator = "increment")
    private int usage_ID;

    @Column(name = "bookExample_ID")
    private int bookExample_ID;

    @Column(name = "user_ID")
    private int user_ID;

    @Basic
    @Column(name = "takeDate")
    private LocalDate takeDate;

    @Basic
    @Column(name = "returnDate")
    private LocalDate returnDate;


    public Usage(int bookExample_ID, int user_ID, LocalDate takeDate, LocalDate returnDate) {
        this.bookExample_ID = bookExample_ID;
        this.user_ID = user_ID;
        this.takeDate = takeDate;
        this.returnDate = returnDate;
    }

    public Usage(int bookExample_ID, int user_ID, LocalDate takeDate) {
        this.bookExample_ID = bookExample_ID;
        this.user_ID = user_ID;
        this.takeDate = takeDate;
    }

    public Usage() {
    }

    @ManyToOne()
    @JoinColumn(name = "bookExample_ID", insertable = false, updatable = false)
    private BookExample bookExamples;


    @ManyToOne()
    @JoinColumn(name = "user_ID", insertable = false, updatable = false)
    private User users;

    public Optional<LocalDate> getReturnDate() {
        return Optional.ofNullable(returnDate);
    }

    @Override
    public String toString() {
        return "Usage{" +
                "usage_ID=" + usage_ID +
                ", bookExample_ID=" + bookExample_ID +
                ", user_ID=" + user_ID +
                ", takeDate='" + takeDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }

}
