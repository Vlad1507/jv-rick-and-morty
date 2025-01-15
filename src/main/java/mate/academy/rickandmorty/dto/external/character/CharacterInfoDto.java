package mate.academy.rickandmorty.dto.external.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterInfoDto {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String originName;
    private String originUrl;
    private String locationName;
    private String locationUrl;
    private String image;
    @JsonProperty("episode")
    private List<String> episodeUrl;
    private String url;
    private String created;

}
