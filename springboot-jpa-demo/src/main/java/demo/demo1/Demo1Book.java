package demo.demo1;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "categories")
@Entity(name = "DEMO1_BOOK")
public class Demo1Book {

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private Long id;
    private String title;
    private String author;
    private int price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "DEMO1_BOOK_CATEGORY",
        joinColumns = @JoinColumn(name = "BOOK_ID"),
        inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    private List<Demo1Category> categories;
}
