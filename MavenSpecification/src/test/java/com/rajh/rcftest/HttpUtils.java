package com.rajh.rcftest;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpUtils {
		public static CloseableHttpResponse doSomething() throws IOException {
	        CloseableHttpClient httpClient= HttpClients.createDefault();
	        HttpGet httpget = new HttpGet("http://localhost:9888/some/thing");
	        System.out.println("executing request " + httpget.getURI());
	        // 执行get请求.
	        System.out.println("111");
	        CloseableHttpResponse response = httpClient.execute(httpget);
	        System.out.println(response.getEntity());
	        System.out.println( response.getAllHeaders());
	        System.out.println( response.getStatusLine().getStatusCode());
	            // 获取响应实体
	         return  response;
	}
}