package it.eng.corso.reviewservice.service;


import it.eng.corso.reviewservice.dto.ReviewDTO;
import it.eng.corso.reviewservice.model.Review;
import it.eng.corso.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDTO save(ReviewDTO review) {
        review.setUuid(String.valueOf(UUID.randomUUID()));
        return modelToDto(reviewRepository.save(dtoToModel(review)));
    }

    @Override
    public Double average(String uuidBook) {
        return reviewRepository.findByUuidBook(uuidBook)
                .stream()
                .map(Review::getStars)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0D);

    }

    private Review dtoToModel(ReviewDTO review) {
        return Review.builder()
                .uuid(review.getUuid())
                .uuidBook(review.getUuidBook())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt())
                .build();
    }

    private ReviewDTO modelToDto(Review review) {
        return ReviewDTO.builder()
                .uuid(review.getUuid())
                .uuidBook(review.getUuidBook())
                .stars(review.getStars())
                .createdAt(review.getCreatedAt())
                .build();
    }


}
