package com.controller;

import com.domain.Post;
import com.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class homeController {
    private final PostService postService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        //TODO: add login logic
        log.info("login");
        return "login";
    }

    @RequestMapping("/post")
    public String post(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        log.info("post");
        return "post";
    }

    @RequestMapping("/post/form")
    public String addNewForm(Model model) {
        Post post = new Post();
        model.addAttribute("Post", post);
        return "post/form";
    }

    @GetMapping("/validation")
    public String validation() {
        return "validation";
    }

}
