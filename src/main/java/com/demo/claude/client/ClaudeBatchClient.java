package com.demo.claude.client;

import com.anthropic.client.AnthropicClient;
import org.springframework.stereotype.Component;

@Component
public class ClaudeBatchClient {

	private final AnthropicClient client;

	public ClaudeBatchClient(AnthropicClient client) {
		this.client = client;
	}

	public void listBatches() {

		var batches = client.messages().batches().list();

		batches.data().forEach(batch -> System.out.println(batch.id()));
	}
}
