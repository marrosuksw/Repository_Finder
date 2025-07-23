package pl.repo_finder.repos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.repo_finder.dto.BranchGithubRequest;
import pl.repo_finder.dto.ReposGithubRequest;
import pl.repo_finder.dto.ReposResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReposService {

    private final ReposClient reposClient;
    @Autowired
    public ReposService(ReposClient reposClient) {
        this.reposClient = reposClient;
    }

    //I need to list all of the (user)'s repositories
    //for each repository:
    // check if they are forks
    // list their names
    // list owner login
    // list their branch names
    //  for each branch name:
    //      get last commit sha
    public List<ReposResponse> getAllRepos(String username) {
        List<ReposResponse> repositoryInfoList = new ArrayList<>();
        List<ReposGithubRequest> githubRepositoryRequests = reposClient.getReposData(username);
        for (ReposGithubRequest githubRequest : githubRepositoryRequests) {
            if(!githubRequest.isFork()){
                List<BranchGithubRequest> githubBranchRequests = reposClient.getBranchData(githubRequest.getOwner().getLogin(), githubRequest.getName());
                ReposResponse response = new ReposResponse(githubRequest, githubBranchRequests);
                repositoryInfoList.add(response);
            }
        }
        return repositoryInfoList;
    }
}
