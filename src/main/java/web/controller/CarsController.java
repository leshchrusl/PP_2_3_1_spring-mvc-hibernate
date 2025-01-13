package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.*;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count,
                          Model model) {

        if (count == null) {
            count = 5;
        }

        model.addAttribute("carsList",  new CarServiceImpl().getCars(count));
        
        return "cars";
    }

}
