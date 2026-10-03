package com.demo.claude.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.claude.model.ChatRequest;
import com.demo.claude.model.ChatResponse;
import com.demo.claude.service.ClaudeService;

@RestController
@RequestMapping("/api/claude")
public class ClaudeController {

    private final ClaudeService claudeService;

    public ClaudeController(ClaudeService claudeService) {
        this.claudeService = claudeService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response =
                claudeService.chat(request.getMessage());
        return new ChatResponse(response);
    }

    @PostMapping("/tokens")
    public long countTokens(@RequestBody ChatRequest request) {
        return claudeService.countTokens(
                request.getMessage()
        );
    }

    @GetMapping("/models")
    public String models() {
        claudeService.listModels();
        return "Models printed to application console";
    }

    @GetMapping("/batches")
    public String batches() {
        claudeService.listBatches();
        return "Batches printed to application console";
    }
}