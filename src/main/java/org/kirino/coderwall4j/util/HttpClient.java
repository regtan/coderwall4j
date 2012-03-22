package org.kirino.coderwall4j.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpClient {
	public static final String CODERWALL_TEAM_BASE_URL = "http://coderwall.com/teams/";

	public static Document getDocument(String teamId) throws IOException {
		return Jsoup.connect(CODERWALL_TEAM_BASE_URL + teamId).timeout(20000).get();
	}

}
