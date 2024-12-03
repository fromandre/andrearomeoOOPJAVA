package it.eng.corso.reviewservice.service;

import it.eng.corso.reviewservice.dto.ReviewDTO;

public interface ReviewService {

    ReviewDTO save(ReviewDTO review);

    Double average(String uuidBook);


}

