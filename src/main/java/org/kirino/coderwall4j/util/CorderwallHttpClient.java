package org.kirino.coderwall4j.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.kirino.coderwall4j.exception.CoderwallException;

public class CorderwallHttpClient {
	public static final String CODERWALL_TEAM_BASE_URL = "http://coderwall.com/teams/";

	public static Document getTeamDocument(String teamId) throws CoderwallException {
		try {
			Document doc = Jsoup.connect(CODERWALL_TEAM_BASE_URL + teamId).timeout(20000).get();
			return doc;
		} catch (IOException e) {
			throw new CoderwallException("Cannot get Team data");
		}
	}

}
