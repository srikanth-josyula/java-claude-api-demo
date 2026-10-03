package com.demo.claude.service;

import org.springframework.stereotype.Service;

import com.demo.claude.client.ClaudeBatchClient;
import com.demo.claude.client.ClaudeClient;
import com.demo.claude.client.ClaudeModelClient;
import com.demo.claude.client.ClaudeTokenClient;

@Service
public class ClaudeService {

	private final ClaudeClient claudeClient;
	private final ClaudeTokenClient tokenClient;
	private final ClaudeModelClient modelClient;
	private final ClaudeBatchClient batchClient;

	public ClaudeService(ClaudeClient claudeClient, ClaudeTokenClient tokenClient, ClaudeModelClient modelClient,
			ClaudeBatchClient batchClient) {

		this.claudeClient = claudeClient;
		this.tokenClient = tokenClient;
		this.modelClient = modelClient;
		this.batchClient = batchClient;
	}

	public String chat(String message) {

		if (message == null || message.isBlank()) {
			throw new IllegalArgumentException("Message cannot be empty");
		}

		return claudeClient.sendMessage(message);
	}

	public long countTokens(String message) {
		return tokenClient.countTokens(message);
	}

	public void listModels() {
		modelClient.listModels();
	}

	public void listBatches() {
		batchClient.listBatches();
	}

}