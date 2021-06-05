package ma.ousama.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ma.ousama.demo.domain.SearchResult;

@Service
public class GitHubRepoService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${search.repo.url}")
	private String baseUrl;

	public SearchResult getRepositoriesByUser(String userName) {
		return restTemplate.getForObject(baseUrl+"?q=user:" + userName, SearchResult.class);
	}

	public SearchResult getRepositoriesByLanguage(String language) {
		return restTemplate.getForObject(baseUrl+"?q=language:" + language, SearchResult.class);
	}
}
