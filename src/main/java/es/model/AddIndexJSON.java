package es.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "acknowledged",
        "shards_acknowledged",
        "index"
})
public class AddIndexJSON implements ESable{

    @JsonProperty("acknowledged")
    private Boolean acknowledged;
    @JsonProperty("shards_acknowledged")
    private Boolean shardsAcknowledged;
    @JsonProperty("index")
    private String index;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("acknowledged")
    public Boolean getAcknowledged() {
        return acknowledged;
    }

    @JsonProperty("acknowledged")
    public void setAcknowledged(Boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    @JsonProperty("shards_acknowledged")
    public Boolean getShardsAcknowledged() {
        return shardsAcknowledged;
    }

    @JsonProperty("shards_acknowledged")
    public void setShardsAcknowledged(Boolean shardsAcknowledged) {
        this.shardsAcknowledged = shardsAcknowledged;
    }

    @JsonProperty("index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String getRequest() {
        return "";
    }

    @Override
    public void print() {
        System.out.println("Added index:"+index);
    }
}