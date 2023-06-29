package cett.PostAndCommentApi.Controllers;

import cett.PostAndCommentApi.Entities.Post;
import cett.PostAndCommentApi.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> listarPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public Post buscarPostPorId(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping
    public Post criarPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PutMapping
    public Post atualizarPost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletarPost(@PathVariable Long id) {
        postService.deletePostById(id);
    }
}
