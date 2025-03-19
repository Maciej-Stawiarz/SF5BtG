package ms.project.SF5BtG.bootstrap;

import ms.project.SF5BtG.author.Author;
import ms.project.SF5BtG.author.AuthorRepository;
import ms.project.SF5BtG.book.Book;
import ms.project.SF5BtG.book.BookRepository;
import ms.project.SF5BtG.publisher.Publisher;
import ms.project.SF5BtG.publisher.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public Init(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) {
    Author eric = new Author("Eric", "Smith");
    Author jason = new Author("Jason", "Smith");

    Book book_1 = new Book("Harry Potter and the Sorcerer's Stone", "1338878921");
    Book book_2 = new Book("The Making of Middle-earth", "1454944757");

    Publisher publisher = new Publisher();
    publisher.setName("SFG Publishing");
    publisher.setCity("St Petersburg");
    publisher.setState("FL");

    publisherRepository.save(publisher);

    eric.getBooks().add(book_1);
    jason.getBooks().add(book_2);

    authorRepository.save(eric);
    authorRepository.save(jason);

    book_1.getAuthors().add(eric);
    book_2.getAuthors().add(jason);
    book_1.setPublisher(publisher);
    book_2.setPublisher(publisher);

    bookRepository.save(book_1);
    bookRepository.save(book_2);

    publisher.getBooks().add(book_1);
    publisher.getBooks().add(book_2);

    publisherRepository.save(publisher);

    System.out.println("--------------------------------------------");
    System.out.println("Amount of authors: " + authorRepository.count());
    System.out.println("Amount of books: " + bookRepository.count());
    System.out.println("Amount of publishers books: " + publisherRepository.findById(1L).get().getBooks().size());
  }
}
