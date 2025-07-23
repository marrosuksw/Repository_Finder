package pl.repo_finder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReposResponse {
    String repoName;
    String ownerLogin;
    List<BranchWrapper> branch;
    boolean fork;

    public ReposResponse(ReposGithubRequest reposGithubRequest,
                         List<BranchGithubRequest> branchGithubRequest)
    {
        this.repoName = reposGithubRequest.getName();
        this.ownerLogin = reposGithubRequest.getOwner().getLogin();
        this.fork = reposGithubRequest.isFork();
        branch = new ArrayList<>();
        for(BranchGithubRequest branchRequest : branchGithubRequest) {
            branch.add(new BranchWrapper(branchRequest.getName(), branchRequest.getCommit().getSha()));
        }
    }
    public ReposResponse(ReposGithubRequest reposGithubRequest) {
        this.repoName = reposGithubRequest.getName();
        this.ownerLogin = reposGithubRequest.getOwner().getLogin();
        this.fork = reposGithubRequest.isFork();
    }
    public ReposResponse(List<BranchGithubRequest> branchGithubRequest) {
        for(BranchGithubRequest branchRequest : branchGithubRequest) {
            branch.add(new BranchWrapper(branchRequest.getName(), branchRequest.getCommit().getSha()));
        }
    }

}
