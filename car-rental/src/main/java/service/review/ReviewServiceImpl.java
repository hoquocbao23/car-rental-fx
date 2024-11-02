package service.review;

import java.util.List;

import pojo.Review;
import repository.review.IReviewRepository;
import repository.review.ReviewRepository;

 

public class ReviewServiceImpl implements IReviewService{
	
	private IReviewRepository repo;
	
	public ReviewServiceImpl () {
		repo = new ReviewRepository("hibernate.cfg.xml");
	}
	
	@Override
	public void save(Review review) {
		  repo.save(review);
	}

	@Override
	public void update(Review review) {
		  repo.update(review);
	}

	@Override
	public void delete(Review review) {
		repo.delete(review);
	}
	
	@Override
	public void deleteById (int reviewId) {
		repo.deleteById(reviewId);
	}

	@Override
	public Review findById(int reviewId) {
		return repo.findById(reviewId);
	}
	

	@Override
	public List<Review> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Review> findByCustomerId(Integer customerId) {
		return repo.findByCustomerId(customerId);
	}

	@Override
	public List<Review> findByCarId(Integer carId) {
		return repo.findByCarId(carId);
	}
	
}
