package com.demo.claude.client;

import com.anthropic.client.AnthropicClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;
import org.springframework.stereotype.Component;

@Component
public class ClaudeClient {

    private final AnthropicClient client;

    public ClaudeClient(AnthropicClient client) {
        this.client = client;
    }

    public String sendMessage(String userMessage) {

        MessageCreateParams params = MessageCreateParams.builder()
                .model(Model.CLAUDE_OPUS_5_5)
                .maxTokens(1024L)
                .addUserMessage(userMessage)
                .build();

        Message message = client.messages().create(params);

        return message.content()
                .stream()
                .flatMap(contentBlock -> contentBlock.text().stream())
                .map(textBlock -> textBlock.text())
                .findFirst()
                .orElse("");
    }
}