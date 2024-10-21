package dev.chafon.spring.ai.chatclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory) {
        return builder
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(chatMemory)
                )
                .defaultSystem("You are a friendly chat bot that answers question politely")
                .build();
    }

    @Bean
    ChatMemory chatMemory() {
        return new InMemoryChatMemory();
    }
}
