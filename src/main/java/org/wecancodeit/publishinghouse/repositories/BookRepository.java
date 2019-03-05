package org.wecancodeit.publishinghouse.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.publishinghouse.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByTitle(String title);

}
