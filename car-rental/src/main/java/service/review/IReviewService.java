package service.review;

import java.util.List;

import pojo.Review;
 

public interface IReviewService {
	void save(Review review);
	void update(Review review);
    
    void delete(Review review);
    void deleteById(int reviewId);
    
    Review findById(int reviewId);
    List<Review> findByCustomerId (Integer reviewId);
    List<Review> findByCarId (Integer carId);
    List<Review> findAll();
}
