package com.github.reneranzinger.audiobook.wishlist.persist;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
