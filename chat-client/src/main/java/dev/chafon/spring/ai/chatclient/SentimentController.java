package dev.chafon.spring.ai.chatclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentiment/analyse")
public class SentimentController {

    private final ChatClient chatClient;

    public SentimentController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    String analyseSentiment(@RequestParam(value = "text", defaultValue = "Hello, Good morning") String text) {
        return chatClient.prompt()
                .system("Analyse the sentiment of the text.")
                .user(text)
                .call()
                .content();
    }
}
