package io.lostemanon.itsworking.controller;

import io.lostemanon.itsworking.dto.CommentDto;
import io.lostemanon.itsworking.dto.PostDto;
import io.lostemanon.itsworking.service.CommentService;
import io.lostemanon.itsworking.service.PostService;
import io.lostemanon.itsworking.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

  private final PostService postService;
  private final UserService userService;
  private final CommentService commentService;

  @Autowired
  public MainController(PostService postService,
      UserService userService,
                        CommentService commentService) {
    this.postService = postService;
    this.userService = userService;
    this.commentService = commentService;
  }

  @GetMapping
  public String index(Model model) {
    model.addAttribute("posts", postService.getAll());
    model.addAttribute("newPost", new PostDto());
    return "index";
  }

  @GetMapping("about")
  public String about() {
    return "about";
  }

  @GetMapping("useful")
  public String useful() {
    return "useful";
  }

  @PostMapping("createPost")
  public ModelAndView createPost(@ModelAttribute PostDto postDto) {
    postService.save(postDto);
    return new ModelAndView("redirect:/");
  }

  @PostMapping("createComment")
  public ModelAndView createPost(
          @ModelAttribute CommentDto commentDto) {
      long postId = commentDto.getPostId();
    commentService.save(postId, commentDto);
    return new ModelAndView("redirect:/posts/" + postId);
  }

  @GetMapping("posts/{id}")
  public String getPost(
          @PathVariable long id,
          Model model) {
    model.addAttribute("post", postService.getById(id));
    model.addAttribute("newComment", CommentDto.builder()
            .postId(id)
            .build());
    return "post";
  }

  @GetMapping("users/{id}")
  public String getUser(@PathVariable long id, Model model) {
    model.addAttribute("user", userService.getById(id));
    model.addAttribute("userPosts", postService.getAllByUserId(id));
    return "user";
  }
}
