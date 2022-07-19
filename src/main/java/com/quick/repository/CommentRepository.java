package com.quick.repository;

import com.quick.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByPost_Id(int t);
}
