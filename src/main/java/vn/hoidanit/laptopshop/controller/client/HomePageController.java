package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.hoidanit.laptopshop.serivce.ProductService;

@Controller
public class HomePageController {
    private final ProductService productService;

    public HomePageController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "client/homepage/show";
    }

}
