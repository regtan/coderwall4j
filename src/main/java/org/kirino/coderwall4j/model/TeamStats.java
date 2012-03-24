package org.kirino.coderwall4j.model;

public class TeamStats {
	private Long views;
	private Long followers;
	private Long collectiveDaysOnGitHub;
	private Long collectiveDaysOnTwitter;

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public Long getFollowers() {
		return followers;
	}

	public void setFollowers(Long followers) {
		this.followers = followers;
	}

	public Long getCollectiveDaysOnGitHub() {
		return collectiveDaysOnGitHub;
	}

	public void setCollectiveDaysOnGitHub(Long collectiveDaysOnGitHub) {
		this.collectiveDaysOnGitHub = collectiveDaysOnGitHub;
	}

	public Long getCollectiveDaysOnTwitter() {
		return collectiveDaysOnTwitter;
	}

	public void setCollectiveDaysOnTwitter(Long collectiveDaysOnTwitter) {
		this.collectiveDaysOnTwitter = collectiveDaysOnTwitter;
	}

}
