package pl.repo_finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ReposClient {

    private RestClient restClient;
    @Autowired
    public ReposClient(RestClient restClient) {
        this.restClient = restClient;
    }

}
