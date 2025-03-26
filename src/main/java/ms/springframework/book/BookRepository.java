package ms.springframework.book;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

  @Override
  List<Book> findAll();
}