package org.kirino.coderwall4j.util;

import java.io.IOException;

import mockit.Expectations;
import mockit.Mocked;

import org.jsoup.Jsoup;
import org.junit.Test;
import org.kirino.coderwall4j.exception.CoderwallException;

public class HttpClientTest {
	@Mocked
	final Jsoup jsoup = null;

	@Test(expected = CoderwallException.class)
	public void corderwallのチームデータが取れなかったらCoderwallException() throws Exception {
		new Expectations() {
			{
				Jsoup.connect("http://coderwall.com/teams/4f61c42bdb6418000a000001");
				result = new IOException();
			}
		};
		HttpClient.getTeamDocument("4f61c42bdb6418000a000001");
	}
}
