package cett.PostAndCommentApi.Controllers;

import cett.PostAndCommentApi.Entities.Comment;
import cett.PostAndCommentApi.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private CommentService commentService;

    @Autowired
    public CommentsController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public Comment buscarComentarioPorId(@PathVariable Long id) {
        return commentService.findCommentById(id);
    }

    @GetMapping
    public List<Comment> buscarTodosOsComentarios() {
        return commentService.findAllComments();
    }

    @PostMapping("/inserirComentarioNoPost/{postId}")
    public Comment criarComentarioEmUmPost(@RequestBody Comment comment, @PathVariable Long postId) {
        return commentService.saveCommentByPostId(comment,postId);
    }

    @PutMapping
    public Comment atualizarComentario(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deletarComentario(@PathVariable Long id){
        commentService.deleteCommentById(id);
    }
}
