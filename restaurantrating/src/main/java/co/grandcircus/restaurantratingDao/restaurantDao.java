package co.grandcircus.restaurantratingDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import co.grandcircus.restaurantratingEntity.Restaurant;

@Repository // Dao Implementation
@Transactional

public class restaurantDao {

	@PersistenceContext
	EntityManager em;

	public List<Restaurant> findAll() {
		List<Restaurant> restaurant = em.createQuery("FROM Restaurant", Restaurant.class).getResultList();
		return restaurant;
	}

	public Restaurant findById(Long id) {
		return em.find(Restaurant.class, id);
	}

	public void create(Restaurant restaurant) {
		em.persist(restaurant);
	}

	public void voteUp(long id) {

		Restaurant restaurant = em.getReference(Restaurant.class, id);
		double increase = restaurant.getRating() + 0.5;
		if (increase > 5) {
			restaurant.setRating(5);
		} else {
			restaurant.setRating(increase);
		}
		em.merge(restaurant);

	}
	
	public void voteDown(long id) {

		Restaurant restaurant = em.getReference(Restaurant.class, id);
		double decrease = restaurant.getRating() - 0.5;
		if(decrease < 0) {
			restaurant.setRating(0);
		}else {
			restaurant.setRating(decrease);
		}
		em.merge(restaurant);

	}

}
