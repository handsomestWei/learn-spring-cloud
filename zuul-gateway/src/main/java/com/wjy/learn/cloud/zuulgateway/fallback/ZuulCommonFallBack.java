package com.wjy.learn.cloud.zuulgateway.fallback;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ZuulCommonFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse(){
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders hd = new HttpHeaders();
                hd.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return hd;
            }

            @Override
            public InputStream getBody() throws IOException {
                JSONObject object = new JSONObject();
                object.put("rspCode","2998");
                object.put("rspInfo","ZuulException：系统繁忙");
                return new ByteArrayInputStream(object.toJSONString().getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}
