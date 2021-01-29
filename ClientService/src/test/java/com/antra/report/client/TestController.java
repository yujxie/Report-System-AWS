package com.antra.report.client;

import com.antra.report.client.pojo.request.ReportRequest;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.junit.jupiter.api.Test;
import com.antra.report.client.controller.ReportController;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestController {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getReportShouldReturnValue() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        String url = "http://localhost:" + port + "/report";
        assertThat(this.restTemplate.getForObject(url, String.class).equals("{\"statusCode\":\"OK\",\"data\":[]}"));
    }

    @Test
    public void getReportByIdShouldReturnValue() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        String url = "http://localhost:" + port + "/report/reqId";
        assertThat(this.restTemplate.getForObject(url, String.class).isEmpty());
    }
}
