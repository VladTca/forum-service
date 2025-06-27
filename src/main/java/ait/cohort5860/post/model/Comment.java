package ait.cohort5860.post.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String message;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private int likes;

    @Setter
    @ManyToOne
    private Post post;

    public Comment(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public void addLike() {
        likes++;
    }

}
