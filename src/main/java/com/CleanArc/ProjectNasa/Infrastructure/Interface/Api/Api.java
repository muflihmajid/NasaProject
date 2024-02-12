package com.CleanArc.ProjectNasa.Infrastructure.Interface.Api;
import com.CleanArc.ProjectNasa.Application.Interface.Api.IApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class Api implements IApi {
    @Override
    public String GetApiCall(String url) {
        HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = null;
		
        HttpGet request = new HttpGet(url);
        try
		{
			response = client.execute(request);
			if(response!=null)
			{
				BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
				StringBuilder jsonBuilder = new StringBuilder();
				String responseline = "";
				while ((responseline = rd.readLine()) != null) {
					jsonBuilder.append(responseline);
				}
				String jsonResponse = jsonBuilder.toString();		
				return jsonResponse;
			}
			else
			{
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}
    }
}
