package com.project1.csvReport;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MyCurrencyConverter implements CurrencyConverter {

	@Override
	public double convert(String currencyFrom, String currencyTo) throws Exception {
		// TODO Auto-generated method stub
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = null;

		try {

			HttpGet request = new HttpGet("https://free.currconv.com/api/v7/convert?q=" + currencyFrom + "_"
					+ currencyTo + "&compact=ultra&apiKey=cfb63678d53e439693ff");

			CloseableHttpResponse response = httpClient.execute(request);

			try {

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					// return it as a String
					result = EntityUtils.toString(entity);

					result = result.substring(result.indexOf(':') + 1, result.length() - 1);
					// System.out.println(result);

				}

			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}

		return Double.parseDouble(result);

	}

}