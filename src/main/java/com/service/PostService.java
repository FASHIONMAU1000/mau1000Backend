package com.service;

import com.domain.Post;
import com.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void save(Post post){
        postRepository.save(post);
    }
    public void delete(Post post){
        postRepository.delete(post);
    }
    public Long update(Post post){
        postRepository.update(post);
        return 1L;
    }
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }


}