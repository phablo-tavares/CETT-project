package cett.PostAndCommentApi.Dao;

import cett.PostAndCommentApi.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
