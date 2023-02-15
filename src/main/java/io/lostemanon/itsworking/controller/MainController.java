package io.lostemanon.itsworking.controller;

import io.lostemanon.itsworking.dto.PostDto;
import io.lostemanon.itsworking.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

  private final PostService postService;

  @Autowired
  public MainController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public String index(Model model) {
    List<PostDto> posts = postService.getAll();
    model.addAttribute("posts", posts);
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
}
