package ms.project.SF5BtG.bootstrap;

import ms.project.SF5BtG.author.Author;
import ms.project.SF5BtG.author.AuthorRepository;
import ms.project.SF5BtG.book.Book;
import ms.project.SF5BtG.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public Init(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) {
    Author eric = new Author("Eric", "Smith");
    Author jason = new Author("Jason", "Smith");

    Book book_1 = new Book("Harry Potter and the Sorcerer's Stone", "1338878921");
    Book book_2 = new Book("The Making of Middle-earth", "1454944757");

    eric.getBooks().add(book_1);
    jason.getBooks().add(book_2);

    authorRepository.save(eric);
    authorRepository.save(jason);

    book_1.getAuthors().add(eric);
    book_2.getAuthors().add(jason);

    bookRepository.save(book_1);
    bookRepository.save(book_2);
  }
}
