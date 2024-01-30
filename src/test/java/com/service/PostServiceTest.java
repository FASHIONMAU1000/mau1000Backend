package com.service;

import com.domain.Post;
import com.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostRepository postRepository;


    @Test
    void getPost(){
        //given
        Post post = Post.builder().author("lee").title("title").content("content").build();

        //when
        Post save = postRepository.save(post);
        Optional<Post> byId = postRepository.findById(save.getId());
        String author = byId.get().getAuthor();
        //then
        assertEquals(post, save);
        assertEquals("lee", author);
    }

}