import es.ESObject;
import es.model.*;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        ESObject<HealthJSON> es = new ESObject<HealthJSON>(HealthJSON.class, HealthJSON::new, "http://localhost:9200/_cluster/health");
        ESable json = es.get();
        json.print();

        //GET HEALTH
        /*
        String result = ESObject.getString("http://localhost:9200/_cat/indices?v");
        System.out.println(result);
        */

        /*
        //ADD NEW INDEX
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
*/
        //ADD NEW DOCUMENT
        /*
        ​PUT index/type/1
        {"body": "here"}
         */
        /*
        String url = "http://localhost:9200/index/type/2";
        String requestJson ="{\"body\": \"here\"}";
        ESObject<AddDocJSON> es1 = new ESObject<AddDocJSON>(AddDocJSON.class, AddDocJSON::new, url);
        ESable add = es1.put(url,requestJson);
        add.print();
        */

        //GET DOC
        /*
        ​
GET index/type/1
         */

        ESObject<GetDocJSON> es2 = new ESObject<GetDocJSON>(GetDocJSON.class, GetDocJSON::new, "http://localhost:9200/index/type/1");
        ESable json2 = es2.get();
        json2.print();

    }
}
