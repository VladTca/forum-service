package ait.cohort5860.post.service;


import ait.cohort5860.post.dto.CommentDto;
import ait.cohort5860.post.dto.NewCommentsDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService{


    @Override
    public PostDto addPost(String author, NewPostDto newPostDto) {
        return null;
    }

    @Override
    public PostDto findPostById(Long id) {
        return null;
    }

    @Override
    public void addLike(Long id) {

    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return List.of();
    }

    @Override
    public CommentDto addComment(Long id, String author, NewCommentsDto newCommentsDto) {
        return null;
    }

    @Override
    public PostDto deletePost(Long id) {
        return null;
    }

    @Override
    public List<PostDto> findPostsByTag(Set<String> tags) {
        return List.of();
    }

    @Override
    public List<PostDto> findPostsByPeriod(String startDate, String endDate) {
        return List.of();
    }

    @Override
    public PostDto updatePost(Long id, NewPostDto newPostDto) {
        return null;
    }
}
