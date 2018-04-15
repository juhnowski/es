package es;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.model.ESable;
import es.model.error.ErrorJSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class ESObject<T> {
    HttpClient client = new DefaultHttpClient();
    HttpGet request;
    final Class<T> typeParameterClass;
    private Supplier<T> supplier;

    public ESObject(Class<T> typeParameterClass, Supplier<T> supplier, String req){
        this.supplier = supplier;
        this.request = new HttpGet(req);
        this.typeParameterClass = typeParameterClass;
    }

    T createJSON(){
        return supplier.get();
    }

    public ESable put(String url, String requestJson) throws Exception {
        HttpPut putRequest = new HttpPut();
        putRequest.setHeader("Content-Type","application/json");
        HttpPut httpPut = new HttpPut(url);
        StringEntity entity = new StringEntity(requestJson, "UTF-8");
        entity.setContentType("application/json");
        httpPut.setEntity(entity);
        HttpResponse resp = client.execute(httpPut);

        BufferedReader rd = new BufferedReader (new InputStreamReader(resp.getEntity().getContent()));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        String result = sb.toString();
        T json = createJSON();
        if (result.contains("error")){
            ErrorJSON err = mapper.readValue(result, ErrorJSON.class);
            return  err;
        } else {
            json = mapper.readValue(result, typeParameterClass);
            return (ESable)json;
        }
    }

    public ESable get() throws ClientProtocolException,IOException {
        HttpResponse response = client.execute(request);
        T json = createJSON();
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        ObjectMapper mapper = new ObjectMapper();
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        String resp = sb.toString();
        if (resp.contains("error")){
            ErrorJSON err = mapper.readValue(resp, ErrorJSON.class);
            return  err;
        } else {
            json = mapper.readValue(resp, typeParameterClass);
            return (ESable)json;
        }

    }

    public static String getString(String r) throws ClientProtocolException,IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet req = new HttpGet(r);
        HttpResponse response = client.execute(req);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }
        return sb.toString();
    }

}
