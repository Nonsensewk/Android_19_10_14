package ies.syuct.edu.cn.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtilsHttpClient {

    //1.创建HttpClient对象
    private static HttpClient httpClient = new DefaultHttpClient();

    public static String BASE_URL= "http://111.117.187.27:8080/AndroidTest/";
//http://localhost:8080/AndroidTest/LoginServlet
    /**
     * GET方式
     * @param url
     * @return
     */
    public static String getRequest(String url){
        String result  = "";

        //2.创建HttpGet对象
        HttpGet httpGet= new HttpGet(url);
        try {
            //3.发送Get请求
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200){
                //4.获取服务器返回的数据
                HttpEntity entity = response.getEntity();
                result  = EntityUtils.toString(entity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result ;
    }

    /**
     * post方式
     * @param url
     * @param params
     * @return
     */
    public static String postRequest(String url,Map<String,String> params){
        String result = "";

        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> parameters = new ArrayList<>();
        for (Map.Entry<String,String>  entry: params.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(),entry.getValue());
            parameters.add(pair);
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters,"utf-8"));

            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200){
                //4.获取服务器返回的数据
                HttpEntity entity = response.getEntity();
                result  = EntityUtils.toString(entity);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}


