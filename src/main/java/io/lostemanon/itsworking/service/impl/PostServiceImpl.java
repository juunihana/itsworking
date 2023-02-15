package io.lostemanon.itsworking.service.impl;

import io.lostemanon.itsworking.dto.PostDto;
import io.lostemanon.itsworking.entity.Post;
import io.lostemanon.itsworking.mapper.PostMapper;
import io.lostemanon.itsworking.repository.PostRepository;
import io.lostemanon.itsworking.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  private final PostMapper postMapper = Mappers.getMapper(PostMapper.class);

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;

    save(PostDto.builder()
        .title("First post")
        .content("Welcome to the main page<br/>\n"
            + "  There is no information here but in the future there will be even less<br/>\n"
            + "  What else did you expect?")
        .build());
  }

  @Override
  public PostDto getById(long id) {
    return postMapper.postToPostDto(
        postRepository.findById(id).orElse(
            Post.builder()
                .id(0)
                .createTime(LocalDateTime.now())
                .editTime(LocalDateTime.now())
                .title("not found").build()));
  }

  @Override
  public List<PostDto> getAll() {
    return postRepository.findAll().stream()
        .map(postMapper::postToPostDto)
        .collect(Collectors.toList());
  }

  @Override
  public void save(PostDto postDto) {
    postDto.setCreateTime(LocalDateTime.now());
    postDto.setEditTime(LocalDateTime.now());
    postRepository.save(postMapper.postDtoToPost(postDto));
  }

  @Override
  public void update(long id, PostDto postDto) {
    if (postRepository.findById(id).orElse(null) != null) {
      postDto.setCreateTime(LocalDateTime.now());
      postDto.setEditTime(LocalDateTime.now());
      postRepository.save(postMapper.postDtoToPost(postDto));
    }
  }

  @Override
  public void delete(long id) {
    if (postRepository.findById(id).orElse(null) != null) {
      postRepository.deleteById(id);
    }
  }
}
