package com.platzi.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("Generate a short greeting message for the {{platform}} application")
    String generateGreeting(@V("platform") String platform);

    @SystemMessage("""
        You are an expert on cinema that recommends personalized movies based on the user's taste.
        You have to recommend 3 movies at most.
        Don't include movies outside Platzi Play's catalog.
        """)
    String generateMovieSuggestions(@UserMessage String userMessage);
}
