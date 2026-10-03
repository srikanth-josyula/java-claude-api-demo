package com.demo.claude.client;

import com.anthropic.client.AnthropicClient;
import org.springframework.stereotype.Component;

@Component
public class ClaudeModelClient {

	private final AnthropicClient client;

	public ClaudeModelClient(AnthropicClient client) {
		this.client = client;
	}

	public void listModels() {

		var models = client.models().list();

		models.data().forEach(model -> System.out.println(model.id()));
	}
}