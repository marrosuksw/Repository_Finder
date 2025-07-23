package pl.repo_finder.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pl.repo_finder.dto.BranchGithubRequest;
import pl.repo_finder.dto.ReposGithubRequest;

import java.util.List;

@Component
public class ReposClient {

    private RestClient restClient;
    @Autowired
    public ReposClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<ReposGithubRequest> getReposData(String username) {
        String url = "/users/"+username+"/repos";
        return restClient.get()
                .uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<List<ReposGithubRequest>>(){});
    }
    public List<BranchGithubRequest> getBranchData(String owner, String repoName) {
        String url = "/repos/"+owner+"/"+repoName+"/branches";
        return restClient.get()
                .uri(url)
                .retrieve()
                .body(new ParameterizedTypeReference<List<BranchGithubRequest>>(){});
    }
}
