package com.thej.dockerguide.controller;

import com.thej.dockerguide.entity.Message;
import com.thej.dockerguide.repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepo repo;

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody Message message) {
        repo.save(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = repo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello from inside the main class!");
    }
}
