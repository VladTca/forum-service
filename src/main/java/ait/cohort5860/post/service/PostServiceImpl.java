package ait.cohort5860.post.service;


import ait.cohort5860.post.dao.CommentRepository;
import ait.cohort5860.post.dao.PostRepository;
import ait.cohort5860.post.dao.TagRepository;
import ait.cohort5860.post.dto.CommentDto;
import ait.cohort5860.post.dto.NewCommentsDto;
import ait.cohort5860.post.dto.NewPostDto;
import ait.cohort5860.post.dto.PostDto;
import ait.cohort5860.post.dto.exeption.NotFoundException;
import ait.cohort5860.post.model.Comment;
import ait.cohort5860.post.model.Post;
import ait.cohort5860.post.model.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final TagRepository tagRepository;
    private final CommentRepository commentRepository;


    @Override
    @Transactional
    public PostDto addPost(String author, NewPostDto newPostDto) {
        Post post = new Post(newPostDto.getTitle(), newPostDto.getContent(), author);
        Set<String> tags = newPostDto.getTags();
        //Handle tag
        if (tags != null) {
            for (String tagName : tags) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }
        post = postRepository.save(post);
        return modelMapper.map(post, PostDto.class);

    }

    @Override
    public PostDto findPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundException::new);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    @Transactional
    public void addLike(Long id) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundException::new);
        post.addLike();
        postRepository.save(post);

    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        List<Post> posts = postRepository.findPostsByAuthorIgnoreCase(author);
        List<PostDto> result = new ArrayList<>();
        for (Post post : posts) {
            result.add(modelMapper.map(post, PostDto.class));
        }
        return result;
    }

    @Override
    @Transactional
    public CommentDto addComment(Long id, String author, NewCommentsDto newCommentsDto) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundException::new);
        Comment comment = new Comment(author, newCommentsDto.getMessage());
        comment.setPost(post);
        post.addComment(comment);
        comment = commentRepository.save(comment);
        postRepository.save(post);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    @Transactional
    public PostDto deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundException::new);
        postRepository.delete(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByTag(Set<String> tags) {
        List<Post> posts = new ArrayList<>();
        List<PostDto> res = new ArrayList<>();

        for (String tagName : tags) {
            Tag tag = tagRepository.findByNameIgnoreCase(tagName);
            if (tag != null) {
                for (Post post : tag.getPosts()) {
                    if (!posts.contains(post)) {
                        posts.add(post);
                    }
                }
            }
        }

        for (Post post : posts) {
            res.add(modelMapper.map(post, PostDto.class));
        }

        return res;
    }

    @Override
    public List<PostDto> findPostsByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        List<Post> posts = postRepository.findAll();
        List<PostDto> res = new ArrayList<>();

        for (Post post : posts) {
            LocalDateTime postDate = post.getDateCreated();
            if ((postDate.isEqual(startDate) || postDate.isAfter(startDate)) &&
                    (postDate.isEqual(endDate) || postDate.isBefore(endDate))) {
                res.add(modelMapper.map(post, PostDto.class));
            }
        }

        return res;
    }

    @Override
    public PostDto updatePost(Long id, NewPostDto newPostDto) {
        Post post = postRepository.findById(id).orElseThrow(NotFoundException::new);
        if (newPostDto.getTitle() != null) {
            post.setTitle(newPostDto.getTitle());
        }
        if (newPostDto.getContent() != null) {
            post.setContent(newPostDto.getContent());
        }
        Set<String> tagNames = newPostDto.getTags();
        if (tagNames != null) {
            for (String tagName : tagNames) {
                Tag tag = tagRepository.findById(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                post.addTag(tag);
            }
        }

        post = postRepository.save(post); //  лучше писать анотацию трансакшенал и тогда не нада делать сейв, но это тока для апдейта
        return modelMapper.map(post, PostDto.class);
    }
}
