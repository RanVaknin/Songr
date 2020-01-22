package com.rafaelsdiamonds.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongrController {

    @Autowired
    AlbumRepository repo;

    @GetMapping("/")
    public String splash() {
        return "index";
    }

    @GetMapping("/hello")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imgUrl) {
        Album album = new Album(title, artist, songCount, length, imgUrl);
        repo.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/albums")
    public String rednerAlbums(Model m) {
        List<Album> albums = repo.findAll();
        m.addAttribute("albums", albums);
        return "albums";
    }

    @GetMapping("/albums/{id}")
    public String getOneAlbum(@PathVariable Long id, Model m) {

        m.addAttribute("albums", repo.getOne(id));
        return "singleAlbum";
    }

    @GetMapping("/capitalize/{capitalizedRoute}")
    public String upperCase(@PathVariable String capitalizedRoute) {
        return capitalizedRoute.toUpperCase();
    }

    @DeleteMapping ("/albums/{id}")
    public RedirectView deleteOneAlbum(@PathVariable Long id) {
        System.out.println("deleting");
        repo.deleteById(id);
        return new RedirectView("/albums");
    }
}