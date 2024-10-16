package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.*;

@Controller
@RequestMapping(value = "/productcart")
public class ProductCartController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductDAO productModel = new ProductDAO();
		modelMap.put("products", productModel.findAll());
		return "index";
	}

}

