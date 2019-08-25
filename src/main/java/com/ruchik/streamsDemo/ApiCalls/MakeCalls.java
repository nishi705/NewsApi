package com.ruchik.streamsDemo.ApiCalls;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MakeCalls {
    // /statuses/home_timeline.json
    WebClient client = WebClient.builder()
            .baseUrl("https://newsapi.org/v2")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .defaultHeaders(HttpHeaders.AUTHORIZATION, OAuth)
            .build();

    @GetMapping("/news")
    public Flux<?> getTweets() {
        List<Object> myArray = new ArrayList<>();
        Flux<?> response = Flux.fromIterable(myArray);

          return client.get()
                .uri("/everything?q=bitcoin&from=2019-07-22&sortBy=publishedAt&apiKey=633fb5de3a7e4458b85fa627921a10fe")
//                .header("Authorization", "OAuth oauth_consumer_key=\"633fb5de3a7e4458b85fa627921a10fe\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1566283643\",oauth_nonce=\"51PROn\",oauth_version=\"1.0\"")

                    .retrieve()
                  .bodyToFlux(Object.class);
//                .exchange().filter(a -> myArray.add(a));
//                .flatMapMany(clientResponse -> myArray.add(clientResponse.bodyToMono(Object.class)));"

//          return  response;
    }

}
