package mate.academy.rickandmorty.dto.external.episode;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.rickandmorty.dto.external.RickAndMortyDto;

@Getter
@Setter
public class EpisodeResponseDataDto implements RickAndMortyDto {
    private EpisodeMetadataDto info;
    private List<EpisodeInfoDto> results;
}
