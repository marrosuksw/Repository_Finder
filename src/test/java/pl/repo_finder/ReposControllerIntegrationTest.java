package pl.repo_finder;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cache.support.NullValue;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReposControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void givenExistingGithubUser_whenRequestingUserRepositoryInformation_thenReturnUserRepositoryData() {
        //given
        String username = "marrosuksw";
        given()
                .when() // when
                .get("user/repos/" + username)
                .then() //then
                .statusCode(200)
                .body("$", not(empty()))
                .body("[0].repoName", notNullValue())
                .body("[0].ownerLogin", equalTo(username))
                .body("[0].branch", notNullValue())
                .body("[0].branch[0].branchName", notNullValue())
                .body("[0].branch[0].lastCommitSha", notNullValue())
                .body("[0].fork", equalTo(false));
    }
}
