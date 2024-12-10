package dev.chafon.spring.ai.chatclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/story/telling")
public class StoryController {

    private final ChatClient chatClient;

    public StoryController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    Flux<String> stream() {
        return this.chatClient.prompt()
                .system("You are a story teller, tell me a short story.")
                .stream()
                .content();

    }
}
