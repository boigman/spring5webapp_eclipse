package stauffer.springframework.spring5webapp.repositories;

import stauffer.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dws on 05/07/2020
*/
public interface BookRepository extends CrudRepository<Book, Long> {

}

