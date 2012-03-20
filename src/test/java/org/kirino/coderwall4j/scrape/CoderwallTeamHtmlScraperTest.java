package org.kirino.coderwall4j.scrape;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.io.IOException;

import org.junit.Test;
import org.kirino.coderwall4j.model.Team;

public class CoderwallTeamHtmlScraperTest {

	@Test
	public void nicobookのデータが取れること() throws IOException {
		CoderwallTeamHtmlScraper cts = new CoderwallTeamHtmlScraper("4f61c42bdb6418000a000001");
		Team team = cts.scrapeTeamData();
		assertThat(team.getTeamName(), is("nicobook"));
		assertThat(team.getUrl(), is("http://seiga.nicovideo.jp/book/"));
		assertThat(team.getLocation(), is("Hamacho"));
		assertThat(team.getAbout(), is("The Team Nicobook in Dwango inc."));
		assertThat(team.getCoreSkills(),
				hasItems("ruby", "javascript", "java", "coffeescript", "c", "mysql", "git", "python"));

		assertThat(team.getTeamAchievements().get(0).getAchievementNo(), is(7L));
		assertThat(team.getTeamAchievements().get(0).getAchievementName(), is("Charity"));
		assertThat(team.getTeamAchievements().get(0).getAchievementImgSourceUrl(),
				is("http://cdn.coderwall.com/assets/badges/charity-bf61e713137d910534ff805f389bcffb.png"));

	}

}
