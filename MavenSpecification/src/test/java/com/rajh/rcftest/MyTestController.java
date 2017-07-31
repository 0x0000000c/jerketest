package com.rajh.rcftest;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.rajh.rcf.dao.SignonDao;
import com.rajh.rcf.service.SignonService;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;


public class MyTestController {
	
	
	@Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(9888) ,false);
    @Test
    public  void exampleTest() throws IOException {
            stubFor(get("/some/thing") .willReturn(aResponse()
                            .withStatus(200).
                            withHeader("Content-Type", "text/xml")
                           .withBody("<response>Some content</response>")));

            System.out.println("stubed!");
            
            CloseableHttpResponse closeableHttpResponse = HttpUtils.doSomething();

            assertEquals(200,closeableHttpResponse.getStatusLine().getStatusCode());
            System.out.println("haha");

    }
}

