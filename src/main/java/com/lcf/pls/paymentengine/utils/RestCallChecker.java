package com.lcf.pls.paymentengine.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public final class RestCallChecker {

    public static <T> Object callRestGetService(String url, HttpEntity<Object> createRequest, Class<T> responseClass,
                                                RestTemplate restTemplate, int connTimeout, int readTimeout) {
        ResponseEntity<T> response = null;

        response = restTemplate.exchange(url, HttpMethod.GET, createRequest, responseClass);

        return response.getBody();
    }

    public static <T> Object callRestPostService(String url, HttpEntity<Object> createRequest, Class<T> responseClass,
                                                 RestTemplate restTemplate, int connTimeout, int readTimeout) {
        T response = null;
        response = restTemplate.postForObject(url, createRequest, responseClass);
        return response;
    }

    public static HttpComponentsClientHttpRequestFactory setRestTimeoutData(int connTimeOut, int readTimeOut) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connTimeOut * 1000);
        requestFactory.setReadTimeout(readTimeOut * 1000);
        return requestFactory;
    }
}
