package com.rafaelsdiamonds.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongrController {

    @GetMapping("/")
    public String splash() {
        return "index";
    }

    @GetMapping("/hello")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/capitalize/{capitalizedRoute}")
    public String upperCase(@PathVariable String capitalizedRoute) {
        return capitalizedRoute.toUpperCase();
    }

    @GetMapping("/albums")
    public String albums(Model m) {
        Album[] albums = new Album[]{
                new Album("Kind Of Blue", "Miles Davis", 15, 2700, "https://upload.wikimedia.org/wikipedia/en/9/9c/MilesDavisKindofBlue.jpg"),
                new Album("The Wall", "Pink Floyd", 26, 4800, "https://upload.wikimedia.org/wikipedia/en/thumb/c/cb/PinkFloydAnotherBrickCover.jpg/220px-PinkFloydAnotherBrickCover.jpg"),
                new Album("Highway To Hell", "AC/DC", 10, 2460, "https://upload.wikimedia.org/wikipedia/en/a/ac/Acdc_Highway_to_Hell.JPG")
        };
        m.addAttribute("albums", albums);
        return "albums";
    }
}