package cett.PostAndCommentApi.Services;

import cett.PostAndCommentApi.Dao.PostRepository;
import cett.PostAndCommentApi.Entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService{
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> findAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public Post findPostById(Long id){
        Post post = postRepository.findById(id).orElse(null);
        return post;
    }

    public Post savePost(Post post){
        post.setId(0l);
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    public Post updatePost(Post post){
        Post updatedPost = postRepository.save(post);
        return updatedPost;
    }

    public void deletePostById(long id){
        postRepository.deleteById(id);
    }
}
