package api.userdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Search {

    @JsonProperty("languages")
    private String[] languages;
    @JsonProperty("username")
    private String username;
    @JsonProperty("readyForBusinessTrip")
    private boolean readyForBusinessTrip;
    @JsonProperty("skills")
    private String[] skills;


}
