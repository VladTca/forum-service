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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "message", columnDefinition = "TEXT")   //потому шо мы в ямле указалитип текст а оно по автомату варчар лепит
    private String message;
    @Column(name = "date_created")
    private LocalDateTime dateCreated = LocalDateTime.now();
    @Column(name = "likes")
    private int likes;

    @Setter
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public void addLike() {
        likes++;
    }

}
