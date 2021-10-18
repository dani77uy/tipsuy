package me.tipsuy.twitterpostsweb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.tipsuy.twitterpostsweb.dao.TeamRepository;

/**
 * @author Daniel Baharian
 * @since 11 oct. 2021
 */
@RequestMapping(value = "/team")
@Controller
public class TeamController {

   @Autowired
   TeamRepository teamRepository;

   @GetMapping("/get/{id}")
   public String get(@PathVariable long id, Model model) {
      final var teamBean = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid team id: " + id));
      model.addAttribute("team", teamBean);
      return "get";
   }

   @GetMapping("/index")
   public String showTeamList(Model model) {
      model.addAttribute("teams", teamRepository.findAll());
      return "index";
   }

}
