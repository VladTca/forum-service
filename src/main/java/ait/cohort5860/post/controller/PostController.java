package ait.cohort5860.post.controller;

import ait.cohort5860.post.dto.CommentDto;
import ait.cohort5860.post.dto.NewCommentsDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum")
public class PostController {
    private final PostService postService;


    @ResponseStatus(HttpStatus.CREATED)
    public PostDto addPost(String author, NewPostDto newPostDto) {
        return null;
    }


    public PostDto findPostById(Long id) {
        return null;
    }


    public List<PostDto> findPostByAuthor(String author) {
        return List.of();
    }


    public CommentDto addComment(Long id, String author, NewCommentsDto newCommentsDto) {
        return null;
    }


    public PostDto deletePost(Long id) {
        return null;
    }


    public List<PostDto> findPostsByTag(String tag) {
        return List.of();
    }


    public List<PostDto> findPostsByPeriod(String startDate, String endDate) {
        return List.of();
    }

    public PostDto updatePost(Long id, NewPostDto newPostDto) {
        return null;
    }

@ResponseStatus(HttpStatus.NO_CONTENT)
    public void addLike(Long id) {

    }
}
