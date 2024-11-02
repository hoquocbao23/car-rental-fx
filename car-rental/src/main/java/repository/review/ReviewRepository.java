package repository.review;

import java.util.List;

import dao.ReviewDao;
import pojo.Review;




public class ReviewRepository implements IReviewRepository{
	
	private ReviewDao dao;
	
	public ReviewRepository(String filename) {
		dao = new ReviewDao(filename);
	}
	
	@Override
	public void save(Review review) {
		dao.save(review);
		 
	}

	@Override
	public void update(Review review) {
		dao.update(review);
		 
	}

	@Override
	public void delete(Review review) {
		dao.delete(review);
	}
	
	@Override
	public void deleteById (int reviewId) {
		delete(
				dao.findById(reviewId)
		);
	}

	@Override
	public Review findById(int reviewId) {
		return dao.findById(reviewId);
	}

	@Override
	public List<Review> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Review> findByCustomerId(Integer customerId) {
		return dao.findAllByCustomerId(customerId);
	}

	@Override
	public List<Review> findByCarId(Integer carId) {
		return dao.findAllByCarId(carId);
	}
	
}
