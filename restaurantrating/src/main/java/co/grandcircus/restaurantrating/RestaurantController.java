package co.grandcircus.restaurantrating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.restaurantratingDao.restaurantDao;
import co.grandcircus.restaurantratingEntity.Restaurant;


public class RestaurantController {

	@Autowired
	private restaurantDao Dao;

	
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("HELPME!!");
		List<Restaurant> restaurant = Dao.findAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("restaurant", restaurant);
		return mv;
	}
	
	@RequestMapping("/restaurant/voteup")
	public ModelAndView voteUp(@RequestParam("id") Long id) {
		Dao.voteUp(id);
		return new ModelAndView("redirect:/");

	}

	
	@RequestMapping("/restaurant/votedown")
	public ModelAndView voteDown(@RequestParam("id") Long id) {
		Dao.voteDown(id);
		return new ModelAndView("redirect:/");

	}
	
}
