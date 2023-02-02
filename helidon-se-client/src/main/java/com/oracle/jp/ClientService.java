package com.oracle.jp;

import io.helidon.webserver.Routing.Rules;
import io.helidon.common.reactive.Single;
import io.helidon.webclient.WebClient;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class ClientService implements Service {

    @Override
    public void update(Rules rules) {
        rules.get("/say", this::say);
    }

    private void say(ServerRequest req, ServerResponse res) {
        WebClient webClient = WebClient
                .builder()
                .baseUri("http://cowweb-helidon:8080")
                .build();
        Single<String> singleResponse = webClient.get().path("/cowsay/say").request(String.class);
        res.send(singleResponse.await());
    }

}
