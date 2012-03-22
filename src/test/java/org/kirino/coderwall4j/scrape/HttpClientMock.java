package org.kirino.coderwall4j.scrape;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;


public class HttpClientMock {
	public static final String CODERWALL_TEAM_BASE_URL = "http://coderwall.com/teams/";

	public static Document getDocument(String teamId) throws IOException {
		String html = FileUtils.readFileToString(new File("src/test/resources/nicobook.html"));
		return new Document(html);
	}

}
