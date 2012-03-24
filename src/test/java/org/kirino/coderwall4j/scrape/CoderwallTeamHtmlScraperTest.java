package org.kirino.coderwall4j.scrape;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.io.File;

import mockit.Expectations;
import mockit.Mocked;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.kirino.coderwall4j.model.Team;
import org.kirino.coderwall4j.util.HttpClient;

public class CoderwallTeamHtmlScraperTest {
	@Mocked
	final HttpClient httpClient = null;

	@Test
	public void nicobookのデータが取れること() throws Exception {
		new Expectations() {
			{
				HttpClient.getTeamDocument("4f61c42bdb6418000a000001");
				result = Jsoup.parse(FileUtils.readFileToString(new File("src/test/resources/nicobook.html")));
			}
		};

		CoderwallTeamHtmlScraper cts = new CoderwallTeamHtmlScraper("4f61c42bdb6418000a000001");
		Team team = cts.scrapeTeamData();
		assertThat(team.getTeamName(), is("nicobook"));
		assertThat(team.getUrl(), is("http://seiga.nicovideo.jp/book/"));
		assertThat(team.getLocation(), is("Hamacho"));
		assertThat(team.getAbout(), is("The Team Nicobook in Dwango inc."));
		assertThat(team.getCoreSkills(),
				hasItems("ruby", "javascript", "java", "coffeescript", "c", "mysql", "git", "objective-c"));
		assertThat(team.getInviteUrl(), is("http://coderwall.com/i/4f61c42bdb6418000a000001/73TO0Y5813E"));

		assertThat(team.getTeamAchievements().get(0).getAchievementNo(), is(7L));
		assertThat(team.getTeamAchievements().get(0).getAchievementName(), is("Charity"));
		assertThat(team.getTeamAchievements().get(0).getAchievementImgSourceUrl(),
				is("http://cdn.coderwall.com/assets/badges/charity-bf61e713137d910534ff805f389bcffb.png"));

		assertThat(team.getMembers().get(0).getUserId(), is("masarakki"));
		assertThat(
				team.getMembers().get(0).getAvaterImgSourceUrl(),
				is("https://secure.gravatar.com/avatar/d52c8b0a24dfaec053feba8ba4125ac5?d=http://cdn.coderwall.com/assets/blank-mugshot-cd8f375611cece404f4d3797dd07b141.png"));
		assertThat(team.getMembers().get(0).getUserName(), is("yamada masaki"));
		assertThat(team.getMembers().get(0).getDiscription(), is("Anime Driven Development"));
		assertThat(team.getMembers().get(0).getAchievements(), is(9L));
		assertThat(team.getMembers().get(0).getEndorsements(), is(0L));
	}

}
