package ait.cohort5860.post.service;


import ait.cohort5860.post.dao.PostRepository;
import ait.cohort5860.post.dao.TagRepository;
import ait.cohort5860.post.dto.CommentDto;
import ait.cohort5860.post.dto.NewCommentsDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.dto.exeption.NotFoundException;
import ait.cohort5860.post.model.Post;
import ait.cohort5860.post.model.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final TagRepository tagRepository;


    @Override
    @Transactional
    public PostDto addPost(String author, NewPostDto newPostDto) {
        Post post =new Post(newPostDto.getTitle(),newPostDto.getContent(),author);
        Set<String> tags = newPostDto.getTags();
        //Handle tag
        if(tags!=null) {
            for(String tagName:tags) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }
        post = postRepository.save(post);
        return modelMapper.map(post,PostDto.class);

     }

    @Override
    public PostDto findPostById(Long id) {
        Post post= postRepository.findById(id).orElseThrow(NotFoundException::new);
        return  modelMapper.map(post,PostDto.class);
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
    public List<PostDto> findPostsByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        return List.of();
    }

    @Override
    public PostDto updatePost(Long id, NewPostDto newPostDto) {
        return null;
    }
}
