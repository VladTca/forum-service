package ait.cohort5860.post.service;

import ait.cohort5860.post.dto.CommentDto;
import ait.cohort5860.post.dto.NewCommentsDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface PostService {
    PostDto addPost(String author, NewPostDto newPostDto);

    PostDto findPostById(Long id);

    void addLike(Long id);

    List<PostDto> findPostsByAuthor(String author);

    CommentDto addComment(Long id,String author, NewCommentsDto newCommentsDto);

    PostDto deletePost(Long id);

    List<PostDto> findPostsByTag(Set<String> tags);

    List<PostDto> findPostsByPeriod(LocalDateTime startDate, LocalDateTime endDate);
    PostDto updatePost(Long id, NewPostDto newPostDto);


}
