package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.model.Product;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product2")
public class ProductController2 {

    @GetMapping("/form")
    public String form2(Model model) {
        // product mặc định
        Product p = new Product("iPhone 17", 1700000.0);
        model.addAttribute("p1", p);

        // thêm p2 rỗng để tránh null trong view
        model.addAttribute("p2", new Product());

        return "product2"; // trỏ tới product2.html
    }

    @PostMapping("/save")
    public String save2(@ModelAttribute("p2") Product p, Model model) {
        // giữ lại p1 và danh sách để không bị mất khi reload trang
        Product p1 = new Product("iPhone 17", 1700000.0);
        model.addAttribute("p1", p1);

        // p2 sẽ tự động được Thymeleaf hiển thị
        model.addAttribute("p2", p);

        return "product2";
    }

    // danh sách sản phẩm
    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 2.0),
                new Product("C", 3.0)
        );
    }
}
