package ms.springframework.publisher;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

  @Override
  List<Publisher> findAll();
}