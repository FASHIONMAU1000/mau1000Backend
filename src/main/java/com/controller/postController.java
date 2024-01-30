package com.controller;

import com.domain.Post;
import com.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class postController {
    private final PostService postService;
    @PostMapping
    public void addPost(Post post, HttpServletResponse response) throws IOException {
        log.info("addPost");
        postService.save(post);
        redirect(response);
    }

    public void redirect(HttpServletResponse response) throws IOException {
        log.info("redirect");
        response.sendRedirect("/post");
    }

    @PutMapping
    public void updatePost(@RequestBody Post post) {
        log.info("updatePost");
        postService.update(post);
    }
    @DeleteMapping
    public void deletePost(@RequestBody Post post) {
        postService.delete(post);
    }

}
