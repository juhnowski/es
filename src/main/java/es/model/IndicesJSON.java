package es.model;

public class IndicesJSON implements ESable {
    @Override
    public String getRequest() {
        return "http://localhost:9200/_cat/indices?v";
    }
}
