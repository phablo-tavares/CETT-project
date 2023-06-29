package cett.PostAndCommentApi.Services;

import cett.PostAndCommentApi.Dao.CommentRepository;
import cett.PostAndCommentApi.Entities.Comment;
import cett.PostAndCommentApi.Entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private PostService postService;

    @Autowired
    public CommentService(CommentRepository commentRepository,PostService postService){
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public Comment findCommentById(Long id){
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment;
    }

    public List<Comment> findAllComments(){
        List<Comment> comments = commentRepository.findAll();
        return comments;
    }

    public Comment saveCommentByPostId(Comment comment,Long postId){
        comment.setId(0l);
        Post post = postService.findPostById(postId);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return savedComment;
    }

    public Comment updateComment(Comment comment){
        Comment updatedComment = commentRepository.save(comment);
        return updatedComment;
    }

    public void deleteCommentById(long id){
        commentRepository.deleteById(id);
    }
}
