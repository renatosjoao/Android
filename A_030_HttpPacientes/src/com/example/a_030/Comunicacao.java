package com.example.a_030;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Comunicacao {

	public static String getInputStringFromURL(String url, String params) {
		HttpClient httpClient = null;
		InputStream content = null;

		try {
			/**
			 *  Formatação da Requisição HTTP
			 */
			httpClient = new DefaultHttpClient();
			setProxy((DefaultHttpClient) httpClient);
			HttpPost httpPost = new HttpPost(url);
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("json", params));
			httpPost.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse response = httpClient.execute(httpPost);		
			/**
			 * Leitura da Resposta da Requisição HTTP
			 */
			content = response.getEntity().getContent();
			if (content != null) {
				Writer writer = new StringWriter();
				char[] buffer = new char[1024];
				try {
					Reader reader = new BufferedReader(new InputStreamReader(content, "UTF_8"));
					int n;
					while ((n = reader.read(buffer)) != -1) {
						writer.write(buffer, 0, n);

					}
					return writer.toString();
				} catch (Exception e) {
				} finally {
					content.close();
				}
			} else {
				return "";
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			httpClient.getConnectionManager().shutdown();

		}

		return "";

	}

	public Comunicacao() {
	}

	public static void setProxy(DefaultHttpClient httpclient) {
		final String PROXY_IP = "172.16.100.2";
		final int PROXY_PORT = 8088;

		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(PROXY_IP, PROXY_PORT),
				new UsernamePasswordCredentials("internet", "internet"));

		HttpHost proxy = new HttpHost(PROXY_IP, PROXY_PORT);

		httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
				proxy);

	}
}
