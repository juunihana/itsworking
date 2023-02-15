package io.lostemanon.itsworking.repository;

import io.lostemanon.itsworking.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
