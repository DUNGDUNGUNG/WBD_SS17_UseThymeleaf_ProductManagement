package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ModelAndView listProduct() {
        return new ModelAndView("list", "products", productService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "products", new Product());
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 5555));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Saved product successfully!");
        return new ModelAndView("redirect:/products/list");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable int id) {
        return new ModelAndView("edit", "products", productService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView updateProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Modified product successfully!");
        return new ModelAndView("redirect:/products/list");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        return new ModelAndView("delete", "products", productService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView removeProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return new ModelAndView("redirect:/products/list");

    }

    @GetMapping("/{id}/view")
    public ModelAndView viewProduct(@PathVariable int id) {
        return new ModelAndView("view", "products", productService.findById(id));
    }

    @PostMapping("/search")
    public ModelAndView searchNameProduct(@RequestParam("search") String name) {
        return new ModelAndView("search", "products", productService.findByName(name));
    }

}
