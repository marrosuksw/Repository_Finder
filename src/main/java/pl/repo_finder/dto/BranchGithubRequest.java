package pl.repo_finder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BranchGithubRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private Commit commit;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Commit {
        @JsonProperty("sha")
        private String sha;
    }

}
