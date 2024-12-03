package it.eng.corso.reviewservice.controller;


import it.eng.corso.reviewservice.dto.ReviewDTO;
import it.eng.corso.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO review){
        return reviewService.save(review);
    }

    @GetMapping("/average")
    public Double getAverageByUuid(@RequestParam String uuidBook){
        return reviewService.average(uuidBook);
    }

}
