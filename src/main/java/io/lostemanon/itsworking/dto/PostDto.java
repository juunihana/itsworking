package io.lostemanon.itsworking.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

  private LocalDateTime createTime;
  private LocalDateTime editTime;
  private String title;
  private String content;
}
