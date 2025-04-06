package com.papasong.bloomfesta.festa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Controller
public class FestaController {

    @GetMapping(value = "/")
    public String index() throws Exception{

        StringBuilder urlBuilder = new StringBuilder("http://api.kcisa.kr/openapi/service/rest/meta4/getKCPG0504"); // 기본 URL

        // 실제 값으로 치환할 것!
        String serviceKey = "serviceKey";
        String numOfRows = "10"; // 한 페이지에 10개씩
        String pageNo = "1";     // 1페이지

        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json"); // JSON 응답 원하면 반드시 포함!

        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        System.out.println("응답 데이터:");
        System.out.println(sb.toString());


        return "index";
    }

    @GetMapping(value = "/festaList")
    public String festaList(){

        return "festaList";
    }
}
