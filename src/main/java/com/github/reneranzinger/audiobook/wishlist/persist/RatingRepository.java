package com.github.reneranzinger.audiobook.wishlist.persist;

import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long>
{
}
