package mate.academy.rickandmorty.dto.external.location;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.rickandmorty.dto.external.RickAndMortyDto;

@Getter
@Setter
public class LocationResponseDataDto implements RickAndMortyDto {
    private LocationMetadataDto info;
    private List<LocationInfoDto> results;
}
