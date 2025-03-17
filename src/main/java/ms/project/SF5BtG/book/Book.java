package ms.project.SF5BtG.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import ms.project.SF5BtG.author.Author;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String isbn;

  @ManyToMany
  @JoinTable(name = "author_book",
  joinColumns = @JoinColumn(name = "author_id"),
  inverseJoinColumns = @JoinColumn(name = "book_id"))
  private Set<Author> authors;

  public Book(String title, String isbn, Set<Author> authors) {
    this.title = title;
    this.isbn = isbn;
    this.authors = authors;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", authors=" + authors +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;
    return id.equals(book.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}