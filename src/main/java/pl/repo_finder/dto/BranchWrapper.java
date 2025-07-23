package pl.repo_finder.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BranchWrapper {
    private String branchName;
    private String lastCommitSha;
}
