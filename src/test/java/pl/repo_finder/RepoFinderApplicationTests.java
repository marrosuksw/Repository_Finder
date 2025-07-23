package pl.repo_finder;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.hamcrest.Matcher.*;

import static io.restassured.RestAssured.given;


@SpringBootTest
class RepoFinderApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void givenExistingGithubUser_whenFindAllRepositories_then() {
		//given
		String username = "marrosuksw";
//		given().
		//when

		//then
	}
}
