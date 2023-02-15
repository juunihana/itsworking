package io.lostemanon.itsworking.repository;

import io.lostemanon.itsworking.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> getByPostId(long id);
}
