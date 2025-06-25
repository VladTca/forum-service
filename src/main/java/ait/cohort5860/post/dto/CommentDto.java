package ait.cohort5860.post.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentDto {
    private String user;
   private String message;
   private String dateCreated;
   private long likes;
}

