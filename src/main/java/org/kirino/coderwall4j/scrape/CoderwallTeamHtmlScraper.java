package org.kirino.coderwall4j.scrape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.kirino.coderwall4j.model.Team;
import org.kirino.coderwall4j.model.TeamAchievement;

public class CoderwallTeamHtmlScraper {
	public final String CODERWALL_TEAM_BASE_URL = "http://coderwall.com/teams/";
	final String teamId;

	public CoderwallTeamHtmlScraper(String teamId) {
		this.teamId = teamId;
	}

	public Team scrapeTeamData() throws IOException {
		Document doc = Jsoup.connect(createTeamBaseUrl(teamId)).timeout(20000).get();
		Team team = new Team();
		team.setTeamName(scrapeTeamName(doc));
		team.setUrl(scrapeUrl(doc));
		team.setLocation(scrapeLocation(doc));
		team.setAbout(scrapeAbout(doc));
		team.setCoreSkills(scrapeCoreSkills(doc));
		team.setTeamAchievements(scrapeTeamAchievements(doc));

		return team;
	}

	private String createTeamBaseUrl(String teamId) {
		return CODERWALL_TEAM_BASE_URL + teamId;
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

}
