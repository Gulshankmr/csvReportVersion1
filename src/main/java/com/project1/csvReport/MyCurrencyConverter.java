package com.project1.csvReport;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MyCurrencyConverter implements CurrencyConverter {   

	@Override
	public float convert(String currencyFrom, String currencyTo) throws Exception {
		// TODO Auto-generated method stub
		CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet("https://free.currconv.com/api/v7/convert?q="+currencyFrom+"_"+currencyTo+"USD_INR&compact=ultra&apiKey=cfb63678d53e439693ff");

            // add request headers
 //          request.addHeader("custom-key", "mkyong");
 //          request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
		return 0;
	}

}