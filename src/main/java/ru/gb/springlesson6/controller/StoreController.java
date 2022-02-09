package ru.gb.springlesson6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.springlesson6.entity.Product;
import ru.gb.springlesson6.repository.ProductDao;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class StoreController {

    private final ProductDao repository;


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String processForm(Product product){
        
        if(product.getId() == null){
            repository.addProduct(product);
        } else {
            repository.editProduct(product);
        }
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Long id){
        Product product = repository.findById(id);
        model.addAttribute("product", product);

        return "product";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProducts(Model model){
        model.addAttribute("products", repository.showAllProducts());
        return "product-list";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editProduct(Model model, @RequestParam Long id){
        Product product = repository.findById(id);
        model.addAttribute("product", product);
        return "create-product";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Long id){
        repository.deleteProductById(id);
        return "redirect:/product/all";
    }




}
