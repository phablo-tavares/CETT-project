package cett.PostAndCommentApi.Dao;

import cett.PostAndCommentApi.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
