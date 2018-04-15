import es.ESObject;
import es.model.AddIndexJSON;
import es.model.ESable;
import es.model.HealthJSON;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        ESObject<HealthJSON> es = new ESObject<HealthJSON>(HealthJSON.class, HealthJSON::new, "http://localhost:9200/_cluster/health");
        ESable json = es.get();
        json.print();
/*
        String result = ESObject.getString("http://localhost:9200/_cat/indices?v");
        System.out.println(result);
  */

        String url = "http://localhost:9200/books6";
        String requestJson = "{\"settings\":{\n" +
                "  \t\t\"number_of_shards\":1,\n" +
                "  \t\t\"number_of_replicas\":0\n" +
                "\t},\n" +
                " \"mappings\":{\n" +
                "   \"authors\":{\n" +
                "     \"properties\":{\n" +
                "       \t\"name\":{\n" +
                "          \"type\":\"text\"\n" +
                "        },\n" +
                "        \"book_count\":{\n" +
                "          \"type\":\"integer\"\n" +
                "        },\n" +
                "        \"date\":{\n" +
                "          \"type\":\"date\"\n" +
                "        }\n" +
                "     }\n" +
                "   }\n" +
                " }\n" +
                "}";
        ESObject<AddIndexJSON> es1 = new ESObject<AddIndexJSON>(AddIndexJSON.class, AddIndexJSON::new, url);
        ESable add = es1.put(url,requestJson);
        add.print();

    }
}
