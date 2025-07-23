package pl.repo_finder.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.repo_finder.dto.ReposResponse;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ReposController {

    private final ReposService reposService;

    @Autowired
    public ReposController(ReposService reposService) {
        this.reposService = reposService;
    }

    @GetMapping("/repos/{username}")
    public ResponseEntity<List<ReposResponse>> getUserRepositoryInfoByUsername(@PathVariable String username) {
        return new ResponseEntity<List<ReposResponse>>(reposService.getAllRepos(username), HttpStatus.OK);
    }
}
