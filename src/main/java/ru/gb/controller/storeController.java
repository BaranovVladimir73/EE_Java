package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class storeController {

    private final ProductRepository repository;


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String processForm(Product product){
        repository.addProductToRepository(product);
        return "redirect:/main/all";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllMessages(Model model){
        model.addAttribute("products", repository.showAllProducts());
        return "product-list";
    }
}
