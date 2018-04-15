package es;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.model.HealthJSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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

    public T get() throws ClientProtocolException,IOException {
        HttpResponse response = client.execute(request);
        T json = createJSON();
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        ObjectMapper mapper = new ObjectMapper();
        json = mapper.readValue(rd, typeParameterClass);
        return json;
    }

    public static void getString(String r) throws ClientProtocolException,IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet req = new HttpGet(r);
        HttpResponse response = client.execute(req);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

}
