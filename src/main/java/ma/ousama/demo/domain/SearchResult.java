package ma.ousama.demo.domain;

import java.util.List;

public class SearchResult {

	private Long total_count;

	private List<GithubRepo> items;

	public Long getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}

	public List<GithubRepo> getItems() {
		return items;
	}

	public void setItems(List<GithubRepo> items) {
		this.items = items;
	}

}
