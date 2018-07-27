package api.userdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    @JsonProperty("username")
    private String name;
    @JsonProperty("password")
    private String password;

}
