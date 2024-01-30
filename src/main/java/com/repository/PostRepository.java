package com.repository;

import com.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("update Post p set p.title = ?1, p.content = ?2 where p.id = ?3")
    void update(Post post);

}
