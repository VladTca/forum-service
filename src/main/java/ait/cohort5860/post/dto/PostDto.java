package ait.cohort5860.post.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime dateCreated;
    @Singular
    private Set<String> tags;
    private Integer likes;
    @Singular
    private List<String> comments;

}
//{
//        "id": 1,
//        "title": "JavaEE",
//        "content": "Java is the best for backend",
//        "author": "JavaFan",
//        "dateCreated": "2021-12-14T11:39:05",
//        "tags": [
//        "Java",
//        "backend",
//        "JEE",
//        "Spring"
//        ],
//        "likes": 0,
//        "comments": []
//        }