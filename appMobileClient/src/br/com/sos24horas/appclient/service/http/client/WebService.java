package br.com.sos24horas.appclient.service.http.client;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * @author wellington
**/
 
public class WebService{
 
    DefaultHttpClient httpClient;
    HttpContext localContext;
    private String ret;
    private String TAG = "WebService";
 
    HttpResponse response = null;
    HttpPost httpPost = null;
    HttpGet httpGet = null;
    String webServiceUrl;
 
    
    public WebService(String serviceName){
        HttpParams myParams = new BasicHttpParams();
 
        HttpConnectionParams.setConnectionTimeout(myParams, 10000);
        HttpConnectionParams.setSoTimeout(myParams, 10000);
        httpClient = new DefaultHttpClient(myParams);
        localContext = new BasicHttpContext();
        webServiceUrl = serviceName;
 
    }
  
    
    public String webInvoke(String methodName, String param){
    	
    	return this.webInvoke(methodName, param, "application/json" );   	
    	
    	
    }
 
    private String webInvoke(String methodName, String data, String contentType) {
        ret = null;
 
        httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);
 
        httpPost = new HttpPost(webServiceUrl + methodName);
        response = null;
 
        StringEntity tmp = null; 
        
        httpPost.setHeader("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
 
        if (contentType != null) {
            httpPost.setHeader("Content-Type", contentType);
        } else {
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        }
 
        try {
            tmp = new StringEntity(data,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "HttpUtils : UnsupportedEncodingException : "+e);
        }
 
        httpPost.setEntity(tmp);
 
        Log.d(TAG, webServiceUrl + "?" + data);
 
        try {
            response = httpClient.execute(httpPost,localContext);
 
            if (response != null) {
                ret = EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            Log.e(TAG, "HttpUtils: " + e);
        }
 
        return ret;
    }
 
    
    public String webGet(String methodName, Map<String, String> params) {
        String getUrl = webServiceUrl + methodName;
 
        int i = 0;
        for (Map.Entry<String, String> param : params.entrySet())
        {
            if(i == 0){
                getUrl += "?";
            }
            else{
                getUrl += "&";
            }
 
            try {
                getUrl += param.getKey() + "=" + URLEncoder.encode(param.getValue(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG, "Erro método webGet " + e);
                
            }
 
            i++;
        }
 
        httpGet = new HttpGet(getUrl);
        Log.e(TAG, "WebGetURL: " + getUrl);
 
        try {
            response = httpClient.execute(httpGet);
        } catch (Exception e) {
            Log.e("Groshie:", e.getMessage());
        }
 
        
        try {
            ret = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            Log.e("Groshie:", e.getMessage());
        }
 
        return ret;
    }
 
  
    public String doPost(String methodName, List<NameValuePair> params) {
       
    	String getUrl = webServiceUrl + methodName;       
 
        httpPost = new HttpPost(getUrl);
       
        try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
		} catch (UnsupportedEncodingException e1) {
			Log.e(TAG, "Erro metodo doPost" + e1);
			e1.printStackTrace();
		} 

        Log.e(TAG, "WebGetURL: " + getUrl);
        
        
        try {
            response = httpClient.execute(httpPost);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
 
       
        try {
            ret = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            Log.e("Groshie:", e.getMessage());
        }
 
        return ret;
    }
    
    
    public InputStream getHttpStream(String urlString) throws IOException {
        InputStream in = null;
        int response = -1;
 
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
 
        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Não há uma coneção  HTTP ");
 
        try{
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect(); 
 
            response = httpConn.getResponseCode();                 
 
            if (response == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        } catch (Exception e) {
            throw new IOException("Erro em tentar conctar");
        } 
 
        return in;
    }
 
    public void clearCookies() {
        httpClient.getCookieStore().clear();
    }
 
    public void abort() {
        try {
            if (httpClient != null) {
                System.out.println("Aborta.");
                httpPost.abort();
            }
        } catch (Exception e) {
            Log.e(TAG, "Erro ao tentar abortar " + e);
        }
    }
}