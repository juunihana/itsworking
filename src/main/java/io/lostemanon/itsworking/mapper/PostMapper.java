package io.lostemanon.itsworking.mapper;

import io.lostemanon.itsworking.dto.PostDto;
import io.lostemanon.itsworking.entity.Post;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper {

  PostDto postToPostDto(Post post);

  Post postDtoToPost(PostDto postDto);
}
