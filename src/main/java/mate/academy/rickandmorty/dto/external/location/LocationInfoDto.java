package mate.academy.rickandmorty.dto.external.location;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.rickandmorty.dto.external.character.CharacterInfoDto;

@Getter
@Setter
public class LocationInfoDto {
    private Long id;
    private String name;
    private String type;
    private String dimension;
    private List<CharacterInfoDto> residents;
    private String url;
    private String created;

}
