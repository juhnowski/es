import es.ESObject;
import es.model.HealthJSON;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClientProtocolException,IOException {
        ESObject<HealthJSON> es = new ESObject<HealthJSON>(HealthJSON.class, HealthJSON::new, "http://localhost:9200/_cluster/health");
        HealthJSON json = es.get();
        System.out.println("status="+json.status);
        ESObject.getString("http://localhost:9200/_cat/indices?v");

    }
}
