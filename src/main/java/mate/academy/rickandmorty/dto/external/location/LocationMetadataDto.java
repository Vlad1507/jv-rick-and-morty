package mate.academy.rickandmorty.dto.external.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationMetadataDto {
    @JsonProperty("count")
    private Long characterCount;
    @JsonProperty("pages")
    private Long pages;
    @JsonProperty("next")
    private String urlNext;
    @JsonProperty("prev")
    private String urlPrev;
}
