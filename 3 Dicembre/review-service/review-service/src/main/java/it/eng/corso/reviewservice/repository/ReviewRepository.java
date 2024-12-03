package it.eng.corso.reviewservice.repository;


import it.eng.corso.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUuidBook(String uuidBook);

    Review findByUuid(String uuid);
}
