package io.lostemanon.itsworking.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
  private long id;
  private long authorId;
  private String author;
  private LocalDateTime createTime;
  private String content;
}
