package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.AppConfig;
import mate.academy.rickandmorty.dto.internal.location.LocationDto;
import mate.academy.rickandmorty.model.CharacterLocation;
import org.mapstruct.Mapper;

@Mapper(config = AppConfig.class)
public interface LocationMapper {
    LocationDto toDto(CharacterLocation location);

    CharacterLocation toModel(LocationDto locationDto);
}
