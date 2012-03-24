package org.kirino.coderwall4j.scrape;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.kirino.coderwall4j.model.Team;
import org.kirino.coderwall4j.model.TeamAchievement;
import org.kirino.coderwall4j.model.TeamStats;
import org.kirino.coderwall4j.model.User;
import org.kirino.coderwall4j.util.HttpClient;

public class CoderwallTeamHtmlScraper {

	final String teamId;

	public CoderwallTeamHtmlScraper(String teamId) {
		this.teamId = teamId;
	}

	public Team scrapeTeamData() throws Exception {
		Document doc = HttpClient.getTeamDocument(teamId);
		Team team = new Team();
		team.setTeamName(scrapeTeamName(doc));
		team.setUrl(scrapeUrl(doc));
		team.setLocation(scrapeLocation(doc));
		team.setAbout(scrapeAbout(doc));
		team.setCoreSkills(scrapeCoreSkills(doc));
		team.setInviteUrl(scrapeInveiteUrl(doc));
		team.setTeamScore(scrapeTeamScore(doc));
		team.setTeamRank(scrapeTeamRank(doc));
		team.setTeamStats(scrapeTeamStats(doc));
		team.setTeamAchievements(scrapeTeamAchievements(doc));
		team.setMembers(scrapeMembers(doc));

		return team;
	}

	private TeamStats scrapeTeamStats(Document doc) {
		TeamStats teamStats = new TeamStats();
		Elements elements = doc.select("div.side-panel.team-stats ul li");

		teamStats.setViews(getLongValue(elements.get(0)));
		teamStats.setFollowers(getLongValue(elements.get(1)));
		teamStats.setCollectiveDaysOnGitHub(getLongValue(elements.get(2)));
		teamStats.setCollectiveDaysOnTwitter(getLongValue(elements.get(3)));

		return teamStats;
	}

	private Integer scrapeTeamRank(Document doc) {
		String teamRank = getText(doc, "li.your-rank span");
		return StringUtils.isBlank(teamRank) ? 0 : Integer.valueOf(teamRank.substring(0, teamRank.length() - 2));
	}

	private Integer scrapeTeamScore(Document doc) {
		String teamScore = getText(doc, "li.your-rank div.disc p");
		return StringUtils.isBlank(teamScore) ? 0 : Integer.valueOf(teamScore);
	}

	private String scrapeInveiteUrl(Document doc) {
		return getText(doc, ".add-members a");
	}

	private String scrapeTeamName(Document doc) {
		return getText(doc, ".team-header h1");
	}

	private String scrapeUrl(Document doc) {
		return getText(doc, "li.home-page a");
	}

	private String scrapeLocation(Document doc) {
		return getText(doc, "li.team-location");
	}

	private String scrapeAbout(Document doc) {
		return getText(doc, "div.about-team p");
	}

	private List<String> scrapeCoreSkills(Document doc) {
		return getList(doc, "div.side-panel.core-skills ul li");
	}

	private String getText(Document doc, String query) {
		String text = "";
		Elements elements = doc.select(query);
		for (Element element : elements) {
			text = element.text();
		}
		return text;
	}

	private List<String> getList(Document doc, String query) {
		List<String> list = new ArrayList<String>();
		Elements elements = doc.select(query);
		for (Element element : elements) {
			list.add(element.text());
		}
		return list;
	}

	private List<TeamAchievement> scrapeTeamAchievements(Document doc) {
		List<TeamAchievement> teamAchievements = new ArrayList<TeamAchievement>();
		Elements elements = doc.select("div.side-panel.side-achievements ul li");
		for (Element element : elements) {
			TeamAchievement achievement = new TeamAchievement();
			for (Element achievementNoElement : element.getElementsByClass("achievement-no")) {
				achievement.setAchievementNo(Long.valueOf(achievementNoElement.text()));
			}
			for (Element badgeElement : element.getElementsByTag("img")) {
				achievement.setAchievementName(badgeElement.attr("alt"));
				achievement.setAchievementImgSourceUrl(badgeElement.attr("src"));
			}
			teamAchievements.add(achievement);
		}
		return teamAchievements;
	}

	private List<User> scrapeMembers(Document doc) {
		List<User> teamMembers = new ArrayList<User>();
		Elements elements = doc.select("div.member-top");
		for (Element element : elements) {
			User user = new User();
			for (Element avaterElement : element.getElementsByTag("img")) {
				user.setUserId(avaterElement.attr("alt"));
				user.setAvaterImgSourceUrl(avaterElement.attr("src"));
			}
			for (Element nameElement : element.getElementsByTag("h3")) {
				user.setUserName(nameElement.text());
			}
			for (Element discriptionElement : element.getElementsByTag("h4")) {
				user.setDiscription(discriptionElement.text());
			}
			user.setAchievements(Long.valueOf(getText(doc, "a[href=/" + user.getUserId() + "] ul li.card-achievements")));
			user.setEndorsements(Long.valueOf(getText(doc, "a[href=/" + user.getUserId() + "] ul li.card-endorsements")));

			teamMembers.add(user);
		}
		return teamMembers;
	}

	private Long getLongValue(Element element) {
		String str = StringUtils.trim(element.ownText()).replace(",", "").replace("\"", "");
		return StringUtils.isNumeric(str) ? Long.valueOf(str) : 0;
	}
}
