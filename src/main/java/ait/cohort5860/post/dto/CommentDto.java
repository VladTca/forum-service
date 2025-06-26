package ait.cohort5860.post.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentDto {
    @JsonProperty("user")
    private String username;
   private String message;
   private String dateCreated;
   private long likes;
}

