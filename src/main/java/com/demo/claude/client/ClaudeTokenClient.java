package com.demo.claude.client;

import com.anthropic.client.AnthropicClient;
import com.anthropic.models.messages.MessageCountTokensParams;
import com.anthropic.models.messages.Model;

import org.springframework.stereotype.Component;

@Component
public class ClaudeTokenClient {

    private final AnthropicClient client;

    public ClaudeTokenClient(AnthropicClient client) {
        this.client = client;
    }

    public long countTokens(String message) {

        MessageCountTokensParams params =
                MessageCountTokensParams.builder()
                        .model(Model.CLAUDE_OPUS_5_5)
                        .addUserMessage(message)
                        .build();

        var response = client.messages().countTokens(params);

        return response.inputTokens();
    }
}