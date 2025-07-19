package pl.repo_finder.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReposRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Owner {
        @JsonProperty("login")
        private String login;
    }
}
