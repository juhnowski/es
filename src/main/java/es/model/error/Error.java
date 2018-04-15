package es.model.error;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "root_cause",
        "type",
        "reason",
        "index_uuid",
        "index"
})
public class Error {

    @JsonProperty("root_cause")
    private List<RootCause> rootCause = null;
    @JsonProperty("type")
    private String type;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("index_uuid")
    private String indexUuid;
    @JsonProperty("index")
    private String index;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("root_cause")
    public List<RootCause> getRootCause() {
        return rootCause;
    }

    @JsonProperty("root_cause")
    public void setRootCause(List<RootCause> rootCause) {
        this.rootCause = rootCause;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("index_uuid")
    public String getIndexUuid() {
        return indexUuid;
    }

    @JsonProperty("index_uuid")
    public void setIndexUuid(String indexUuid) {
        this.indexUuid = indexUuid;
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

}
