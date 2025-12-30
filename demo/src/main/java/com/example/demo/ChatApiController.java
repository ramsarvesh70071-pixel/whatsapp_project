package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*") // Ye Flutter integration ke liye bahut zaroori hai
public class ChatApiController {

    @Autowired
    private ChatRepository chatRepository;

    // Flutter app isse purane messages fetch karega
    @GetMapping
    public List<ChatMessage> getMessages() {
        return chatRepository.findAll();
    }

    // Agar Flutter se bina WebSocket ke message bhejna ho
    @PostMapping
    public ChatMessage saveMessage(@RequestBody ChatMessage chatMessage) {
        return chatRepository.save(chatMessage);
    }
}