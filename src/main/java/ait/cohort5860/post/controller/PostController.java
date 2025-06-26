package ait.cohort5860.post.controller;

import ait.cohort5860.post.dto.CommentDto;
import ait.cohort5860.post.dto.NewCommentsDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum/post")
public class PostController {


    private final PostService postService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{author}")
    public PostDto addPost(@PathVariable String author, @RequestBody NewPostDto newPostDto) {
        return postService.addPost(author, newPostDto);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto findPostById(@PathVariable Long id) {

        return postService.findPostById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/like")
    public void addLike(@PathVariable Long id) {
    }


    @GetMapping("/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> findPostsByAuthor(@PathVariable String author) {
        return postService.findPostsByAuthor(author);
    }


    @PatchMapping("/{id}/comment/{author}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto addComment(@PathVariable Long id, @PathVariable String author, @RequestBody NewCommentsDto newCommentsDto) {
        return postService.addComment(id, author, newCommentsDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public PostDto deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tags")
    public List<PostDto> findPostsByTag(@RequestParam("values") String values) {
        String[] arr = values.split(",");
        Set<String> tags = new HashSet<>(Arrays.asList(arr));
        return postService.findPostsByTag(tags);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/period")
    public List<PostDto> findPostsByPeriod(@RequestParam String startDate, @RequestParam String endDate) {
        return postService.findPostsByPeriod(startDate, endDate);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public PostDto updatePost(@PathVariable Long id, @RequestBody NewPostDto newPostDto) {
        return postService.updatePost(id, newPostDto);
    }

}
