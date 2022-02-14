package ru.gb.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.springdata.entity.Product;
import ru.gb.springdata.service.ProductService;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class StoreController {

    private final ProductService repository;


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }


    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String processForm(Product product){
        repository.save(product);
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Long id){
        Product product = repository.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

//    @RequestMapping(path = "/all", method = RequestMethod.GET)
//    public String getAllProducts(Model model){
//        model.addAttribute("products", repository.findAll());
//        return "product-list";
//    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editProduct(Model model, @RequestParam Long id){
        Product product = repository.findById(id);
        model.addAttribute("product", product);
        return "create-product";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam(name = "id") Long id){
        repository.deleteProductById(id);
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProducts(Model model,
                                 @RequestParam(name = "sort", defaultValue = "name_asc", required = false) String sort){
        if (sort.equals("name_asc")){
            model.addAttribute("products", repository.findAll(Sort.by(Sort.Direction.ASC, "title")));
        }
        if (sort.equals("name_desc")){
            model.addAttribute("products", repository.findAll(Sort.by(Sort.Direction.DESC, "title")));
        }
        return "product-list";
    }


}
