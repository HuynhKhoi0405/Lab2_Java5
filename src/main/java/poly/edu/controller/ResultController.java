package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @RequestMapping("/a")
    public String a(Model model) {
        model.addAttribute("message", "Trang A");
        return "bai5";
    }
    @RequestMapping("/b")
    public String b(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a";
    }

    @RequestMapping("/c")
    public String c(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";
    }

    @ResponseBody
    @RequestMapping("/d")
    public String d() {
        return "I come from d";
    }
}
