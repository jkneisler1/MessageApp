package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String messageList(Model model, String search) {
        model.addAttribute("messages", messageRepository.findAll());
        return "list";                                                      // ToDo: make a list html page
    }

    @GetMapping("/add")
    public String addMessage(Model model) {
        model.addAttribute("message", new Message());
        return "messageform";                                               // ToDo: Need an href with an "add" reference
    }

    @PostMapping("/processsearch")
    public String searchResult(Model model,  @RequestParam String search) {
        model.addAttribute("messageByTitle", messageRepository.findByTitle(search));
        return "searchlist";
    }

    @PostMapping("/processmessage")
    public String processForm(@ModelAttribute Message message) {
        messageRepository.save(message);
        return "redirect:/";
    }
}
