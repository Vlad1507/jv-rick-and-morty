package mate.academy.rickandmorty.dto.external.episode;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeInfoDto {
    private Long id;
    private String name;
    @JsonProperty("air_date")
    private String airDate;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

}
