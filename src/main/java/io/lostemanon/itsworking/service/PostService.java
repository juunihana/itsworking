package io.lostemanon.itsworking.service;

import io.lostemanon.itsworking.dto.PostDto;
import java.util.List;

public interface PostService {

  PostDto getById(long id);

  List<PostDto> getAll();

  void save(PostDto postDto);

  void update(long id, PostDto postDto);

  void delete(long id);
}
