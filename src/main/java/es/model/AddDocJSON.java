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
        "_index",
        "_type",
        "_id",
        "_version",
        "result",
        "_shards",
        "_seq_no",
        "_primary_term"
})
public class AddDocJSON implements ESable{

    @JsonProperty("_index")
    private String index;
    @JsonProperty("_type")
    private String type;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_version")
    private Integer version;
    @JsonProperty("result")
    private String result;
    @JsonProperty("_shards")
    private Shards shards;
    @JsonProperty("_seq_no")
    private Integer seqNo;
    @JsonProperty("_primary_term")
    private Integer primaryTerm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("_index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @JsonProperty("_type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("_version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("_version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("_shards")
    public Shards getShards() {
        return shards;
    }

    @JsonProperty("_shards")
    public void setShards(Shards shards) {
        this.shards = shards;
    }

    @JsonProperty("_seq_no")
    public Integer getSeqNo() {
        return seqNo;
    }

    @JsonProperty("_seq_no")
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    @JsonProperty("_primary_term")
    public Integer getPrimaryTerm() {
        return primaryTerm;
    }

    @JsonProperty("_primary_term")
    public void setPrimaryTerm(Integer primaryTerm) {
        this.primaryTerm = primaryTerm;
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
        return null;
    }

    @Override
    public void print() {
        System.out.println("Added to "+index+" id:"+id);
    }
}