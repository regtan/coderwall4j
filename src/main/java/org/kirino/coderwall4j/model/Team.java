package org.kirino.coderwall4j.model;

import java.util.List;

public class Team {
	private String teamName;
	private String url;
	private String location;
	private String about;
	private List<String> coreSkills;
	private List<User> members;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<String> getCoreSkills() {
		return coreSkills;
	}

	public void setCoreSkills(List<String> coreSkills) {
		this.coreSkills = coreSkills;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

}
