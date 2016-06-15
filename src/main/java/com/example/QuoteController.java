package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by markheckler on 6/14/16.
 */
@RestController
@RefreshScope
public class QuoteController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${quote}")
    private String defaultQuote;

//    @Autowired
//    Source source;
//
//    @RequestMapping(value = "/newquote", method = RequestMethod.POST)
//    public void addQuote(@RequestBody Quote quote) {
//        this.source.output().send(MessageBuilder.withPayload(quote).build());
//    }
//

    @RequestMapping("/quotorama")
    @HystrixCommand(fallbackMethod = "getDefaultQuote")
    public Quote getRandomQuote() {
        return restTemplate.getForObject("http://quote-service/random", Quote.class);
    }

    public Quote getDefaultQuote() {
        return new Quote(defaultQuote, "Me");
    }
}
