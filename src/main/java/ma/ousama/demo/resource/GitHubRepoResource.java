package ma.ousama.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.ousama.demo.domain.SearchResult;
import ma.ousama.demo.service.GitHubRepoService;

@RestController
public class GitHubRepoResource {

	@Autowired
	private GitHubRepoService gitHubRepoService;
	
	@ApiOperation(value = "Get list of GitHub repositories by user name", response = SearchResult.class)
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(value = "/github-repos/user/{user}")
	public ResponseEntity<SearchResult> getRepositoriesByUser(@PathVariable("user") String user) 
	{
		SearchResult searchResult = gitHubRepoService.getRepositoriesByUser(user);
	    return new ResponseEntity<>(searchResult, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get list of GitHub repositories by language", response = SearchResult.class)
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping(value = "/github-repos/language/{language}")
	public ResponseEntity<SearchResult> getRepositoriesByLanguage(@PathVariable("language") String language) 
	{
		SearchResult searchResult = gitHubRepoService.getRepositoriesByLanguage(language);
		return new ResponseEntity<>(searchResult, HttpStatus.OK);
	}
}
